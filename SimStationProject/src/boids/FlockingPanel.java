package boids;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import mvc.*;
import simstation.*;

public class FlockingPanel extends SimStationPanel{
	
	public FlockingPanel(AppFactory factory) {
		super(factory);		
	}
	
	public static void main(String[] args) {
		AppFactory factory = new FlockingFactory();
		AppPanel panel = new FlockingPanel(factory);
		panel.display();
	}
	
}
