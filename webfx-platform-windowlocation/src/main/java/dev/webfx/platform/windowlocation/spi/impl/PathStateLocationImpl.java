package dev.webfx.platform.windowlocation.spi.impl;

import dev.webfx.platform.windowlocation.spi.PathLocation;
import dev.webfx.platform.windowlocation.spi.PathStateLocation;

/**
 * @author Bruno Salmon
 */
public class PathStateLocationImpl extends PathLocationImpl implements PathStateLocation {

    private final Object state;

    public PathStateLocationImpl(PathStateLocation pathStateLocation) {
        this(pathStateLocation, pathStateLocation.getState());
    }

    public PathStateLocationImpl(PathLocation pathLocation, Object state) {
        super(pathLocation);
        this.state = state;
    }

    public PathStateLocationImpl(String path, String queryString, String fragment, Object state) {
        super(path, queryString, fragment);
        this.state = state;
    }

    @Override
    public Object getState() {
        return state;
    }

    /*@Override
    public String toString() {
        return "PathStateLocationImpl{" +
               "state=" + state +
               "} " + super.toString();
    }*/
}
