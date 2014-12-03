/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This is the GridMember class that is an interface
* that represents anything that is represented on 
* the 9 x 9 grid. This interface contains methods that
* all grid members must possess in order to be functional
* represented on the grid.
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
 * Here we have the GridMember class that contains
 * a string which represents the object in the array
 * of objects. There is an ImageIcon for the gui version,
 * but the gui has not been completed in time.
 */
public interface GridMember {
	
	/**
	 * The toString method will display the
	 * object as a string in the array of objects.
	 * Each class that implements this class is 
	 * represented as something between to brackets.
	 */ 
	
	String toString();
	
	/**
	 * The toImage method is similiar to the
	 * toString method, but will display an image
	 * when used in the GUI.
	 */ 
	
	ImageIcon toImage();
	
	/**
	 * The isSeen method is a boolean that when true,
	 * the object that is being seen will be revealed
	 * on the grid. If false, then the object is not 
	 * seen and will be represented as a star.
	 */ 
	
	boolean isSeen();
	
	/**
	 * The isSomething method is a boolean that is anything
	 * that exists on the grid with the exception of the empty
	 * member object. The object being something makes it easier 
	 * to interact with one another when the player moves into
	 * something.
	 */ 
	
	boolean isSomething();
	
	/**
	 * The see method is a method that sets the isSeen
	 * boolean to true whenever something is within range of 
	 * the player.
	 */ 
	
	void see();
	
	/**
	 * The resetSee method will change everything that isSeen
	 * to false, this is here to make sure the player 
	 * doesn't have sight on something they're not 
	 * supposed to.
	 */ 
	
	void resetSee();
}
