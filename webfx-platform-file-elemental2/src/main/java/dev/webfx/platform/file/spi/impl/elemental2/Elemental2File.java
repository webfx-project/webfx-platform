package dev.webfx.platform.file.spi.impl.elemental2;

import dev.webfx.platform.blob.spi.impl.elemental2.Elemental2Blob;
import dev.webfx.platform.file.File;
import jsinterop.base.Js;

/**
 * @author Bruno Salmon
 */
public final class Elemental2File extends Elemental2Blob implements File {

    public Elemental2File(elemental2.dom.File jsFile) {
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
