/*
 * Amy, 4/13: created
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
