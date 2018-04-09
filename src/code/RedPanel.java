package code;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class RedPanel extends JPanel{
	
	
	private String[] options = {"Yes", "No"};

	public RedPanel(JPanel mainPanel, CardLayout cl, boolean gameRunning) {
		// TODO Auto-generated constructor stub
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		setBackground(Color.RED);
		JPanel locationButtons = new JPanel();
		locationButtons.setBackground(Color.RED);
		
		JLabel label = new JLabel("Select A Person");
		label.setFont(new Font("Ariel", Font.ITALIC, 40));
		JLabel label2 = new JLabel("when you are done, end your turn");
		label2.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		
		locationButtons.setLayout(new GridLayout(5, 5, 10, 10));
    	ArrayList<JButton> jbuttonList = new ArrayList<JButton>();
    	for(int i = 1; i<26; i++){
    		JButton b = new JButton("Button " + i);
    		b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					b.setEnabled(false);
				}
			});
    		b.setPreferredSize(new Dimension(100, 50));
    		jbuttonList.add(b);
    	}
		
    	JButton buttonB1 = new JButton("Main Menu");
		JButton buttonB2 = new JButton("End Turn");
		buttonB1.setPreferredSize(new Dimension(100, 30));
		buttonB2.setPreferredSize(new Dimension(100, 30));
    	buttonB1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int thing = JOptionPane.showOptionDialog(null, "Do you want return to the main menu?", "Exit Conformation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if(thing == 0 && thing != -1){
					cl.show(mainPanel, "1");
				}
			}
			
		});
		
		buttonB2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int thing = JOptionPane.showOptionDialog(null, "Would you like to end your turn?", "End Conformation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if(thing == 0 && thing != -1){
					JOptionPane.showMessageDialog(null, "You have ended your turn");
					//other code
//					cl.show(mainPanel, "3");
					
				}
			}
		});
		locationButtons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(buttonB1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(label, gc);
		
		for(int i=0; i<jbuttonList.size(); i++){
			locationButtons.add(jbuttonList.get(i));
		}
		gc.gridx = 0;
		gc.gridy = 2;
		add(locationButtons, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		add(label2, gc);
		
		gc.gridx = 0;
		gc.gridy = 4;
		add(buttonB2, gc);
		
	}

}
