package simstation;

import java.io.Serializable;
import java.lang.Thread.State;

import mvc.*;

abstract class Agent implements Runnable, Serializable {
	private static final long serialVersionUID = 1L;
	private Thread thread;
	protected String name;
	protected Simulation world;
	protected int xc, yc;
	protected Heading heading;
	private AgentState state, goal;

	public String getName() {
		return name;
	}

	public void join() throws InterruptedException {
		if (thread != null) thread.join();
	}

	public Agent(String name) {
		this.name = name;
		state = AgentState.READY;
		thread = null;
		xc = Utilities.rng.nextInt(Simulation.SIZE);
		yc = Utilities.rng.nextInt(Simulation.SIZE);
		heading = Heading.random();
	}

//	public Agent() {
//		this("Agent_ " + mvc.Utilities.getID());
//	}

	public void run() {
		thread = Thread.currentThread(); // catch my thread
		while(!isStopped()) {
			state = AgentState.RUNNING;
			update();
			if (goal == state) stop();
			try {
				Thread.sleep(100); // be cooperative
				synchronized(this) {
					while(isSuspended()) { wait(); }		// waiting for notify
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public synchronized void start() {
		onStart();
		state = AgentState.READY;
		if(thread == null) {
			thread = new Thread(this, name);
		}
		thread.start();		// calls run()
	}

	public abstract void update();

	protected synchronized void onStart() {
		System.out.println(name + " is starting!!!");
	}

	protected synchronized void onExit() {
		System.out.println(name + " is exiting!!!");
	}

	protected synchronized void onInterrupted() {
		System.out.println(name + " is interrupted!!!");
	}

	// state changing functions
	public synchronized void suspend() { state = AgentState.SUSPENDED; }

	public synchronized void resume() {
		if (!isStopped()) {
			state = AgentState.RUNNING;
			notify();
		}
	}

	public synchronized void stop() { state = AgentState.STOPPED; }

	public synchronized boolean isStopped() { return state == AgentState.STOPPED; }

	public boolean isSuspended() { return state == AgentState.SUSPENDED;  }

	public Simulation getWorld() {
		return world;
	}

	public void setWorld(Simulation world) {
		this.world = world;
	}

	// get distance from this agent to agent a
	public double distance(Agent a) {
		// find distance by sqrt((a.xc - this.xc)^2 + (a.yc - this.yc)^2)
		return Math.sqrt(Math.pow((double)(a.xc - this.xc), 2) + Math.pow((double)(a.yc - this.yc), 2));
	}

	// test
	public synchronized boolean finished() {
		return (state == AgentState.STOPPED) || (thread != null && thread.getState() != State.RUNNABLE);
	}
	
	public synchronized void move(int steps) {
		if (heading == Heading.N) {
			int tempY = yc - steps;
			if (tempY < 0) {
				yc = 250 + tempY;
			} else {
				yc -= steps;
			}
		} else if (heading == Heading.E) {
			int tempX = xc + steps;
			if (tempX > 250) {
				int difference = tempX - 250;
				xc = difference;
			} else {
				xc += steps;
			}
		} else if (heading == Heading.S) {
			int tempY = yc + steps;
			if (tempY > 250) {
				int difference = tempY - 250;
				yc = difference;
			} else {
				yc += steps;
			}
		} else {
			int tempX = xc - steps;
			if (tempX < 0) {
				xc = 250 + tempX;
			} else {
				xc -= steps;
			}
		}
		
		world.changed();
	}
	
	public void changeHeading() {
		heading = Heading.random();
	}
}	
