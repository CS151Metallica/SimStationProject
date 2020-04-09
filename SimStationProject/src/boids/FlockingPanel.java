package boids;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.*;
import simstation.*;

public class FlockingPanel extends AppPanel{

	private JButton start, suspend, resume, stop, stats;
	
	public FlockingPanel(AppFactory factory) {
		super(factory);
		
		SimulationView view = new SimulationView((Simulation)model);
		this.setLayout(new GridLayout(1, 2));
		
		start = new JButton("Start");
		start.addActionListener(this);
		suspend = new JButton("Suspend");
		suspend.addActionListener(this);
		resume = new JButton("Resume");
		resume.addActionListener(this);
		stop = new JButton("Stop");
		stop.addActionListener(this);
		stats = new JButton("Stats");
		stats.addActionListener(this);
		
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(1, 100, 15));
		buttonPanel.add(start);
		buttonPanel.add(suspend);
		buttonPanel.add(resume);
		buttonPanel.add(stop);
		buttonPanel.add(stats);
		
		add(buttonPanel, "West");
		add(view, "East");
		
	}
	
	public static void main(String[] args) {
		AppFactory factory = new FlockingFactory();
		AppPanel panel = new FlockingPanel(factory);
		panel.display();
	}
	
}
