/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Isa
 *
 */
public class UserInterface {

	private Grid grid;
	
	private GridMember[][] gridCells;
	
	public UserInterface(Grid grid){
		this.grid = grid;
		gridCells = grid.getGrid();
		
	}
	
	public int printFirstMenu(){
		int choice = 0;
		while(choice == 0){
		
		try{
			
			Scanner k = new Scanner(System.in);
			System.out.println("Welcome to Taha's Adventure!\n\nPress: \n 1. Start Game \n 2. Load Game \n 3. Help \n 4. Quit");
			choice = k.nextInt();
			k.nextLine();
		} catch(InputMismatchException e){ 
			System.out.println("Wrong input");
			
		}
		}
		
		return choice;
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
