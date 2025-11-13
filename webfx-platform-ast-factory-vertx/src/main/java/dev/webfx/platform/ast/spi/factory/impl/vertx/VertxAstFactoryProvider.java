package dev.webfx.platform.ast.spi.factory.impl.vertx;

import dev.webfx.platform.ast.*;
import dev.webfx.platform.ast.spi.factory.nativeast.NativeAstFactoryProvider;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.Map;

/**
 * @author Bruno Salmon
 */
public class VertxAstFactoryProvider implements NativeAstFactoryProvider {

    static VertxAstFactoryProvider INSTANCE;

    public VertxAstFactoryProvider() {
        INSTANCE = this;
    }

    @Override
    public Object createNativeObject() {
        return new JsonObject();
    }

    @Override
    public Object createNativeArray() {
        return new JsonArray();
    }

    @Override
    public boolean isAstObjectFromThisFactory(ReadOnlyAstObject astObject) {
        return astObject instanceof VertxAstObject;
    }

    @Override
    public boolean isAstArrayFromThisFactory(ReadOnlyAstArray astArray) {
        return astArray instanceof VertxAstArray;
    }

    @Override
    public Object astToNativeObject(ReadOnlyAstObject astObjectFromThisFactory) {
        return astObjectFromThisFactory == null ? null : ((VertxAstObject) astObjectFromThisFactory).getVertxObject();
    }

    @Override
    public Object astToNativeArray(ReadOnlyAstArray astArrayFromThisFactory) {
        return astArrayFromThisFactory == null ? null : ((VertxAstArray) astArrayFromThisFactory).getVertxArray();
    }

    @Override
    public boolean acceptAsNativeObject(Object nativeElement) {
        return nativeElement instanceof JsonObject || nativeElement instanceof Map || AST.isObject(nativeElement);
    }

    @Override
    public boolean acceptAsNativeArray(Object nativeElement) {
        return nativeElement instanceof JsonArray || nativeElement instanceof List || AST.isArray(nativeElement);
    }

    @Override
    public AstObject nativeToAstObject(Object nativeObject) {
        if (nativeObject == null)
            return null;
        if (nativeObject instanceof JsonObject vertxJsonObject)
            return new VertxAstObject(vertxJsonObject);
        if (nativeObject instanceof Map<?, ?> map)
            return new VertxAstObject(map);
        if (nativeObject instanceof AstObject astObject)
            return astObject;
        // Possible ClassCastException, especially with AST.createReadOnlySingleKeyAstObject() or other methods returning
        // a ReadOnlyAstObject. TODO: provide nativeToReadOnlyAstObject() method to avoid this
        return (AstObject) nativeObject;
    }

    @Override
    public AstArray nativeToAstArray(Object nativeArray) {
        if (nativeArray == null)
            return null;
        if (nativeArray instanceof JsonArray vertxJsonArray)
            return new VertxAstArray(vertxJsonArray);
        if (nativeArray instanceof List list)
            return new VertxAstArray(list);
        if (nativeArray instanceof AstArray astArray)
            return astArray;
        // TODO: provide nativeToReadOnlyAstArray() method to avoid this
        return (AstArray) nativeArray; // will throw a ClassCast exception
    }

}
