package simstation;

import java.util.Random;

enum AgentState {
	RUNNING, SUSPENDED, STOPPED, READY
}

enum Heading {
	NORTH, EAST, SOUTH, WEST
}

abstract class Agent implements Runnable {

	private String name;
	private AgentState state;
	private Thread thread;
	
	private Heading heading;
	private int xc;
	private int yc;
	


	public Agent(String name) {
		this.name = name;
		state = AgentState.READY;
		
		//start at center
		xc = 125;
		yc = 125;
		
		//chooses a random Heading
		Random random = new Random();
		int pickHeading = random.nextInt(Heading.values().length);
		heading = Heading.values()[pickHeading];
	}



	public synchronized void stop() { state = AgentState.STOPPED; }
	public synchronized boolean isStopped() { return state == AgentState.STOPPED; }
	public synchronized void suspend() { state = AgentState.SUSPENDED; }
	public synchronized boolean isSuspended() { return state == AgentState.SUSPENDED;  }
	public synchronized void resume() {
		if (!isStopped()) {
			state = AgentState.RUNNING;
			notify();
		}
	}
	public String getName() { return name; }
	public synchronized AgentState getState() { return state; }
	public synchronized void join() throws InterruptedException {
		if (thread != null) thread.join();
	}
	public synchronized String toString() { return name + ".state = " + state; }

	public void run() {
		thread = Thread.currentThread(); // catch my thread
		while(!isStopped()) {
			state = AgentState.RUNNING;
			update();
			try {
				Thread.sleep(100); // be cooperative
				synchronized(this) {
					while(isSuspended()) { wait(); }
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public abstract void update();
	
//	public void move(int steps) {
//		if (heading == Heading.NORTH) {
//			yc -= steps;
//		} else if (heading == Heading.EAST) {
//			xc += steps;
//		} else if (heading == Heading.SOUTH) {
//			yc += steps;
//		} else {
//			xc -= steps;
//		}
//	}
}





