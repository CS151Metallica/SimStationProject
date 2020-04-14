package prisoners;

import mvc.*;
import java.util.*;

import simstation.*;

public class Prisoner extends Agent{
	private int fitnessScore = 0;
	private Strategy strategy;
	private boolean lastOpponent = true; //last opponent cooperation, all start with true
	
	public Prisoner(String name, Strategy strategy) {
		super(name);
		this.strategy = strategy;
		this.strategy.setOwner(this);
	}
	
	public boolean cooperate() {
		return strategy.cooperate();
	}
	
	public void addScore(int score) {
		fitnessScore += score;
	}

	@Override
	public void update() {
		Agent other = world.getNeighbor(this, 10);
		
		if(other != null) {
			Prisoner neighbor = (Prisoner)other;
			boolean neighborCooperation = neighbor.cooperate();
			boolean cooperation = strategy.cooperate();
			neighbor.lastOpponent = cooperation;
			lastOpponent = neighborCooperation;
			if (neighborCooperation == true && cooperation == true) {
				//if both cooperate, add 3 to both fitness score
				addScore(PrisonerDT.COOPERATIVE);
				neighbor.addScore(PrisonerDT.COOPERATIVE);
			} else if (neighborCooperation == true && cooperation == false) {
				//if only the neighbor cooperated, add 5 to this Prisoner fitness score and 0 to its neighbor
				addScore(PrisonerDT.WIN);
				neighbor.addScore(PrisonerDT.LOSE);
			} else if (neighborCooperation == false && cooperation == true) {
				//if only this Prisoner cooperated, add 0 to this Prisoner fitness score and 5 to its neighbor
				addScore(PrisonerDT.LOSE);
				neighbor.addScore(PrisonerDT.WIN);
			} else {
				//if both cheated
				addScore(PrisonerDT.CHEAT);
				neighbor.addScore(PrisonerDT.CHEAT);
			}
			
			//System.out.println("GAME\n" + name + " " + fitnessScore + " " + strategy.getStrategyType() + " " + cooperation + "\n" + neighbor.getName() + " " + neighbor.getScore() + " " + neighbor.getStrategyType() + " " + neighborCooperation + "\n" );
		}
		
		changeHeading();
		move(Utilities.rng.nextInt(10));
	}
	
	public void updateCooperation(boolean cooperate) {
		lastOpponent = cooperate;
	}
	
	public int getScore() {
		return fitnessScore;
	}
	
	public String getStrategyType() {
		return strategy.getStrategyType();
	}
	
	public boolean getLast() {
		return lastOpponent;
	}

}
