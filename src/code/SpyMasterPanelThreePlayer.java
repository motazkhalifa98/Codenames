package code;

import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.JTextField;

public class SpyMasterPanelThreePlayer extends JPanel{
	private JTextField hintField;
	private JTextField countField;
	private JPanel mainPanel;
	private CardLayout cl;
	private threePlayer board2;
	public SpyMasterPanelThreePlayer(JPanel mainPanel, CardLayout cl, threePlayer board2) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		this.cl = cl;
		this.board2=board2;
		setLayout(new GridBagLayout());
		setBackground(Color.MAGENTA);
		
		JLabel hintLabel = new JLabel("Hint: ");
		hintLabel.setFont(new Font("Serif", Font.BOLD, 40));
		hintField = new JTextField("Type in your hint here SpyMaster", 20);
		hintField.setMinimumSize(new Dimension(550, 40));
		hintField.setFont(new Font ("Arial", Font.BOLD, 35));
		
		JLabel countLabel = new JLabel("Count: ");
		countLabel.setFont(new Font("Serif", Font.BOLD, 40));
		countField = new JTextField("Count", 20);
		countField.setFont(new Font ("Arial", Font.BOLD, 35));
		countField.setMinimumSize(new Dimension(120, 40));
			
		JButton button = new JButton("Submit2");
		button.setPreferredSize(new Dimension(300, 50));
		button.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent event) {
    			board2.setClue(hintField.getText());
    			if(countField.getText().length()>2) {
    				checkLegal();
    			}
    			else{
    				boolean something = false;
    				String thing = countField.getText();
    				if(thing.length() == 1) {
    					for(int i=0; i<10; i++) {
        					String number = "" + i;
        					if(thing.substring(0, 1).equals(number)) {
        						something =true;
        					}
    					}
    				}
    				else {
    					for(int i=0; i<10; i++) {
    						String number = "" + i;
    						
    						if(thing.substring(0, 1).equals(number)) {
    							for(int k = 0; k <10 ; k++) {
    								String number2 = "" + k;
    								if(thing.substring(1, 2).equals(number2)) {
    									something =true;
    								}    							
    							}
    						}
    					}
    				}
    				if(something == true) {
    					board2.setCount(thing);
    					checkLegal();
    				}
    				else {
    					JOptionPane.showMessageDialog(null, "Illegal Count", "PLEASE READ", JOptionPane.WARNING_MESSAGE);
    					hintField.setText("Type in your hint here SpyMaster");
    					countField.setText("Count");
    				}
    			}
        	}
        });
		JPanel locationButtons = new JPanel();
		locationButtons.setBackground(Color.MAGENTA);
		locationButtons.setLayout(new GridLayout(5, 5, 10, 10));
    	ArrayList<JButton> jbuttonList = new ArrayList<JButton>();
    	for(int i = 1; i<26; i++){
    		JButton b = new JButton("Button " + i);
    		b.setEnabled(false);
    		//if board[i][y] is not revealed
    		//set text to ???
    		//else set text to board[i][y]s person type
    		b.setPreferredSize(new Dimension(400, 100));
    		jbuttonList.add(b);
    	}
    	int count=0;
		Location [][] locs=board2.getBoard();
		for(int x=0; x<5; x++)
			for( int y=0; y<5; y++) {
				if(locs[x][y].getReveal()==0) {	
					if(((Person)locs[x][y].getPersonType()).getPersonType()=="RedAgent") {
						jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: Red Agent");	
					}
					else if(((Person)locs[x][y].getPersonType()).getPersonType()=="BlueAgent") {
						jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: Blue Agent");	
					}
					else if(((Person)locs[x][y].getPersonType()).getPersonType()=="Assassin") {
						jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: Assassin");
					}
					else if(((Person)locs[x][y].getPersonType()).getPersonType()=="GreenAgent") {
						jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: Green Agent");
					}
					else if(((Person)locs[x][y].getPersonType()).getPersonType()=="InnocentBystander") {
						jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: Innocent Bystander");
					}
//					jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: "+locs[x][y].getPersonType().toString());
				}
				else {
					if(locs[x][y].getPersonType().equals("RedAgent")) {
						jbuttonList.get(count).setText("Type: Red Agent");
					}
					else if(locs[x][y].getPersonType().equals("BlueAgent")) {
						jbuttonList.get(count).setText("Type: Blue Agent");
					}
					else if(locs[x][y].getPersonType().equals("Assassin")) {
						jbuttonList.get(count).setText("Type: Assassin");
					}
					else if(locs[x][y].getPersonType().equals("GreenAgent")) {
						jbuttonList.get(count).setText("Type: Green Agent");
					}
					else if(locs[x][y].getPersonType().equals("InnocentBystander")) {
						jbuttonList.get(count).setText("Type: Innocent Bystander");
					}
//					jbuttonList.get(count).setText(" Type: "+locs[x][y].getPersonType());
				}
				count++;
			}
		GridBagConstraints gc = new GridBagConstraints();
		for(int i=0; i<jbuttonList.size(); i++){
			locationButtons.add(jbuttonList.get(i));
		}
//		gc.fill =GridBagConstraints.HORIZONTAL;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.gridwidth = 1;
		add(hintLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.gridwidth = 1;
		add(hintField, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.gridwidth = 1;
		add(countLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.gridwidth = 1;
		add(countField, gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.gridwidth = 2;
		add(locationButtons, gc);
		
		gc.gridx= 0;
		gc.gridy = 4;
		gc.gridwidth = 1;
		add(button, gc);
	}

	private void checkLegal() {
		System.out.println(hintField.getText());
		if(board2.legalClue()&&board2.legalCount()) {
			hintField.setText("Type in your hint here SpyMaster");
			countField.setText("Count");
			cl.show(mainPanel, "6");
		}else if(board2.legalClue()==false){
			JOptionPane.showMessageDialog(this, "Illegal Clue", "PLEASE READ", JOptionPane.WARNING_MESSAGE);
			hintField.setText("Type in your hint here SpyMaster");
			countField.setText("Count");
		}else {
			JOptionPane.showMessageDialog(this, "Illegal Count", "PLEASE READ", JOptionPane.WARNING_MESSAGE);
			hintField.setText("Type in your hint here SpyMaster");
			countField.setText("Count");
		}

	}
}
