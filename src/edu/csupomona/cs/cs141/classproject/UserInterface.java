/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.awt.Desktop;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Isa
 *
 */
public class UserInterface implements Serializable {






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
		case 1: 
			options();
			break;
		case 2: //call load game method here
			System.out.println("Enter your save Game filename");
			String fileName = kb.nextLine().toLowerCase();
			gameEng.loadGame(fileName+".taha");
			options();
			break;
		case 3: //call about method here
			System.out.println("Creators:\n Isaac (aka IsaacDG)\n Thomas (aka Butthole Ripper)\n Taha (aka Jericho)\n James (aka kor3a)\n Fraz (aka muffinbottoms)\n");
			FirstMenu();
			break;
		case 4: //call help method here
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
			FirstMenu();
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
			System.out.println("W. Up, D. Right, S. Down, A. Left, 0 to quit, 2. Shoot, 3 Look Around, 4 to Save Game, 5 To go back to the Main Menu.");
			playerStatus();
			gameEng.playerTurnUsedWhileInvincible();

			playerChoice = kb.next().toLowerCase();
			kb.nextLine();
			switch(playerChoice){
			case "2":
				if(gameEng.ammoCheck()){
					playerShoot();
				}
				else{
					System.out.println("You are out of ammo.");
				}
				break;
			case "w":
			case "a":
			case "s":
			case "d":
				gameEng.move(playerChoice.toLowerCase());
				options();
				break;
			case "4":
				System.out.println("Enter the Save File name");
				String saveFileName = kb.nextLine();
				gameEng.saveGame(saveFileName + ".taha");
				options();
				break;
			case "5":
				System.out.println("Are you sure you want to the Main Menu, all unsaved progress will be lost!");
				System.out.println("Y/N");
				String saveGameYesNo = kb.next().toLowerCase();
				kb.nextLine();
				switch(saveGameYesNo){
				case "y":
					player = new Taha();
					gameEng = new GameEngine(player);
					FirstMenu();
					break;
				case "n":
					System.out.println("Press Enter to Continue.");
					kb.next();
					options();
					break;
				default:
					options();
					break;

				}
				break;
			case "3":
				wantedToSee();
				gameEng.printGrid();
				System.out.println("Press 1 to continue.");
				kb.next();
				kb.nextLine();
				options();
				break;
			case "0":
				System.exit(0);
				break;
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
	public void doYouWannaSee(){
		int lookFurther = 0;
		System.out.println("Do you want to look further in a direction? 1 yes 2 no");
		lookFurther = kb.nextInt();
		if(lookFurther == 1){
			wantedToSee();
		}
		else{
			System.out.println("Guess you wanna be blind");
		}
	}

	public void wantedToSee(){
		String lookDirection = "0";
		System.out.println("Which direction do you wanna look at?");
		System.out.println("W up, D right, S down, A left" );
		lookDirection = kb.next();
		kb.nextLine();
		gameEng.playerLook(lookDirection);
	}



}