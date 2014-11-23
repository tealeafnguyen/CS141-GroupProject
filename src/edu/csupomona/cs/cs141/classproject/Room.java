/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * @author Isa
 *
 */
public class Room implements GridMember, Serializable{

	private boolean briefcase;

	public boolean isDoor(int playerDirection){
		boolean result;
		if(playerDirection == 3){
			result = true;
		}else{
			result = false;
		}
		return result;
	}

	public void giveBriefcase(){
		briefcase = true;
	}

	public boolean hasBriefcase(){
		return briefcase;
	}

	public String toString(){

		String result = "[R]";
		return result;

	}

	public void resetSee(){

	}

	public boolean isSomething(){
		return true;
	}

	public boolean isSeen(){
		return true;
	}

	public void see(){

	}
	public ImageIcon toImage(){
		ImageIcon result;

		result = new ImageIcon("Room.jpg");
		return result;



	}


}
