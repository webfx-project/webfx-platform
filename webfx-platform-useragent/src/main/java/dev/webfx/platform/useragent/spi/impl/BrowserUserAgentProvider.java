package dev.webfx.platform.useragent.spi.impl;

/**
 * @author Bruno Salmon
 */
public class BrowserUserAgentProvider extends ClientUserAgentProvider {

    private static final String CHROME_TAG = "chrome/";
    private static final String FIREFOX_TAG = "firefox/";
    private static final String SAFARI_TAG = "safari/";
    private static final String EDGE_TAG1 = "edge/";
    private static final String EDGE_TAG2 = "edg/";

    private static boolean IS_CHROME;
    private static boolean IS_FIREFOX;
    private static boolean IS_SAFARI;
    private static boolean IS_EDGE;
    private static boolean IS_OTHER;
    private static String BROWSER_VERSION;
    private static int BROWSER_MAJOR_VERSION = -1;

    public BrowserUserAgentProvider(String userAgentName) {
        super(userAgentName, true, false);
    }

    @Override
    public boolean isChrome() {
        checkBrowserDetectionIsDone();
        return IS_CHROME;
    }

    @Override
    public boolean isFireFox() {
        checkBrowserDetectionIsDone();
        return IS_FIREFOX;
    }

    @Override
    public boolean isSafari() {
        checkBrowserDetectionIsDone();
        return IS_SAFARI;
    }

    @Override
    public boolean isEdge() {
        checkBrowserDetectionIsDone();
        return IS_EDGE;
    }

    @Override
    public boolean isOtherBrowser() {
        checkBrowserDetectionIsDone();
        return IS_OTHER;
    }

    @Override
    public String getBrowserVersion() {
        checkBrowserDetectionIsDone();
        return BROWSER_VERSION;
    }

    @Override
    public int getBrowserMajorVersion() {
        checkBrowserDetectionIsDone();
        return BROWSER_MAJOR_VERSION;
    }

    private void checkBrowserDetectionIsDone() {
        if (BROWSER_VERSION == null) {
            String userAgent = getUserAgentName().toLowerCase();
            boolean isEdge1 = userAgent.contains(EDGE_TAG1);
            boolean isEdge2 = userAgent.contains(EDGE_TAG2);
            IS_EDGE = isEdge1 || isEdge2;
            IS_FIREFOX = !IS_EDGE && userAgent.contains(FIREFOX_TAG);
            IS_SAFARI = !IS_EDGE && !IS_FIREFOX && userAgent.contains(SAFARI_TAG) && !userAgent.contains(CHROME_TAG) && !userAgent.contains("android");
            IS_CHROME = !IS_EDGE && !IS_FIREFOX && !IS_SAFARI && userAgent.contains(CHROME_TAG);
            IS_OTHER = !IS_EDGE && !IS_FIREFOX && !IS_SAFARI && !IS_CHROME;
            String browserTag = IS_CHROME ? CHROME_TAG : IS_FIREFOX ? FIREFOX_TAG : IS_SAFARI ? SAFARI_TAG : isEdge1 ? EDGE_TAG1 : isEdge2 ? EDGE_TAG2 : null;
            int versionPos = browserTag == null ? -1 : userAgent.indexOf(browserTag);
            if (versionPos < 0) {
                BROWSER_VERSION = "Unknown";
                BROWSER_MAJOR_VERSION = -1;
            } else {
                String versionAndSoOn = userAgent.substring(versionPos + browserTag.length());
                int nextSpacePos = versionAndSoOn.indexOf(' ');
                BROWSER_VERSION = nextSpacePos == -1 ? versionAndSoOn : versionAndSoOn.substring(0, nextSpacePos);
                BROWSER_MAJOR_VERSION = Integer.parseInt(BROWSER_VERSION.substring(0, BROWSER_VERSION.indexOf('.')));
            }
        }
    }
}
