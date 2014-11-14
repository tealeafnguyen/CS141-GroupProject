/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public interface GridMember {
	
	String toString();
	
	boolean isSeen();
	
	boolean isSomething();
	
	boolean isEntity();
	
	boolean isPowerUp();
	
	boolean isRoom();
	
	boolean hasBriefcase();
	
	void see();
	
	void resetSee();
}
