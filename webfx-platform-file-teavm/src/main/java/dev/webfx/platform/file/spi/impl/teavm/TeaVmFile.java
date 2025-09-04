package dev.webfx.platform.file.spi.impl.teavm;

import dev.webfx.platform.blob.spi.impl.teavm.TeaVmBlob;
import dev.webfx.platform.file.File;

/**
 * @author Bruno Salmon
 */
final class TeaVmFile extends TeaVmBlob implements File {

    public TeaVmFile(JSFile jsFile) {
        super(jsFile);
    }

    @Override
    public JSFile getPlatformBlob() {
        return (JSFile) super.getPlatformBlob();
    }

    @Override
    public String getName() {
        return getPlatformBlob().getName();
    }

    @Override
    public long lastModified() {
        return (long) getPlatformBlob().getLastModified();
    }

    @Override
    public String getParentPath() {
        return getPlatformBlob().getWebkitRelativePath();
    }

}