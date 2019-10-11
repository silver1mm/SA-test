package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public  class frmLogin {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserBUS _userBus = new UserBUS();
		JFrame frame = new JFrame("ThreeLayerDemo");
		frame.setSize(400, 300);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.add(panel);
		
		JTextArea inputextArea = new JTextArea();
		panel.add(inputextArea);
		inputextArea.setBounds(40, 10, 300, 80);
		
		JTextArea ouTextArea = new JTextArea();
		panel.add(ouTextArea);
		ouTextArea.setEditable(false);
		ouTextArea.setBounds(40, 100, 300, 100);
		
		JButton button = new JButton("Search");
		panel.add(button);
		button.setBounds(130, 210, 100, 50);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserVO myvo = _userBus.getUserEmailByName(inputextArea.getText());
				inputextArea.setText(null);
				ouTextArea.setText(null);
				ouTextArea.append("au_id: " + myvo.au_id + "\n");
				ouTextArea.append("au_fname: " + myvo.au_fname + "\n");
				ouTextArea.append("au_lname: " + myvo.au_lname + "\n");
				ouTextArea.append("phone: " + myvo.phone + "\n");
				ouTextArea.append("address: " + myvo.address + "\n");
			}
		});
		
		frame.setVisible(true);
	}
}
