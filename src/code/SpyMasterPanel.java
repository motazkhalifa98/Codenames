package code;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SpyMasterPanel extends JPanel implements KeyListener{

	private JTextField hintField;
	private JPanel mainPanel;
	private CardLayout cl;
	private boolean gameRunning;
	
	public SpyMasterPanel(JPanel mainPanel, CardLayout cl) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		this.cl = cl;
		this.gameRunning = gameRunning;
		
		setLayout(new GridBagLayout());
		setBackground(Color.ORANGE);
		JLabel hintLabel = new JLabel("Hint: ");
		hintField = new JTextField("Type in your hint here SpyMaster", 20);
		hintLabel.setFont(new Font("Serif", Font.BOLD, 40));
		hintField.setFont(new Font ("Arial", Font.BOLD, 35));
		hintField.addKeyListener(this);
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = 0;
		gc.gridy = 0;
		add(hintLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		add(hintField, gc);
	}

	private void checkLegal() {
		// TODO Auto-generated method stub
		System.out.println(hintField.getText());
		if(hintField.getText().equals("legal")) {
			gameRunning = true;
			cl.show(mainPanel, "4");
		}
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			gameRunning = false;
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
