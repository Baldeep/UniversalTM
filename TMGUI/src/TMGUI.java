import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.jface.viewers.ComboViewer;

public class TMGUI extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TMGUI(Composite parent, int style) {
		super(parent, style);
		setLayout(new GridLayout(3, false));
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label lblNewLabel = new Label(this, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("Q: ");
		
		Label lblNewLabel_1 = new Label(this, SWT.NONE);
		lblNewLabel_1.setText("New Label");
		new Label(this, SWT.NONE);
		
		Label lblu = new Label(this, SWT.NONE);
		lblu.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblu.setText("sigma: ");
		
		Label lblNewLabel_2 = new Label(this, SWT.NONE);
		lblNewLabel_2.setText("New Label");
		new Label(this, SWT.NONE);
		
		Label lblu_1 = new Label(this, SWT.NONE);
		lblu_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblu_1.setText("gamma: ");
		
		Label lblNewLabel_3 = new Label(this, SWT.NONE);
		lblNewLabel_3.setText("New Label");
		new Label(this, SWT.NONE);
		
		Label lblNewLabel_4 = new Label(this, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("Q1: ");
		
		Label lblNewLabel_5 = new Label(this, SWT.NONE);
		lblNewLabel_5.setText("New Label");
		new Label(this, SWT.NONE);
		
		Label lblNewLabel_6 = new Label(this, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_6.setText("Qacc: ");
		
		Label lblNewLabel_7 = new Label(this, SWT.NONE);
		lblNewLabel_7.setText("New Label");
		new Label(this, SWT.NONE);
		
		Label lblNewLabel_8 = new Label(this, SWT.NONE);
		lblNewLabel_8.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_8.setText("Qrej: ");
		
		Label lblNewLabel_10 = new Label(this, SWT.NONE);
		lblNewLabel_10.setText("New Label");
		new Label(this, SWT.NONE);
		new Label(this, SWT.NONE);
		
		Label label = new Label(this, SWT.NONE);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

}
