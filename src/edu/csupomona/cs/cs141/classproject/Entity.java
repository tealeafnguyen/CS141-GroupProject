/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

/**
 * @author Isa
 *
 */
public abstract class Entity implements GridMember, Serializable {
	
	private boolean seen;
	
	private int[] position = new int[2];
	
	public boolean isSeen(){
		return seen;
	}
	
	
	public void setPosition(int row, int col){
		position[0] = row;
		position[1] = col;
	}
	
	public int[] getPosition(){
		return position;
	}
	
	public void see(){
		seen = true;
	}
	
	public void resetSee(){
		seen = false;
	}
	
	public boolean isSomething(){
		return true;
	}
	
	
}
