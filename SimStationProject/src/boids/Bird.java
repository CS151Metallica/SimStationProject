package boids;

import mvc.Utilities;
import simstation.*;

public class Bird extends Agent{

	private int speed;
	
	public Bird(String name) {
		super(name);
		speed = Utilities.rng.nextInt(9) + 1;
	}
	
	public int getSpeed() {
		return speed;
	}

	@Override
	public void update() {	
		Agent neighbor = world.getNeighbor(this, 25);
		
		//if there is a neighbor, copy the neighbor's heading and speed
		if (neighbor != null) {
			Bird bird2 = (Bird)neighbor;
			speed = bird2.getSpeed();
			heading = bird2.heading;
		}
		
		move(speed);
	}
	
	public int getX() {
		return xc;
	}
	
	public int getY() {
		return yc;
	}

}
