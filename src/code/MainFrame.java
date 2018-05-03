package code;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private boolean gameRunning = false;
	private MainMenuPanel mainMenuPanel;
	private SpyMasterPanel spyMasterPanel;
	private GamePanel gamePanel;
	private BonusPanel bonusPanel;
	private ArrayList<String> answers=new ArrayList<String>();
	
	public MainFrame(String title) {
		super(title);
		//Layout
		CardLayout cl = new CardLayout();
		Container c = getContentPane();
		setLayout(new BorderLayout());
		//Swing component
		JPanel mainPanel = new JPanel();
		JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("FILE");
        menuBar.add(menu1);
        JMenuItem startItem = new JMenuItem("Start");
        JMenuItem quitItem = new JMenuItem("Quit");
        menu1.add(startItem);
        menu1.add(quitItem);
        Board board=new Board(5,5);
        board.setCodeNames("src/GameWords.txt");
        board.makeList();
		for(int i=0; i<5; i++)
			for(int y=0; y<5; y++)
				answers.add(board.getBoard()[i][y].getPersonType().toString());
        //System.out.println(board.getGameCodeNames());
        startItem.addActionListener(new ActionListener() {
        	
        	@Override
        	public void actionPerformed(ActionEvent event) {
        		
        	}
        });
        quitItem.addActionListener(new ActionListener() {
        	
    		@Override
    		public void actionPerformed(ActionEvent event) {
    			System.exit(0);
    		}
        });
		
        mainMenuPanel = new MainMenuPanel(mainPanel, cl,board);
        bonusPanel = new BonusPanel(mainPanel, cl,board);
        spyMasterPanel = new SpyMasterPanel(mainPanel, cl,board);
        gamePanel = new GamePanel(mainPanel, cl,board,answers);
    	mainPanel.setLayout(cl);
    	mainPanel.add(mainMenuPanel, "1");
    	mainPanel.add(bonusPanel, "2");
    	mainPanel.add(spyMasterPanel, "3");
    	mainPanel.add(gamePanel, "4");
    	cl.show(mainPanel, "1");
		//Add Swing components
        c.add(menuBar, BorderLayout.NORTH);
        c.add(mainPanel, BorderLayout.CENTER);
	}
}