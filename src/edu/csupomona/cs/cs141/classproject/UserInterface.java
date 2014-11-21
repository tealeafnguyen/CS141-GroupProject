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

	

	

	
	private Taha player = new Taha();
	
	GameEngine gameEng = new GameEngine(player);

	Scanner kb = new Scanner(System.in);

	// Menu has been updated
	// I've disabled it for now.
	//
	public int FirstMenu(){
	int userChoice = 0;

	
	kb = new Scanner(System.in);
	System.out.println("Welcome to Taha's Japanese Adventure in Japan!\n");
	System.out.println("1. Start Game");
	System.out.println("2. Load Game");
	System.out.println("3. About");
	System.out.println("4. Help");
	System.out.println("5. Quit");
	
	try{
		while(userChoice < 1 || userChoice > 5){
			userChoice = kb.nextInt();
			kb.nextLine();
			
			
			
		}
	} catch(InputMismatchException e){
		System.out.println("Bad Input, Try again");
	}
	return userChoice;
 }
	

	
	public void FirstMenuRedirection(int userChoice) {
		// TODO Auto-generated method stub
		switch (userChoice){
		case 1: options();
			break;
		case 2: //call load game method here
			break;
		case 3: //call about method here
			break;
		case 4: //call help method here
			break;
		case 5: System.exit(0);
		}
	}
	
	public void options(){
		String playerChoice = "9";
		while(playerChoice != "0"){
		gameEng.callGridSeeReset();
		gameEng.callGridSeeAround();
		gameEng.printGrid();
		gameEng.gameOverCheck();
		doIWinYet();
		System.out.println("1. Shoot, W. Up, D. Right, S. Down, A. Left, or 0 to quit.");
		playerStatus();
		gameEng.playerTurnUsedWhileInvincible();
		
		playerChoice = kb.next();
		kb.nextLine();
		switch(playerChoice){
		case "1":
			if(gameEng.ammoCheck()){
				playerShoot();
			}
			else{
				System.out.println("You are out of ammo.");
			}
			break;
		case "W": 
		case "w":
		case "a":
		case "A":
		case "s":
		case "S":
		case "d":
		case "D":

			gameEng.resetSee(); //wouldnt it be better to use these instead of the ones at the top?
			gameEng.move(playerChoice.toLowerCase());
			gameEng.see();     //likewise
			options();
			
		default:
			
			System.out.println(playerChoice + " was not one of the choices, try again.");
			
			options();
		}
				
		}
		}
		
// 	this was the old one, just in case someone wants to refer to this:	
//	public void options(){
//		int shootMove = 9;
//		while(shootMove != 0){
//		
//		gameEng.callGridSeeReset();
//		gameEng.callGridSeeAround();
//		gameEng.printGrid();
//		gameEng.gameOverCheck();
//		doIWinYet();
//		System.out.println("1 Shoot 2 Move");
//		playerStatus();
//		gameEng.playerTurnUsedWhileInvincible();
//		shootMove = kb.nextInt();
//		kb.nextLine();
//		if (playerChoice == "1"){
//			if(gameEng.ammoCheck()){
//				playerShoot();
//			}
//			else{
//				System.out.println("You are out of ammo.");
//			}
//		}
//		else{
//			theGameInterface();
//		}
//				
//		}
//		}
	
	
// 	going to be removing this soon, implemented the functionality in options()
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
//		public void doIWinYet(){
//			if(gameEng.recieveWinFromGrid()){
//				System.out.println("You have won the game");
//				System.exit(0);
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
	
	public void doIWinYet(){
		if(gameEng.recieveWinFromGrid()){
			System.out.println("You have won the game");
			System.exit(0);
		}
	
}
