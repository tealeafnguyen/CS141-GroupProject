/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Isa
 *
 */
public class TahasJapAdv implements Serializable {

	/**
	 * @param args
	 */
	// Menu has been updated but disabled for now....

	public static void main(String[] args) {
		if (args.length == 0) {
			int userChoice = 0;
			UserInterface UI = new UserInterface();

			userChoice = UI.FirstMenu();
			UI.FirstMenuRedirection(userChoice);
		} else {
			if (args[0].equals("-gui")) {
				GUIMainMenu gui = new GUIMainMenu();
			}
		}
	}
	// This here is just a placeHolder for functionality.
	// Please rework the UI and Main class later
	// public static void main(String[] args) {
	// UserInterface ui = new UserInterface();
	// ui.options();
	// }

	// testing gui
	// public static void main(String[] args){
	//
	// GUIMainMenu gui = new GUIMainMenu();
	//
	// }
}
