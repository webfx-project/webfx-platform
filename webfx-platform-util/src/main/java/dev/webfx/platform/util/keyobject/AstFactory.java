package dev.webfx.platform.util.keyobject;

import dev.webfx.platform.util.keyobject.impl.listmap.ListMapAstFactory;

/**
 * @author Bruno Salmon
 */
public interface AstFactory {

    KeyObject createObject();

    IndexedArray createArray();

    static AstFactory get() {
        return ListMapAstFactory.getInstance();
    }

}
