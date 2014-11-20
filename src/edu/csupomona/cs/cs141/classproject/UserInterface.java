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

	
//	private GridMember[][] gridCells; // needs to be removed, breaks encapsulation.
	
//	Scanner kb = new Scanner(System.in);
	
//	Taha tahaPlayer = new Taha();
		
//	GameEngine gameEng = new GameEngine(tahaPlayer);
	
//	public UserInterface(){

//		gridCells = grid.printGrid();

//	}
	
//	public int FirstMenu(){
//		int userChoice = 0;
//		Taha tahaPlayer = new Taha();
//		GameEngine gameEng = new GameEngine(tahaPlayer);
		
//		Scanner kb = new Scanner(System.in);
//		System.out.println("Welcome to Taha's Adventure!\n");
//		System.out.println("1. Start Game");
//		System.out.println("2. Load Game");
//		System.out.println("3. About");
//		System.out.println("4. Help");
//		System.out.println("5. Quit");
		
//		try{
//			while(userChoice < 1 || userChoice > 5){
//				userChoice = kb.nextInt();
//				kb.nextLine();
				
				
				
//			}
//		} catch(InputMismatchException e){
//			System.out.println("Bad Input, Try again");
//		}
//		return userChoice;
//	}
	

//	public void FirstMenuRedirection(int userChoice) {
		// TODO Auto-generated method stub
//		switch (userChoice){
//		case 1: theGameInterface();
//			break;
//		case 2: //call load game method here
//			break;
//		case 3: //call about method here
//			break;
//		case 4: //call help method here
//			break;
//		case 5: System.exit(0);
//		}
//	}

//	public void theGameInterface(){
		
//		gameEng.printGrid();
//		String playerChoice = "Q";
//		while(playerChoice != "A" || playerChoice != "W" || playerChoice != "S" || playerChoice != "D" || playerChoice != "0"){
		
//			gameEng.gameOverCheck();
//			System.out.println("W. Up, D. Right, S. Down, A. Left, or 0 to quit.");
//			System.out.println("Lives: " + tahaPlayer.showLives() + " Ammo: " + tahaPlayer.showAmmo());	
//			try{
//				playerChoice = kb.next();
//				kb.nextLine();
//				gameEng.move(playerChoice.toLowerCase());
//			} catch(InputMismatchException e){
//				System.out.println("Please enter correct input.");
//				kb.next();
//			}
//		}
//	}
	

//  No, this method should not be here since according to Rodriguez, passing in gridCells breaks encapsulation. Somehow,
//  we have to make the method already existing in the grid class pass the entire grid(in string form) to GameEngine, and
// then from GameEngine to UserInterface. Shouldn't be too hard. But yea, this should't be here anymore. And neither should
// the GridCells field.

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



	//This part here is my code, the one above is Taha's
	private Taha player = new Taha();
	
	GameEngine gameEng = new GameEngine(player);

	Scanner kb = new Scanner(System.in);
	
	

	
	public void options(){
		String playerChoice = "9";
		while(playerChoice != "0"){
		
		gameEng.printGrid();
		gameEng.gameOverCheck();
		System.out.println("1. Shoot, W. Up, D. Right, S. Down, A. Left, or 0 to quit.");
		playerStatus();
		gameEng.playerTurnUsedWhileInvincible();
		
		playerChoice = kb.next();
		kb.nextLine();
		switch(playerChoice){
		case "1":
		
			playerShoot();
		
		case "W": 
		case "w":
		case "a":
		case "A":
		case "s":
		case "S":
		case "d":
		case "D":

					gameEng.resetSee();
					gameEng.move(playerChoice.toLowerCase());
					gameEng.see();
					options();
			
		default:
			System.out.println(playerChoice + " was not one of the choices, try again.");
			
			options();
		}
				
		}
		}
		
// this was the old one, just in case someone wants to refer to this:	
//	public void options(){
//		String playerChoice = "9";
//		while(playerChoice != "0"){
//		
//		gameEng.printGrid();
//		gameEng.gameOverCheck();
//		System.out.println("1. Shoot, W. Up, D. Right, S. Down, A. Left, or 0 to quit.");
//		playerStatus();
//		gameEng.playerTurnUsedWhileInvincible();
//		
//		playerChoice = kb.next();
//		kb.nextLine();
//		if (playerChoice == "1"){
//			playerShoot();
//		}
//		else{
//			theGameInterface();
//		}
//				
//		}
//		}
	
	
// going to be removing this soon, implemented the functionality in options()
//	public void theGameInterface() {
//		
//		String playerChoice = "Q";
//		
//			System.out
//					.println("W. Up, D. Right, S. Down, A. Left, or 0 to quit.");
//			try {
//				playerChoice = kb.next();
//				kb.nextLine();
//					gameEng.resetSee();
//					gameEng.move(playerChoice.toLowerCase());
//					gameEng.see();
//				
//			} catch (InputMismatchException e) {
//				System.out.println("Please enter correct input.");
//				kb.next();
//			}
//		}
	
	
	public void playerShoot(){
		System.out.println("Which direction to shoot? 1 up 2 left 3 down 4 right");
		int shootChoice = kb.nextInt();
		gameEng.shootDirection(shootChoice);
	}
	
	public void playerStatus(){
		System.out.println("Lives: " + gameEng.lives()+ " Ammo: "+ gameEng.ammo());
		System.out.println("Turns invincible: "+ gameEng.cantDie() );
	}
	
}
