package prisoners;

import mvc.*;
import simstation.*;

public class PrisonerDTPanel extends SimulationPanel{
	public PrisonerDTPanel(AppFactory factory) {
		super(factory);
	}
	
	public static void main(String[] args) {
		AppFactory factory = new PrisonerDTFactory();
		AppPanel panel = new PrisonerDTPanel(factory);
		panel.display();
	}
}
