package elemental2.dom;

import org.teavm.jso.JSBody;
import org.teavm.jso.JSObject;

/**
 * TeaVM polyfill for Elemental2's Console class
 */
public interface Console extends JSObject {

    @JSBody(params = {"messages"}, script = """
        var n = messages.length;
        if (n === 1) {
            console.log($rt_ustr(messages[0]));
        } else if (n === 0) {
            console.log();
        } else {
            var args = [];
            for (var i = 0; i < n; i++) {
              args.push($rt_ustr(messages[i]));
            }
            console.log.apply(console, args);
        }""")
    void log(Object... messages);

}