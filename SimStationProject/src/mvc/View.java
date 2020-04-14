/*
 *  04/07: Amy: First initialize
 */
package mvc;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JComponent;
import javax.swing.border.LineBorder;

public class View extends JComponent implements PropertyChangeListener{
	protected Model model;
	
	public View(Model model) {
		super();
		this.model = model;
		model.addPropertyChangeListener(this);		// add myself to the listener of model
		//set border arount the view component
		setBorder(LineBorder.createBlackLineBorder());
	}
	
	public Model getModel() {
		return model;
	}
	
	// called by File/Open and File/New
	public void setModel(Model model) {
		if(this.model != null) {
			this.model.removePropertyChangeListener(this);
		}	
		this.model = model;
		if(model != null) {
			this.model.addPropertyChangeListener(this);
			repaint();
		}	
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}
