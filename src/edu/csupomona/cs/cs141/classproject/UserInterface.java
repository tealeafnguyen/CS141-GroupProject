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
public class UserInterface {

	
	private GridMember[][] gridCells;
	
	public UserInterface(){

//		gridCells = grid.printGrid();

	}
	
	public int FirstMenu(){
		int userChoice = 0;
		Taha tahaPlayer = new Taha();
		GameEngine gameEng = new GameEngine(tahaPlayer);
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Welcome to Taha's Adventure!\n");
		System.out.println("1. Start Game");
		System.out.println("2. Load Game");
		System.out.println("3. About");
		System.out.println("4. Help");
		System.out.println("5. Quit");
		
		try{
			while(userChoice != 1 || userChoice !=2 || userChoice != 3 || userChoice != 4 || userChoice != 5){
				userChoice = kb.nextInt();
				kb.nextLine();
				
				
				
			}
		} catch(InputMismatchException e){
			System.out.println("Bad Input, Try again");
		}
		return userChoice;
	}
	
	@SuppressWarnings("unused")
	public void FirstMenuRedirection(int userChoice) {
		// TODO Auto-generated method stub
		if(userChoice == 1){
			theGameInterface();	
		}
		if(userChoice == 2){
//			 load game stuff here	
		}
		if(userChoice == 3){
//			About stuff here
		}
		if(userChoice == 4){
//			how to play the game stuff here
		}
		if(userChoice == 5){
			System.exit(0);
		}
	}

	public void theGameInterface(){
		Scanner kb = new Scanner(System.in);
		Taha tahaPlayer = new Taha();
		UserInterface UI = new UserInterface();
		
		GameEngine gameEng = new GameEngine(tahaPlayer);
		gameEng.printGrid();
		String playerChoice = "Q";
		while(playerChoice != "A" || playerChoice != "W" || playerChoice != "S" || playerChoice != "D" || playerChoice != "0"){
		
			System.out.println("W. Up, D. Right, S. Down, A. Left, or 0 to quit.");
			try{
				playerChoice = kb.next();
				kb.nextLine();
				tahaPlayer.move(playerChoice.toLowerCase(), gameEng);
			} catch(InputMismatchException e){
				System.out.println("Please enter correct input.");
				kb.next();
			}
		}
	}
	

//  Isaac, this method is also in the engine, do we need it here?	
// 
//	public void printGrid(){
//		for(int i = 0; i < gridCells.length; i++){
//			for(int j = 0; j < gridCells[i].length; j++){
//				System.out.print(gridCells[i][j].toString());
//			}
//			System.out.println();
//		}
//		System.out.println();
//	}
	
}
