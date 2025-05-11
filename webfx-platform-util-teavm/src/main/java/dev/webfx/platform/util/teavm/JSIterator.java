package dev.webfx.platform.util.teavm;

/**
 * @author Bruno Salmon
 */
public interface JSIterator<VALUE> {

    JSIIterableResult<VALUE> next();

    JSIIterableResult<VALUE> next(Object value);
}
