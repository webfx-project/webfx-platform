package dev.webfx.platform.util.teavm;

import org.teavm.jso.JSProperty;

/**
 * @author Bruno Salmon
 */
public interface JSIIterableResult<VALUE> {

    @JSProperty
    VALUE getValue();

    @JSProperty
    boolean isDone();

    @JSProperty
    void setDone(boolean done);

    @JSProperty
    void setValue(VALUE value);
}

