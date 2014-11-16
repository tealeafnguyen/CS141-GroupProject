/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public abstract class PowerUp implements GridMember{
	
	private boolean seen;
	
	public boolean isSeen(){
		return seen;
	}
	
	public void see(){
		seen = true;
	}
	
	public boolean isSomething(){
		return true;
	}
	
	
	public void resetSee(){
		seen = false;
	}
	
}
