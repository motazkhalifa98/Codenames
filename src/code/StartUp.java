package code;

import javax.swing.JFrame;

public class StartUp {
	
	public static void main(String[] args){
		//This creates a app window
    	JFrame frame = new GUIv2("I Hate CSE Major");
    	//size if screen (x, y)
    	frame.setSize(1000, 800);
    	//even though you exit the app, the program still runs, therefore
    	//you have to terminate it "on close"
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//set visible.... idek... you got to make it visible so you can see???
    	frame.setVisible(true);
    }
	
}
