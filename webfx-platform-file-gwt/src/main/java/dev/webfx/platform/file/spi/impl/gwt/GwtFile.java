package dev.webfx.platform.file.spi.impl.gwt;

import dev.webfx.platform.file.File;

/**
 * @author Bruno Salmon
 */
public final class GwtFile extends GwtBlob implements File {

    public GwtFile(elemental2.dom.File jsFile) {
        super(jsFile);
    }

    @Override
    public elemental2.dom.File getPlatformBlob() {
        return (elemental2.dom.File) super.getPlatformBlob();
    }

    @Override
    public String getName() {
        return getPlatformBlob().name;
    }

    @Override
    public long lastModified() {
        return (long) getPlatformBlob().lastModified;
    }

    @Override
    public String getParentPath() {
        return getJsJavaObjectAttribute(getPlatformBlob(), "webkitRelativePath");
    }

    public static native <T> T getJsJavaObjectAttribute(elemental2.dom.File o, String name) /*-{
        return o[name];
    }-*/;

}