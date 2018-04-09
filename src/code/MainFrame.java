package code;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MainFrame extends JFrame{
	
	private boolean gameRunning = false;
	private MainMenuPanel mainMenuPanel;
	private SpyMasterPanel spyMasterPanel;
	private RedPanel redPanel;
	private BluePanel bluePanel;
	private BonusPanel bonusPanel;
	
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
		
        mainMenuPanel = new MainMenuPanel(mainPanel, cl, gameRunning);
        bonusPanel = new BonusPanel(mainPanel, cl, gameRunning);
        spyMasterPanel = new SpyMasterPanel(mainPanel, cl, gameRunning);
        redPanel = new RedPanel(mainPanel, cl, gameRunning);
        bluePanel = new BluePanel(mainPanel, cl, gameRunning);
    	mainPanel.setLayout(cl);
    	mainPanel.add(mainMenuPanel, "1");
    	mainPanel.add(bonusPanel, "2");
    	mainPanel.add(spyMasterPanel, "3");
    	mainPanel.add(redPanel, "4");
    	mainPanel.add(bluePanel, "5");
    	cl.show(mainPanel, "1");
		//Add Swing components
        c.add(menuBar, BorderLayout.NORTH);
        c.add(mainPanel, BorderLayout.CENTER);
	}
}
