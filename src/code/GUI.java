package code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class GUI implements ActionListener, ItemListener{
	private static Board _board;
	private static code _windowHolder;
	private static JPanel mainPanel;
    public GUI(Board b,JPanel cd, code code) {
    	_windowHolder = code;
    	_board = b;
    	mainPanel = cd;
    	mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
    	_board.startGame();
    }
    
    
    public static void startGUI() {
        JFrame frame = new JFrame("Codenames");
        frame.setSize(1000, 1000);
        GUI gui = new GUI(_board, mainPanel, _windowHolder);
        
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
        		startGUI();
        }
        });
        quitItem.addActionListener(gui);

        
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