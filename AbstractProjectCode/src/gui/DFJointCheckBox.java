package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import datastructures.DFJoint;

public class DFJointCheckBox implements ChangeListener, ActionListener {
	private int position;
	private DFJoint dfJoint;
	private JRadioButton rdButton;
	
	public DFJointCheckBox() {
		this.position = 0;
		this.dfJoint = new DFJoint();
		this.rdButton = new JRadioButton();
	}
	
	public DFJointCheckBox(int pos, DFJoint dfJoint, String name) {
		this.position = pos;
		this.dfJoint = dfJoint;
		this.rdButton = new JRadioButton(name);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public DFJoint getDfJoint() {
		return dfJoint;
	}

	public void setDfJoint(DFJoint dfJoint) {
		this.dfJoint = dfJoint;
	}

	public JRadioButton getRdButton() {
		return rdButton;
	}

	public void setRdButton(JRadioButton chckBox) {
		this.rdButton = chckBox;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
}
