package gui;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import datastructures.DFJoint;
import datastructures.dependency.ADependency;

public class ProjectionOnAttributeJointDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public ProjectionOnAttributeJointDialog(final ArrayList<DFJointCheckBox> dfList) {
		setBounds(100, 100, 550, 450);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 534, 411);
		getContentPane().add(panel);
			
		ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < dfList.size(); i++) {
			DFJointCheckBox rd = dfList.get(i);
			
			rd.getRdButton2().setBounds(10, 10 + i * 25, 1080, 25);
			
			panel.add(rd.getRdButton2());
			rdGroup.add(rd.getRdButton2());
		}
		
		JPanel panelDF = new JPanel();
		
		final JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				if (rdbtnNewRadioButton.isSelected()) {
					DFJoint dfJoint = new DFJoint();
					
					ArrayList<ADependency> dfs = new ArrayList<>();
					
					for (DFJointCheckBox dfJ : dfList) {
						if (dfJ.getRdButton2().isSelected())
							dfJoint = new DFJoint(dfJ.getDfJoint());
					}
					
					for (ADependency df : dfJoint) {
						JRadioButton dfRdButton = new JRadioButton(df.toString());
						dfs.add(df);
						
					}
				}
					
			}
		});
		rdbtnNewRadioButton.setBounds(23, 351, 109, 23);
		panel.add(rdbtnNewRadioButton);
	}
}
