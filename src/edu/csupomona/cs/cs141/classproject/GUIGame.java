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
import java.applet.*;
import javax.swing.*;



/**
 * @author Taha
 *
 */
public class GUIGame extends JFrame{
	private Taha player = new Taha();
	GameEngine gameEng = new GameEngine(player);
	private JButton Left;
	private JButton Right;
	private JButton Up;
	private JButton Down;
	private JButton Shoot;
	private JButton saveGame;
	private JButton MainMenu;
	private JPanel panel;

	public GUIGame(){
		setTitle("Taha's new Adventure");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final int WINDOW_WIDTH = 500;
		final int WINDOW_HEIGHT = 500;
		setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
		
		buildWindow();
		add(panel);
		setVisible(true);
		
	}

	private void buildWindow() {
		// TODO Auto-generated method stub
		Left = new JButton("Left");

		Left.addActionListener(new LeftActionListener());

		Right = new JButton("Right");

		Right.addActionListener(new RightActionListener());

		Up= new JButton("Up");

		Up.addActionListener(new UpActionListener());

		Down = new JButton("Down");
		
		Shoot = new JButton("Shoot");

		Shoot.addActionListener(new ShootActionListener());

		saveGame = new JButton("Save Game");

		saveGame.addActionListener(new saveGameActionListener());

		MainMenu = new JButton("Main Menu");

		MainMenu.addActionListener(new MainMenuActionListener());

		panel = new JPanel();

		panel.add(Up);
		panel.add(Down);
		panel.add(Left);
		panel.add(Right);
		panel.add(saveGame);
		panel.add(MainMenu);


	}

	public class LeftActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}	
	public class RightActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}
	}

	public class UpActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public class DownActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public class MainMenuActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public class ShootActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
	public class saveGameActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub

		}

	}
}