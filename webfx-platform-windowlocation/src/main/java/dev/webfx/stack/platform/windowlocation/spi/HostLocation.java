package dev.webfx.stack.platform.windowlocation.spi;

/**
 * @author Bruno Salmon
 */
public interface HostLocation {

    /**
     * Ex: https in https://developer.mozilla.org/en-US/search?q=URL#search-results-close-container
     * @return A String containing the protocol scheme of the URL.
     */
    String getProtocol();

    /**
     * Ex: developer.mozilla.org in https://developer.mozilla.org:443/en-US/search?q=URL#search-results-close-container
     * @return A String containing the domain of the URL.
     */
    String getHostname();

    /**
     * Ex: 443 in https://developer.mozilla.org:443/en-US/search?q=URL#search-results-close-container
     * @return A String containing the port number of the URL (or blank if not specified)
     */
    String getPort();

}
