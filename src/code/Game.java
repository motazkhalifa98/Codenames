package code;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Game {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frame = new MainFrame("CodeNames");
				frame.setSize(1600, 800);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
