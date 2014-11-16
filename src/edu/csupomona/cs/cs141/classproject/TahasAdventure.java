/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Isa
 *
 */
public class TahasAdventure {

	/**
	 * @param args
	 */
	public static void main(String[] args) { 
	
	int userChoice = 0;
	UserInterface UI = new UserInterface();
	
	userChoice = UI.FirstMenu();
	UI.FirstMenuRedirection(userChoice);
}

}