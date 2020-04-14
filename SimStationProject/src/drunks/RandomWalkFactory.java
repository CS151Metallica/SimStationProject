/*
 * Trung: Add RandomWalkFactory.java
 */
package drunks;

import mvc.*;
import simstation.*;

public class RandomWalkFactory extends SimStationFactory{
	@Override
	public Model makeModel() { return new RandomWalk(); }	// return RandomWalk - (a CustomSimulation) 
}
