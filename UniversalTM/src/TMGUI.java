import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;


public class TMGUI extends JFrame {
	private File f;
	private String tmString;
	private TMReader tmr;
	private Parser p;
	
	private DefaultListModel lmQ;

	public static void main(String[] args){
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TMGUI ex = new TMGUI();
				ex.setVisible(true);
			}
		});
	}

	public TMGUI(){
		tmr = new TMReader();
		p = new Parser();
		lmQ = new DefaultListModel();
		build_GUI();
	}

	private void build_GUI(){
		setTitle("Universal Turing Machine");
		setSize(500, 700);
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
	    JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Text files", "txt");
	    chooser.setFileFilter(filter);
	    
	    JButton load = new JButton("Load");
	    //load.setSize(30, 15);
	    load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            	int returnVal = chooser.showOpenDialog(pane);
        	    if(returnVal == JFileChooser.APPROVE_OPTION) {
        	       System.out.println("You chose to open this file: " +
        	            chooser.getSelectedFile().getName());
        	       
        	       f = chooser.getSelectedFile();
        	       try {
					tmString = tmr.readTM(f);
					setLabels(pane);
				} catch (FileNotFoundException e) {
					JOptionPane.showMessageDialog(pane, e.getMessage(),
	                        "Error", JOptionPane.ERROR_MESSAGE);
				}
        	    }
            }
        });
	    
	    JLabel qlab = new JLabel("Q:");
		qlab.setBounds(35, 65, 20, 20);
		JLabel sigmalab = new JLabel("\u03A3:");
		sigmalab.setBounds(35, 95, 20, 20);
		JLabel gammalab = new JLabel("\u0393:");
		gammalab.setBounds(35, 125, 20, 20);
		JLabel deltalab = new JLabel("\u03B4:");
		deltalab.setBounds(35, 155, 20, 20);
		JLabel q1lab = new JLabel("q1:");
		q1lab.setBounds(30, 185, 20, 20);
		JLabel qacclab = new JLabel("qacc:");
		qacclab.setBounds(15, 215, 35, 20);
		JLabel qrejlab = new JLabel("qrej:");
		qrejlab.setBounds(20, 245, 30, 20);

		JList listQ = new JList(lmQ); //data has type Object[]
		listQ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listQ.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		listQ.setVisibleRowCount(-1);
		JScrollPane listScroller = new JScrollPane(listQ);
		listScroller.setPreferredSize(new Dimension(250, 80));
		
		pane.add(qlab);
		pane.add(sigmalab);
		pane.add(gammalab);
		pane.add(deltalab);
		pane.add(q1lab);
		pane.add(qacclab);
		pane.add(qrejlab);
		pane.add(listQ);
	    pane.add(load);
	    load.setBounds(5, 5, 70, 40);
	    
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void setLabels(Container c){
		try {
			p.setInput(tmString);
			for(String s :p.getQ()){
				System.out.println(s);
				lmQ.addElement(s);
			}
		} catch (InvalidTMFormat e) {
			JOptionPane.showMessageDialog(c, e.getMessage() + "\n Try a different file",
                    "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		System.out.println("done");
	}

	private void build_GUII(){

		JPanel toolPanel = new JPanel();
		toolPanel.setLayout(new GridLayout(2, 2, 1, 0));

		JToolBar toolbar = new JToolBar(null, JToolBar.HORIZONTAL);
		//this.setLayout(new GridLayout(5, 2, 1, 1));

		String[] gizmos = {"Absorber", "Circle", "Square", "Triange", "Line", "Ball", "Left Flipper", "Right Flipper"}; 
		JComboBox gizmoList = new JComboBox(gizmos);
		JMenuItem circle = new JMenuItem("Circle", new ImageIcon("pics/add1.png"));
		gizmoList.add(circle);

		toolbar.add(gizmoList);

		JButton play = new JButton(new ImageIcon("pics/add1.png"));
		toolbar.add(play);

		JButton rotate = new JButton(new ImageIcon("pics/rotate1.png"));
		toolbar.add(rotate);

		JButton pause = new JButton(new ImageIcon("pics/move1.png"));
		toolbar.add(pause);

		JButton stop = new JButton(new ImageIcon("pics/link1.png"));
		toolbar.add(stop);

		JButton delete = new JButton(new ImageIcon("pics/delete1.png"));
		toolbar.add(delete);


		toolbar.add(Box.createHorizontalGlue());

		JButton save = new JButton(new ImageIcon("pics/save1.png"));
		toolbar.add(save);

		JButton load = new JButton(new ImageIcon("pics/load1.png"));
		toolbar.add(load);


		JButton playMode = new JButton(new ImageIcon("pics/play1.png"));
		toolbar.add(playMode);

		toolbar.setFloatable(false);

		toolPanel.add(toolbar);


		JToolBar toolbar1 = new JToolBar();

		JLabel gravLabel = new JLabel();
		gravLabel.setText("Gravity: ");
		toolbar1.add(gravLabel);

		JSlider gravity = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
		gravity.setMajorTickSpacing(25);
		gravity.setMinorTickSpacing(5);
		gravity.setPaintLabels(true);
		gravity.setPaintTicks(true);

		toolbar1.add(gravity);
		toolbar.add(Box.createVerticalStrut(25));

		JLabel fricLabel = new JLabel();
		fricLabel.setText("Friction: ");
		toolbar1.add(fricLabel);

		JSlider friction = new JSlider(JSlider.HORIZONTAL, 0, 100, 10);
		friction.setMajorTickSpacing(25);
		friction.setMinorTickSpacing(5);
		friction.setPaintLabels(true);
		friction.setPaintTicks(true);

		toolbar1.add(friction);

		toolbar1.setFloatable(false);

		toolPanel.add(toolbar1);

		add(toolPanel, BorderLayout.NORTH);

		//JLabel board = new JLabel(new ImageIcon("pics/board3.png"));
		JPanel mouseTest = new JPanel();
		mouseTest.setSize(500, 500);
		

		add(Box.createHorizontalStrut(500));

		add(mouseTest, BorderLayout.CENTER);

		JTextField helpMsg = new JTextField();
		helpMsg.setText("Help Message Here");
		add(helpMsg, BorderLayout.SOUTH);
		//add(helpMsg);

		setTitle("Build Screen");
		//setSize(600, 600);
		this.pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


