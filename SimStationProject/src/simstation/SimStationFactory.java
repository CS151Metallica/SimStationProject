package simstation;

import mvc.*;

public class SimStationFactory implements SimFactory {

    public Model makeModel() { return new Simulation(); }

    public String[] getEditCommands() {
        return new String[]{"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    public Command makeEditCommand(Model model, String type) {
        if(type == "Start")
            return new StartCommand(model);
        else if(type == "Suspend")
            return new SuspendCommand(model);
        else if(type == "Resume")
            return new ResumeCommand(model);
        else if(type == "Stop")
            return new StopCommand(model);
        else if(type == "Stats")
            return new StatsCommand(model);
        return null;
    }

    public String getTitle() { return "SimStation"; }

    public String[] getHelp() {
        return new String[] {"SimStation exemplifies the multi-agent or agent-based architecture. It is a framework for creating simulations. A typical simulation might involve a population of agents (birds, bees, shoppers, cars, etc.) moving around an environment and interacting with random neighbors (e.g. fighting, bargaining, mating, etc.).\n"};
    }

    public String about() {
        return "SimStation v1.0 created by Metallica team";
    }

	@Override
	public View getView(Model model) {
		return new SimulationView((Simulation)model);
	}
}
