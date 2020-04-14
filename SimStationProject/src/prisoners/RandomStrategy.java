/*
 * Amy, 4/13: created
 */
package prisoners;

import mvc.Utilities;

public class RandomStrategy extends Strategy{
	@Override
	boolean cooperate() {
		//50% true, 50% false
		return Utilities.rng.nextInt(100) > 50;
	}

	@Override
	String getStrategyType() {
		return "Random";
	}

}
