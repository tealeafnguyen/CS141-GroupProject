/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Project
 *
 * This class contains the command line user interface part of the game
 * it takes in the input from user uses the gameengine to make the changes to the
 * grid thats printed out, this class also saves and loads the game.
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

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.InputMismatchException;
import java.util.Scanner;











public class UserInterface {

	/**
	 * This creates the Taha object that holds most of the , for more information
	 * go to the Taha class's javadoc
	 */
	private Taha player = new Taha();
	/**
	 * creates the GameEngine object and initializes it with the by sending in the 
	 * player object
	 */
	GameEngine gameEng = new GameEngine(player);
	/**
	 * Universal Scanner to take input from the user.
	 */
	Scanner kb = new Scanner(System.in);
	/**
	 * this boolean variable determines if debug mode is on or off.
	 */
	private boolean debug = false;
	/**
	 * this boolean variable helps check if the user has looked around
	 * once per turn or not.
	 */
	private boolean lookAroundUsedOnce = false;
	/**
	 * This is the first menu the User encounters when the game is launched
	 * this method contains the takes the input from the user and sends the
	 * input to the FirstMenuRedirection method.
	 */
	public void FirstMenu(){
		int userChoice = 0;


		kb = new Scanner(System.in);
		System.out.println("Welcome to Taha's Japanese Adventure in Japan!\n");
		System.out.println("1. Start Game");
		System.out.println("2. Load Game");
		System.out.println("3. About");
		System.out.println("4. Help");
		System.out.println("5. Quit");

		try{

			userChoice = kb.nextInt();
			kb.nextLine();
			FirstMenuRedirection(userChoice);



		} catch(InputMismatchException e){
			System.out.println("Bad Input, Try again");
			FirstMenu();

		}

	}

	/**
	 * This method takes in the user's choice and opens the
	 * appropriate method
	 * @param userChoice the user input taken in from the FirstMenu method
	 */

	public void FirstMenuRedirection(int userChoice) {
		// TODO Auto-generated method stub
		switch (userChoice){
		case 1: 
			options();
			break;
		case 2: //call load game method here..... NO
			printTheListofSaves();
			System.out.println("Enter your save Game filename, or press N to go back to Main Menu");
			String fileName = kb.nextLine().toLowerCase();
			if(fileName.equals("n")){
				FirstMenu();
				break;
			}
			loadGame(fileName+".taha");
			options();
			break;
		case 3: //call about method here..... NO
			System.out.println("Creators:\n Isaac (aka IsaacDG)\n Thomas (aka Butthole Ripper)\n Taha (aka Jericho)\n James (aka kor3a)\n Fraz (aka muffinbottoms)\n");
			FirstMenu();
			break;
		case 4: //call help method here.... NO
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
	/**
	 * This method does calls on multiple other methods to check if
	 * the game is won, if the debug mode is enabled, if the player is inviniclbe
	 * this method also prints out the grid, it also takes the input 
	 * from the user and does the appropriate action. We incorporated recursion
	 * into this method, but since it barely uses any memory, it should not cause
	 * any errors.
	 */
	public void options(){

		String playerChoice = "AWWWWWWWWWWW YEEEEEEEEEE, LET THE GAMES BEGIN";
		while(playerChoice != "0"){

			gameEng.callGridSeeReset();
			gameEng.callGridSeeAround();
			debugCheck();
			printGrid();
			gameEng.gameOverCheck();
			if(gameEng.gameOverCheck()){
				player = new Taha();
				gameEng = new GameEngine(player);
				FirstMenu();
			}


			doIWinYet();
			System.out.println("W. Up, D. Right, S. Down, A. Left, 0 to quit, 1. Shoot, 2 Look Around, 3 to Save Game, 4 To go back to the Main Menu.");
			playerStatus();
			gameEng.playerTurnUsedWhileInvincible();

			playerChoice = kb.next().toLowerCase();
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
			case "w":
			case "a":
			case "s":
			case "d":
				gameEng.move(playerChoice);
				resetLookAroundUsed();
				options();
				break;
			case "3":
				System.out.println("Enter the Save File name");
				String saveFileName = kb.nextLine();
				makeAListofSaves(saveFileName);
				saveGame(saveFileName + ".taha");
				options();
				break;
			case "4":
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
			case "2":
				checkLookAroundUsed();
				break;
			case "0":
				System.exit(0);
				break;
			case "8":
				System.out.println("Debug mode activated");
				if(debug == false){
					debug = true;	
				} else {
					debug = false;
				}

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

	/**
	 * this method asks the user which direction to shoot then calls
	 * the shoot method in the game engine.
	 */
	public void playerShoot(){
		System.out.println("Which direction to shoot? 1 up 2 left 3 down 4 right");
		int shootChoice = kb.nextInt();
		gameEng.shootDirection(shootChoice);
	}

	/**
	 * This method shows the amount of lives left and prints it on the 
	 * screen, the lives are shown by called the lives method in from
	 * the game engine.
	 */
	public void playerStatus(){
		System.out.println("Lives: " + gameEng.lives()+ " Ammo: "+ gameEng.ammo());
		System.out.println("Turns invincible: "+ gameEng.cantDie() );
	}
	/**
	 * This method checks if the game is won or not, it is called in options methods, 
	 * and if the game is won, the player is redirected to the main menu.
	 */
	public void doIWinYet(){
		if(gameEng.recieveWinFromGrid()){
			System.out.println("You have won the game");			
			System.out.println("Press 1 to continue.");
			kb.nextInt();
			kb.nextLine();
			player = new Taha();
			gameEng = new GameEngine(player);
			FirstMenu();
		}
	}
	/**
	 * This method is called once the player has used
	 * the look around ability once per turn, then
	 * it doesn't allow the player to use it again.
	 */
	public void lookAroundUsed(){
		lookAroundUsedOnce = true;
	}
	/**
	 * This method resets the boolean value to false
	 * when the player's turn is started, so that the
	 * player can use the look around ability.
	 */
	public void resetLookAroundUsed(){
		lookAroundUsedOnce = false;
	}
	/**
	 * This method checks the boolean value to determine
	 * if the lookaround ability is already used or not,
	 * the look around ability is only available to the player
	 * once per turn.
	 */
	public void checkLookAroundUsed(){
		if(lookAroundUsedOnce){
			System.out.println("You can only look ahead once per turn.");
		} else {
			wantedToSee();
//			gameEng.printGrid();
			System.out.println("Press 1 to continue.");
			kb.next();
			kb.nextLine();
			lookAroundUsed();
			options();
		}
	}
/**
 * This method makes/edits a file called ".savedata" and makes
 * a list of save games in there.
 * @param FileName
 */
	public void makeAListofSaves(String FileName){
		try {

			FileWriter ff = new FileWriter(".savedata", true);
			PrintWriter pw = new PrintWriter(ff);
			pw.println(FileName);
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Something's wrong, bruh");
		} finally{
			//do nothing
		}

	}
	/**
	 * This method opens the ".savedata" file and prints out the list
	 * of save files from there to the screen, so the user can use it
	 * to type the load files name from here.
	 */
	public void printTheListofSaves(){
		File fileReader = new File(".savedata");
		try {
			Scanner fileR = new Scanner(fileReader);
			System.out.println("Here are the List of current saved game files:");
			while(fileR.hasNextLine()){
				System.out.println(fileR.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/**
	 * This method asks for user input and then reveals one additional block
	 * depending on the direction the user inputs.
	 */
	public void wantedToSee(){
		String lookDirection = "0";
		System.out.println("Which direction do you wanna look at?");
		System.out.println("W up, D right, S down, A left" );
		lookDirection = kb.next();
		kb.nextLine();
		gameEng.playerLook(lookDirection);
	}
	/**
	 * This method just enables the debug mode. 
	 * 
	 */
	public void debugCheck(){
		if(debug == true){
			debugActivate();
		}
	}
	/**
	 * This method calls the debug mode method from the 
	 * game engine
	 */
	public void debugActivate(){
		gameEng.debug();
	}
	/**
	 * this method allows the user to save the game. the method saves
	 * the game engine object into a binary file and catches 
	 * exceptions and prints out an error.
	 * @param fileName
	 */
	public void saveGame(String fileName){

		try {

			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(gameEng);
			oos.close();
			System.out.println("Game Saved Successfully.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Save Game Unsuccessful.");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Could not save game.");
			e.printStackTrace();
		}
	}
	/**
	 * The loadGame method loads allows the user to load
	 * a previously saved game into memory, what it actually
	 * does is load the game engine object from file and load 
	 * it to memory.
	 * @param fileName
	 */
	public void loadGame(String fileName){
		try {

			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			gameEng = (GameEngine) ois.readObject();
			Taha testPlayer = gameEng.getPlayer();
			gameEng.setPlayer(testPlayer);
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	/**
	 * This method is used to print the grid out to
	 * the user in a form of readable strings.
	 * It uses toString methods from the individual
	 * objects in the grid to print out their
	 * specific icon.
	 */
		public void printGrid() {
				GridMember gm = null;
				for(int i = 0; i < 9; i++){
				for(int j = 0; j < 9; j++){
						gm = gameEng.getGM(i, j);
						System.out.print(gm.toString());
					}
					System.out.println();
				}
			}

	/**
	 * printLogo method is just used to make the UI a 
	 * bit more snazzy, it prints out an ascii logo from
	 * a file when the game is started.
	 */
	public void printLogo(){
		try {

			FileReader fr = new FileReader("theMainText.txt");
			Scanner fs = new Scanner(fr);
			while(fs.hasNextLine()){
				System.out.println(fs.nextLine());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
