package dev.webfx.platform.audio;

public interface AudioSpectrumListener {

    void spectrumDataUpdate(double timestamp, double duration, float[] magnitudes, float[] phases);

}
