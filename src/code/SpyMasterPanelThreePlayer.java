package code;

import java.awt.CardLayout;

import javax.swing.JPanel;

public class SpyMasterPanelThreePlayer extends JPanel{
	private JPanel mainPanel;
	private CardLayout cl;
	private Board board;
	public SpyMasterPanelThreePlayer(JPanel mainPanel, CardLayout cl, Board board) {
		// TODO Auto-generated constructor stub
		this.mainPanel = mainPanel;
		this.cl = cl;
		this.board=board;
	}

}
