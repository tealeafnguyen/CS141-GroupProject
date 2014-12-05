/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

/**
 * @author Isa
 *
 */
public abstract class PowerUp implements GridMember, Serializable{
	
	private boolean seen;
	
	private boolean isUsed; 

	public boolean isSeen() {
		return seen;
	}

	public void see() {
		seen = true;
	}

	public boolean isSomething() {
		return true;
	}

	public void resetSee() {
		seen = false;
	}
	
	public void powerGain(){
		isUsed = true;
	}
	

	public boolean isUsed(){
		boolean returningIsUsed = isUsed;
		return returningIsUsed;
	}
	
}
