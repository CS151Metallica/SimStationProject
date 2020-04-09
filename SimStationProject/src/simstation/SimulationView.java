package simstation;

import mvc.*;
import java.awt.*;
import java.util.ArrayList;

public class SimulationView extends View {

    public SimulationView(Simulation sim)
    {
        super(sim);
    }

    public void paintComponent(Graphics gc) {
    	Simulation simulation = (Simulation)model;
		Color oldColor = gc.getColor();
		gc.setColor(Color.RED);
		
		ArrayList<Agent> list = simulation.getAgents();
		for (Agent agent: list) {
			gc.fillOval(agent.xc, agent.yc, 5, 5);
		}
		
		gc.setColor(oldColor);
		
	}
}
