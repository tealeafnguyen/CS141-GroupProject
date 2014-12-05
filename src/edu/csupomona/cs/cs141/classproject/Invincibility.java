/**
* CS 141: Introduction to Programming and Problem Solving
* Professor: Edwin Rodr&iacute;guez
*
* Programming Project
*
* This class, Invincibility, is an extension of the class, PowerUp, because this
* class needs to be able to read and take the methods to be used in this class
* to function properly. It also implements Serializable to be able to save and
* load.
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

public class Invincibility extends PowerUp implements GridMember, Serializable {
	/**
	 * This class takes in the field, result, and prints out if the result is
	 * seen or not in the game field of the grid. Then, it prints out the result
	 * according to the if and else statement.
	 */
	public String toString() {
		String result;
		if (isSeen()) {
			result = "[I]";
		} else
			result = "[*]";
		return result;
	}
	/**
	 * This method is exactly same as method as above, toString(). This method
	 * was created for the use of GUI.
	 */
	public ImageIcon toImage(){
		ImageIcon result;
		if(isSeen()){
			result = new ImageIcon("invipowerup.jpg");
			return result;
		} else {
			result = new ImageIcon("nothing.jpg");
			return result;
		}
	}
	
}
