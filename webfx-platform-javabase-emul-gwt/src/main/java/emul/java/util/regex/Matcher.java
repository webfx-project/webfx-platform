package emul.java.util.regex;


import elemental2.core.JsArray;
import elemental2.core.JsObject;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

public class Matcher {

    private final String input;
    private final XRegExp xRegExp;
    private Object matchResult;
    private boolean findConsumed;
    private int findStartPos, findMatchStartPos, findMatchLength;

    private static String getMatchResultGroup(Object mr, String name) {
        // return mr.groups ? mr.groups[name] : null;
        Object groups = Js.asPropertyMap(mr).get("groups");
        return groups == null ? null : Js.asString(Js.asPropertyMap(groups).get(name));
    }

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

    public int start() {
        return findMatchStartPos;
    }

    public int end() {
        return findMatchStartPos + findMatchLength;
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
        return matchResult != null;
    }

    public Matcher appendReplacement(StringBuilder sb, String replacement) {
        sb.append(input, findStartPos, findMatchStartPos).append(replacement);
        return this;
    }

    public StringBuilder appendTail(StringBuilder sb) {
        return sb.append(input.substring(findMatchStartPos + findMatchLength));
    }

    public Matcher appendReplacement(StringBuffer sb, String replacement) {
        sb.append(input, findStartPos, findMatchStartPos).append(replacement);
        return this;
    }

    public StringBuffer appendTail(StringBuffer sb) {
        return sb.append(input.substring(findMatchStartPos + findMatchLength));
    }

    public int groupCount() {
        return matchResultLength(matchResult) - 1;
    }

    public String group(int group) {
        return matchValue(matchResult, group);
    }

    public String group(String name) {
        return getMatchResultGroup(matchResult, name);
    }

    private static Object newMatchResult(XRegExp xRegExp, String input, int pos) {
        //return $wnd.XRegExp.exec(input, xRegExp, pos);
        return XRegExp.exec(input, xRegExp, pos);
    }

    private static int matchIndex(Object mr) {
        // return mr.index;
        return Js.asInt(Js.asPropertyMap(mr).get("index"));
    }

    private static int matchLength(Object mr) {
        // return mr[0].length;
        return Js.asString(Js.asArray(mr)[0]).length();
    }

    private static int matchResultLength(Object mr) {
        // return mr.length
        JsPropertyMap<Object> map = Js.asPropertyMap(mr);
        Object length = map.get("length");
        return Js.asInt(length);
    }

    private static String matchValue(Object mr, int pos) {
        //return Object.values(mr)[pos]; // not supported by IE
        //return mr[Object.keys(mr)[pos]];
        JsArray<String> keys = JsObject.keys(mr);
        String key = keys.getAt(pos); // Using getAt() for legacy browser support (avoids Array.prototype.at)
        Object value = Js.asPropertyMap(mr).get(key);
        return value == null ? null : Js.asString(value);
    }

}