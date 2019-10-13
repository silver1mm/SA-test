package player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AAPFrame {
    private AAPlayer player;
    private JFrame frame;
    private JTextField field;
    private Plugin plugin=null;
    public AAPFrame(AAPlayer player) {
		this.player=player;		
	}
    public void init() {
		frame= new JFrame("MusicPlayer");
		frame.setSize(450,200);
		frame.setResizable(false);
		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		field = new JTextField();
		panel.add(field);
		field.setEditable(false);
		field.setBounds(20, 10, 300, 50);
		JButton searchButton=new JButton("search");
		panel.add(searchButton);
		searchButton.setBounds(340, 10, 80, 50);
		searchButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser j_chooser =new JFileChooser();
				j_chooser.setFileSelectionMode(j_chooser.FILES_ONLY);
				j_chooser.showOpenDialog(null);
				File file = j_chooser.getSelectedFile();
				if(file!=null) {
					Plugin p=player.playmusic(file);
					if(p!=null) {
						plugin=p;
						field.setText(file.getAbsolutePath());
					}
					else {
						JOptionPane.showMessageDialog(null, "File Not Found!");
					}
				}
			}
		});
		JButton playButton =new JButton("play");
		panel.add(playButton);
		playButton.setBounds(20, 80, 80, 50);
		playButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (plugin !=null) {
					plugin.play();
				}
			}
		});
		JButton pauseButton = new JButton("pause");
		panel.add(pauseButton);
		pauseButton.setBounds(120,80,80,50);
		pauseButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(plugin!=null) {
					plugin.pause();
				}
			}
		});
		JButton stopButton = new JButton("stop");
		panel.add(stopButton);
		stopButton.setBounds(220,80,80,50);
		stopButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(plugin!=null) {
					plugin.stop();
				}
			}
		});
		AboutBox aboutBox = new AboutBox();
		panel.add(aboutBox);
		aboutBox.setBounds(320, 80, 100, 50);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
    
}
