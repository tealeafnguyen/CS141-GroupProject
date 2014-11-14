/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public class Room implements GridMember{
	
	private boolean briefcase;
	
	public boolean isDoor(int playerDirection){
		boolean result;
		if(playerDirection == 3){
			result = true;
		}else{
			result = false;
		}
		return result;
	}
	
	public void giveBriefcase(){
		briefcase = true;
	}
	
	public boolean hasBriefcase(){
		return briefcase;
	}
	
	public String toString(){
		
		String result = "[R]";
		return result;
		
	}
	
	public void resetSee(){
		
	}
	
	public boolean isSomething(){
		return true;
	}
	
	public boolean isRoom(){
		return true;
	}
	
	public boolean isEntity(){
		return false;
	}
	
	public boolean isPowerUp(){
		return false;
	}
	
	public boolean isSeen(){
		return true;
	}
	
	public void see(){
		
	}

}
