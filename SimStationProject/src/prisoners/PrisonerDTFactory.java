/*
 * 04/13: Amy: First created
 */
package prisoners;

import mvc.*;
import simstation.*;

public class PrisonerDTFactory extends SimStationFactory{
	@Override
	public Model makeModel() { return new PrisonerDT(); }	// return RandomWalk - (a CustomSimulation) 
}
