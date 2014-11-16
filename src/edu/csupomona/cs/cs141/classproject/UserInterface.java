/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

/**
 * @author Isa
 *
 */
public class UserInterface {

	
	private GridMember[][] gridCells;
	
	public UserInterface(Grid grid){
		gridCells = grid.getGrid();
	}
	
	public void printGrid(){
		for(int i = 0; i < gridCells.length; i++){
			for(int j = 0; j < gridCells[i].length; j++){
				System.out.print(gridCells[i][j].toString());
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
