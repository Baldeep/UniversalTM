import org.eclipse.swt.widgets.Composite;

public class TMGUI extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TMGUI(Composite parent, int style) {
		super(parent, style);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
