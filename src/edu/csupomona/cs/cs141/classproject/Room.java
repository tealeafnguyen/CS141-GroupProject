/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This is the Room class where objects created by
* this class will display as [R] when they are
* created on the grid class. The purpose of this class
* is to represent the nine rooms in the game where
* one of the rooms will possess the briefcase in
* order to give a win condition to the player.
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
 * The Room class implements the GridMember and Serializable
 * interfaces. The serializable will save which room contains
 * the briefcase and the grid member interface all share the
 * toString method,
 */
public class Room implements GridMember, Serializable{

	/**
	 * The boolean briefcase is an attribute
	 * that all rooms possess. A room will
	 * either have a briefcase or not, only one
	 * room may have a briefcase at any given
	 * instance of the game.
	 */

	private boolean briefcase;
	
	/**
	 * The isDoor method checks whether or not
	 * the player entering the room from the top
	 * of the room. Otherwise the player will not
	 * be able to access the room.
	 */ 

	public boolean isDoor(int playerDirection){
		boolean result;
		if(playerDirection == 3){
			result = true;
		}else{
			result = false;
		}
		return result;
	}
	
	/**
	 * The giveBriefcase method will give a
	 * random room a briefcase, but only one
	 * room is allowed to have a briefcase. Please
	 * see grid class for how this is done.
	 */ 

	public void giveBriefcase(){
		briefcase = true;
	}
	
	/**
	 * The hasBriefcase method will return the
	 * boolean attribute whenever the player tries
	 * to access the room from the top. 
	 */ 

	public boolean hasBriefcase(){
		return briefcase;
	}
	
	/**
	 * The toString method represents the room
	 * as [R] when the print grid method is called.
	 * There should only be nine of these on the grid.
	 * Eight if the radar has been found.
	 */ 

	public String toString(){

		String result = "[R]";
		return result;

	}
	
	/**
	 * The resetSee method is empty here because the room
	 * is always visible to the player no matter what
	 * happens. This method is mainly for everything else, 
	 * but this method was from the interface of grid member.
	 */ 

	public void resetSee(){
	}
	
	/**
	 * The isSomething method is a method from the 
	 * grid member interface. This method represents that
	 * an object created from the Room class is considered
	 * as something.
	 */ 

	public boolean isSomething(){
		return true;
	}
	
	/**
	 * The isSeen method is a method from the interface
	 * grid member. When something is seen, they are considered
	 * visible to the player, but since the room objects will
	 * always be visible, this is just left here to satisfy the
	 * interfcase.
	 */ 

	public boolean isSeen(){
		return true;
	}
	
	/**
	 * The see method will reveal the object from the darkness
	 * or a shadow, something that is not meant to be seen until
	 * the player gains vision of it. This method is not needed,
	 * because the room objects will always be visible.
	 */ 

	public void see(){
	}
	
	/**
	 * The toImage method is the same as the toString method,
	 * but was created for the use of a GUI.
	 */ 
	
	public ImageIcon toImage(){
		ImageIcon result;

		result = new ImageIcon("Room.jpg");
		return result;

	}

}
