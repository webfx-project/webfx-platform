package dev.webfx.platform.vertx.common;

import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.sockjs.BridgeEvent;
import io.vertx.ext.web.sstore.SessionStore;

/**
 * @author Bruno Salmon
 */
public final class VertxInstance {

    private static Vertx VERTX;
    private static Router HTTP_ROUTER;
    private static SessionStore SESSION_STORE;
    private static Handler<BridgeEvent> BRIDGE_EVENT_HANDLER;

    public static void setVertx(Vertx vertx) {
        VERTX = vertx;
    }

    public static Vertx getVertx() {
        return VERTX;
    }

    public static Router getHttpRouter() {
        return HTTP_ROUTER;
    }

    public static void setHttpRouter(Router httpRouter) {
        HTTP_ROUTER = httpRouter;
    }

    public static SessionStore getSessionStore() {
        return SESSION_STORE;
    }

    public static void setSessionStore(SessionStore sessionStore) {
        SESSION_STORE = sessionStore;
    }

    public static Handler<BridgeEvent> getBridgeEventHandler() {
        return BRIDGE_EVENT_HANDLER;
    }

    public static void setBridgeEventHandler(Handler<BridgeEvent> bridgeEventHandler) {
        VertxInstance.BRIDGE_EVENT_HANDLER = bridgeEventHandler;
    }

}
