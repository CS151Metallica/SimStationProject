package plague;

import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import simstation.*;

public class PlagueSimulation extends Simulation{
	  public static int VIRULENCE = 50; // % chance of infection
	  public static int RESISTANCE = 2; // % chance of resisting infection
	  
	  public static Color infected = Color.RED;
	  public static Color notInfected = Color.GREEN;
	  
	  public static double POPULATION = 50;
	  
	  public static Random plagueRandom; //is used to help determine whether an Individual become infected
	  
	  public PlagueSimulation() {
		  plagueRandom = new Random();
	  }
	  
	  @Override
	  public void populate() {
		  // populate might create 50 Individual and add them to the agents list.
		  for(int i = 0; i < POPULATION; i++) {
			  Individual a = new Individual(Integer.toString(i));
			  addAgent(a);
		  }
	  }
	  
	  //calculate how the percentage of Individual affected in the population
	  public double percentInfected() {
		  int count = 0;
		  ArrayList<Agent> list = getAgents();
		  for (Agent individual: list) {
			  Individual current = (Individual)individual;
			  if (current.isInfected()) {
				  count++;
			  }
		  }
		  
		  double percentage = (count / POPULATION) * 100;
		  return percentage;
	  }
	  
	  @Override
	  public void stats() {
	  JFrame frame = new JFrame("Status");
		JOptionPane.showMessageDialog(null, "#agents = " + POPULATION + "\nclock = " + getClock() + "\n% infected = " + percentInfected());
	  }
	  
	  public static boolean infect() {
		  //whether an Individual gets infected is based on the VIRULENCE
		  return plagueRandom.nextInt(100) < VIRULENCE;
	  }
}
	  