/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This is the EmptyMember class, it implements GridMember because it
* is a part of the 9x9 grid and serializable so it can be stored with
* the grid object to save. This object represents the EmptyMembers in the
* grid, ie where there aren't any rooms, ninjaOctopi, etc.
*
* Team Crazy Bananas
* Taha Khan
* Farzad Kosar
* Yool Weeji Jeon (James)
* Isaac Gonzalez
* Thomas Nguyen
*/ 
package edu.csupomona.cs.cs141.classproject;

import java.awt.Image;
import java.io.Serializable;
import java.applet.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;



/**
 * * This is the EmptyMember class, it implements GridMember because it
 * is a part of the 9x9 grid and serializable so it can be stored with
 * the grid object to save. This object represents the EmptyMembers in the
 * grid, ie where there aren't any rooms, ninjaOctopi, etc.
 *
 *
 */
public class EmptyMember implements GridMember, Serializable {
	/**
	 * The boolean seen, determines if an object is to be 
	 * revealed or not, to the player.
	 */
	private boolean seen;
	
	/**
	 * The toImage method is similiar to the
	 * toString method, but will display an image
	 * when used in the GUI.
	 */ 
	public ImageIcon toImage(){
		ImageIcon result = null;
		if(isSeen()){
			result = new ImageIcon("seeEmptyMember.jpg");
		} else{
			result = new ImageIcon("nothing.jpg");
		}
		return result;
		
	}
	
	/**
	 * The toString method will display the
	 * object as a string in the array of objects.
	 * The empty member is displayed as a * when
	 * not seen and an empty box when seen.
	 */ 
	
	public String toString(){
		String result;
		if(isSeen()){
			result = "[ ]";
		}
		else result = "[*]";
		return result;
	}
	
	/**
	 * The isSeen method is a boolean that when true,
	 * the object that is being seen will be revealed
	 * on the grid. If false, then the object is not 
	 * seen and will be represented as a star.
	 */
	
	public boolean isSeen(){
		return seen;
	}
	
	/**
	 * The resetSee method will change everything that isSeen
	 * to false, this is here to make sure the player 
	 * doesn't have sight on something they're not 
	 * supposed to.
	 */ 
	public void resetSee(){
		seen = false;
	}
	/**
	 * The see method is a method that sets the isSeen
	 * boolean to true whenever something is within range of 
	 * the player.
	 */ 
	public void see(){
		seen = true;
	}
	/**
	 * The isSomething method is a boolean that is anything
	 * that exists on the grid with the exception of the empty
	 * member object. The object being something makes it easier 
	 * to interact with one another when the player moves into
	 * something.
	 */ 
	public boolean isSomething(){
		return false;
	}
	
	
	
}
