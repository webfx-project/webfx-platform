package dev.webfx.platform.arch.spi.impl.teavm;

import dev.webfx.platform.arch.spi.impl.web.WebArchProvider;
import dev.webfx.platform.util.teavm.TeaVmUtil;

/**
 * @author Bruno Salmon
 */
public final class TeaVmArchProvider extends WebArchProvider {

    public TeaVmArchProvider() {
        super(
            TeaVmUtil.getUserAgent(),
            TeaVmUtil.getPlatform(),
            TeaVmUtil.getCpuClass(),
            TeaVmUtil.getHardwareConcurrency()
        );
    }

}