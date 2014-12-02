/**
 * CS 141: Introduction to Programming and Problem Solving
 * Professor: Edwin Rodr&iacute;guez
 *
 * Programming Project
 *
 * This is the grid class of the project. This class handles anything
 * that occurs in the grid such as spawning or moving entities. The grid class
 * also holds the positions of the spawn locations of anything that exists on the grid
 * which will be discussed in each of the methods. The grid is called by the game engine,
 * the grid will return values back to the game engine and will contain a method that will
 * contain the 9 x 9 array that will contain all objects. This class is serializable to save the
 * current state of the program because this classs possesses all of the positions of any entity
 * that exists on this grid and the power up spawn locations as well as the rooms and the 
 * one true room that possesses the briefcase. 
 *
 * Team Crazy Bananas
 * Taha Khan
 * Farzad Kosar
 * Yool Weeji Jeon (James)
 * Isaac Gonzalez
 * Thomas Nguyen
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

/**
 * The public class Grid implements serializable to save the state of the game
 * because the grid holds information such as the location of anything that is
 * on the grid.
 *
 */
public class Grid implements Serializable {

	static final long serialVersionUID = 123456789L;
	/**
	 * The GridMember object is created to hold the 9 x 9 grid that is the map
	 * of the game. The Grid Member class is an interface for anything that is
	 * on the grid.
	 */
	private GridMember[][] grid;
	/**
	 * The object NinjaOctopi was originally ninjas, but was changed to add some
	 * flavor to the game. There are 6 ninja octopi objects in the game. Their
	 * attributes will be explained in the NinjaOctopi class.
	 */

	private NinjaOctopi[] ninjaOctopi = new NinjaOctopi[6];

	/**
	 * The Taha object will be controlled by the player. The player is to
	 * navigate the deadly 9 x 9 grid to find the briefcase to recover the power
	 * of friendship to smite all evil. The attributes of the Taha class will be
	 * explained in the Taha class.
	 */

	private static Taha thePlayer;

	/**
	 * In the GridMember player object, this object will take on the attributes
	 * of the Taha class which is shown in the constructor.
	 */

	private GridMember player;

	/**
	 * The array playerPosition will hold the player's current position. This
	 * position will be called in order to move the player or check if a ninja
	 * can murder the player.'
	 */
	private int[] playerPosition = new int[2];

	/**
	 * The array briefcase will contain the location of the briefcase which is
	 * in one of 9 rooms. The point of this array is to work with the radar
	 * power up which is collected by the player. The location of the briefcase
	 * is revealed by using this array.
	 */
	private static int[] briefcase = new int[2];

	/**
	 * The PowerUp radar is a power up that will grant the player the ability to
	 * see where the briefcase is.
	 */

	private PowerUp radar = new Radar();

	/**
	 * The PowerUp extraBullet will add 1 extra ammo to the player when picked
	 * up by the player.
	 */
	private PowerUp extraBullet = new ExtraBullet();

	/**
	 * The PowerUp cantDie is an invincibility object. I called it cantDie
	 * because it was easier to write out than Invincibility, When the player is
	 * invincible , then the player can't die.'
	 */
	private PowerUp cantDie = new Invincibility();

	/**
	 * The array radarPosition holds the location of the radar when it initially
	 * spawns
	 */

	private int[] radarPosition = new int[2];

	/**
	 * The array bulletPosition holds the location of the extraBullet object
	 * when it initially spawns
	 */

	private int[] bulletPosition = new int[2];

	/**
	 * The array inviPosition holds the location of the cantDie object when it
	 * initially spawns
	 */

	private int[] inviPosition = new int[2];

	/**
	 * The boolean win is initially set to false until the player finds the room
	 * with the briefcase.
	 */

	private boolean win = false;

	/**
	 * The constructor grid will take the Taha object as an arguments. The Grid
	 * Member object player will then take on the Taha object. The ninjaOctopi
	 * objects are created in the size 6 array. The 9 x 9 grid will initially be
	 * covered in EmptyMember objects. Then the spawn Rooms method is called to
	 * spawn rooms in 9 equidistant locations. Once the rooms spawn the
	 * spawnNinjas method is called to spawn afterwards to avoid ninjas spawning
	 * in the rooms. Afterwards, the methods to spawn the power ups are called.
	 * Finally, the player is spawn at the lower left most part of the grid. The
	 * player position is saved to the playerPosition array.
	 */

	public Grid(Taha tahaPlayer) {

		for (int x = 0; x < ninjaOctopi.length; x++) {
			ninjaOctopi[x] = new NinjaOctopi();
		}
		grid = new GridMember[9][9];
		player = tahaPlayer;
		thePlayer = tahaPlayer;
		player = thePlayer;

		for (int k = 0; k < grid.length; k++) {
			for (int l = 0; l < grid[k].length; l++) {
				grid[k][l] = new EmptyMember();
			}
		}

		spawnRooms();

		// spawns ninjas randomly, I am having trouble with having them spawn
		// everywhere, not within
		// 3 spaces of the player.
		spawnNinjas();
		spawnRadar();
		spawnExtraBullet();
		spawnInvincibility();

		// ninja = new Ninja();
		// grid[5][5] = ninja;
		// ninja.setPosition(5, 5);
		grid[8][0] = player;
		thePlayer.setPosition(8, 0);

		playerPosition[0] = 8;
		playerPosition[1] = 0;
	}

	public void debugMode() {
		for (int k = 0; k < grid.length; k++) {
			for (int l = 0; l < grid[k].length; l++) {
				grid[k][l].see();
			}
		}
	}

	/**
	 * The spawnRadar method will spawn at a random location within the 9 x 9
	 * grid. If something is on a current cell of the grid that is not an empty
	 * member, then the coordinates of the power up is rerolled. The position of
	 * the power up is saved to its respective array.
	 */

	public void spawnRadar() {
		Random rand = new Random();
		int[] itemCoordinates = new int[2];
		int iRow = rand.nextInt(6) + 3;
		int iCol = rand.nextInt(6) + 3;
		while (grid[iRow][iCol].isSomething()) {
			iRow = rand.nextInt(6) + 3;
			iCol = rand.nextInt(6) + 3;
		}
		itemCoordinates[0] = iRow;
		itemCoordinates[1] = iCol;

		radarPosition[0] = iRow;
		radarPosition[1] = iCol;

		grid[iRow][iCol] = radar;
	}

	/**
	 * The spawnExtraBullet method will spawn at a random location within the 9
	 * x 9 grid. If something is on a current cell of the grid that is not an
	 * empty member, then the coordinates of the power up is rerolled. The
	 * position of the power up is saved to its respective array.
	 */

	public void spawnExtraBullet() {
		Random rand = new Random();
		int[] itemCoordinates = new int[2];
		int iRow = rand.nextInt(6) + 3;
		int iCol = rand.nextInt(6) + 3;
		while (grid[iRow][iCol].isSomething()) {
			iRow = rand.nextInt(6) + 3;
			iCol = rand.nextInt(6) + 3;
		}
		itemCoordinates[0] = iRow;
		itemCoordinates[1] = iCol;

		bulletPosition[0] = iRow;
		bulletPosition[1] = iCol;

		grid[iRow][iCol] = extraBullet;
	}

	/**
	 * The spawnInvincibility method will spawn at a random location within the
	 * 9 x 9 grid. If something is on a current cell of the grid that is not an
	 * empty member, then the coordinates of the power up is rerolled. The
	 * position of the power up is saved to its respective array.
	 */

	public void spawnInvincibility() {
		Random rand = new Random();
		int[] itemCoordinates = new int[2];
		int iRow = rand.nextInt(6) + 3;
		int iCol = rand.nextInt(6) + 3;
		while (grid[iRow][iCol].isSomething()) {
			iRow = rand.nextInt(6) + 3;
			iCol = rand.nextInt(6) + 3;
		}
		itemCoordinates[0] = iRow;
		itemCoordinates[1] = iCol;

		inviPosition[0] = iRow;
		inviPosition[1] = iCol;

		grid[iRow][iCol] = cantDie;
	}

	/**
	 * The runAllChecks method will call the check methods for each of the power
	 * up, the check methods check the objects whether or not they have been
	 * used by the player.
	 */

	public void runAllChecks() {
		bulletGainedCheck();
		radarGainedCheck();
		inviGainedCheck();
	}

	/**
	 * The resetSeeAll method will change the boolean of all Grid Members to
	 * false causing the player to not see further than they should be able to.
	 */

	public void resetSeeAll() {
		for (int k = 0; k < grid.length; k++) {
			for (int l = 0; l < grid[k].length; l++) {
				grid[k][l].resetSee();
			}
		}
	}

	/**
	 * The bulletGainedCheck method checks whether or not the power up has been
	 * used. If it is false, then the bulletOverridenCheck is called.
	 */

	public void bulletGainedCheck() {
		if (extraBullet.isUsed() == false) {
			bulletOverridenCheck();
		}
	}

	/**
	 * The bulletOverridenCheck method checks the position of the power up if it
	 * has been turned into an EmptyMember. This puts the power up back to its
	 * original state.
	 */

	public void bulletOverridenCheck() {
		int row, col;

		row = bulletPosition[0];
		col = bulletPosition[1];

		if (grid[row][col] instanceof EmptyMember) {
			grid[row][col] = extraBullet;
		}
	}

	/**
	 * The radarGainedCheck method checks the object whether or not it has been
	 * used by the player or not. If false, then call the radarOverridenCheck
	 * method
	 */

	public void radarGainedCheck() {
		if (radar.isUsed() == false) {
			radarOverridenCheck();
		}
	}

	/**
	 * The radarOverridenCheck method will check if the power up's location is
	 * an Empty Member or not, then recreate the power up and put it back where
	 * it belongs
	 */

	public void radarOverridenCheck() {
		int row, col;

		row = radarPosition[0];
		col = radarPosition[1];

		if (grid[row][col] instanceof EmptyMember) {
			grid[row][col] = radar;
		}
	}

	/**
	 * The inviGainedCheck method checks if the cantDie object is used or not.
	 * If false, then it calls the inviOverridenCheck method.
	 */

	public void inviGainedCheck() {
		if (cantDie.isUsed() == false) {
			inviOverridenCheck();
		}
	}

	/**
	 * The inviOverridenCheck method will check the cantDie object's location
	 * and if it is an Empty Member, then replace that object will the power up.
	 */

	public void inviOverridenCheck() {
		int row, col;

		row = inviPosition[0];
		col = inviPosition[1];

		if (grid[row][col] instanceof EmptyMember) {
			grid[row][col] = cantDie;
		}
	}

	/**
	 * The getPowerUp method will check if the location that the player is
	 * heading into is a type of power up. This method is called from the move
	 * player method. Depending on the power up that is picked up, an effect is
	 * given to the player. The description of their effects are in their
	 * respective classes. After the power up is taken, the location of the
	 * power up is changed to an empty member.
	 */

	public void getPowerUp(int row, int col) {

		if (grid[row][col] instanceof Radar) {
			radarGained();
			radar.powerGain();
			grid[row][col] = new EmptyMember();
		}

		else if (grid[row][col] instanceof ExtraBullet) {
			thePlayer.addAmmo();
			extraBullet.powerGain();
			grid[row][col] = new EmptyMember();
		}

		else if (grid[row][col] instanceof Invincibility) {
			thePlayer.isWalkingOnSunshine();
			cantDie.powerGain();
			grid[row][col] = new EmptyMember();
		}

		grid[row][col] = new EmptyMember();
	}

	/**
	 * The radarGained method is called when the player picks up the radar. This
	 * takes the location of the briefcase array and recreates the room into a
	 * TrueRoom object which will always have the briefcase, but is represented
	 * with a different letter.
	 */

	public void radarGained() {

		grid[briefcase[0]][briefcase[1]] = new TrueRoom();

	}

	/**
	 * The playerRespawn method is called whenever the player has been slain.
	 * The method will take the player's current position and change it into and
	 * empty member and then put the player back into their initial spawn point.
	 */

	public void playerRespawn() {
		int row = 8;
		int col = 0;
		int previousRow = playerPosition[0];
		int previousCol = playerPosition[1];
		playerPosition[0] = row;
		playerPosition[1] = col;
		grid[row][col] = player;
		thePlayer.setPosition(row, col);
		grid[previousRow][previousCol] = new EmptyMember();
		grid[8][0] = player;
		thePlayer.setPosition(8, 0);
	}

	/**
	 * The spawnRooms method is called at the constructor. 9 rooms are spawned
	 * equidistant from each other. The field randRoom is randomly generated and
	 * if a room with a certain index of int count matches the randRoom value,
	 * then the room of that value will possess the briefcase.
	 */

	public void spawnRooms() {
		Random rand = new Random();
		int randRoom = rand.nextInt(9);
		int startRow = 1;
		int startCol = 1;
		int count = 0;
		for (int y = 0; y < 3; y++) {

			Room room1 = new Room();
			grid[startRow][startCol] = room1;
			++count;
			if (randRoom == count) {
				room1.giveBriefcase();
				briefcase[0] = startRow;
				briefcase[1] = startCol;
			}

			Room room2 = new Room();
			grid[startRow][startCol + 3] = room2;
			++count;
			if (randRoom == count) {
				room2.giveBriefcase();
				briefcase[0] = startRow;
				briefcase[1] = startCol + 3;
			}

			Room room3 = new Room();
			grid[startRow][startCol + 6] = room3;
			++count;
			if (randRoom == count) {
				room3.giveBriefcase();
				briefcase[0] = startRow;
				briefcase[1] = startCol + 6;
			}

			startRow += 3;
		}
	}

	/**
	 * The spawnNinjas method will spawn a ninja in a random location as long as
	 * the location is an Empty Member. That position of the ninja is recorded
	 * into an array.
	 */

	public void spawnNinjas() {
		Random rand = new Random();
		int[] ninjaCoordinates = new int[2];
		for (NinjaOctopi currentNinja : ninjaOctopi) {
			int ninRow = rand.nextInt(6) + 3;
			int ninCol = rand.nextInt(6) + 3;
			while (grid[ninRow][ninCol].isSomething()) {
				ninRow = rand.nextInt(6) + 3;
				ninCol = rand.nextInt(6) + 3;
			}
			ninjaCoordinates[0] = ninRow;
			ninjaCoordinates[1] = ninCol;

			grid[ninRow][ninCol] = currentNinja;
			currentNinja.setPosition(ninRow, ninCol);
		}

		grid[8][0] = player;
		thePlayer.setPosition(8, 0);

		playerPosition[0] = 8;
		playerPosition[1] = 0;
	}

	/**
	 * There is no real use to this method, please get rid of this because the
	 * game engine can print it by itself.
	 */

	public void printGrid() { // this will eventually be moved to UserInterface

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j].toString());
			}
			System.out.println();
		}
		System.out.println();

	}

	public void printGUIGrid() { // still need to make major changes

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j].toImage());
			}
			System.out.println();
		}
		System.out.println();

	}

	/**
	 * The getPlayer method will return the object of the player to whatever
	 * calls it, the only thing that should be calling this is the game engine.
	 */

	public Taha getPlayer() {
		return thePlayer;
	}

	/**
	 * The movePlayer method will take the player's current location and try to
	 * move them 1 space towards a desired direction. If it is a room, then they
	 * cant move there unless the player's direction is 3. If it is a power up
	 * then the getPowerUp method is called passing that location as an
	 * argument. Else the player will be able to move from cell to cell without
	 * a problem. The player's object is created in the next cell while the
	 * location of the current player is erased, simulating "moving".
	 */

	public void movePlayer(int row, int col) {
		int previousRow = playerPosition[0];
		int previousCol = playerPosition[1];
		int playerDirection = thePlayer.getPlayerDirection();

		// this try-catch block deals with moving the player object to a new
		// position on the Grid.
		// for now, it only deals with interaction with Room objects, but we
		// will have to write code
		// so the player object can deal with all the other types of
		// objects.(should be pretty easy,
		// using the .isSomething() method inherited from GridMember and maybe
		// writing another method
		// called interact() in the GridMember interface? We can just define it
		// differently in all the
		// classes that inherit GridMember.)
		try {
			if (grid[row][col] instanceof Room) {
				Room room = (Room) grid[row][col];
				if (playerDirection == 3) {
					// printGrid();
					if (room.hasBriefcase()) {
						System.out.println("has briefcase!");
						youWon();
					}
					System.out.println("You can pick up the case!");
				} else {
					// printGrid();
					System.out.println("You can only enter rooms from "
							+ "the North side!");
				}
			}

			else if (grid[row][col] instanceof PowerUp) {
				getPowerUp(row, col);
				playerPosition[0] = row;
				playerPosition[1] = col;
				grid[row][col] = player;
				thePlayer.setPosition(row, col);
				grid[previousRow][previousCol] = new EmptyMember();

				moveNinjaOctopi(previousRow, previousCol);
				playerSeeAround();
				printGrid();
				resetPlayerSeeAround();
			} else {
				playerPosition[0] = row;
				playerPosition[1] = col;
				grid[row][col] = player;
				thePlayer.setPosition(row, col);
				grid[previousRow][previousCol] = new EmptyMember();

				moveNinjaOctopi(previousRow, previousCol);
				playerSeeAround();
				resetPlayerSeeAround();
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			playerPosition[0] = previousRow;
			playerPosition[1] = previousCol;
			grid[previousRow][previousCol] = player;
			// printGrid();
			System.out.println("You can't walk through walls!");
		}
	}

	/**
	 * resetPlayerSeeAround method take the adjacent cell to the player and
	 * change the boolean of the adjacent cell into false, making it so the cell
	 * isn't seen. The try catch is put in place incase the location around the
	 * player is the end of the grid.
	 */

	public void resetPlayerSeeAround() {
		int row = playerPosition[0];
		int col = playerPosition[1];
		try {
			grid[row + 1][col].resetSee();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		try {
			grid[row - 1][col].resetSee();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		try {
			grid[row][col + 1].resetSee();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		try {
			grid[row][col - 1].resetSee();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
	}

	/**
	 * The playerSeeAroundMethod will take the locations that are adjacent to
	 * the player and change their boolean to true which allows the cell to be
	 * "seen". The try catch is place incase the player's location is next to
	 * the end of the grid.
	 */

	public void playerSeeAround() {
		int row = playerPosition[0];
		int col = playerPosition[1];
		try {
			grid[row + 1][col].see();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		try {
			grid[row - 1][col].see();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		try {
			grid[row][col + 1].see();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}
		try {
			grid[row][col - 1].see();
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		}

	}

	/**
	 * The killCheck method will cycle through all the ninjas to check if the
	 * player is adjacent to them. If the player is adjacent to them, then the
	 * player will die and call the dies method in the player object and the
	 * playerRespawn method.
	 */

	public void killCheck() {

		for (NinjaOctopi currNinja : ninjaOctopi) {
			if (!currNinja.totallyGotShot()) {
				int[] pp = thePlayer.getPosition();
				int[] nc = currNinja.getPosition();
				int row = pp[0];
				int col = pp[1];
				int nrow = nc[0];
				int ncol = nc[1];

				if (nrow + 1 == row && ncol == col) {
					System.out.println("You have died");
					thePlayer.dies();
					playerRespawn();

				} else if (nrow - 1 == row && ncol == col) {
					System.out.println("You have died");
					thePlayer.dies();
					playerRespawn();
				} else if (nrow == row && ncol + 1 == col) {
					System.out.println("You have died");
					thePlayer.dies();
					playerRespawn();
				} else if (nrow == row && ncol - 1 == col) {
					System.out.println("You have died");
					thePlayer.dies();
					playerRespawn();
				} else {
					// Nothing happens here.
				}
			} else {
				// Nothing happens here if totallyGotShot is true.

			}
		}
	}

	/**
	 * The deathCheck method will check if the player is not currently
	 * invincible. If they don't have that power up, then it calls the killCheck
	 * method.
	 */

	public void deathCheck() {
		if (thePlayer.showCantDieTime() <= 0) {
			killCheck();
		}
	}

	/**
	 * The moveNinjaOctopi method will loop through all the ninja octopi to
	 * move. If the ninja octopi is dead, then they are unable to perform any
	 * actions. If the ninja tries to walk into a wall or into a room, then the
	 * ninja will keep trying to move until they have actually moved somewhere.
	 */

	public void moveNinjaOctopi(int row, int col) {
		for (NinjaOctopi currNinja : ninjaOctopi) {
			int direction;
			boolean hasMoved = false;
			boolean tried = false;
			boolean isDead = false;
			do {
				isDead = ifNinjaPlaceIsEmptyCell(currNinja);

				if (isDead) {
					hasMoved = true;
					break;
				}
				deathCheck();
				int[] ninCoord = currNinja.getPosition();
				currNinja.setDirection(row, col);
				direction = currNinja.getDirection();
				if (tried && currNinja.getPlayerInSight()) {
					Random rand = new Random();
					direction = rand.nextInt(4) + 1;
					System.out.println("Avoided room loop");
				}
				try {
					switch (direction) {

					case 1:

						if (grid[ninCoord[0] + 1][ninCoord[1]] instanceof Room
								|| grid[ninCoord[0] + 1][ninCoord[1]] instanceof NinjaOctopi) {
							hasMoved = false;
							tried = true;
							currNinja.setPosition(ninCoord[0], ninCoord[1]);

						} else {

							grid[ninCoord[0] + 1][ninCoord[1]] = currNinja;
							if (!(grid[ninCoord[0]][ninCoord[1]] instanceof PowerUp)) {
								grid[ninCoord[0]][ninCoord[1]] = new EmptyMember();
							}
							currNinja.setPosition((ninCoord[0] + 1),
									ninCoord[1]);
							hasMoved = true;
						}
						runAllChecks();
						break;
					case 2:

						if (grid[ninCoord[0]][ninCoord[1] + 1] instanceof Room
								|| grid[ninCoord[0]][ninCoord[1] + 1] instanceof NinjaOctopi) {
							hasMoved = false;
							tried = true;
							currNinja.setPosition(ninCoord[0], ninCoord[1]);
						} else {
							grid[ninCoord[0]][ninCoord[1] + 1] = currNinja;
							if (!(grid[ninCoord[0]][ninCoord[1]] instanceof PowerUp)) {
								grid[ninCoord[0]][ninCoord[1]] = new EmptyMember();
							}
							currNinja.setPosition(ninCoord[0],
									(ninCoord[1] + 1));
							hasMoved = true;
						}
						runAllChecks();
						break;
					case 3:

						if (grid[ninCoord[0] - 1][ninCoord[1]] instanceof Room
								|| grid[ninCoord[0] - 1][ninCoord[1]] instanceof NinjaOctopi) {
							hasMoved = false;
							tried = true;
							currNinja.setPosition(ninCoord[0], ninCoord[1]);
						} else {
							grid[ninCoord[0] - 1][ninCoord[1]] = currNinja;
							if (!(grid[ninCoord[0]][ninCoord[1]] instanceof PowerUp)) {
								grid[ninCoord[0]][ninCoord[1]] = new EmptyMember();
							}
							currNinja.setPosition((ninCoord[0] - 1),
									ninCoord[1]);
							hasMoved = true;
						}
						runAllChecks();
						break;
					case 4:

						if (grid[ninCoord[0]][ninCoord[1] - 1] instanceof Room
								|| grid[ninCoord[0]][ninCoord[1] - 1] instanceof NinjaOctopi) {
							hasMoved = false;
							tried = true;
							currNinja.setPosition(ninCoord[0], ninCoord[1]);
						} else {
							grid[ninCoord[0]][ninCoord[1] - 1] = currNinja;
							if (!(grid[ninCoord[0]][ninCoord[1]] instanceof PowerUp)) {
								grid[ninCoord[0]][ninCoord[1]] = new EmptyMember();
							}
							currNinja.setPosition(ninCoord[0],
									(ninCoord[1] - 1));
							hasMoved = true;
						}
						runAllChecks();
						break;
					}
				} catch (ArrayIndexOutOfBoundsException e) {
					hasMoved = false;
					currNinja.setPosition(ninCoord[0], ninCoord[1]);
				}
			} while (!hasMoved && !isDead);
		}
	}

	/**
	 * The getGridMember returns the object at a grids location. This method is
	 * called from the game engine to print out the grid.
	 */

	public GridMember getGridMember(int row, int col) {

		return grid[row][col];

	}

	/**
	 * The getPlayerPosition method returns the player's current position. This
	 * is used when a method needs to know where the player currently is in
	 * order to perform an action.
	 */

	public int[] getPlayerPostion() {
		return playerPosition;
	}

	/**
	 * The shootDirection method will take an argument for a direction from the
	 * player. The method will then call the shoot method to go through that
	 * direction to check for enenmies or a wall.
	 */

	public void shootDirection(int direction) {
		int[] playerPosition = getPlayerPostion();
		int row = playerPosition[0];
		int col = playerPosition[1];
		switch (direction) {

		case 1:
			thePlayer.setPlayerDirection(1);
			shoot(row - 1, col, direction);
			break;
		case 2:
			thePlayer.setPlayerDirection(2);
			shoot(row, col - 1, direction);
			break;
		case 3:
			thePlayer.setPlayerDirection(3);
			shoot(row + 1, col, direction);
			break;
		case 4:
			thePlayer.setPlayerDirection(4);
			shoot(row, col + 1, direction);
			break;
		}
	}

	/**
	 * The shoot method will scan through the array down a certain direction
	 * passed from the shootDirection method , The try catch will keep the loop
	 * from going out of bounds. If a room or a ninja is hit, then the loop is
	 * broken out of and the player will lose 1 ammo in the finally statement.
	 * When a ninja is shot, their current location is changed into null and the
	 * fixTheNull method will replace the null into an Empty Member. THe ninja
	 * that got shot will be considered dead and will no longer take action.
	 */

	public void shoot(int row, int col, int direction) {
		try {
			switch (direction) {
			case 1:
				while (!(grid[row][col] instanceof Room)
						|| !(grid[row][col] instanceof NinjaOctopi)) {
					if (grid[row][col] instanceof Room) {
						System.out.println("You shot a wall of a room"); // Prints
						// when
						// you
						// shoot
						// a
						// room
						break; // only here to check if this works
					} else if (grid[row][col] instanceof NinjaOctopi) {
						for (NinjaOctopi currNinja : ninjaOctopi) {
							int[] shotPosition = currNinja.getPosition();
							if (grid[row][col] == grid[shotPosition[0]][shotPosition[1]]) {
								System.out.println("Totally got shot"); // Placed
								// here
								// to
								// check
								// if
								// ninja
								// got
								// shot
								currNinja.gotShot(); // will remove later
								grid[row][col] = null;
								fixTheNull(row, col);
								break;
							}
						}
					} else {

					}
					row--;
				}

			case 2:
				while (!(grid[row][col] instanceof Room)
						|| !(grid[row][col] instanceof NinjaOctopi)) {
					if (grid[row][col] instanceof Room) {
						System.out.println("You shot a wall of a room"); // Prints
						// when
						// you
						// shoot
						// a
						// room
						break; // only here to check if this works
					} else if (grid[row][col] instanceof NinjaOctopi) {
						for (NinjaOctopi currNinja : ninjaOctopi) {
							int[] shotPosition = currNinja.getPosition();
							if (grid[row][col] == grid[shotPosition[0]][shotPosition[1]]) {
								System.out.println("Totally got shot"); // Placed
								// here
								// to
								// check
								// if
								// ninja
								// got
								// shot
								currNinja.gotShot(); // will remove later
								grid[row][col] = null;
								fixTheNull(row, col);
								break;
							}
						}
						break;
					} else {

					}
					col--;
				}

			case 3:
				while (!(grid[row][col] instanceof Room)
						|| !(grid[row][col] instanceof NinjaOctopi)) {
					if (grid[row][col] instanceof Room) {
						System.out.println("You shot a wall of a room"); // Prints
						// when
						// you
						// shoot
						// a
						// room
						break; // only here to check if this works
					} else if (grid[row][col] instanceof NinjaOctopi) {
						for (NinjaOctopi currNinja : ninjaOctopi) {
							int[] shotPosition = currNinja.getPosition();
							if (grid[row][col] == grid[shotPosition[0]][shotPosition[1]]) {
								System.out.println("Totally got shot"); // Placed
								// here
								// to
								// check
								// if
								// ninja
								// got
								// shot
								currNinja.gotShot(); // will remove later
								grid[row][col] = null;
								fixTheNull(row, col);
								break;
							}
						}
						break;
					} else {

					}
					row++;
				}
			case 4:
				while (!(grid[row][col] instanceof Room)
						|| !(grid[row][col] instanceof NinjaOctopi)) {
					if (grid[row][col] instanceof Room) {
						System.out.println("You shot a wall of a room"); // Prints
						// when
						// you
						// shoot
						// a
						// room
						break; // only here to check if this works
					} else if (grid[row][col] instanceof NinjaOctopi) {
						for (NinjaOctopi currNinja : ninjaOctopi) {
							int[] shotPosition = currNinja.getPosition();
							if (grid[row][col] == grid[shotPosition[0]][shotPosition[1]]) {
								System.out.println("Totally got shot"); // Placed
								// here
								// to
								// check
								// if
								// ninja
								// got
								// shot
								currNinja.gotShot(); // will remove later
								grid[row][col] = null;
								fixTheNull(row, col);
								break;
							}
						}
						break;
					} else {

					}
					col++;
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("You shot a wall"); // This is here only to check
			// if a bullet makes it all
			// the way through
			// to the end of the world, if this prints along with a ninja
			// getting shot
		} finally { // please let me know
			playerSeeAround();
			resetPlayerSeeAround();
			thePlayer.shoot();
		}
	}

	/**
	 * The ifNinjaPlaceIsEmptyCell method will take a ninja object as the
	 * argument. This will check if the current ninja totally got shot or not,
	 * if the ninja got shot then the boolean of this method will return true,
	 * else false. This prevents a dead ninja from taking action.
	 */

	public boolean ifNinjaPlaceIsEmptyCell(NinjaOctopi currNinja) {
		if (currNinja.totallyGotShot()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * The look method will allow the player to look an extra cell ahead. There
	 * is a loop to check till the end of the array given a direction. If a
	 * ninja is found, the game will give the player a warning that there is a
	 * ninja down that direction.
	 */

	public void look(String direction) {
		int playerRow = -1;
		int playerCol = -1;
		int[] position = thePlayer.getPosition();
		playerRow = position[0];
		playerCol = position[1];
		boolean ninjaAhead = false;
		try {
			switch (direction) {
			case "w":
				for (NinjaOctopi ninja : ninjaOctopi) {
					int[] ninPosition = ninja.getPosition();
					if (ninPosition[1] == playerCol) {
						if (ninPosition[0] < playerRow) {
							ninjaAhead = true;
						}
					}
				}
				grid[playerRow - 1][playerCol].see();
				grid[playerRow - 2][playerCol].see();
				break;
			case "d":
				for (NinjaOctopi ninja : ninjaOctopi) {
					int[] ninPosition = ninja.getPosition();
					if (ninPosition[0] == playerRow) {
						if (ninPosition[1] > playerCol) {
							ninjaAhead = true;
						}
					}
				}
				grid[playerRow][playerCol + 1].see();
				grid[playerRow][playerCol + 2].see();
				break;
			case "s":
				for (NinjaOctopi ninja : ninjaOctopi) {
					int[] ninPosition = ninja.getPosition();
					if (ninPosition[1] == playerCol) {
						if (ninPosition[0] > playerRow) {
							ninjaAhead = true;
						}
					}
				}
				grid[playerRow + 1][playerCol].see();
				grid[playerRow + 2][playerCol].see();
				break;
			case "a":
				for (NinjaOctopi ninja : ninjaOctopi) {
					int[] ninPosition = ninja.getPosition();
					if (ninPosition[0] == playerRow) {
						if (ninPosition[1] < playerCol) {
							ninjaAhead = true;
						}
					}
				}
				grid[playerRow][playerCol - 1].see();
				grid[playerRow][playerCol - 2].see();
				break;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			// do nothing
		} finally {
			if (ninjaAhead) {
				System.out.println("Ninja ahead!");
			} else {
				System.out.println("All clear.");
			}
		}
	}

	/**
	 * The fixTheNull method is called when a ninja is killed. The area where
	 * the ninja died turns into a null and this method will turn that location
	 * back into an Empty Member object.
	 */

	public void fixTheNull(int row, int col) {
		grid[row][col] = new EmptyMember();
	}

	/**
	 * This method is called when the player finds the briefcase. win is true.
	 */
	public void youWon() {
		win = true;
	}

	/**
	 * The showWin method will return win to the game engine.
	 */

	public boolean showWin() {
		return win;
	}


	
	public void setPlayer(Taha player) {
		thePlayer = player;
		this.player = player;
	}

}
