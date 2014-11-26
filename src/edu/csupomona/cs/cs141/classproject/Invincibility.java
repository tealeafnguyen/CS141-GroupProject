package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

import javax.swing.ImageIcon;

public class Invincibility extends PowerUp implements GridMember, Serializable {
	public String toString() {
		String result;
		if (isSeen()) {
			result = "[I]";
		} else
			result = "[*]";
		return result;
	}
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
