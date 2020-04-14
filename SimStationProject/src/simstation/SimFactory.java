/*
 * Trung, 4/14: created
 */
package simstation;

import mvc.*;

public interface SimFactory extends AppFactory {
	public abstract View getView(Model model);
}
