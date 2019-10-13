package player;

import java.io.File;

public interface Plugin {
    void LoadMusic(File music);
    void pause();
    void play();
    void stop();
    String GetMusicType();
}
