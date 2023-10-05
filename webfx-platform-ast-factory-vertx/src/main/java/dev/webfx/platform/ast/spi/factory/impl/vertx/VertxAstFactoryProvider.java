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
        if (nativeObject instanceof JsonObject)
            return new VertxAstObject((JsonObject) nativeObject);
        if (nativeObject instanceof Map)
            return new VertxAstObject((Map) nativeObject);
        return (AstObject) nativeObject;
    }

    @Override
    public AstArray nativeToAstArray(Object nativeArray) {
        if (nativeArray instanceof JsonArray)
            return new VertxAstArray((JsonArray) nativeArray);
        if (nativeArray instanceof List)
            return new VertxAstArray((List) nativeArray);
        return (AstArray) nativeArray;
    }

}
