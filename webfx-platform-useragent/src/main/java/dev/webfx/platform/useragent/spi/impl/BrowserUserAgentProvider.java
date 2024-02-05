package dev.webfx.platform.useragent.spi.impl;

import dev.webfx.platform.useragent.BrowserType;

/**
 * @author Bruno Salmon
 */
public class BrowserUserAgentProvider extends ClientUserAgentProvider {

    private static final String CHROME_TAG = "chrome/";
    private static final String FIREFOX_TAG = "firefox/";
    private static final String SAFARI_TAG = "safari/";
    private static final String EDGE_TAG1 = "edge/";
    private static final String EDGE_TAG2 = "edg/";
    private static final String OPERA_TAG1 = "opera/";
    private static final String OPERA_TAG2 = "opr/";

    private final BrowserType browserType;
    private final String browserVersion;
    private final int browserMajorVersion;

    public BrowserUserAgentProvider(String userAgentName) {
        super(userAgentName, true, false);
        String userAgent = userAgentName.toLowerCase();
        boolean isOpera1 = userAgent.contains(OPERA_TAG1);
        boolean isOpera2 = userAgent.contains(OPERA_TAG2);
        boolean isEdge1 = userAgent.contains(EDGE_TAG1);
        boolean isEdge2 = userAgent.contains(EDGE_TAG2);
        String browserTag;
        if (isOpera1 || isOpera2) {
            browserType = BrowserType.OPERA;
            browserTag = isOpera1 ? OPERA_TAG1 : OPERA_TAG2;
        } else if (isEdge1 || isEdge2) {
            browserType = BrowserType.EDGE;
            browserTag = isEdge1 ? EDGE_TAG1 : EDGE_TAG2;
        } else if (userAgent.contains(FIREFOX_TAG)) {
            browserType = BrowserType.FIREFOX;
            browserTag = FIREFOX_TAG;
        } else if (userAgent.contains(SAFARI_TAG) && !userAgent.contains(CHROME_TAG) && !userAgent.contains("android")) {
            browserType = BrowserType.SAFARI;
            browserTag = SAFARI_TAG;
        } else if (userAgent.contains(CHROME_TAG)) {
            browserType = BrowserType.CHROME;
            browserTag = CHROME_TAG;
        } else {
            browserType = BrowserType.UNKNOWN;
            browserTag = null;
        }
        int versionPos = browserTag == null ? -1 : userAgent.indexOf(browserTag);
        if (versionPos < 0) {
            browserVersion = "Unknown";
            browserMajorVersion = -1;
        } else {
            String versionAndSoOn = userAgent.substring(versionPos + browserTag.length());
            int nextSpacePos = versionAndSoOn.indexOf(' ');
            browserVersion = nextSpacePos == -1 ? versionAndSoOn : versionAndSoOn.substring(0, nextSpacePos);
            browserMajorVersion = Integer.parseInt(browserVersion.substring(0, browserVersion.indexOf('.')));
        }
        //dev.webfx.platform.console.Console.log("browserType = " + browserType + ", browserVersion = " + browserVersion);
    }

    @Override
    public BrowserType getBrowserType() {
        return browserType;
    }

    @Override
    public String getBrowserVersion() {
        return browserVersion;
    }

    @Override
    public int getBrowserMajorVersion() {
        return browserMajorVersion;
    }
}
