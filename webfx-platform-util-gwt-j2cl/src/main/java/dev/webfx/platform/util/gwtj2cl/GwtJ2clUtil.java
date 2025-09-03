package dev.webfx.platform.util.gwtj2cl;

import elemental2.core.JsIIterableResult;
import elemental2.core.JsIterator;
import elemental2.dom.DomGlobal;

import java.util.Iterator;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clUtil {

    public static <T> Iterator<T> jsIteratorToJavaIterator(JsIterator<T, ?, ?> jsIterator) {
        return new Iterator<>() {
            private JsIIterableResult<T> next = jsIterator.next();

            @Override
            public boolean hasNext() {
                return !next.isDone();
            }

            @Override
            public T next() {
                T value = next.getValue();
                next = jsIterator.next();
                return value;
            }
        };
    }

    private static boolean isSafariCached, safariChecked;
    public static boolean isSafari() {
        if (!safariChecked) {
            String ua = DomGlobal.navigator.userAgent;
            // Consider Safari when UA has Safari but not Chrome/Chromium/Edge (including iOS variants)
            boolean safariLike = ua.contains("Safari");
            boolean excludeChromium = ua.contains("Chrome") || ua.contains("Chromium") || ua.contains("CriOS") || ua.contains("Edg") || ua.contains("OPR") || ua.contains("FxiOS");
            isSafariCached = safariLike && !excludeChromium;
            safariChecked = true;
        }
        return isSafariCached;
    }


}
