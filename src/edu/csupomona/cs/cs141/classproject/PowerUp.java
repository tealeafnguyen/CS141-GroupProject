/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This is the abstract class of PowerUps, it creates a 
* template for the three power ups avaible in the game
* this abstract class implements GridMember since the objects
* based on this class will spawn on the grid and also serializable
* so the powerups can be saved and loaded.
*
* Team Crazy Bananas
* Taha Khan
* Farzad Kosar
* Yool Weeji Jeon (James)
* Isaac Gonzalez
* Thomas Nguyen
*/ 
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

/**
 * * This is the abstract class of PowerUps, it creates a 
* template for the three power ups avaible in the game
* this abstract class implements GridMember since the objects
* based on this class will spawn on the grid and also serializable
* so the powerups can be saved and loaded.
*
 */
public abstract class PowerUp implements GridMember, Serializable{
	/**
	 * This boolean determines if the powerup is 
	 * seen by the player or not.
	 */
	private boolean seen;
	
	/**
	 * This boolean determines if the powerup is 
	 * picked by the player or not.
	 * 
	 */
	private boolean isUsed; 
	/**
	 * This method returns the value of seen
	 *  
	 */
	public boolean isSeen() {
		return seen;
	}
	/**
	 * This method makes the powerup visible to the
	 * player.
	 * 
	 */
	public void see() {
		seen = true;
	}
	/**
	 * The isSomething method is a boolean that is anything
	 * that exists on the grid with the exception of the empty
	 * member object. The object being something makes it easier 
	 * to interact with one another when the player moves into
	 * something.
	 */ 
	public boolean isSomething() {
		return true;
	}
	/**
	 * The resetSee method will change everything that isSeen
	 * to false, this is here to make sure the player 
	 * doesn't have sight on something they're not 
	 * supposed to.
	 */ 
	public void resetSee() {
		seen = false;
	}
	/**
	 * This method sets the isUsed boolean value to true, 
	 * which means the powerup has been picked up.
	 * 
	 */
	public void powerGain(){
		isUsed = true;
	}
	
	/**
	 * The isUsed method returns the value of the boolean isUsed,
	 * and checks if the powerup has been picked up or not. 
	 */
	public boolean isUsed(){
		boolean returningIsUsed = isUsed;
		return returningIsUsed;
	}
	
}
