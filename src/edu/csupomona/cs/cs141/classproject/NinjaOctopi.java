/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;
import java.util.Random;
/**
 * @author Isa
 *
 */
public class NinjaOctopi extends Entity implements GridMember {

	private int direction;

	private boolean playerInSight;

	private boolean isShot;

	public int getDirection() {
		return direction;
	}

	public void updatePosition(int row, int col) {

	}

	// incomplete method that takes care of the "AI" of the ninja as well as
	// moving randomly
	public void setDirection(Taha player) {
		int[] playerCoordinates = player.getPosition();
		int[] ninjaCoordinates = getPosition();
		Random rand = new Random();
		int range = -1; //initialize range, this value doesn't matter.
		if (playerCoordinates[0] == ninjaCoordinates[0]) {
			range = playerCoordinates[1] - ninjaCoordinates [1];
			if(Math.abs(range) == 2){ //checks if absolute value of range is 2.
			if (playerCoordinates[1] > ninjaCoordinates[1]) {
				direction = 2;
			} else {
				direction = 4;
			}
			playerInSight = true;
			} else {
			playerInSight = false;
		}
		} else if (playerCoordinates[1] == ninjaCoordinates[1]) {
			range = playerCoordinates[0] - ninjaCoordinates[0];
			if(Math.abs(range) == 2){
			if (playerCoordinates[0] > ninjaCoordinates[0]) {
				direction = 1;
			} else {
				direction = 3;
			}
			playerInSight = true;
			} else {
				playerInSight = false;
			}
		} else {
			direction = rand.nextInt(4) + 1;
		}

	}

	public void setDirection(int row, int col) {

		int[] ninjaCoordinates = getPosition();
		Random rand = new Random();
		if (row == ninjaCoordinates[0]) {

			if (col > ninjaCoordinates[1]) {
				direction = 2;
			} else {
				direction = 4;
			}
			playerInSight = true;

		} else if (col == ninjaCoordinates[1]) {

			if (row > ninjaCoordinates[0]) {
				direction = 1;
			} else {
				direction = 3;
			}
			playerInSight = true;

		} else {
			direction = rand.nextInt(4) + 1;
			playerInSight = false;
		}

	}

	public boolean getPlayerInSight() {
		return playerInSight;
	}

	public void resetPlayerInSight() {
		playerInSight = false;
	}

	public void gotShot(){
		isShot = true;
	}

	public boolean totallyGotShot(){
		return isShot;
	}

	@Override
	public String toString() {
		String result;


		if(isShot || (!isSeen())){ //the !isSeen() will make it to where Ninjas won't show up when they're
			result = "[O]";    //not in range. The method can be found in Entity.
			return result;
		}

		else{
			result = "[O]";
			return result;
		}
	}
}
