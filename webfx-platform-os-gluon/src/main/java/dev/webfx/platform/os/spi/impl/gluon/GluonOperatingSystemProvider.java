package dev.webfx.platform.os.spi.impl.gluon;

import com.gluonhq.attach.util.Platform;
import dev.webfx.platform.os.spi.impl.OperatingSystemProviderBase;

/**
 * @author Bruno Salmon
 */
public final class GluonOperatingSystemProvider extends OperatingSystemProviderBase {

    public GluonOperatingSystemProvider() {
        super(
                Platform.isAndroid() ? "Android" : // Note: System.getProperty("os.name") can't be used because it returns Linux in this case
                Platform.isIOS() ? "iOS" : // Note: System.getProperty("os.name") can't be used because it returns macOS in this case
                // Other platforms are desktops, so either Linux, macOS or Windows
                System.getProperty("os.name") // Note: this returns the OS of the machine used during the Gluon compilation, not the OS of the machine running the app, however they should match
        );
    }

}
