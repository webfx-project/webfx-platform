package dev.webfx.platform.file.spi.impl.gwtj2cl;

import dev.webfx.platform.blob.spi.impl.gwtj2cl.GwtJ2clBlob;
import dev.webfx.platform.file.File;
import jsinterop.base.Js;

/**
 * @author Bruno Salmon
 */
public final class GwtJ2clFile extends GwtJ2clBlob implements File {

    public GwtJ2clFile(elemental2.dom.File jsFile) {
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
        return (String) Js.asPropertyMap(getPlatformBlob()).get("webkitRelativePath");
    }

}
