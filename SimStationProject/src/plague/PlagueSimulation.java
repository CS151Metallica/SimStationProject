/*
 * Edit history:
 * Amy, 4/10: created
 * Amy, 4/10: added populate, percentInfected, stats, and infect method
 * Trung, 4/13: change random() to mvc.Utilties random
 * Amy, 4/13: removed constructor and unnecessary plagueRandom static variable
 */
package plague;

import java.awt.*;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mvc.Utilities;
import simstation.*;

public class PlagueSimulation extends Simulation{
	  public static int VIRULENCE = 50; // % chance of infection
	  public static int RESISTANCE = 2; // % chance of resisting infection
	  
	  public static Color infected = Color.RED;
	  public static Color notInfected = Color.GREEN;
	  
	  public static double POPULATION = 50;
	  
	  @Override
	  public void populate() {
		  // populate might create 50 Individual and add them to the agents list.
		  for(int i = 0; i < POPULATION; i++) {
			  Individual a = new Individual(Integer.toString(i));
			  addAgent(a);
		  }
	  }
	  
	  //calculate the percentage of Individual infected in the population
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
		  return Utilities.rng.nextInt(100) < VIRULENCE;
	  }
	  
}
	  
