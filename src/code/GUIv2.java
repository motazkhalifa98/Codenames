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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIv2 extends JFrame{
	
	boolean gameRunning = false;
	static String[] clue = new String[2];
	static String[] options2 = {"OK"};
	String[] currentTurn = {"SpyMaster", "Red", "Blue"};
	
	public static void main(String[] args){
		//This creates a app window
		//menu screen
    	JFrame frame = new JFrame("I Hate CSE");
    	frame.setLayout(new BorderLayout());
    	JPanel contrPanel = new JPanel();
    //Menu
    	JPanel panel1 = new JPanel();
    //Game
    	
// a = main menu b = end turn c = 25 buttons
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
    //5 is SpyMaster
    	JPanel panel5 = new JPanel();
    	JPanel panel5a = new JPanel();
    	JPanel panel5c = new JPanel();
    	JLabel lbl = new JLabel("Clue:");
    	JTextField txt = new JTextField(10);
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
    	contrPanel.add(panel5, "5");
    	cl.show(contrPanel, "1");
 ////////////////////////////
    	String[] options = {"Yes", "No"};
 ////////////////////////////
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
	//note: E refers to the panel5 (game screen SPYMASTER)
		JButton buttonE1 = new JButton("Main Menu");
		JButton buttonE2 = new JButton("End Turn");
		buttonE1.setPreferredSize(new Dimension(100, 30));
		buttonE2.setPreferredSize(new Dimension(100, 30));
	//note: Panel1
		//this adds a "action" to a button (when the button is pressed, run this)
		buttonA1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//start the game
				cl.show(contrPanel, "5");
			    boolean blueClue = false;
				boolean redClue = false;
//				while(!redClue){
					System.out.println("try again");
					int redInput = JOptionPane.showOptionDialog(null, panel5, "The Title", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options2 , options2[0]);
					//check legal
//					if(redInput==0){
//						String text = txt1.getText();
//						clue[0]=text;
//					}
//				}
//				while(!blueClue){
//					System.out.println("try again");
//					int blueInput = JOptionPane.showOptionDialog(null, "blue", "title", JOptionPane.QUESTION_MESSAGE, JOptionPane.QUESTION_MESSAGE, options2 , options2[0]);
//					//check legal
//					if(blueInput==0){
//						String text = txt2.getText();
//						clue[1]=text;
//					}
//				}
//				cl.show(contrPanel, "2");
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
				int thing = JOptionPane.showOptionDialog(null, "Do you want to exit the app?", "Exit Conformation", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				if(thing == 0 && thing != -1){
					System.exit(0);
				}
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
	//note: panel5
		buttonE1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(contrPanel, "1");
			}
			
		});
	//menu stuff
		JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("FILE");
        menuBar.add(menu1);
        JMenuItem startItem = new JMenuItem("Start");
        JMenuItem quitItem = new JMenuItem("Quit");
        menu1.add(startItem);
        menu1.add(quitItem);
        startItem.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		cl.show(contrPanel, "2");
        	}
        });
        quitItem.addActionListener(new ActionListener() {
        	
    		@Override
    		public void actionPerformed(ActionEvent event) {
    			System.exit(0);
    		}
        });
//ignore
//		this just places it left to right (assuming you have more than a 2 by 2)
		panel2b.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel3b.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.add(contrPanel);
		frame.add(menuBar, BorderLayout.NORTH);
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
		
		panel5.add(panel5a);
		panel5a.add(buttonE1);
		panel5.add(lbl);
		panel5.add(txt);
		
		//set visible.... idek... you got to make it visible so you can see???
		frame.setVisible(true);
	}

}
