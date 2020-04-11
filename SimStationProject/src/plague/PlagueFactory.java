package plague;

import mvc.*;
import simstation.*;

public class PlagueFactory extends SimStationFactory{
	@Override
	public Model makeModel() { return new PlagueSimulation(); }	
}
