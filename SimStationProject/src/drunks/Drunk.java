package drunks;

import simstation.*;
import java.util.*;

import simstation.*;

public class Drunk extends Agent{
	private Random randomWalk;
	private boolean drunk;
	
	public Drunk(String name) {
		super(name);
		
		randomWalk = new Random();
	}
	
	@Override
	public void update() {
		move(randomWalk.nextInt(10));
	}
}