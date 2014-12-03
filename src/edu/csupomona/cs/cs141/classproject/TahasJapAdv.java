/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Project
 *
 * TahasJapAdv class is only used to start the program,
 * this class contains the main method.
 *
 * Team Crazy Bananas
 * Taha Khan
 * Farzad Kosar
 * Yool Weeji Jeon (James)
 * Isaac Gonzalez
 * Thomas Nguyen
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;


public class TahasJapAdv{

	/**
	 * This is the main method used to either start the command
	 * line version of the game or the graphics version of the game
	 * depending on the argument given at launch.
	 * @param args the array of arguments given at launch,
	 * currently the only argument is "-gui" which launches
	 * the gui. 
	 */


	public static void main(String[] args) {
		
		if (args.length == 0) {
			int userChoice = 0;
			UserInterface UI = new UserInterface();
			UI.printLogo();
			UI.FirstMenu();

		} else {
			if (args[0].equals("-gui")) {
				GUIMainMenu gui = new GUIMainMenu();
			}
		}
	}

}
