package boids;

import mvc.*;
import simstation.*;

public class FlockingFactory extends SimStationFactory{
	@Override
	public Model makeModel() { return new Flocking(); }	// return RandomWalk - (a CustomSimulation) 
}