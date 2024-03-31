// File managed by WebFX (DO NOT EDIT MANUALLY)

/**
 * 
        
        Cross-platform API for accessing local files (mock of the Web File API). Files can't be created programmatically,
        but they can be instantiated by some other APIs such as the FilePicker provided as part of WebFX Extras.
        More info can be found in this &lt;a href="https://blog.webfx.dev/2022/10/19/accessing-local-files/"&gt;post&lt;/a&gt;.
        
    
 */
module webfx.platform.file {

    // Direct dependencies modules
    requires transitive webfx.platform.async;
    requires webfx.platform.blob;
    requires webfx.platform.service;

    // Exported packages
    exports dev.webfx.platform.file;
    exports dev.webfx.platform.file.spi;

    // Used services
    uses dev.webfx.platform.file.spi.FileProvider;

}