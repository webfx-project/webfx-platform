package dev.webfx.platform.ast;

import dev.webfx.platform.ast.spi.factory.AstFactoryProvider;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;

/**
 * @author Bruno Salmon
 */
public final class AstCloneVisitor extends AstVisitor {
    private final AstFactoryProvider factory;
    private final NativeAstFactoryProvider nativeFactory;
    private final boolean platform;
    private AstObject cloningObject;
    private AstArray cloningArray;


    public AstCloneVisitor(AstFactoryProvider factory, boolean platform) {
        this.factory = factory;
        nativeFactory = factory instanceof NativeAstFactoryProvider ? (NativeAstFactoryProvider) factory : null;
        this.platform = platform;
    }

    @Override
    public Object visitAstObject(ReadOnlyAstObject astObject) {
        AstObject oldCloningObject = cloningObject;
        AstObject newCloningObject = cloningObject = platform && nativeFactory.isAstObjectFromThisFactory(astObject) && astObject instanceof AstObject ? (AstObject) astObject : factory.createObject();
        super.visitAstObject(astObject);
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
    public Object visitAstArray(ReadOnlyAstArray array) {
        AstArray oldCloningArray = cloningArray;
        AstArray newCloningArray = cloningArray = platform && nativeFactory.isAstArrayFromThisFactory(array) && array instanceof AstArray ? (AstArray) array : factory.createArray();
        super.visitAstArray(array);
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
