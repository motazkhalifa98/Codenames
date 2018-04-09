package code;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MainMenuPanel extends JPanel{
	boolean running = false;
	public MainMenuPanel(JPanel mainPanel, CardLayout cl) {
//		Dimension size = getPreferredSize();
//		size.width = 250;
//		setPreferredSize(size);
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		String[] options = {"Yes", "No"};
	
		JLabel label1 = new JLabel();
    	label1.setText("Welcome!!!");
//    	label1.setPreferredSize(new Dimension(500, 200));
    	label1.setFont(new Font("Serif", Font.BOLD, 50));
    	
		JButton buttonA1 = new JButton("Start");
		buttonA1.setPreferredSize(new Dimension(600, 50));
		JButton buttonA2 = new JButton("Click Click");
		buttonA2.setPreferredSize(new Dimension(300, 50));
		JButton buttonA3 = new JButton("Exit");
		buttonA3.setPreferredSize(new Dimension(300, 50));
		
		buttonA1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				//start the game
				if(running){
					int thing = JOptionPane.showOptionDialog(null, "Do you want start a new game?", "New Game Conformation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if(thing == 0 && thing != -1){
						cl.show(mainPanel, "3");
					}
					else if(thing == 1 && thing != -1){
						cl.show(mainPanel, "4");
					}
				}
				else{
					running = true;
					cl.show(mainPanel, "3");
				}
			}
			
		});
		
		buttonA2.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//what ever button two does
				cl.show(mainPanel, "2");
			}
			
		});
		
		buttonA3.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//it exits
				int thing = JOptionPane.showOptionDialog(null, "Do you want to exit the app?", "Exit Conformation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if(thing == 0 && thing != -1){
					System.exit(0);
				}
			}
		});
		//
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 2;
		add(label1, gc);
		
		
		gc.gridx = 1;
		gc.gridy = 1;
		//not needed cuz already set but here for good looks
		gc.gridwidth = 2;
		add(buttonA1, gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.gridwidth = 1;
		add(buttonA2, gc);
		
		gc.gridx = 2;
		gc.gridy = 2;
		gc.gridwidth = 1;
		add(buttonA3, gc);
	}
}
