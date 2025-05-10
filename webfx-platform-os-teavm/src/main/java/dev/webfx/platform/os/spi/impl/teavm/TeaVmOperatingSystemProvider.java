package dev.webfx.platform.os.spi.impl.teavm;


import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;
import dev.webfx.platform.util.teavm.TeaVmUtil;
/**
 * @author Bruno Salmon
 */
public final class TeaVmOperatingSystemProvider extends OperatingSystemProviderBase {

    public TeaVmOperatingSystemProvider() {
        super(TeaVmUtil.getUserAgent());
    }
}


