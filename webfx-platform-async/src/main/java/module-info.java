// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        Platform-independent API for asynchronous operations (such as the Fetch API provided by the webfx-platform-fetch
        module) (see {@link dev.webfx.platform.async.Future Future} &amp;
        {@link dev.webfx.platform.async.Promise Promise}).
    
 */
module webfx.platform.async {

    // Direct dependencies modules
    requires java.logging;
    requires webfx.platform.util;

    // Exported packages
    exports dev.webfx.platform.async;
    exports dev.webfx.platform.async.impl;
    exports dev.webfx.platform.async.util;

}