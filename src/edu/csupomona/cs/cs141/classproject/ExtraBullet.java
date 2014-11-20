/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public class ExtraBullet extends PowerUp {
	public String toString() {
		String result;
		if (isSeen()) {
			result = "[B]";
		} else
			result = "[B]";
		return result;
	}
}
