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
public class NinjaChamploo { //this class will eventually hold the main method.

	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) { 
		Scanner kb = new Scanner(System.in);
		Taha player = new Taha();
		int gameChoice = 0;
		
		Grid grid = new Grid(player);
		UserInterface UI = new UserInterface(grid);
		gameChoice = UI.printFirstMenu();
		
		if(gameChoice == 1){
			
		
		
		grid.printGrid();
		int playerChoice = -1;
		while(playerChoice != 0){
		
			System.out.println("1. Up, 2. Right, 3. Down, 4. Left or 0 to quit."); // will be moved to UserInterface
			try{
				playerChoice = kb.nextInt();
				kb.nextLine();
				player.move(playerChoice, grid);
			} catch(InputMismatchException e){
				System.out.println("Please enter correct input.");
				kb.next();
			}
		}
		}
	}

}
