package dev.webfx.platform.audio;

public interface Audio {

    void setLooping(boolean looping);

    void setVolume(double volume);

    void play();

    void pause();

    void stop();

    void dispose();

    boolean isDisposed();

    long getCurrentTimeMillis();

}
