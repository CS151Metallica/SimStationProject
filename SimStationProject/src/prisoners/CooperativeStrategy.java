/*
 * 04/13: Amy: First created
 */
package prisoners;

public class CooperativeStrategy extends Strategy{
	@Override
	public boolean cooperate() {
		return true;
	}

	@Override
	String getStrategyType() {
		return "Cooperative";
	}
	
}
