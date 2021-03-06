/*
 * 04/07: Trung: First add RandomWalk.java
 * 04/07: Amy: add populate();
 * 04/13: Trung: add main()
 */
package drunks;

import mvc.AppFactory;
import mvc.AppPanel;
import simstation.*;

/*
 * In Random Walk agents are drunks. 
 * They update themselves by selecting a random heading and random number of steps (less than some global speed, maybe 10), 
 * then they call the move function. 
 * (Drunk walks were used to determine the probability that setting off the first A-bomb might cause a chain reaction 
 * in the world's atmosphere!)
 */
public class RandomWalk extends Simulation {
	// override the populate() from Simulation
	@Override
	public void populate() {
		// populate might create 50 drunks and add them to the agents list.
		int drunkCount = 50;
		for(int i = 0; i < drunkCount; i++) {
			Drunk a = new Drunk(Integer.toString(i));
			addAgent(a);
		}
		
	}
	
	public static void main(String[] args) {
		AppFactory factory = new RandomWalkFactory();
		AppPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}
