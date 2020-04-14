package prisoners;

public abstract class Strategy {
	protected Prisoner owner;
	
	public void setOwner(Prisoner owner) {
		this.owner = owner;
	}
	abstract boolean cooperate();
	abstract String getStrategyType();
}
