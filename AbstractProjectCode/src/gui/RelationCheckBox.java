package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import datastructures.Relation;

public class RelationCheckBox {
	private int position;
	private Relation relation;
	private JCheckBox chckBox;
	
	public RelationCheckBox(int pos, Relation r) {
		this.position = pos;
		this.relation = r;
		this.chckBox = new JCheckBox(r.getName());
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public Relation getRelation() {
		return relation;
	}

	public void setRelation(Relation relation) {
		this.relation = relation;
	}

	public JCheckBox getChckBox() {
		return chckBox;
	}

	public void setChckBox(JCheckBox chckBox) {
		this.chckBox = chckBox;
	}
	
	public JPanel getPanel(int i) {
		JPanel panel = new JPanel();
		
		panel.setSize(1920, 90);
		panel.setLocation(0, 40 + 90 * i);
				
		JSeparator sep = new JSeparator();
		sep.setBounds(15, 0, 1920, 1);
		sep.setForeground(Color.BLACK);
		
		this.chckBox.setBounds(15, 5, 1920, 25);
		
		JLabel attrJoint = new JLabel("Atributos: " + this.relation.getAttrJoint().toString());
		attrJoint.setBounds(25, 30, 1920, 20);
		attrJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dfJoint = new JLabel("Dependencias: " + this.relation.getDFJoint().toString());
		dfJoint.setBounds(25, 55, 1920, 20);
		dfJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		panel.add(sep);
		panel.add(chckBox);
		panel.add(attrJoint);
		panel.add(dfJoint);
				
		return panel;
	}
}
