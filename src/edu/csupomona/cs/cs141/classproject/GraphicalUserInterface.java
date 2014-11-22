/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;
import java.awt.*;
import javax.swing.*;



/**
 * @author Taha
 *
 */
public class GraphicalUserInterface extends JFrame  {
	
	private JButton newGameButton;
	private JButton loadGameButton;
	private JButton aboutButton;
	private JButton helpButton;
	private JButton ExitButton; //might not use this.
	
	public GraphicalUserInterface(){
		// the title of the window
		setTitle("Taha's Japanese Adventure in Japan");
		// the operation of what the X does on the top right of the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// window width 
		// gonna change this depending on how we code the gui
		final int WINDOW_WIDTH = 500;
		final int WINDOW_HEIGHT = 500;
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		setVisible(true);
	}
}
