package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;


public class TrueRoom extends Room implements Serializable {

	private boolean briefcase;
	
	public TrueRoom() {

		briefcase = true;
	}
	
	public String toString() {
		
		String result = "[b]";
		return result;
}
	public boolean hasBriefcase() {
		return briefcase;
	}
	
	

}
