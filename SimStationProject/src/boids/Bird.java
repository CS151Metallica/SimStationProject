package boids;

import java.util.*;

import simstation.*;

public class Bird extends Agent{

	private int speed;
	public static Random speedGen = new Random();
	
	private int radius = 10;
	
	
	public Bird(String name) {
		super(name);
		speed = speedGen.nextInt(9) + 1;
	}
	
	public int getSpeed() {
		return speed;
	}

	@Override
	public void update() {
		int clock = world.getClock();
//		if (clock > 0 && clock % 100 == 0) {
//			radius += 10;
//			System.out.println(radius);
//		}
	
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
