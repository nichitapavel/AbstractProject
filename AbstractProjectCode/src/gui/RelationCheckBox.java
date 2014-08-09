package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
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
	
	public Container getContainer(int i) {
		Container cont = new Container();
		
		cont.setSize(1920, 90);
		cont.setLocation(0, 40 + 90 * i);
				
		this.chckBox.setBounds(15, 10, 1920, 25);
		
		JSeparator sep = new JSeparator();
		sep.setBounds(15, 0, 1920, 1);
		sep.setForeground(Color.BLACK);
		
		
		JLabel attrJoint = new JLabel("Atributos: " + this.relation.getAttrJoint().toString());
		attrJoint.setBounds(25, 40, 1920, 20);
		attrJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel dfJoint = new JLabel("Dependencias: " + this.relation.getDFJoint().toString());
		dfJoint.setBounds(25, 65, 1920, 20);
		dfJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		cont.add(sep);
		cont.add(chckBox);
		cont.add(attrJoint);
		cont.add(dfJoint);
				
		return cont;
	}
}
