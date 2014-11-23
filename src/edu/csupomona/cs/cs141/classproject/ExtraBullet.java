/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

/**
 * @author Isa
 *
 */
public class ExtraBullet extends PowerUp implements Serializable {
	public String toString() {
		String result;
		if (isSeen()) {
			result = "[B]";
		} else
			result = "[B]";
		return result;
	}
}
