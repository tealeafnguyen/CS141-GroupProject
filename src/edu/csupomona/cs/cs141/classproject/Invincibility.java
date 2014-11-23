package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

public class Invincibility extends PowerUp implements GridMember, Serializable {
	public String toString() {
		String result;
		if (isSeen()) {
			result = "[I]";
		} else
			result = "[I]";
		return result;
	}
	
}
