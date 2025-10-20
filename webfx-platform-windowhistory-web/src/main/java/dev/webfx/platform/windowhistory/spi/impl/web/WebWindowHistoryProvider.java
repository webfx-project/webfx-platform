package dev.webfx.platform.windowhistory.spi.impl.web;

import dev.webfx.platform.ast.ReadOnlyAstObject;
import dev.webfx.platform.scheduler.Scheduler;
import dev.webfx.platform.util.Objects;
import dev.webfx.platform.util.Strings;
import dev.webfx.platform.windowhistory.spi.BrowsingHistoryEvent;
import dev.webfx.platform.windowhistory.spi.WindowHistoryProvider;
import dev.webfx.platform.windowhistory.spi.impl.BrowsingHistoryLocationImpl;
import dev.webfx.platform.windowhistory.spi.impl.MemoryBrowsingHistory;
import dev.webfx.platform.windowlocation.WindowLocation;
import dev.webfx.platform.windowlocation.spi.PathStateLocation;

/**
 * @author Bruno Salmon
 */
public final class WebWindowHistoryProvider extends MemoryBrowsingHistory implements WindowHistoryProvider {

    private final JsWindowHistory jsWindowHistory;
    private final boolean supportsStates;
    private final boolean showHash;

    public WebWindowHistoryProvider() {
        this(JsWindowHistory.get());
    }

    public WebWindowHistoryProvider(JsWindowHistory jsWindowHistory) {
        this.jsWindowHistory = jsWindowHistory;
        supportsStates = jsWindowHistory.supportsStates();
        //Console.log("supportsStates: " + supportsStates);
        showHash = true; // !supportsState;
        //jsWindowHistory.onBeforeUnload(event -> checkBeforeUnload(getCurrentLocation()));
        if (supportsStates)
            jsWindowHistory.onPopState(this::onPopState);
        // Can't access the platform API at this stage since it is currently initializing, so the remaining
        // initialization will be done later in checkInitialized()
    }

    private void checkInitialized() {
        if (getMountPoint() == null) {
            String mountPath = WindowLocation.getPathname();
            if (mountPath.endsWith("/index.html"))
                mountPath = mountPath.substring(0, mountPath.lastIndexOf('/') + 1);
            setMountPoint(mountPath);
            onPopState(supportsStates ? jsWindowHistory.state() : null);
            if (!supportsStates)
                Scheduler.schedulePeriodic(500, () -> {
                    if (!Objects.areEquals(WindowLocation.getFragment(), getCurrentLocation().getFragment()))
                        onPopState(null);
                });
        }
    }

    @Override
    protected String fullToMountPath(String fullPath) {
        checkInitialized();
        String subPath = super.fullToMountPath(fullPath);
        subPath = Strings.removePrefix(subPath, "index.html");
        subPath = Strings.removePrefix(subPath, "#");
        return subPath;
    }

    @Override
    protected String mountToFullPath(String mountPath) {
        checkInitialized();
        if (showHash && !mountPath.startsWith("#"))
            mountPath = "#" + mountPath;
        return super.mountToFullPath(mountPath);
    }

    @Override
    public BrowsingHistoryLocationImpl getCurrentLocation() {
        checkInitialized();
        return super.getCurrentLocation();
    }

    private void onPopState(ReadOnlyAstObject state) { // called a posteriori (origin: browser navigation)
        //Console.log("Entering onPopState() with state = " + state);
        // Transforming the current window location into a history location descriptor
        String path = fullToMountPath(WindowLocation.getPath());
        //Console.log("Pop state with path = " + path);
        PathStateLocation pathStateLocation = createPathStateLocation(path, state);
        int currentLocationIndex = getCurrentLocationIndex();
        int newLocationIndex;
        // Most probable indexes are backward or forward. Note: if the new path matches both previous and next index,
        // there is no way to know if it's backward or forward, so we just assume it's backward 🤷
        if (currentLocationIndex > 0 && Objects.areEquals(locationStack.get(currentLocationIndex - 1), pathStateLocation)) {
            newLocationIndex = currentLocationIndex - 1;
        } else if (currentLocationIndex < locationStack.size() - 1 && Objects.areEquals(locationStack.get(currentLocationIndex + 1), pathStateLocation)) {
            newLocationIndex = currentLocationIndex + 1;
        } else // neither backward nor forward, let's see if we get it
            newLocationIndex = locationStack.indexOf(pathStateLocation);
        //Console.log("Index in stack: " + newLocationIndex);
        BrowsingHistoryLocationImpl location;
        if (newLocationIndex != -1) {
            location = locationStack.get(newLocationIndex);
            location.setEvent(BrowsingHistoryEvent.POPPED);
            setCurrentLocationIndex(newLocationIndex);
        } else { // new history entry
            location = createHistoryLocation(pathStateLocation, BrowsingHistoryEvent.POPPED);
            super.doAcceptedPush(location);
        }
        // For any reason there is a performance issue with Chrome if we fire the location change now, so we defer it
        Scheduler.scheduleDeferred(() -> fireLocationChanged(location));
        //Console.log("Exiting onPopState");
    }

    @Override
    protected void doAcceptedPush(BrowsingHistoryLocationImpl historyLocation) { // Called a priori (origin: programmatically - typically ui router)
        //Console.log("Entering doAcceptedPush() with historyLocation = " + historyLocation);
        setGoingBackward(false);
        String path = historyLocation.getPath();
        if (supportsStates) {
            jsWindowHistory.pushState(historyLocation.getState(), null, path);
        } else {
            WindowLocation.assignHref(path);
        }
        super.doAcceptedPush(historyLocation);
    }

    @Override
    protected void doAcceptedReplace(BrowsingHistoryLocationImpl historyLocation) { // Called a priori (origin: programmatically - typically ui router)
        //Console.log("Entering doAcceptedReplace() with historyLocation = " + historyLocation);
        setGoingBackward(false);
        String path = historyLocation.getPath();
        if (supportsStates) {
            jsWindowHistory.replaceState(historyLocation.getState(), null, path);
        } else {
            WindowLocation.replaceHref(path);
        }
        super.doAcceptedReplace(historyLocation);
    }

    @Override
    public void go(int offset) {
        //Console.log("Entering go() with offset = " + offset);
        setCurrentLocationIndex(getCurrentLocationIndex() + offset);
        jsWindowHistory.go(offset);
        // super.go(offset); // Commented as this causes extra routing. TODO: find another way to synchronize the memory history
    }
}
