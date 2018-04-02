package code;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class GUIv2 extends JFrame{
	
	public GUIv2(String title){
		super(title);
		//borderlayout just lets you add components to the top, bottom, left, right, and center
		//of the frame
			//pannel in the middle, tool bar etc.
		setLayout(new BorderLayout());
		//Swing stuf
		JButton button1 = new JButton("Click Click");
		JTextArea justText = new JTextArea();
		//Adding Swing shit to content pane
		Container c = getContentPane();
		//see locations
		//https://docs.oracle.com/javase/7/docs/api/java/awt/BorderLayout.html
		c.add(button1, BorderLayout.SOUTH);
		c.add(justText, BorderLayout.CENTER);
		button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				justText.append("Click Click \n");
			}});
	}

}
