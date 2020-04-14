/*
 * Trung: First add Flocking.java
 * Amy: add population()
 * Trung: Add main()
 */
package boids;

import mvc.AppFactory;
import mvc.AppPanel;
import simstation.*;

public class Flocking extends Simulation{
	@Override
	public void populate() {
		// populate might create 50 birds and add them to the agents list.
		int birdCount = 50;
		for(int i = 0; i < birdCount; i++) {
			Bird a = new Bird(Integer.toString(i));
			addAgent(a);
		}	
	}
	
	public static void main(String[] args) {
		AppFactory factory = new FlockingFactory();
		AppPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}