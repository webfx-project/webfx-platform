package dev.webfx.platform.windowhistory.spi.impl;

import dev.webfx.platform.windowhistory.spi.BrowsingHistoryEvent;
import dev.webfx.platform.windowhistory.spi.BrowsingHistoryLocation;

import java.util.Stack;

/**
 * @author Bruno Salmon
 */
public class MemoryBrowsingHistory extends BrowsingHistoryBase {

    protected final Stack<BrowsingHistoryLocationImpl> locationStack = new Stack<>();
    private int currentLocationIndex = -1;

    public int getCurrentLocationIndex() {
        return currentLocationIndex;
    }

    public void setCurrentLocationIndex(int currentLocationIndex) {
        setGoingBackward(currentLocationIndex < this.currentLocationIndex);
        //Console.log("Setting currentLocationIndex to " + currentLocationIndex);
        this.currentLocationIndex = currentLocationIndex;
    }

    @Override
    public BrowsingHistoryLocationImpl getCurrentLocation() {
        int index = getCurrentLocationIndex();
        return index >= 0 && index < locationStack.size() ? locationStack.get(index) : null;
    }

    @Override
    public void transitionTo(BrowsingHistoryLocation location) {
        int index = locationStack.indexOf(location);
        if (index >= 0)
            go(index - getCurrentLocationIndex());
    }

    @Override
    public void go(int offset) {
        int previousLocationIndex = getCurrentLocationIndex();
        int requestedLocationIndex = previousLocationIndex + offset;
        if (offset != 0 && requestedLocationIndex >= 0 && requestedLocationIndex < locationStack.size()) {
            setCurrentLocationIndex(requestedLocationIndex);
            BrowsingHistoryLocationImpl newLocation = getCurrentLocation();
            checkBeforeUnloadThenCheckBeforeThenTransit(newLocation, BrowsingHistoryEvent.POPPED)
                    .onFailure(cause -> setCurrentLocationIndex(previousLocationIndex));
        }
    }

    @Override
    protected void doAcceptedPush(BrowsingHistoryLocationImpl historyLocation) {
        while (!locationStack.empty() && currentLocationIndex < locationStack.size() - 1)
            locationStack.pop();
        locationStack.push(historyLocation);
        setCurrentLocationIndex(locationStack.size() - 1);
        //logLocationStack();
    }

    protected void doAcceptedReplace(BrowsingHistoryLocationImpl historyLocation) {
        setGoingBackward(false);
        int index = getCurrentLocationIndex();
        if (index != -1)
            locationStack.set(index, historyLocation);
        else {
            locationStack.push(historyLocation);
            setCurrentLocationIndex(locationStack.size() - 1);
        }
        //logLocationStack();
    }

    /*private void logLocationStack() {
        Console.log("locationStack: " + Collections.toString(locationStack, true, true));
    }*/

}
