/*
 * 04/09: Trung: First add Flocking.java
 * 04/09: Amy: add population()
 * 04/13: Trung: Add main()
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