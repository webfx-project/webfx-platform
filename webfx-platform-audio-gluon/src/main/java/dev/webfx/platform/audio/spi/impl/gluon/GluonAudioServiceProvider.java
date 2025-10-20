package dev.webfx.platform.audio.spi.impl.gluon;

import dev.webfx.platform.audio.Audio;
import dev.webfx.platform.audio.spi.AudioServiceProvider;
import dev.webfx.platform.console.Console;
import dev.webfx.platform.scheduler.Scheduler;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

/**
 * @author Bruno Salmon
 */
public final class GluonAudioServiceProvider implements AudioServiceProvider {

    private com.gluonhq.attach.audio.AudioService audioService;

    public GluonAudioServiceProvider() {
        // Note: All Gluon servies must be created in the UI thread, otherwise the application crashes
        Scheduler.runInUiThread(() -> {
            audioService = com.gluonhq.attach.audio.AudioService.create().orElse(null);
            if (audioService == null) // It seems the audio service is implemented only for Android, so this happens on other platforms
                Console.log("WARNING [WebFX Platform]: Unable to load Gluon Audio Service - No sound/music will be played");
        });
    }

    @Override
    public Audio loadSound(String url) {
        return loadAudio(url, false);
    }

    @Override
    public Audio loadMusic(String url) {
        return loadAudio(url, true);
    }

    private Audio loadAudio(String urlString, boolean music) {
        Console.log("INFO [WebFX Platform]: Loading " + (music ? "music" : "sound") + " from url " + urlString);
        if (audioService == null) {
            Console.log("WARNING [WebFX Platform]: failed as Gluon audio service is not loaded");
            return null;
        }
        try {
            URL url = new URL(urlString);
            Optional<com.gluonhq.attach.audio.Audio> audio = music ? audioService.loadMusic(url) : audioService.loadSound(url);
            GluonAudio gluonAudio = audio.map(GluonAudio::new).orElse(null);
            if (gluonAudio == null)
                Console.log("WARNING [WebFX Platform]: Unable to load " + urlString);
            return gluonAudio;
        } catch (IOException  e) {
            Console.log("ERROR [WebFX Platform]: while loading " + urlString, e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean supportsMusicSpectrumAnalysis() {
        return false;
    }
}
