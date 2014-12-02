/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;


/**
 * @author
 *
 */
public class GameEngine implements Serializable { //A lot of stuff has been moved to Grid

	private static final String String = null;

	private Taha thePlayer;

	private Grid grid;

	private int playerDirection; // moved from Taha class

	public GameEngine(Taha tahaPlayer) {

		thePlayer = new Taha();
		playerDirection = thePlayer.getPlayerDirection();
		grid = new Grid(thePlayer);

	}

	public boolean recieveWinFromGrid(){
		if(grid.showWin()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void debug(){
		grid.debugMode();
	}


	public void playerTurnUsedWhileInvincible() {
		if (thePlayer.showCantDieTime() > 0) {
			thePlayer.cantDieCheck();
		}
	}

	public boolean gameOverCheck() {
		if (thePlayer.showLives() <= 0) {
			Scanner kb = new Scanner(System.in);
			System.out.println("Game Over");
			System.out.println("Press 1 to continue.");
			kb.nextInt();
			kb.nextLine();
			return true;
		} else{
			return false;
		}
	}

	public void printGrid(){
		GridMember gm = null;
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				gm = grid.getGridMember(i, j);
				System.out.print(gm.toString());
			}
			System.out.println();
		}
		System.out.println();
	}


	public void move(String direction) { 
		int[] playerPosition = grid.getPlayerPostion(); 
		int row = playerPosition[0]; 
		int col = playerPosition[1]; 
		switch (direction) {

		case "w":
			thePlayer.setPlayerDirection(1);
			grid.movePlayer(row - 1, col);
			break;
		case "d":
			thePlayer.setPlayerDirection(2);
			grid.movePlayer(row, col + 1);
			break;
		case "s":
			thePlayer.setPlayerDirection(3);
			grid.movePlayer(row + 1, col);
			break;
		case "a":
			thePlayer.setPlayerDirection(4);
			grid.movePlayer(row, col - 1);
			break;
		}
	}

	public void playerLook(String direction) {
		grid.look(direction);
	}

	public int getPlayerDirection() { // Moved from Taha class
		return playerDirection;
	}

	public void callGridSeeAround(){
		grid.playerSeeAround();
	}

	public void callGridSeeReset(){
		grid.resetSeeAll();
	}

	public Taha getPlayer() {
		return thePlayer;
	}

	public int lives() {
		return thePlayer.showLives();
	}

	public int ammo() {
		return thePlayer.showAmmo();
	}

	public int cantDie() {
		return thePlayer.showCantDieTime();
	}

	public void shootDirection(int shootChoice) {

		grid.shootDirection(shootChoice);

	}

	public boolean ammoCheck(){
		if(thePlayer.showAmmo() > 0){
			return true;
		}
		else{
			return false;
		}
	}

	public void saveGame(String fileName){

		try {
			Grid.saveLivesAndAmmo(fileName);
			FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(grid);
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

	public void loadGame(String fileName){
		try {
			Grid.loadLivesAndAmmo(fileName);
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis);
			grid = (Grid) ois.readObject();

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

}
