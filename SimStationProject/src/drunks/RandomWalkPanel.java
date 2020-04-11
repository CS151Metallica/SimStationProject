package drunks;

import mvc.*;
import simstation.*;

public class RandomWalkPanel extends SimulationPanel{
	
	public RandomWalkPanel(AppFactory factory) {
		super(factory);
	}
	
	public static void main(String[] args) {
		AppFactory factory = new RandomWalkFactory();
		AppPanel panel = new RandomWalkPanel(factory);
		panel.display();
	}
	
}
