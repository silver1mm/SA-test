package player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class AboutBox extends JButton{
    public AboutBox() {
    	this.setText("About this");
    	this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "This demo is a test for MP3Plugin.", "About this", JOptionPane.INFORMATION_MESSAGE);
			}
		});
    }
}
