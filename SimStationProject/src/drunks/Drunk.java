package drunks;

import simstation.*;
import java.util.*;

import simstation.*;

public class Drunk extends Agent{
	private Random randomWalk;
	
	public Drunk(String name) {
		super(name);
		
		randomWalk = new Random();
	}
	
	@Override
	public void update() {
		changeHeading();
		move(randomWalk.nextInt(10));
	}
	
	public int getX() {
		return xc;
	}
	
	public int getY() {
		return yc;
	}
}