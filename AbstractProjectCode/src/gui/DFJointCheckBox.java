package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import datastructures.DFJoint;

public class DFJointCheckBox implements ChangeListener, ActionListener {
	private int position;
	private DFJoint dfJoint;
	private JCheckBox chckBox;
	
	public DFJointCheckBox() {
		this.position = 0;
		this.dfJoint = new DFJoint();
		this.chckBox = new JCheckBox();
	}
	
	public DFJointCheckBox(int pos, DFJoint dfJoint, String name) {
		this.position = pos;
		this.dfJoint = dfJoint;
		this.chckBox = new JCheckBox(name);
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

	public JCheckBox getChckBox() {
		return chckBox;
	}

	public void setChckBox(JCheckBox chckBox) {
		this.chckBox = chckBox;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comp = e.getActionCommand();
	}
	
	
}
