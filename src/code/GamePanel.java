package code;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	private boolean shown = false;
	private String[] options = {"Yes", "No"};
	
	public GamePanel(JPanel mainPanel, CardLayout cl, Board board, ArrayList<String> answers) {
		// TODO Auto-generated constructor stub

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		setBackground(Color.RED);
		JPanel locationButtons = new JPanel();
		locationButtons.setBackground(Color.BLACK);
		
		JLabel label = new JLabel("Select A Person");
		label.setFont(new Font("Ariel", Font.ITALIC, 40));
		JLabel label2 = new JLabel("when you are done, end your turn");
		label2.setFont(new Font("Times New Roman", Font.ITALIC, 40));
		JLabel clueLabel = new JLabel(" ");
		clueLabel.setFont(new Font("Ariel", Font.ITALIC, 40));
		JLabel countLabel = new JLabel(" ");
		countLabel.setFont(new Font("Ariel", Font.ITALIC, 40));
		
		locationButtons.setLayout(new GridLayout(5, 5, 10, 10));
    	ArrayList<JButton> jbuttonList = new ArrayList<JButton>();
    	for(int i = 0; i<25; i++){
    		JButton b = new JButton(" ");
    		String ST=answers.get(i);
    		int col=i%5;
    		
    		int row=i/5;
    		b.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					b.setText(ST);
					board.setCount(Integer.toString(board.getCount()-1));
					if(shown == true) {
						countLabel.setText(Integer.toString(board.getCount()));
					}
					board.getBoard()[row][col].setReveal(1);
					b.setEnabled(false);
					System.out.println(board.getBoard()[row][col].getPersonType());
					if(board.getBoard()[row][col].getPersonType().toString().contains(board.getCurrentPlayer())) {
						board.makeMove(row, col);
						if(board.getWinningState() == true) {
							JOptionPane.showMessageDialog(null, board.getWinningTeam() + " Team Wins!!!!");
							cl.show(mainPanel, "1");
						}
					}
					else if(board.getCount() == 0) {
						
						JOptionPane.showMessageDialog(null, "Your hint count has hit zero, next person's turn");
						if(board.getCurrentPlayer().equals("RedAgent")) {
							board.setCurrentPlayer("BlueAgent");
							setBackground(Color.BLUE);
							cl.show(mainPanel, "3");
						}
						else {
							board.setCurrentPlayer("RedAgent");
							setBackground(Color.RED);
							cl.show(mainPanel, "3");
						}
					}
					else {
						if(board.getCurrentPlayer().equals("RedAgent")) {							
							board.setCurrentPlayer("BlueAgent");
							setBackground(Color.BLUE);
						}
						else {
							board.setCurrentPlayer("RedAgent");
							setBackground(Color.RED);
						}
						JOptionPane.showMessageDialog(null, "You have lost your turn");
					}
						
				}
			});
    		b.setPreferredSize(new Dimension(400, 100));
    		jbuttonList.add(b);
    
    	}
		
    	JButton buttonB1 = new JButton("Main Menu");
		JButton buttonB2 = new JButton("End Turn");
		JButton buttonB3 = new JButton("Show Hint/Count");
		buttonB1.setPreferredSize(new Dimension(100, 30));
		buttonB2.setPreferredSize(new Dimension(100, 30));
		buttonB3.setPreferredSize(new Dimension(100, 30));
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
					if(board.getCurrentPlayer().equals("RedAgent")) {
						board.setCurrentPlayer("BlueAgent");
						setBackground(Color.BLUE);
					}
					else {
						board.setCurrentPlayer("RedAgent");
						setBackground(Color.RED);
					}
					
				}
			}
		});
		buttonB3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				shown = true;
				clueLabel.setText(board.getClue());
				countLabel.setText(Integer.toString(board.getCount()));
			}
		});
		locationButtons.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		gc.gridx = 0;
		gc.gridy = 0;
		add(buttonB1, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(label, gc);
		
    	int count=0;
		Location [][] locs=board.getBoard();
		for(int x=0; x<5; x++)
			for( int y=0; y<5; y++) {
				if(locs[x][y].getReveal()==0)
					jbuttonList.get(count).setText("Codename: "+locs[x][y].getCodeName());
				else jbuttonList.get(count).setText(" Type: "+locs[x][y].getPersonType());
				count++;
			}
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
		
		gc.gridx = 0;
		gc.gridy = 5;
		add(clueLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 5;
		add(countLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 6;
		add(buttonB3 , gc);
	}

}
