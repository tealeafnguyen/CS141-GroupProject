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
	
	
	// isUsed was private so I had to do this, are you u sure we aren't breaking encapsulation?
	public boolean isUsed(){
		boolean returningIsUsed = isUsed;
		return returningIsUsed;
	}
	
}
