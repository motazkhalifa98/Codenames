package code;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import code.Board;
import code.GUI;

public class code implements Runnable {
	
	private Board board;
	private JFrame window;
	private JPanel mainPanel;
	
	public code(Board b) {
		board = b;
		
	}
	
	public static void main(String[] args) {
		Board b = new Board(5, 5);
		SwingUtilities.invokeLater(new code(b));
		
	}

	@Override
	public void run() {
		window = new JFrame("Codenames");
		mainPanel = new JPanel();
		window.getContentPane().add(mainPanel);

		new GUI(board, mainPanel, this);
		window.setVisible(true);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public void updateJFrame() {
		window.pack();
		window.repaint();
	}
}
