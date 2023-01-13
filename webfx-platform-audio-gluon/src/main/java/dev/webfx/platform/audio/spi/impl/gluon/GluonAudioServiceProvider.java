package dev.webfx.platform.audio.spi.impl.gluon;

import dev.webfx.platform.audio.Audio;
import dev.webfx.platform.audio.spi.AudioServiceProvider;
import dev.webfx.platform.console.Console;

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
        return loadAudio(url, false);
    }

    @Override
    public Audio loadMusic(String url) {
        return loadAudio(url, true);
    }

    private Audio loadAudio(String urlString, boolean music) {
        Console.log("Loading " + (music ? "music" : "sound") + " from url " + urlString);
        try {
            URL url = new URL(urlString);
            Optional<com.gluonhq.attach.audio.Audio> audio = music ? audioService.loadMusic(url) : audioService.loadSound(url);
            GluonAudio gluonAudio = audio.map(GluonAudio::new).orElse(null);
            if (gluonAudio == null)
                Console.log("Unable to load " + urlString + " (maybe not enough memory)");
            return gluonAudio;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean supportsMusicSpectrumAnalysis() {
        return false;
    }
}
