// Trung Le: First initialize
package simstation;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import mvc.*;

public class Simulation extends Model {

	public static int SIZE = 250;
	private Timer timer;
	private int clock;
	private Agent agent;
	private ArrayList<Agent> agents = new ArrayList<Agent>();

	public Simulation()
	{
		agents = new ArrayList<Agent>();
		clock = 0;
	}
	
	public void addAgent(Agent a)
	{
		agents.add(a);
		a.setWorld(this);
	}
	
	public synchronized Agent getNeighbor(Agent asker, double radius)
	{
		Agent neighor = null;
		boolean found = false;
		int i = Utilities.rng.nextInt(agents.size());
		int start = i;
		while(!found) {
			Agent candidate = agents.get(i);
			
			if(candidate != asker && asker.distance(candidate) < radius) 
			{
				neighor = agents.get(i);
				found = true;
			}
			else
			{
				i = (i + 1) % agents.size();
				if(i == start) break;
			}
		}
		return neighor;
	}
	
	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}

	private void stopTimer() {
		timer.cancel();
		timer.purge();	// remove all cancelled tasks from this timer' task queue.
	}

	class ClockUpdater extends TimerTask {
		public void run() {
			clock++;
		}
	}

	//Method start() when click Start button
	public void start()
	{
		agents = new ArrayList<Agent>();
		clock = 0;
		populate();
		startTimer();
		for(Agent a : agents)
			a.start();
	}
	
	// override in subclass
	public void populate() {}

	// Method suspend() when click Suspend button
	public synchronized void suspend()
	{
		for(Agent a: agents)
		{
			a.suspend();
		}
		stopTimer();
	}

	// Method name: resume() when click resume button
	public synchronized void resume()
	{
		startTimer();
		for(Agent a : agents)
		{
			a.resume();
		}
	}

	// Method name: stop()
	public synchronized void stop()
	{
		for(Agent a : agents)
		{
			a.stop();
		}
		stopTimer();
	}
	
	public synchronized int getClock() {
		return clock;
	}
	
	public synchronized Iterator<Agent> iterator(){
		return agents.iterator(); 
	}
	
	private synchronized void incClock() 
	{
		clock++;
		changed();
	}

	// method name: stats()
	public void stats()
	{
		JFrame frame = new JFrame("Status");
		JOptionPane.showMessageDialog(null, "Clicked on Stats button");
	}
	
	public ArrayList<Agent> getAgents() { return agents; }
    public Agent getAgent() { return agent; }

}