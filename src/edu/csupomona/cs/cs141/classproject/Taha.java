/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public class Taha extends Entity implements GridMember{
	
	private int playerDirection;
	
	public Taha(){
		playerDirection = 1;
	}
	
	public void move(String direction, GameEngine grid){
		int[] playerPosition = grid.getPlayerPostion();
		int row = playerPosition[0];
		int col = playerPosition[1];
		switch(direction){
		
		case "w":
			playerDirection = 1;
			grid.movePlayer(row-1, col);
			break;
		case "d":
			playerDirection = 2;
			grid.movePlayer(row, col+1);
			break;
		case "s":
			playerDirection = 3;
			grid.movePlayer(row+1, col);
			break;
		case "a":
			playerDirection = 4;
			grid.movePlayer(row, col-1);
			break;
		default:
			System.exit(0);
		}
		
		
	}
	
	public int getPlayerDirection(){
		return playerDirection;
	}
	
	public String toString(){
		String result = "[P]";
		return result;
	}
	
	public boolean isSeen(){
		return true;
	}
	
	
}
