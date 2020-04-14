/*
 * 04/07: Trung: First add Flocking.java
 * 04/07: Trung: add constructor method
 * 04/08: Amy: add update()
 * 04/14: Amy: Remove getX() and getY()
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