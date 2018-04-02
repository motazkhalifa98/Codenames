package code;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUIv2 extends JFrame{
	
	public static void main(String[] args){
		//This creates a app window
		//menu screen
    	JFrame frame = new JFrame("I Hate CSE");
    	JPanel contrPanel = new JPanel();
    //Menu
    	JPanel panel1 = new JPanel();
    //Game
    //2 is player red
    	JPanel panel2 = new JPanel();
    	JPanel panel2a = new JPanel();
    	JPanel panel2b = new JPanel();
    	JPanel panel2c = new JPanel();
    //3 is player blue
    	JPanel panel3 = new JPanel();
    	JPanel panel3a = new JPanel();
    	JPanel panel3b = new JPanel();
    	JPanel panel3c = new JPanel();
    //Bonus and other shit
    	JPanel panel4 = new JPanel();
    	
    	//size screen (x, y)
    	frame.setSize(600, 500);
    	
    	JLabel label1 = new JLabel();
    	label1.setText("Welcome!!!");
    	label1.setPreferredSize(new Dimension(500, 200));
    	label1.setFont(new Font("Serif", Font.BOLD, 50));
    	
    	JOptionPane.showMessageDialog(frame, "I hate cse please give me a 100", "PLEASE READ", JOptionPane.WARNING_MESSAGE);

    	CardLayout cl = new CardLayout();
    	contrPanel.setLayout(cl);
    	panel2.setBackground(Color.RED);
    	panel2b.setBackground(Color.RED);
    	panel3.setBackground(Color.BLUE);
    	panel3b.setBackground(Color.BLUE);
    	panel4.setBackground(Color.CYAN);
    	contrPanel.add(panel1, "1");
    //note: since hitting main menu doesn't save your turn we need to fix that
    	contrPanel.add(panel2, "2");
    	contrPanel.add(panel3, "3");
    	contrPanel.add(panel4, "4");
    	cl.show(contrPanel, "1");
    	
    	String[] options = {"Yes", "No"};

    	ArrayList<JButton> jbuttonList1 = new ArrayList<JButton>();
    	for(int i = 1; i<26; i++){
    		JButton b = new JButton("Button " + i);
    		b.setPreferredSize(new Dimension(100, 50));
    		jbuttonList1.add(b);
    	}
    	ArrayList<JButton> jbuttonList2 = new ArrayList<JButton>();
    	for(int i = 1; i<26; i++){
    		JButton b = new JButton("Button " + i);
    		b.setPreferredSize(new Dimension(100, 50));
    		jbuttonList2.add(b);
    	}
    	//even though you exit the app, the program still runs, therefore
    	//you have to terminate it "on close"
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//GridLayout(rows, columns, horizontal gap, verical gap)
		panel2b.setLayout(new GridLayout(5, 5, 10, 10));
		panel3b.setLayout(new GridLayout(5, 5, 10, 10));
		
    	//since the layout is being set by something, the location of the buttons cannot be done
	//note: A refers to the panel1 (menu screen)
    	JButton buttonA1 = new JButton("Start");
		buttonA1.setPreferredSize(new Dimension(100, 50));
		JButton buttonA2 = new JButton("Click Click");
		buttonA2.setPreferredSize(new Dimension(100, 50));
		JButton buttonA3 = new JButton("Exit");
		buttonA3.setPreferredSize(new Dimension(100, 50));
	//note: B refers to the panel2 (game screen RED)
		JButton buttonB1 = new JButton("Main Menu");
		JButton buttonB2 = new JButton("End Turn");
		buttonB1.setPreferredSize(new Dimension(100, 30));
		buttonB2.setPreferredSize(new Dimension(100, 30));
	//note: C refers to the panel3 (game screen BLUE)
		JButton buttonC1 = new JButton("Main Menu");
		JButton buttonC2 = new JButton("End Turn");
		buttonC1.setPreferredSize(new Dimension(100, 30));
		buttonC2.setPreferredSize(new Dimension(100, 30));
	//note: D refers to the panel4 (bonus screen)
		JButton buttonD1 = new JButton("Main Menu");
		buttonD1.setPreferredSize(new Dimension(100, 30));
	//note: Panel1
		//this adds a "action" to a button (when the button is pressed, run this)
		buttonA1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//start the game
				cl.show(contrPanel, "2");
			}
			
		});
		
		buttonA2.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//what ever button two does
				cl.show(contrPanel, "4");
			}
			
		});
		
		buttonA3.addActionListener(new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//it exits
				System.exit(0);
			}
		});
	//note: Panel2
		buttonB1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(contrPanel, "1");
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
					cl.show(contrPanel, "3");
					
				}
			}
		});
	//note:panel3
		buttonC1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(contrPanel, "1");
			}
			
		});
		
		buttonC2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int thing = JOptionPane.showOptionDialog(null, "Would you like to end your turn?", "End Conformation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if(thing == 0 && thing != -1){
					JOptionPane.showMessageDialog(null, "You have ended your turn");
					//other code
					cl.show(contrPanel, "2");
					
				}
			}
		});
	//note: panel4
		buttonD1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(contrPanel, "1");
			}
		});
//ignore
//		this just places it left to right (assuming you have more than a 2 by 2)
		panel2b.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel3b.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.add(contrPanel);
		panel1.add(label1);
		panel1.add(buttonA1);
		panel1.add(buttonA2);
		panel1.add(buttonA3);
		
		panel2.add(panel2a);
		panel2.add(panel2b);
		panel2.add(panel2c);
		panel2a.add(buttonB1);
		for(int i=0; i<jbuttonList1.size(); i++){
			System.out.println(i);
			panel2b.add(jbuttonList1.get(i));
		}
		panel2c.add(buttonB2);
		
		panel3.add(panel3a);
		panel3.add(panel3b);
		panel3.add(panel3c);
		panel3a.add(buttonC1);
		for(int i=0; i<jbuttonList2.size(); i++){
			panel3b.add(jbuttonList2.get(i));
		}
		panel3c.add(buttonC2);
		
		panel4.add(buttonD1);
		
		//set visible.... idek... you got to make it visible so you can see???
		frame.setVisible(true);
	}

}
