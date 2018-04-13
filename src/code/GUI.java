package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class GUI implements ActionListener, ItemListener{
	private Board board;
	private code code;
	private JPanel mainPanel;
	private JLabel[][] matrix=new JLabel[5][5];
	
    public GUI(Board b,JPanel panel, code code) {
    	this.code = code;
    	this.board = b;
    	mainPanel = panel;
    	mainPanel.setLayout(new GridLayout(5,5));
    	board.startGame();
    	startGUI();
    }
    
    
    public void startGUI() {
        JFrame frame = new JFrame("Codenames");
        frame.setSize(1000, 1000);
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
        		Board board=new Board(5,5);
        }
        });
        quitItem.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent event) {
    		
    }
    });

        
        JPanel panel = new JPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menuBar);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}