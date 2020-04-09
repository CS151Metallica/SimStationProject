package simstation;

import mvc.Model;

public class RandomWalkFactory extends SimStationFactory{
	@Override
	public Model makeModel() { return new RandomWalk(); }	// return RandomWalk - (a CustomSimulation) 
}
