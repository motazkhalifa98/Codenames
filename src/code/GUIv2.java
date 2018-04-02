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
    	JPanel panel2 = new JPanel();
    	JPanel panel2a = new JPanel();
    	JPanel panel2b = new JPanel();
    //Bonus and other shit
    	JPanel panel3 = new JPanel();
    	
    	//size screen (x, y)
    	frame.setSize(600, 500);
    	
    	
    	
    	JLabel label1 = new JLabel();
    	label1.setText("Welcome!!!");
    	label1.setPreferredSize(new Dimension(500, 200));
    	label1.setFont(new Font("Serif", Font.BOLD, 50));

    	CardLayout cl = new CardLayout();
    	contrPanel.setLayout(cl);
    	panel2.setBackground(Color.GREEN);
    	panel2b.setBackground(Color.GREEN);
    	panel3.setBackground(Color.CYAN);
    	contrPanel.add(panel1, "1");
    	contrPanel.add(panel2, "2");
    	contrPanel.add(panel3, "3");
    	cl.show(contrPanel, "1");

    	panel2b.setLayout(new GridLayout(5, 5));
    	ArrayList<JButton> jbuttonList = new ArrayList<JButton>();
    	for(int i = 1; i<26; i++){
    		JButton b = new JButton("Button " + i);
    		b.setPreferredSize(new Dimension(100, 50));
    		jbuttonList.add(b);
    	}
    	//even though you exit the app, the program still runs, therefore
    	//you have to terminate it "on close"
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//GridLayout(rows, columns, horizontal gap, verical gap)
		panel2b.setLayout(new GridLayout(5, 5, 10, 10));
    	//since the layout is being set by something, the location of the buttons cannot be done
	//note: A refers to the panel1 (menu screen)
    	JButton buttonA1 = new JButton("Start");
		buttonA1.setPreferredSize(new Dimension(100, 50));
		JButton buttonA2 = new JButton("Click Click");
		buttonA2.setPreferredSize(new Dimension(100, 50));
		JButton buttonA3 = new JButton("Exit");
		buttonA3.setPreferredSize(new Dimension(100, 50));
	//note: B refers to the panel2 (game screen)
		JButton buttonB1 = new JButton("Main Menu");
		buttonB1.setPreferredSize(new Dimension(100, 30));
	//note: C refers to the panel3 (bonus screen)
		JButton buttonC1 = new JButton("Main Menu");
		buttonC1.setPreferredSize(new Dimension(100, 30));
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
				cl.show(contrPanel, "3");
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
		
	//note: Panel3
		buttonC1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(contrPanel, "1");
			}
		});
//ignore
//		this just places it left to right (assuming you have more than a 2 by 2)
		panel2b.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		frame.add(contrPanel);
		panel1.add(label1);
		panel1.add(buttonA1);
		panel1.add(buttonA2);
		panel1.add(buttonA3);
		panel2.add(panel2a);
		panel2.add(panel2b);
		panel2a.add(buttonB1);
		for(int i=0; i<jbuttonList.size(); i++){
			System.out.println(i);
			panel2b.add(jbuttonList.get(i));
		}
		panel3.add(buttonC1);
		
		//set visible.... idek... you got to make it visible so you can see???
		frame.setVisible(true);
	}

}
