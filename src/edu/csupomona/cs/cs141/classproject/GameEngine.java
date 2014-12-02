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
 * This class is used to get information from the UserInterface and then pass that
 * info in over to the Grid for the Grid to use. It essentially acts as a sort
 * of "middleman", that way the UserInterface that the game uses can be modular.
 * @author CrazyBananas
 *
 */
public class GameEngine implements Serializable { 

	/**
	 * The {@link Taha} object to be used in the game. It is passed into the
	 * {@link Grid} when it is created in the constructor for this class.
	 */
	private Taha thePlayer;

	/**
	 * The {@link Grid} object to be used in the game and referred to by
	 * the {@link GameEngine}
	 */
	private Grid grid;
	
	/**
	 * This is the direction the player is "facing" on the {@link Grid}
	 */
	private int playerDirection;

	/**
	 * This constructor creates a {@link Taha} and {@link Grid} object and
	 * passes in the created {@link Taha} object into the {@link Grid} so 
	 * the grid knows to interact with that Taha object.
	 * @param tahaPlayer
	 */
	public GameEngine(Taha tahaPlayer) {

		thePlayer = new Taha();
		playerDirection = thePlayer.getPlayerDirection();
		grid = new Grid(thePlayer);

	}

	/**
	 * This method gets information from the {@link #grid} to check if the
	 * player has won the game yet.
	 * @return {@code true} if the player has won and {@code false} if
	 * they have not won.
	 */
	public boolean recieveWinFromGrid(){
		if(grid.showWin()){
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * Calls the {@link #grid}'s {@link Grid.#debugMode()} method to
	 * signal that the game should be in debug mode.
	 */
	public void debug(){
		grid.debugMode();
	}

	/**
	 * Keeps track of the turns that the player has left with the
	 * invincibility power up.
	 */
	public void playerTurnUsedWhileInvincible() {
		if (thePlayer.showCantDieTime() > 0) {
			thePlayer.cantDieCheck();
		}
	}

	/**
	 * Keeps track of the amount of lives the player has left and ends the game
	 * if the player has no lives left.
	 * @return {@code true} if the player has not lives left and {@code false}
	 * if the player still has lives left.
	 */
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

	/**
	 * Gets the GridMember at a certain index in the array from the {@link #grid}
	 * @param row the first index of the array
	 * @param col the second index of the array
	 * @return the {@link GridMember} in that index.
	 */
	public GridMember getGM(int row, int col){
		
		return grid.getGridMember(row, col);
		 
	}

	/**
	 * This method tells the {@link #grid} which direction the user wants
	 * to move within the game. It uses a switch statement to call the
	 * {@link Grid.#movePlayer(int, int)} method according to what information
	 * was passed in by the {@link UserInterface}.
	 * @param direction value passed in by the {@link UserInterface}
	 * that decides what information will be passed to the {@link Grid}
	 * via this method.
	 */
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

	/**
	 * Calls on the {@link Grid} to look in a direction depending on input
	 * given by the user from the {@link UserInterface}
	 * @param direction value to be passed to the {@link Grid.#look(String)}
	 * method.
	 */
	public void playerLook(String direction) {
		grid.look(direction);
	}

	/**
	 * Used to get the player direction.
	 * @return {@link #playerDirection}
	 */
	public int getPlayerDirection() {
		return playerDirection;
	}

	/**
	 * Calls the {@link Grid.#playerSeeAround()} method.
	 */
	public void callGridSeeAround(){
		grid.playerSeeAround();
	}

	/**
	 * Calls the {@link Grid.#resetSeeAll()} method.
	 */
	public void callGridSeeReset(){
		grid.resetSeeAll();
	}

	/**
	 * Gets the {@link Taha} object used in the game.
	 * @return {@link #thePlayer}
	 */
	public Taha getPlayer() {
		return thePlayer;
	}

	/**
	 * Keeps track of the amount of lives the player has left. It uses the 
	 * {@link Taha.#showLives()} method to keep track of the lives.
	 * @return the amount of lives the player has left.
	 */
	public int lives() {
		return thePlayer.showLives();
	}

	/**
	 * Keeps track of the amount of ammo the player has left. It uses the
	 * {@link Taha.#showAmmo()} method.
	 * @return the amount of ammo the player has left.
	 */
	public int ammo() {
		return thePlayer.showAmmo();
	}

	/**
	 * Keeps track of whether or not the player is invincible. It uses the
	 * {@link Taha.#showCantDieTime()} method.
	 * @return the amount of turns the player has left invincible.
	 */
	public int cantDie() {
		return thePlayer.showCantDieTime();
	}

	/**
	 * Gets information from the {@link UserInterface} regarding which direction
	 * the user wants to shoot, if they choose to do so. It passes that value into
	 * the {@link Grid.#shootDirection(int)} method.
	 * @param shootChoice the direction the user wants to shoot in.
	 */
	public void shootDirection(int shootChoice) {

		grid.shootDirection(shootChoice);

	}

	/**
	 * This method checks if the player object has any ammo left to use. It uses
	 * the {@link Taha.#showAmmo()} method to keep track of this value.
	 * @return {@code true} if the player has ammo or {@code false} if they do not.
	 */
	public boolean ammoCheck(){
		if(thePlayer.showAmmo() > 0){
			return true;
		}
		else{
			return false;
		}
	}

	/**
	 * Manually sets the {@link Taha} object for use in the {@link Grid}
	 * @param player the {@link Taha} object to be used in the {@link Grid}
	 */
	public void setPlayer(Taha player){
		grid.setPlayer(player);
	}

}
