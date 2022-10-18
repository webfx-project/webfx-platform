package dev.webfx.platform.file.spi.impl.gwt;

import dev.webfx.platform.file.File;
import elemental2.dom.URL;

/**
 * @author Bruno Salmon
 */
public final class GwtFile implements File {

    private final elemental2.dom.File jsPlatformFile;
    private String url;

    public GwtFile(elemental2.dom.File jsPlatformFile) {
        this.jsPlatformFile = jsPlatformFile;
    }

    @Override
    public elemental2.dom.File getPlatformFile() {
        return jsPlatformFile;
    }

    @Override
    public String getName() {
        return jsPlatformFile.name;
    }

    @Override
    public long length() {
        return jsPlatformFile.size;
    }

    @Override
    public long lastModified() {
        return (long) jsPlatformFile.lastModified;
    }

    @Override
    public String getMimeType() {
        return jsPlatformFile.type;
    }

    @Override
    public String getObjectURL() {
        if (url == null)
            url = URL.createObjectURL(jsPlatformFile);
        return url;
    }

    @Override
    public String getParentPath() {
        return getJsJavaObjectAttribute(jsPlatformFile, "webkitRelativePath");
    }

    public static native <T> T getJsJavaObjectAttribute(elemental2.dom.File o, String name) /*-{
        return o[name];
    }-*/;

}
