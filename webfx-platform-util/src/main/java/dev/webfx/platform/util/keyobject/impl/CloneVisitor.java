package dev.webfx.platform.util.keyobject.impl;

import dev.webfx.platform.util.keyobject.*;

/**
 * @author Bruno Salmon
 */
public final class CloneVisitor extends AstVisitor {
    private final AstFactory factory;
    private final NativeAstFactory nativeFactory;
    private final boolean platform;
    private KeyObject cloningObject;
    private IndexedArray cloningArray;


    public CloneVisitor(AstFactory factory, boolean platform) {
        this.factory = factory;
        nativeFactory = factory instanceof NativeAstFactory ? (NativeAstFactory) factory : null;
        this.platform = platform;
    }

    @Override
    public Object visitTreeObject(ReadOnlyKeyObject keyObject) {
        KeyObject oldCloningObject = cloningObject;
        KeyObject newCloningObject = cloningObject = platform && nativeFactory.isNativeObject(keyObject) && keyObject instanceof KeyObject ? (KeyObject) keyObject : factory.createObject();
        super.visitTreeObject(keyObject);
        cloningObject = oldCloningObject;
        return newCloningObject;
    }

    @Override
    protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyKeyObject keyObject) {
        Object clonedValue = super.visitKeyValue(key, value, keyIndex, keyCount, keyObject);
        cloningObject.set(key, clonedValue);
        return clonedValue;
    }

    @Override
    public Object visitTreeArray(ReadOnlyIndexedArray array) {
        IndexedArray oldCloningArray = cloningArray;
        IndexedArray newCloningArray = cloningArray = platform && nativeFactory.isNativeArray(array) && array instanceof IndexedArray ? (IndexedArray) array : factory.createArray();
        super.visitTreeArray(array);
        cloningArray = oldCloningArray;
        return newCloningArray;
    }

    @Override
    protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyIndexedArray array) {
        Object clonedValue = super.visitIndexedValue(value, keyIndex, keyCount, array);
        if (keyIndex < cloningArray.size())
            cloningArray.set(keyIndex, value);
        else
            cloningArray.push(clonedValue);
        return clonedValue;
    }

    @Override
    protected Object visitScalar(Object scalar) {
        return scalar;
    }

}
