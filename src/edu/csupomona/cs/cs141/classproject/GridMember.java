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
public interface GridMember {
	
	String toString();
	
	ImageIcon toImage();
	
	boolean isSeen();
	
	boolean isSomething();
	
	void see();
	
	void resetSee();
}
