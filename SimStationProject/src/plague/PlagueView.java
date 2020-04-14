/*
 * 04/10: Amy: First created
 */
package plague;

import java.awt.*;
import java.util.*;

import mvc.*;
import simstation.*;

public class PlagueView extends View{
	public PlagueView(Model model) {
		super(model);
	}
	
	public void paintComponent(Graphics gc) {
		Simulation simulation = (Simulation)model;
		Color oldColor = gc.getColor();
		
		ArrayList<Agent> list = simulation.getAgents();
		
		for (Agent agent: list) {
			Individual individual = (Individual)agent;
			if(individual.isInfected()) {
				gc.setColor(PlagueSimulation.infected);
			} else {
				gc.setColor(PlagueSimulation.notInfected);
			}
			
			gc.fillOval(individual.getX(), individual.getY(), 5, 5);
		}
		
		gc.setColor(oldColor);
		
	}

}
