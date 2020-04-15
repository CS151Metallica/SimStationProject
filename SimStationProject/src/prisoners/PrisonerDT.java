/*
 * 04/13: Amy: created
 * 04/13: Trung: added main function
 */
package prisoners;

import java.util.*;

import javax.swing.JOptionPane;

import mvc.AppFactory;
import mvc.AppPanel;
import simstation.*;

public class PrisonerDT extends Simulation{
	public static int NUM_STRATEGIES = 4;	//number of strategies available
	public static int COOPERATIVE = 3;	//score if both cooperate
	public static int CHEAT = 1;		//score if both cheat
	public static int WIN = 5;			//score for the one that only cheated
	public static int LOSE = 0;			//score for the one that got cheated
	
	private ArrayList<String> allStrategies;	//keeps track of all strategy types
	
	public PrisonerDT() {
		allStrategies = new ArrayList<String>();
		allStrategies.add("Cooperative");
		allStrategies.add("Selfish");
		allStrategies.add("Random");
		allStrategies.add("Reciprocal");		
	}
	
	@Override
	public void populate() {
		// populate might create 50 prisoners and add them to the agents list.
		int numAgents = 10;
		
		for(int i = 0; i < numAgents; i++) {
			Prisoner a = new Prisoner(Integer.toString(i), new CooperativeStrategy());
			addAgent(a);
		}
		
		for(int j = 0; j < numAgents; j++) {
			Prisoner a = new Prisoner(Integer.toString(j), new SelfishStrategy());
			addAgent(a);
		}
		
		for(int k = 0; k < numAgents; k++) {
			Prisoner a = new Prisoner(Integer.toString(k), new RandomStrategy());
			addAgent(a);
		}
		
		for(int l = 0; l < numAgents; l++) {
			Prisoner a = new Prisoner(Integer.toString(l), new ReciprocalStrategy());
			addAgent(a);
		}
		
	}
	
	@Override
	public void stats()
	{		
		double[] count = new double[NUM_STRATEGIES];
		double[] totalScore = new double[NUM_STRATEGIES];
		ArrayList<String> average = new ArrayList<String>();
		
		ArrayList<Agent> agents = getAgents();
		for (Agent a: agents) {
			Prisoner prisoner = (Prisoner)a;
			String type = prisoner.getStrategyType();
			
			if (type == "Cooperative") {
				count[0]++;
				totalScore[0] += prisoner.getScore();
			} else if (type == "Selfish") {
				count[1]++;
				totalScore[1] += prisoner.getScore();		
			} else if (type == "Random") {
				count[2]++;
				totalScore[2] += prisoner.getScore();
			} else {
				count[3]++;
				totalScore[3] += prisoner.getScore();
			} 
		}
		
		//calculate average fitness for each strategy by dividing the totalScore by count
		for (int i = 0; i < allStrategies.size(); i++) {
			double temp = totalScore[i] / count[i];
			
			String averageStatement = allStrategies.get(i) + "'s average: " + temp + "\n";
			average.add(averageStatement);
		}
		
		JOptionPane.showMessageDialog(null, "#agents = " + getAgents().size() + "\nclock = " + getClock() + "\n" + average.get(0) + average.get(1) + average.get(2) + average.get(3));
	}
	
	public static void main(String[] args) {
		AppFactory factory = new PrisonerDTFactory();
		AppPanel panel = new SimulationPanel(factory);
		panel.display();
	}
}
