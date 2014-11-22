/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.*;



/**
 * @author Taha
 *
 */
public class GraphicalUserInterface extends JFrame  {

	private JPanel panel;
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
		// method in JFrame class, sets the window's width and height;
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);


		//adds panel

		// adds buttons and other stuff
		buildWindow();

		add(panel);
		// makes the window visible.
		setVisible(true);

	}

	private void buildWindow() {
		// TODO Auto-generated method stub
		newGameButton = new JButton("New Game");

		newGameButton.addActionListener(new NewGameActionListener());

		loadGameButton = new JButton("Load Game");

		loadGameButton.addActionListener(new LoadGameActionListener());

		aboutButton = new JButton("About");

		aboutButton.addActionListener(new AboutActionListener());

		helpButton = new JButton("Help");

		helpButton.addActionListener(new HelpActionListener());

		ExitButton = new JButton("Exit");

		ExitButton.addActionListener(new ExitActionListener());

		panel = new JPanel();

		panel.add(newGameButton);
		panel.add(loadGameButton);
		panel.add(aboutButton);
		panel.add(helpButton);
		panel.add(ExitButton);

	}

	// these classes are used when a button is pressed.
	private class NewGameActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}

	private class LoadGameActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}
	private class AboutActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			JOptionPane.showMessageDialog(null,"Creators:\n Isaac (aka IsaacDG)\n Thomas (aka Butthole Ripper)\n Taha (aka Jericho)\n James (aka kor3a)\n Fraz (aka muffinbottoms)\n");

		}

	}
	private class HelpActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(Desktop.isDesktopSupported())
			{
				try {
					// go to the website where we'll have the help info.
					// will change it later, for now fill this out lol
					Desktop.getDesktop().browse(new URI("http://shrib.com/TahasJapAdv"));
				} catch (IOException | URISyntaxException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	private class ExitActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

	}
}
