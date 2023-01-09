package dev.webfx.platform.audio.spi;

import dev.webfx.platform.audio.Audio;

public interface AudioServiceProvider {

    Audio loadSound(String url);

    Audio loadMusic(String url);

}
