package elemental2.dom;

import jsinterop.base.Js;
import org.teavm.jso.JSObject;

/**
 * @author Bruno Salmon
 */
public interface CSSProperties extends JSObject {

    interface LineHeightUnionType extends JSObject {
        static CSSProperties.LineHeightUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface WidthUnionType extends JSObject {
        static CSSProperties.WidthUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface HeightUnionType extends JSObject {
        static CSSProperties.HeightUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface OpacityUnionType extends JSObject {
        static CSSProperties.OpacityUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface TransformOriginUnionType extends JSObject {
        static CSSProperties.TransformOriginUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface MaxWidthUnionType extends JSObject {
        static CSSProperties.MaxWidthUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface MaxHeightUnionType extends JSObject {
        static CSSProperties.MaxHeightUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface BorderTopLeftRadiusUnionType extends JSObject {
        static CSSProperties.BorderTopLeftRadiusUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface BorderTopRightRadiusUnionType extends JSObject {
        static CSSProperties.BorderTopRightRadiusUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface BorderBottomRightRadiusUnionType extends JSObject {
        static CSSProperties.BorderBottomRightRadiusUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface BorderBottomLeftRadiusUnionType extends JSObject {
        static CSSProperties.BorderBottomLeftRadiusUnionType of(Object o) {
            return Js.cast(o);
        }
    }

    interface BorderRadiusUnionType extends JSObject {
        static CSSProperties.BorderRadiusUnionType of(Object o) {
            return Js.cast(o);
        }
    }

}
