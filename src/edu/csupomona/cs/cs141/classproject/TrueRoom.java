/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This is the TrueRoom class of the Tahas-Japanese-Adventure-in=Japan
* The purpose of this class is to replace the room that is currently
* in the possession of the briefcase when the radar power up had been
* obtained by the player. This class extends the Room class and displays
* a different string in order to represent that the room is clearly
* different than the other rooms.
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
 * The TrueRoom class exentds room and implements serializable.
 * This class is used to create an object that is an instance 
 * of room which will replace the current room that is in the
 * possession of the briefcase. An object created by this class
 * will always have a briefcase.
 */ 

public class TrueRoom extends Room implements Serializable {
	
	/**
	 * The boolean briefcase dictates whether or 
	 * not a room is in the possession of the briefcase.
	 */ 

	private boolean briefcase;
	
	/**
	 * The constructor of the TrueRoom class will
	 * set the boolean briefcase to true, because 
	 * an object created by this class will always
	 * have the briefcase.
	 */ 
	 
	public TrueRoom() {

		briefcase = true;
	}
	
	/**
	 * The toString method here will repesent the
	 * room as [b] so that the player will know that
	 * this room is in the possession of the briefcase.
	 */ 
	
	public String toString() {
		
		String result = "[b]";
		return result;
		
	}
	
	/**
	 * The hasBriefcase method returns the boolean 
	 * of the object whether or not the room has a 
	 * briefcase. This is called when a player moves
	 * into a room from the top.
	 */
	 
	public boolean hasBriefcase() {
		return briefcase;
	}
}
