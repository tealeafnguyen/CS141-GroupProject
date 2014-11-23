/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

/**
 * @author Isa
 *
 */
public interface GridMember {
	
	String toString();
	
	boolean isSeen();
	
	boolean isSomething();
	
	void see();
	
	void resetSee();
}
