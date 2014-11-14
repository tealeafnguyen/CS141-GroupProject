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
	
	public boolean isPowerUp(){
		return true;
	}

	public boolean isSomething(){
		return true;
	}
	
	public boolean isEntity(){
		return false;
	}
	
	public void resetSee(){
		seen = false;
	}
	
	public boolean isRoom(){
		return false;
	}
	
	public boolean hasBriefcase(){
		return false;
	}
}
