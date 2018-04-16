package code;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BonusPanel extends JPanel{
	
	public BonusPanel(JPanel mainPanel, CardLayout cl, Board board) {
		setBackground(Color.CYAN);
		JButton buttonD1 = new JButton("Main Menu");
		buttonD1.setPreferredSize(new Dimension(100, 30));
		
		JLabel tess = new JLabel("HAPPY EASTER XDDDDDDD");
		tess.setFont(new Font("Serif", Font.ITALIC, 100));
		
		buttonD1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cl.show(mainPanel, "1");
			}
		});
		add(buttonD1);
		add(tess);
	}
	
}
