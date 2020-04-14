//Amy
package plague;

import mvc.Utilities;
import simstation.*;

public class Individual extends Agent{

	private boolean infected;
		
	public Individual(String name) {
		super(name);
		
		//some Individual might be infected at the beginning
		setInfected();
	}
	
	//determines whether the individual is infected at the beginning
	private void setInfected() {
		infected = Utilities.rng.nextInt(50) < 5;
	}
	
	public void infect() {
		if (!infected) {
			infected = PlagueSimulation.infect();
		}
	}
	
	public boolean isInfected() {
		return infected;
	}

	@Override
	public void update() {
		Agent neighbor = world.getNeighbor(this, 5);
		
		//if there is a neighbor, figure out if neighbor is infected
		if (neighbor != null) {
			Individual other = (Individual)neighbor;
			
			//if neighbor is infected, this Individual has a chance of getting infected
			if(other.isInfected()) {
				this.infect();
			}
		}
		
		changeHeading();
		move(Utilities.rng.nextInt(7));		
	}
	
	public int getX() {
		return xc;
	}
	
	public int getY() {
		return yc;
	}
	
}
