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
	private JRadioButton rdButton2;
	private JRadioButton rdButton3;
	
	public DFJointCheckBox() {
		this.position = 0;
		this.dfJoint = new DFJoint();
		this.rdButton = new JRadioButton();
		this.rdButton2 = new JRadioButton();
		this.rdButton3 = new JRadioButton();
	}
	
	public DFJointCheckBox(int pos, DFJoint dfJoint, String name) {
		this.position = pos;
		this.dfJoint = dfJoint;
		this.rdButton = new JRadioButton(name);
		this.rdButton2 = new JRadioButton(name);
		this.rdButton3 = new JRadioButton(name);
	}

	public JRadioButton getRdButton3() {
		return rdButton3;
	}

	public void setRdButton3(JRadioButton rdButton3) {
		this.rdButton3 = rdButton3;
	}

	public JRadioButton getRdButton2() {
		return rdButton2;
	}

	public void setRdButton2(JRadioButton rdButton2) {
		this.rdButton2 = rdButton2;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public DFJoint getDfJoint() {
		return new DFJoint(dfJoint);
	}

	public void setDfJoint(DFJoint dfJoint) {
		this.dfJoint = new DFJoint(dfJoint);
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
