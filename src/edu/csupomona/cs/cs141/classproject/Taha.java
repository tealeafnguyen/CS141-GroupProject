/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This is the Taha class, which was formerly the player
* class used to create a player object which will do stuff
* in accordance to the user's demands. This is called
* the Taha class now because the main character needs a 
* name. This class possesses lives, ammo, and direction facing.
* These attributes will be explained further.
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

import javax.swing.ImageIcon;

/**
 * The Taha class extends Entity and implements Serializable 
 * and GridMember. The status of the Taha class must be saved
 * and load when called upon. Every Entity in this game possesses
 * a position on the grid and that position can change dynamically.
 */
 
public class Taha extends Entity implements GridMember, Serializable{
	
	/**
	 * The integer lives represents how many times the
	 * Taha object can die until it is game over.
	 */ 
	
	private int lives;
	
	/**
	 * The integer field ammo keeps track of the player's
	 * ammo. Without ammo, the player will be unable to fire
	 * their swag blaster.
	 */ 

	private int ammo;
	
	/**
	 * The integer field cantDieDuration is a counter that
	 * counts down after every turn that the player uses
	 * up. This countdown will start when the player grabs
	 * the invincibility power up.
	 */ 

	private int cantDieDuration;
	
	/**
	 * The integer field playerDirection keeps track
	 * where the player is facing. This is so the player
	 * can't attempt to enter a room unless they are facing
	 * the 6 o'clock position.
	 */ 
	
	private int playerDirection;
	
	/**
	 * The constructor creates the Taha object to have
	 * 3 lives, 1 ammo, and their initial direction is 1.
	 */ 
	 
	public Taha() {
		lives = 3;
		ammo = 1;
		playerDirection = 1;
	}
	
	/**
	 * The showLives method will return
	 * the amount of lives that the player currently
	 * possess. 
	 */ 

	public int showLives() {
		return lives;
	}
	
	/**
	 * The showAmmo method returns the amount
	 * of ammo the player may have. 
	 */ 

	public int showAmmo() {
		return ammo;
	}
	
	/**
	 * The showCantDieTime returns the amount
	 * of turns left of invicibility. The counter
	 * will stop at zero and the effect of not
	 * dying will end.
	 */ 
	
	public int showCantDieTime(){
		return cantDieDuration;
	}
	
	/**
	 * The cantDieCheck is called whenever
	 * the player is invincible. The integer
	 * cantDieDuraction is subtracted by 1.
	 */ 
	
	public void cantDieCheck(){
		cantDieDuration--;
	}
	
	/**
	 * The shoot method will subtract 1
	 * from the player's ammo. This is called
	 * whenever the player fires their 
	 * swag blaster.
	 */ 

	public void shoot() {
		ammo--;
	}
	
	/**
	 * The dies method is called whenever
	 * the player is killed by the ninja.
	 * This subtracts 1 from the player's
	 * lives.
	 */ 

	public void dies() { 						
		lives--; 
	}
	
	/**
	 * The addAmmo method is called whenever
	 * the player grabs the extra bullet 
	 * power up. The method will add one extra
	 * bullet to their swag blaster.
	 */ 
	
	public void addAmmo(){
		ammo++;
	}
	
	/**
	 * The isWalkingOnSunshine method is 
	 * called when the player grabs the 
	 * invincibility power up. I called this 
	 * method the isWalkingOnSunshine method
	 * because writing invincibility over and over
	 * led to too many errors in spelling.
	 */ 
	
	public void isWalkingOnSunshine(){
		cantDieDuration = 5;
	}
	
	/**
	 * The toImage method is similar to the
	 * toString method, but is for the use of
	 * a GUI. The player is represented as an
	 * image instead of a string.
	 */ 

	public ImageIcon toImage(){
		ImageIcon result = null;
		
			result = new ImageIcon("Taha.jpg");
		
		return result;
	}
	
	/**
	 * The toString method is the representation
	 * of the object on the 9 x 9 grid. Anything
	 * that exists on the grid will be represented
	 * as some sort of string.
	 */ 
	
	public String toString() {
		String result = "[T]";
		return result;
	}
	
	/**
	 * The isSeen method will always return true here.
	 * The player will always be visible to themselves.
	 */ 
	
	public boolean isSeen() {
		return true;
	}
	
	/**
	 * The setPlayerDirection takes an integer
	 * as an argument. The playerDirection is changed
	 * depending on where the player decides to move.
	 * For example, if they move down, then the direction
	 * is 3.
	 */ 
	
	public void setPlayerDirection(int direction) {
		playerDirection = direction;
	}
	
	/**
	 * The getPlayerDirection method returns the current
	 * player's direction. This is important when entering
	 * rooms, since rooms require that the player's direction
	 * is 3 to enter.
	 */ 
	
	public int getPlayerDirection() {
		return playerDirection;
	}

}

