/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* The Entity class is a class that shares all the attributes
* of everything that is alive in the 9 x 9 grid of objects.
* This is extended by the Taha and the NinjaOctopi classes.
* The purpose of this class is to provide a framework to work
* with when designing behaviors for the player and the ninjas.
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
 *The Entity class is an abstract class that possesses a boolean
 * and an integer. This is shared between the ninjas and the player.
 */
public abstract class Entity implements GridMember, Serializable {
	
	/**
	 * The boolean seen is mainly used for the ninjas,
	 * this attribute depends on whether or not the
	 * player is within range to actually see
	 * the ninja. 
	 */ 
	
	private boolean seen;
	
	/**
	 * The integer array size 2 position keeps
	 * track of an entities's position. This array
	 * will change dynamically as the ninjas and
	 * the player will be moving around constantly.
	 */ 
	
	private int[] position = new int[2];
	
	/**
	 * The isSeen method will return the boolean
	 * above. If the entity is seen, their toString method
	 * will display their specialized string that represents
	 * the entity. Which is usually a ninja.
	 */ 
	
	public boolean isSeen(){
		return seen;
	}
	
	/**
	 * The setPosistion method will constantly change
	 * the size 2 array position everytime an entity 
	 * makes their move. 
	 */ 
	
	public void setPosition(int row, int col){
		position[0] = row;
		position[1] = col;
	}
	
	/**
	 * The getPosition method will take the size
	 * 2 array position and return the entire array 
	 * to whatever method that called it. This is mainly
	 * to move something to an adjacent square on the grid.
	 */ 
	
	public int[] getPosition(){
		return position;
	}
	
	/**
	 * The see method will make the boolean seen to true.
	 * This method is called whenever the player is adjacent
	 * to a square. All squares adjacent to the player will be
	 * changed to true so it is considered as "seen".
	 */ 
	
	public void see(){
		seen = true;
	}
	
	/**
	 * The resetSee method is called to keep something from being 
	 * seen. If a player saw a square, then moved away from that
	 * square, that square would still be considered seen and reveal
	 * whatever is on that square. This method fixes that problem.
	 */ 
	
	public void resetSee(){
		seen = false;
	}
	
	/**
	 * The isSomething method is always true for an entity is always
	 * something. The only time the isSomething boolea is false is
	 * when it is an instance of empty member.
	 */ 
	
	public boolean isSomething(){
		return true;
	}
}
