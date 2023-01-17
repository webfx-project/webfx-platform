package dev.webfx.platform.os.spi;

import dev.webfx.platform.os.OSFamily;

public interface OSProvider {

    OSFamily getOSFamily();

}
