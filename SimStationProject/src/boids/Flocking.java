package boids;

import simstation.*;

public class Flocking extends Simulation{
	@Override
	public void populate() {
		// populate might create 50 drunks and add them to the agents list.
		int birdCount = 50;
		for(int i = 0; i < birdCount; i++) {
			Bird a = new Bird(Integer.toString(i));
			addAgent(a);
		}
		
	}
}