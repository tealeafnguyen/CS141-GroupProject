/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

/**
 * @author Isa
 *
 */
public class Radar extends PowerUp implements GridMember, Serializable {

	public String toString() {
		String result;
		if (isSeen()) {
			result = "[r]";
		} else
			result = "[r]";
		return result;
	}
	
}
