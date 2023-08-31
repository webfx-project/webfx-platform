package emul.java.util.regex;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.regexp.shared.RegExp;

/** Emulation of the {@link Matcher} class, uses {@link RegExp} as internal implementation.
 * @author hneuer */

public class Matcher {

    private final String input;
    /* Implementation using standard JavaScript RegExp
     Commented as not all browsers implement named groups (only Chrome 64 for now)

        private final RegExp regExp;
        private final MatchResult matchResult;

        Matcher (Pattern pattern, CharSequence input) {
            this.input = String.valueOf(input);
            this.regExp = pattern.regExp;
            matchResult = regExp.exec(this.input);
        }

        public boolean matches() {
            return regExp.test(input);
        }

        public int groupCount() {
            return matchResult.getGroupCount();
        }

        public String group(int group) {
            return matchResult.getGroup(group);
        }

        public String group(String name) {
            return getMatchResultGroup((JavaScriptObject) (Object) matchResult, name);
        }

    */

    private static native String getMatchResultGroup(JavaScriptObject mr, String name) /*-{
        return mr.groups ? mr.groups[name] : null;
    }-*/;

    private final JavaScriptObject xRegExp;
    private JavaScriptObject matchResult;
    private boolean findConsumed;
    private int findStartPos, findMatchStartPos, findMatchLength;

    Matcher (Pattern pattern, CharSequence input) {
        this.input = String.valueOf(input);
        xRegExp = pattern.xRegExp;
        nextMatchResult(0);
    }

    private void nextMatchResult(int findStartPos) {
        matchResult = newMatchResult(xRegExp, input, findStartPos);
        this.findStartPos = findStartPos;
        if (matchResult != null) {
            findMatchStartPos = matchIndex(matchResult);
            findMatchLength = matchLength(matchResult);
        }
    }

    public boolean matches() {
        return matchResult != null;
    }

    public boolean find() {
        if (matchResult == null)
            return false;
        if (!findConsumed) {
            findConsumed = true;
            return true;
        }
        nextMatchResult(findMatchStartPos + findMatchLength);
        findConsumed = false;
        return matchResult != null;
    }

    public Matcher appendReplacement(StringBuilder sb, String replacement) {
        sb.append(input, findStartPos, findMatchStartPos).append(replacement);
        return this;
    }

    public StringBuilder appendTail(StringBuilder sb) {
        return sb.append(input.substring(findMatchStartPos + findMatchLength));
    }

    public int groupCount() {
        return matchResultLength(matchResult);
    }

    public String group(int group) {
        return matchValue(matchResult, group);
    }

    public String group(String name) {
        return getMatchResultGroup(matchResult, name);
    }

    private static native JavaScriptObject newMatchResult(JavaScriptObject xRegExp, String input, int pos) /*-{
        return $wnd.XRegExp.exec(input, xRegExp, pos);
    }-*/;

    private static native int matchIndex(JavaScriptObject mr) /*-{
        return mr.index;
    }-*/;

    private static native int matchLength(JavaScriptObject mr) /*-{
        return mr[0].length;
    }-*/;


    private static native int matchResultLength(JavaScriptObject mr) /*-{
        return mr.length;
    }-*/;

    private static native String matchValue(JavaScriptObject mr, int pos) /*-{
        //return Object.values(mr)[pos]; // not supported by IE
        return mr[Object.keys(mr)[pos]];
    }-*/;
}