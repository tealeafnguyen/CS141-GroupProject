/**
 * 
 */
package edu.csupomona.cs.cs141.classproject;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * @author Isa
 *
 */
public class ExtraBullet extends PowerUp implements Serializable {
	public String toString() {
		String result;
		if (isSeen()) {
			result = "[B]";
		} else
			result = "[*]";
		return result;
	}

	@Override
	public ImageIcon toImage() {
		// TODO Auto-generated method stub
		ImageIcon result;
		if (isSeen()) {
			result = new ImageIcon("extraBullet.jpg");
		} else
			result = new ImageIcon("nothing.jpg");
		return result;

	}
}
