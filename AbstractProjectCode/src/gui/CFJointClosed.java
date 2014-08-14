package gui;

import java.util.ArrayList;

import javax.swing.JDialog;

import datastructures.Attribute;

public class CFJointClosed extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public CFJointClosed(ArrayList<DFJointCheckBox> dfList, ArrayList<Attribute> aList) {
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(null);

	}

}
