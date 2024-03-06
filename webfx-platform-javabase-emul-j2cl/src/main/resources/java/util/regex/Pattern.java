package java.util.regex;
public final class Pattern {

    public Matcher matcher(CharSequence input) {
        return new Matcher(this, input);
    }

    public static Pattern compile(String regExp) {
        return new Pattern(regExp);
    }

    final XRegExp xRegExp;

    private Pattern (String regExp) {
        xRegExp = new XRegExp(regExp);
    }

}
