package dev.webfx.platform.useragent.spi.impl.teavm;

import dev.webfx.platform.useragent.spi.impl.BrowserUserAgentProvider;
import dev.webfx.platform.util.teavm.TeaVmUtil;

/**
 * @author Bruno Salmon
 */
public final class TeaVmUserAgentProvider extends BrowserUserAgentProvider {

    public TeaVmUserAgentProvider() {
        super(TeaVmUtil.getUserAgent());
    }
}