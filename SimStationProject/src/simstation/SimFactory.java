/*
 * Trung: Add SimFactory.java
 */
package simstation;

import mvc.*;

public interface SimFactory extends AppFactory {
	public abstract View getView(Model mode);
}
