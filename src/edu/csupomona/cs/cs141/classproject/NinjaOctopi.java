package edu.csupomona.cs.cs141.classproject;
import java.io.Serializable;
import java.util.Random;

import javax.swing.ImageIcon;
/**
 * @author CrazyBananas
 *
 */
public class NinjaOctopi extends Entity implements GridMember, Serializable {

	/**
	 * This integer value is used to identify the direction the ninja should
	 * move on the {@link Grid}.
	 */
	private int direction;

	/**
	 * This is a boolean value that is used in the {@link #setDirection(int, int)} method
	 * to flag whether or not a {@link Taha} object is in 'sight' of the Ninja.
	 */
	private boolean playerInSight;

	/**
	 * Boolean value that keeps track of whether or not the {@link NinjaOctopi} is 'shot'
	 * by the {@link Taha} object.
	 */
	private boolean isShot;

	/**
	 * Simply returns the value stored in {@link #direction}
	 * @return {@link #direction}
	 */
	public int getDirection() {
		return direction;
	}

	/**
	 * This method passes in the coordinates of the {@link Player}'s object on the
	 * {@link Grid}, and checks to see if they are in sight of the {@link NinjaOctopi}.
	 * A player is considered as being in sight if they are within two grid spaces of
	 * the {@link NinjaOctopi} object, in any adjacent direction. If the player is in
	 * sight, then {@link #direction} will be given the corresponding value for that
	 * direction. If the player is not in sight, then {@link #direction} will be given
	 * a random value {@code 1} - {@code 4}.
	 * @param row coordinate of the first index of the {@link Taha} objects position(y pos)
	 * @param col coordinate of the second index of the {@link Taha} objects position(x pos)
	 */
	public void setDirection(int row, int col) {

		int[] ninjaCoordinates = getPosition();
			Random rand = new Random();
			int range = -1; //initialize range, this value doesn't matter.
			if (row == ninjaCoordinates[0]) {
				range = col - ninjaCoordinates [1];
				if(Math.abs(range) == 2){ //checks if absolute value of range is 2.
				if (col > ninjaCoordinates[1]) {
					direction = 2;
				} else {
					direction = 4;
				}
				playerInSight = true;
				} else {
					direction = rand.nextInt(4) + 1;
				playerInSight = false;
			}
			} else if (col == ninjaCoordinates[1]) {
				range = row - ninjaCoordinates[0];
				if(Math.abs(range) == 2){
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
			} else {
				direction = rand.nextInt(4) + 1; //choose a random direction
			}

	}

	/**
	 * Returns {@link #playerInSight}
	 * @return {@link #playerInSight}
	 */
	public boolean getPlayerInSight() {
		return playerInSight;
	}

	/**
	 * Used to set {@link #playerInSight} to false.
	 */
	public void resetPlayerInSight() {
		playerInSight = false;
	}

	/**
	 * Sets {@link #isShot} to true, signalling that the {@link NinjaOcopi} has
	 * been 'shot'.
	 */
	public void gotShot(){
		isShot = true;
	}

	/**
	 * Returns {@link #isShot}
	 * @return {@link #isShot}
	 */
	public boolean totallyGotShot(){
		return isShot;
	}

	/**
	 * This method is used to give information about what symbol the {@link NinjaOctopi}
	 * should be associated with visually on the {@link Grid}. If the {@link NinjaOctopi}
	 * is 'seen' by the player on the {@link Grid}, then it will display its true symbol.
	 *
	 * @return "[*]" if the Ninja is not seen, and "[O]" if the Ninja is seen
	 */
	@Override
	public String toString() {
		String result;


		if(isShot || (!isSeen())){ //the !isSeen() will make it to where Ninjas won't show up when they're
			result = "[*]";        //not in range. The method can be found in Entity.
			return result;
		}

		else{
			result = "[O]";
			return result;
		}
	}
	
	/**
	 * This method was meant for use in the Graphical User Interface, however it 
	 * was never completed. It works similarly to the {@link #toString} method.
	 */
	public ImageIcon toImage() {
		ImageIcon result;


		if(isShot || (!isSeen())){
			result = new ImageIcon("nothing.jpg");   
			return result;
		}

		else{
			result = new ImageIcon("octoSee.jpg");
			return result;
		}
	}
}
