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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpyMasterPanel extends JPanel implements KeyListener{

	private JTextField hintField;
	private JPanel mainPanel;
	private CardLayout cl;
	
	public SpyMasterPanel(JPanel mainPanel, CardLayout cl) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		this.cl = cl;
		setLayout(new GridBagLayout());
		
		setLayout(new GridBagLayout());
		setBackground(Color.ORANGE);
		JLabel hintLabel = new JLabel("Hint: ");
		hintField = new JTextField("Type in your hint here SpyMaster", 20);
		hintLabel.setFont(new Font("Serif", Font.BOLD, 40));
		hintField.setFont(new Font ("Arial", Font.BOLD, 35));
		hintField.addKeyListener(this);
		
		JLabel label = new JLabel("Input your hint");
		label.setFont(new Font("Ariel", Font.ITALIC, 40));
		JPanel locationButtons = new JPanel();
		locationButtons.setBackground(Color.ORANGE);
		locationButtons.setLayout(new GridLayout(5, 5, 10, 10));
    	ArrayList<JButton> jbuttonList = new ArrayList<JButton>();
    	for(int i = 1; i<26; i++){
    		JButton b = new JButton("Button " + i);
    		b.setEnabled(false);
    		//stuff
    		
    		
    		b.setPreferredSize(new Dimension(100, 50));
    		jbuttonList.add(b);
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
		gc.gridy = 2;
		gc.gridwidth = 2;
		add(locationButtons, gc);
		
	}

	private void checkLegal() {
		// TODO Auto-generated method stub
		System.out.println(hintField.getText());
		if(hintField.getText().equals("legal")) {
			cl.show(mainPanel, "4");
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			checkLegal();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
