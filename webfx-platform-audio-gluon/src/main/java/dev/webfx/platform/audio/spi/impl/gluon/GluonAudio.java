package dev.webfx.platform.audio.spi.impl.gluon;

import dev.webfx.platform.audio.Audio;
import dev.webfx.platform.audio.AudioSpectrumListener;

/**
 * @author Bruno Salmon
 */
final class GluonAudio implements Audio {

    private final com.gluonhq.attach.audio.Audio audio;
    private long startTime;

    public GluonAudio(com.gluonhq.attach.audio.Audio audio) {
        this.audio = audio;
    }

    @Override
    public void setLooping(boolean looping) {
        audio.setLooping(looping);
    }

    @Override
    public void setVolume(double volume) {
        audio.setVolume(volume);
    }

    @Override
    public void play() {
        audio.play();
        startTime = System.currentTimeMillis();
        // It has been observed on an Android tablet (for the DemoFX demo) that the music doesn't actually start
        // immediately but about 200ms later. So we add this estimated delay to startTime, so the DemoFX animation
        // is correctly synced with the music.
        startTime += 200;
    }

    @Override
    public void pause() {
        audio.pause();
    }

    @Override
    public void stop() {
        audio.stop();
    }

    @Override
    public void dispose() {
        audio.dispose();
    }

    @Override
    public boolean isDisposed() {
        return audio.isDisposed();
    }

    @Override
    public long getCurrentTimeMillis() {
        return Math.max(0, System.currentTimeMillis() - startTime);
    }

    @Override
    public boolean supportsSpectrumAnalysis() {
        return false;
    }

    @Override
    public void setAudioSpectrumInterval(double value) { } // Not supported

    @Override
    public void setAudioSpectrumNumBands(int value) { } // Not supported

    @Override
    public void setAudioSpectrumListener(AudioSpectrumListener listener) { } // Not supported

}
