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
	
	public void move(int direction, Grid grid){
		int[] playerPosition = grid.getPlayerPostion();
		int row = playerPosition[0];
		int col = playerPosition[1];
		switch(direction){
		
		case 1:
			playerDirection = 1;
			grid.movePlayer(row-1, col);
			break;
		case 2:
			playerDirection = 2;
			grid.movePlayer(row, col+1);
			break;
		case 3:
			playerDirection = 3;
			grid.movePlayer(row+1, col);
			break;
		case 4:
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
