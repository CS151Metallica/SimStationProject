package prisoners;

public class SelfishStrategy extends Strategy{
	@Override
	public boolean cooperate() {
		return false;
	}

	@Override
	String getStrategyType() {
		return "Selfish";
	}
	
}
