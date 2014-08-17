package gui;

import javax.swing.JRadioButton;

import datastructures.Attribute;
import datastructures.dependency.ADependency;

public class RareCheckBox {
	private int position;
	private Attribute attr;
	private ADependency dep;
	private JRadioButton rdButton;
	
	public RareCheckBox() {	}
	
	public RareCheckBox(int pos, Attribute attr, ADependency dep) {
		position = pos;
		this.attr = attr;
		this.dep = dep;
		this.rdButton = new JRadioButton(attr + " en " + dep);
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Attribute getAttr() {
		return attr;
	}

	public void setAttr(Attribute attr) {
		this.attr = attr;
	}

	public ADependency getDep() {
		return dep;
	}

	public void setDep(ADependency dep) {
		this.dep = dep;
	}

	public JRadioButton getRdButton() {
		return rdButton;
	}

	public void setRdButton(JRadioButton rdButton) {
		this.rdButton = rdButton;
	}
	
}
