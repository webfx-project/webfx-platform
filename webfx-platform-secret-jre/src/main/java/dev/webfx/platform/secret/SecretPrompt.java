package dev.webfx.platform.secret;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Asks the person at the keyboard for a secret value, without it appearing on screen.
 *
 * <p>Two ways are available, and which one is tried first depends on where the caller runs:
 * <ul>
 *     <li>{@link Preference#DIALOG_FIRST} for an application started by an IDE: its run console is
 *     not a terminal and echoes what is typed, so a password dialog is the only masked option.</li>
 *     <li>{@link Preference#TERMINAL_FIRST} for a command line tool, which normally runs in a real
 *     terminal, where a prompt with the echo off is both masked and expected.</li>
 * </ul>
 * With no desktop and no terminal (ex: a container started without one), nothing is asked and null is
 * returned, so a caller can report the problem instead of waiting for an answer that can never come.
 * Note that a terminal IS a terminal wherever it is attached: a container run interactively will ask,
 * and wait for as long as it takes - there is no timeout, because the person typing may need a while.
 *
 * @author Bruno Salmon
 */
public final class SecretPrompt {

    public enum Preference { DIALOG_FIRST, TERMINAL_FIRST }

    private SecretPrompt() {}

    /** Whether there is any way to ask - false with no desktop and no terminal, where callers must not wait. */
    public static boolean isPossible() {
        return hasDesktop() || isTerminal(System.console());
    }

    /**
     * @param label what is being asked for, shown to the person (never a secret value itself)
     * @param context lines shown above the field, ex: which database - non-secret values only
     * @return what was typed, to be wiped by the caller, or null if refused or impossible
     */
    public static char[] ask(String label, List<String> context, Preference preference) {
        List<String> contextLines = context == null ? List.of() : context;
        boolean desktop = hasDesktop();
        if (desktop && preference == Preference.DIALOG_FIRST) {
            Answer answer = askInDialog(label, contextLines);
            if (answer.value() != null || answer.cancelled()) // a refusal is an answer: don't then ask in the terminal
                return answer.value();
        }
        java.io.Console terminal = System.console();
        if (isTerminal(terminal)) {
            contextLines.forEach(line -> terminal.printf("%s%n", line));
            return terminal.readPassword("%s: ", label);
        }
        return desktop ? askInDialog(label, contextLines).value() : null;
    }

    /** What the dialog gave back: a value, or nothing - and whether nothing meant "cancel" or "couldn't open". */
    private record Answer(char[] value, boolean cancelled) {}

    private static Answer askInDialog(String label, List<String> context) {
        char[][] typed = { null };
        boolean[] cancelled = { false };
        Runnable dialogRunnable = () -> {
            JPasswordField passwordField = new JPasswordField(24);
            Box message = Box.createVerticalBox();
            message.add(newPlainLabel(label));
            context.forEach(line -> message.add(newPlainLabel(line)));
            message.add(Box.createVerticalStrut(8));
            message.add(passwordField);
            JOptionPane optionPane = new JOptionPane(message, JOptionPane.QUESTION_MESSAGE, JOptionPane.OK_CANCEL_OPTION) {
                @Override
                public void selectInitialValue() { // Focusing the password field rather than the OK button
                    passwordField.requestFocusInWindow();
                }
            };
            passwordField.addActionListener(e -> optionPane.setValue(JOptionPane.OK_OPTION)); // Enter = OK
            JDialog dialog = optionPane.createDialog(null, label);
            // The application usually has no window of its own, so the dialog would open behind the IDE
            dialog.setAlwaysOnTop(true);
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.APP_REQUEST_FOREGROUND))
                Desktop.getDesktop().requestForeground(true);
            dialog.setVisible(true); // Modal, so returns once the dialog is closed
            char[] password = passwordField.getPassword();
            if (Objects.equals(optionPane.getValue(), JOptionPane.OK_OPTION))
                typed[0] = password;
            else {
                Arrays.fill(password, '\0');
                cancelled[0] = true;
            }
            dialog.dispose();
        };
        try {
            if (SwingUtilities.isEventDispatchThread())
                dialogRunnable.run();
            else
                SwingUtilities.invokeAndWait(dialogRunnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            cancelled[0] = true;
        } catch (InvocationTargetException | RuntimeException | LinkageError | AWTError e) {
            // Ex: a display server that can't be reached after all - not a refusal, so a terminal may still be tried
            return new Answer(null, false);
        }
        return new Answer(typed[0], cancelled[0]);
    }

    private static JLabel newPlainLabel(String text) {
        JLabel label = new JLabel();
        // Displaying values as text, never as HTML. Set before the text, as the label UI reads it on text changes.
        label.putClientProperty("html.disable", Boolean.TRUE);
        label.setText(text);
        return label;
    }

    private static boolean hasDesktop() {
        try {
            return !GraphicsEnvironment.isHeadless();
        } catch (RuntimeException | LinkageError | AWTError e) {
            return false;
        }
    }

    private static boolean isTerminal(java.io.Console console) {
        if (console == null)
            return false;
        try { // Since JDK 22, System.console() is not null even when not attached to a terminal, which isTerminal() tells
            return (Boolean) java.io.Console.class.getMethod("isTerminal").invoke(console);
        } catch (NoSuchMethodException e) { // Before JDK 22, a console is always attached to a terminal
            return true;
        } catch (ReflectiveOperationException e) {
            return false;
        }
    }
}
