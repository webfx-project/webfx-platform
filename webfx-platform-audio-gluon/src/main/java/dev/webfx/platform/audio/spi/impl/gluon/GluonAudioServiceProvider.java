package dev.webfx.platform.audio.spi.impl.gluon;

import dev.webfx.platform.audio.Audio;
import dev.webfx.platform.audio.spi.AudioServiceProvider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public final class GluonAudioServiceProvider implements AudioServiceProvider {

    private final com.gluonhq.attach.audio.AudioService audioService = com.gluonhq.attach.audio.AudioService.create()
            .orElseThrow(() -> new IllegalStateException("Couldn't instantiate Gluon Audio service. Is <attachList>audio</attachList> present in your GluonFX Maven plugin configuration?"));

    @Override
    public Audio loadSound(String url) {
        try {
            Optional<com.gluonhq.attach.audio.Audio> audio = audioService.loadSound(new URL(url));
            return new GluonAudio(audio.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Audio loadMusic(String url) {
        try {
            Optional<com.gluonhq.attach.audio.Audio> audio = audioService.loadMusic(new URL(url));
            return new GluonAudio(audio.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean supportsMusicSpectrumAnalysis() {
        return false;
    }
}
