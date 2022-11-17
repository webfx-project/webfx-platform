package dev.webfx.platform.boot.spi.impl.vertx;

import dev.webfx.platform.vertx.common.VertxInstance;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonObject;
import io.vertx.core.net.JdkSSLEngineOptions;
import io.vertx.core.net.PemKeyCertOptions;
import io.vertx.ext.bridge.PermittedOptions;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;
import io.vertx.ext.web.handler.LoggerHandler;
import io.vertx.ext.web.handler.SessionHandler;
import io.vertx.ext.web.handler.StaticHandler;
import io.vertx.ext.web.handler.sockjs.BridgeEvent;
import io.vertx.ext.web.handler.sockjs.SockJSBridgeOptions;
import io.vertx.ext.web.handler.sockjs.SockJSHandler;
import io.vertx.ext.web.sstore.LocalSessionStore;
import io.vertx.ext.web.sstore.SessionStore;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Bruno Salmon
 */
final class VertxWebVerticle extends AbstractVerticle {

    @Override
    public void start() {
        // Http server
        createHttpServer(8080, null);
        // Https server (using Let's encrypt certificates)
        String certPath = "fullchain.pem";
        String keyPath = "privkey.pem";
        if (Files.exists(Path.of(certPath)) && Files.exists(Path.of(keyPath)))
            createHttpServer(9191, new PemKeyCertOptions().setCertPath(certPath).setKeyPath(keyPath));
    }

    private void createHttpServer(int port, PemKeyCertOptions pemKeyCertOptions) {
        // Creating web server and its router
        HttpServerOptions httpServerOptions = new HttpServerOptions()
                .setMaxWebSocketFrameSize(65536 * 100) // Increasing the frame size to allow big client request
                .setCompressionSupported(true) // enabling gzip and deflate compression
                .setPort(port) // web port
                .setSsl(pemKeyCertOptions != null)
                .setPemKeyCertOptions(pemKeyCertOptions)
                .setUseAlpn(JdkSSLEngineOptions.isAlpnAvailable()) // Enabling http2 if ALPN package is available
                ;
        HttpServer server = vertx.createHttpServer(httpServerOptions);
        Router router = Router.router(vertx);
        VertxInstance.setHttpRouter(router);

        // Logging web requests
        router.route("/*").handler(LoggerHandler.create());

        SessionStore sessionStore = LocalSessionStore.create(vertx);
        VertxInstance.setSessionStore(sessionStore);
        router.route("/*").handler(SessionHandler.create(sessionStore));

        // SockJS event bus bridge
        router.route("/eventbus/*").subRouter(SockJSHandler.create(vertx)
                .bridge(new SockJSBridgeOptions()
                        .setPingTimeout(40_000) // Should be higher than client WebSocketBusOptions.pingInterval (which is set to 30_000 at the time of writing this code)
                        .addInboundPermitted(new PermittedOptions(new JsonObject()))
                        .addOutboundPermitted(new PermittedOptions(new JsonObject()))
                        , bridgeEvent -> { // Calling the VertxInstance bridge event handler if set
                            Handler<BridgeEvent> bridgeEventHandler = VertxInstance.getBridgeEventHandler();
                            if (bridgeEventHandler != null)
                                bridgeEventHandler.handle(bridgeEvent);
                            else
                                bridgeEvent.complete(true);
                        }
                )
        );

        // GWT perfect caching (xxx.cache.xxx files will never change again)
        router.routeWithRegex(".*\\.cache\\..*").handler(routingContext -> {
            routingContext.response().putHeader("cache-control", "public, max-age=31556926");
            routingContext.next();
        });

        // SPA root page shouldn't be cached (to always return the latest version with the latest GWT compilation)
        router.routeWithRegex(".*/#/.*").handler(routingContext -> {
            routingContext.response().putHeader("cache-control", "public, max-age=0");
            routingContext.next();
        });

        // Serving static files under the webroot folder
        router.route("/*").handler(StaticHandler.create()); // Default one day MAX_AGE is ok except for root index page (how to fix that?)

        router.route("/*").handler(BodyHandler.create());

        // Binding the web port
        server.requestHandler(router).listen();
    }
}
