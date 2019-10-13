package player;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import player.Plugin;

public class AAPlayer {
    private File[] p_list;
    public Map<String, Plugin> p_map = new HashMap<String, Plugin>();
     public static void main(String[] args) {
		new AAPlayer();
	}
     public AAPlayer() {
    	searchPlugins();
    	initPlugins();
    	AAPFrame aapframe =new AAPFrame(this);
    	aapframe.init();
    }
    public void initPlugins() {
		for(File file:p_list) {
			try {
				URL url = file.toURI().toURL();
				URLClassLoader c_loader =new URLClassLoader(new URL[]{url}, Thread.currentThread().getContextClassLoader());
				BufferedReader input = new BufferedReader(new InputStreamReader(c_loader.getResourceAsStream("Class.info")));
				String s = new String();
				while((s=input.readLine())!=null) {
					Class p_class = c_loader.loadClass(s);
					Plugin plugin = (Plugin)p_class.newInstance();
					String type = plugin.GetMusicType();
					if(!p_map.containsKey(type)) {
						p_map.put(type,plugin);
					}
				}
				input.close();
				c_loader.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
    public void searchPlugins() {
		File p_dir = new File("./plugins");
		if (!p_dir.exists()|| !p_dir.isDirectory()) {
			p_list=new File[0];
			return; 
		}
		p_list = p_dir.listFiles(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return name.endsWith(".jar");
			}
		});		
	}   
    public Plugin playmusic(File music) {
		String musicname = music.getName();
		String suff = musicname.substring(musicname.lastIndexOf('.'), musicname.length());
		
		if(p_map.containsKey(suff)) {
			Plugin plugin = p_map.get(suff);
			plugin.LoadMusic(music);
			return plugin;
		}
		return null;
	}
   
}
