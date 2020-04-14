/*
 * Amy, 4/10: created
 */
package plague;

import java.awt.*;

import javax.swing.*;

import mvc.*;
import simstation.*;

public class PlaguePanel extends AppPanel{
	private JButton start, suspend, resume, stop, stats;
	
	public PlaguePanel(AppFactory factory) {
		super(factory);
		
		this.setLayout(new GridLayout(1, 2));
        this.setPreferredSize(new Dimension(600, 600));
		
		PlagueView view = new PlagueView((Simulation)model);
		view.setPreferredSize(new Dimension(255,255));		
		
		// panel to store all buttons: Leap, Clear
        JPanel buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(100,250));
        
        // button Start
        start = new JButton("Start");
        start.addActionListener(this);
        JPanel startPanel = new JPanel();
        start.setPreferredSize(new Dimension(100, 30));
        startPanel.add(start);
        
        // button Suspend
        suspend = new JButton("Suspend");
        suspend.addActionListener(this);
        JPanel suspendPanel = new JPanel();
        suspend.setPreferredSize(new Dimension(100, 30));
        suspendPanel.add(suspend);
        
        // button Resume
        resume = new JButton("Resume");
        resume.addActionListener(this);
        JPanel resumePanel = new JPanel();
        resume.setPreferredSize(new Dimension(100, 30));
        resumePanel.add(resume);
        
        // button Stop
        stop = new JButton("Stop");
        stop.addActionListener(this);
        JPanel stopPanel = new JPanel();
        stop.setPreferredSize(new Dimension(100, 30));
        stopPanel.add(stop);
        
        // button Stats
        stats = new JButton("Stats");
        stats.addActionListener(this);
        JPanel statsPanel = new JPanel();
        stats.setPreferredSize(new Dimension(100, 30));
        statsPanel.add(stats);   
        
        // add all buttons to buttonPanel
        buttonPanel.add(start);
        buttonPanel.add(suspend);
        buttonPanel.add(resume);
        buttonPanel.add(stop);
        buttonPanel.add(stats);
        
		add(buttonPanel, "West");
		add(view, "East");
		
		this.setLayout(new FlowLayout());
        add(buttonPanel);
        add(view); 
	}
	
	public static void main(String[] args) {
		AppFactory factory = new PlagueFactory();
		AppPanel panel = new PlaguePanel(factory);
		panel.display();
	}
	
}
