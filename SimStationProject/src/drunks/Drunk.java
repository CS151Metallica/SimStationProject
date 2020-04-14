/*
 * Trung: First add Flocking.java
 * Amy: add constructor method
 * Amy: add update()
 * Trung: Remove getX() and getY()
 */
package drunks;

import simstation.*;
import mvc.Utilities;

public class Drunk extends Agent{
	
	public Drunk(String name) {
		super(name);
	}
	
	@Override
	public void update() {
		changeHeading();
		move(Utilities.rng.nextInt(10));
	}
}