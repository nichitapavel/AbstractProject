package gui;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import datastructures.dependency.ADependency;

public class DepCheckBox {
	private int position;
	private ADependency dp;
	private JCheckBox chckBox;
	private JRadioButton rdButton;
	
	public DepCheckBox() {
		position = 0;
		dp = null;
		chckBox = new JCheckBox();
		rdButton = new JRadioButton();
	}

	public DepCheckBox(int pos, ADependency df) {
		position = pos;
		dp = df;
		chckBox = new JCheckBox(df.toString());
		rdButton = new JRadioButton(df.toString());
	}

	public JRadioButton getRdButton() {
		return rdButton;
	}

	public void setRdButton(JRadioButton rdButton) {
		this.rdButton = rdButton;
	}

	public ADependency getDP() {
		return dp;
	}

	public void setDP(ADependency dep) {
		this.dp = dep;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public JCheckBox getChckBox() {
		return chckBox;
	}

	public void setChckBox(JCheckBox chckBox) {
		this.chckBox = chckBox;
	}
}
