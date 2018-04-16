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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpyMasterPanel extends JPanel{

	private JTextField hintField;
	private JTextField countField;
	private JPanel mainPanel;
	private CardLayout cl;
	private Board board;
	
	public SpyMasterPanel(JPanel mainPanel, CardLayout cl,Board board) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		this.cl = cl;
		this.board=board;
		setLayout(new GridBagLayout());
		
		setLayout(new GridBagLayout());
		setBackground(Color.ORANGE);
		JLabel hintLabel = new JLabel("Hint: ");
		hintField = new JTextField("Type in your hint here SpyMaster", 20);
		hintLabel.setFont(new Font("Serif", Font.BOLD, 40));
		hintField.setFont(new Font ("Arial", Font.BOLD, 35));
		countField = new JTextField("Count",4);
		JLabel countLabel = new JLabel("Count: ");
		countLabel.setFont(new Font("Serif", Font.BOLD, 40));
		countField.setFont(new Font ("Arial", Font.BOLD, 35));
		
		JButton button = new JButton("Submit");
		button.setPreferredSize(new Dimension(300, 50));
		button.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent event) {
    			board.setClue(hintField.getText());
    			board.setCount(countField.getText());
    			checkLegal();
        	}
        });
		
		JPanel locationButtons = new JPanel();
		locationButtons.setBackground(Color.ORANGE);
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
		Location [][] locs=board.getBoard();
		for(int x=0; x<5; x++)
			for( int y=0; y<5; y++) {
				if(locs[x][y].getReveal()==0)
					jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName()+" Type: "+locs[x][y].getPersonType().toString());
				else jbuttonList.get(count).setText(" Type: "+locs[x][y].getPersonType());
				count++;
			}
				
		GridBagConstraints gc = new GridBagConstraints();
		for(int i=0; i<jbuttonList.size(); i++){
			locationButtons.add(jbuttonList.get(i));
		}
		gc.gridx = 0;
		gc.gridy = 0;
		add(hintLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(hintField, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(countLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
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
		if(board.legalClue()&&board.legalCount()) {
			cl.show(mainPanel, "4");
		}else if(board.legalClue()==false){
			JOptionPane.showMessageDialog(this, "Illegal Clue", "PLEASE READ", JOptionPane.WARNING_MESSAGE);
		}else JOptionPane.showMessageDialog(this, "Illegal Count", "PLEASE READ", JOptionPane.WARNING_MESSAGE);

	}

}
