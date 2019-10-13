package player;

import java.io.File;

public interface Plugin {
	void LoadMusic(File music);
	void play();
	void stop();
	void pause();
	String GetMusicType();
}
