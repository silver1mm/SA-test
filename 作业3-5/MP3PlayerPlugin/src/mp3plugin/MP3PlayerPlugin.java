package mp3plugin;

import java.io.File;

import javax.swing.JOptionPane;

import player.Plugin;

public class MP3PlayerPlugin implements Plugin {
    public void LoadMusic(File music) {
		
	}
    public void play() {
		JOptionPane.showMessageDialog(null, "play");
	}
    public void pause() {
		JOptionPane.showMessageDialog(null, "pause");
	} 
    public void stop() {
		JOptionPane.showMessageDialog(null, "stop");
	}
    public String GetMusicType() {
    	return ".mp3";		
	}
	
	
}
