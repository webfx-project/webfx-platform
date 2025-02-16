package dev.webfx.platform.shutdown;

/**
 * @author Bruno Salmon
 */
public final class ShutdownEvent {

    private final ShutdownEventType type;
    private final ShutdownEventOrigin origin;

    public ShutdownEvent(ShutdownEventType type, ShutdownEventOrigin origin) {
        this.type = type;
        this.origin = origin;
    }

    public ShutdownEventType getType() {
        return type;
    }

    public ShutdownEventOrigin getOrigin() {
        return origin;
    }
}
