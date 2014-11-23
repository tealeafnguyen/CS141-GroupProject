/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.awt.Image;
import java.io.Serializable;
import java.applet.*;
import java.awt.*;
import java.awt.Image;
import javax.swing.*;



/**
 * @author Isa
 *
 */
public class EmptyMember implements GridMember, Serializable {
	
	private boolean seen;

	public ImageIcon toImage(){
		ImageIcon result = null;
		if(isSeen()){
			result = new ImageIcon("seeEmptyMember.jpg");
		} else{
			result = new ImageIcon("nothing.jpg");
		}
		return result;
		
	}
	
	public String toString(){
		String result;
		if(isSeen()){
			result = "[ ]";
		}
		else result = "[*]";
		return result;
	}
	
	public boolean isSeen(){
		return seen;
	}
	
	public void resetSee(){
		seen = false;
	}
	
	public void see(){
		seen = true;
	}
	
	public boolean isSomething(){
		return false;
	}
	
	
	
}
