package gui;

import javax.swing.JCheckBox;

import datastructures.dependency.ADependency;

public class DepCheckBox {
	private int position;
	private ADependency dp;
	private JCheckBox chckBox;
	
	public DepCheckBox() {
		position = 0;
		dp = null;
		chckBox = new JCheckBox();
	}

	public DepCheckBox(int pos, ADependency df) {
		position = pos;
		dp = df;
		chckBox = new JCheckBox(df.toString());
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
