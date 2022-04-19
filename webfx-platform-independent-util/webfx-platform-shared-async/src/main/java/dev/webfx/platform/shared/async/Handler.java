package dev.webfx.platform.shared.async;

// Async API inspired from Vert.x (simplified, without Vert.x context and Netty dependency)

/**
 *  A generic event handler.
 *  <p>
 *  This interface is used heavily throughout Vert.x as a handler for all types of asynchronous occurrences.
 *  <p>
 *
 *  @author <a href="http://tfox.org">Tim Fox</a>
 */
@FunctionalInterface
public interface Handler<E> {

    /**
     * Something has happened, so handle it.
     *
     * @param event  the event to handle
     */
    void handle(E event);
}
