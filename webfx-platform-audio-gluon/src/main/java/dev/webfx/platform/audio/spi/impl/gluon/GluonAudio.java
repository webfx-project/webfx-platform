package dev.webfx.platform.audio.spi.impl.gluon;

import dev.webfx.platform.audio.Audio;

/**
 * @author Bruno Salmon
 */
final class GluonAudio implements Audio {

    private final com.gluonhq.attach.audio.Audio audio;

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

}
