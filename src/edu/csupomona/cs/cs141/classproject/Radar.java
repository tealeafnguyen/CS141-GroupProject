/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public class Radar extends PowerUp implements GridMember {

	public String toString() {
		String result;
		if (isSeen()) {
			result = "[r]";
		} else
			result = "[r]";
		return result;
	}
	
}
