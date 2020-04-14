/*
 * Amy, 4/8: created
 */
package simstation;

import mvc.*;

public class StartCommand extends Command{

	public StartCommand(Model model) {
		super(model);
	}

	@Override
	public void execute() {
		Simulation simulation = (Simulation)model;
		simulation.start();
	}
	
	

}
