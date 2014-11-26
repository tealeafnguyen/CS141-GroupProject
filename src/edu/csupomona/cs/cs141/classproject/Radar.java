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
public class Radar extends PowerUp implements GridMember, Serializable {

	public String toString() {
		String result;
		if (isSeen()) {
			result = "[r]";
		} else
			result = "[*]";
		return result;
	}
	public ImageIcon toImage(){
		ImageIcon result;
		if(isSeen()){
			result = new ImageIcon("radarpowerup.jpg");
			return result;
		} else {
			result = new ImageIcon("nothing.jpg");
			return result;
		}
	}
	
	
}
