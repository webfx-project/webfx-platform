package dev.webfx.platform.audio;

public interface Audio {

    /*********************************************
     + API supported by Gluon (works on mobiles) *
     ********************************************/

    void setLooping(boolean looping);

    void setVolume(double volume);

    void play();

    void pause();

    void stop();

    void dispose();

    boolean isDisposed();

    /********************************************************
     + API not supported by Gluon (doesn't work on mobiles) *
     + but supported by OpenJFX and GWT implementations     *
     *******************************************************/

    long getCurrentTimeMillis(); // Actually ok to use with Gluon as it's emulated by WebFX

    boolean supportsSpectrumAnalysis(); // Gluon: false, OpenJFX/GWT: false for sound, true for music

    void setAudioSpectrumInterval(double value); // can be used if supportsSpectrumAnalysis() returns true

    void setAudioSpectrumNumBands(int value); // can be used if supportsSpectrumAnalysis() returns true

    void setAudioSpectrumListener(AudioSpectrumListener listener); // can be used if supportsSpectrumAnalysis() returns true

}
