package dev.webfx.platform.util.keyobject.impl.listmap;

import dev.webfx.platform.util.keyobject.IndexedArray;
import dev.webfx.platform.util.keyobject.KeyObject;
import dev.webfx.platform.util.keyobject.AstFactory;

/**
 * @author Bruno Salmon
 */
public final class ListMapAstFactory implements AstFactory {

    private final static ListMapAstFactory INSTANCE = new ListMapAstFactory();

    public static ListMapAstFactory getInstance() {
        return INSTANCE;
    }

    @Override
    public KeyObject createObject() {
        return new MapKeyObject();
    }

    @Override
    public IndexedArray createArray() {
        return new ListIndexedArray();
    }
}
