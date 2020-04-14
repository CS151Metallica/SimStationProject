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
	
	public int getX() {
		return xc;
	}
	
	public int getY() {
		return yc;
	}
}