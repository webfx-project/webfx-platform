package dev.webfx.platform.audio;

import dev.webfx.platform.audio.spi.AudioServiceProvider;
import dev.webfx.platform.util.serviceloader.SingleServiceProvider;

import java.util.ServiceLoader;

/**
 * @author Bruno Salmon
 */
public final class AudioService {

    private AudioService() {}

    private static AudioServiceProvider getProvider() {
        return SingleServiceProvider.getProvider(AudioServiceProvider.class, () -> ServiceLoader.load(AudioServiceProvider.class));
    }

    public static Audio loadSound(String url) {
        return getProvider().loadSound(url);
    }

    public static Audio loadMusic(String url) {
        return getProvider().loadMusic(url);
    }

    public static boolean supportsMusicSpectrumAnalysis() {
        return getProvider().supportsMusicSpectrumAnalysis();
    }

}
