package prisoners;

public class ReciprocalStrategy extends Strategy{
	@Override
	boolean cooperate() {
		return owner.getLast();
	}

	@Override
	String getStrategyType() {
		return "Reciprocal";
	}

}
