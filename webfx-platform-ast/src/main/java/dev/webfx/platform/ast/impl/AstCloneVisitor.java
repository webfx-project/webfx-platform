package dev.webfx.platform.ast.impl;

import dev.webfx.platform.ast.*;

/**
 * @author Bruno Salmon
 */
public final class AstCloneVisitor extends AstVisitor {
    private final AstFactory factory;
    private final NativeAstFactory nativeFactory;
    private final boolean platform;
    private AstObject cloningObject;
    private AstArray cloningArray;


    public AstCloneVisitor(AstFactory factory, boolean platform) {
        this.factory = factory;
        nativeFactory = factory instanceof NativeAstFactory ? (NativeAstFactory) factory : null;
        this.platform = platform;
    }

    @Override
    public Object visitTreeObject(ReadOnlyAstObject astObject) {
        AstObject oldCloningObject = cloningObject;
        AstObject newCloningObject = cloningObject = platform && nativeFactory.isNativeObject(astObject) && astObject instanceof AstObject ? (AstObject) astObject : factory.createObject();
        super.visitTreeObject(astObject);
        cloningObject = oldCloningObject;
        return newCloningObject;
    }

    @Override
    protected Object visitKeyValue(String key, Object value, int keyIndex, int keyCount, ReadOnlyAstObject astObject) {
        Object clonedValue = super.visitKeyValue(key, value, keyIndex, keyCount, astObject);
        cloningObject.set(key, clonedValue);
        return clonedValue;
    }

    @Override
    public Object visitTreeArray(ReadOnlyAstArray array) {
        AstArray oldCloningArray = cloningArray;
        AstArray newCloningArray = cloningArray = platform && nativeFactory.isNativeArray(array) && array instanceof AstArray ? (AstArray) array : factory.createArray();
        super.visitTreeArray(array);
        cloningArray = oldCloningArray;
        return newCloningArray;
    }

    @Override
    protected Object visitIndexedValue(Object value, int keyIndex, int keyCount, ReadOnlyAstArray array) {
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
