/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
 
 //Ultimately, we should move the move method into the game engine
 //For now I'm adding in attributes that the player should have
 
public class Taha extends Entity implements GridMember{
	
	private int lives;
	
	private int ammo;
	
	public Taha(){ 
		lives = 3;
		ammo = 1;
	}
	
	public int showLives(){
		return lives;
	}
	
	public int showAmmo(){
		return ammo;
	}
	
	public void shoot(){
		ammo--;
	}
	
	public void dies(){ //when a ninja kills the player, this method should be called, then another method
		lives--;    // that places the player at spawn should be called
	}
	
	public String toString(){
		String result = "[P]";
		return result;
	}
	
	public boolean isSeen(){
		return true;
	}
	
	
}
