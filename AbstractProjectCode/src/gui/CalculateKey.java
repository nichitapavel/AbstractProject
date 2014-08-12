package gui;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;

import datastructures.AttributeJoint;
import datastructures.KeyJoint;
import datastructures.Relation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculateKey extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public CalculateKey(ArrayList<RelationCheckBox> relList) {
		setBounds(100, 100, 450, 500);
		getContentPane().setLayout(null);
		
		final ArrayList<RelationCheckBox> rList = new ArrayList<>(relList);
		final ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 410, 450);
		panel.setLayout(null);
		
		final JTextArea txtResultados = new JTextArea();
		txtResultados.setText("Resultados\\n");
		txtResultados.setBounds(0, 310, 440, 150);
		panel.add(txtResultados);
		
		JButton btnCalcular = new JButton("Calcular claves");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relation r1 = new Relation();
				
				for (RelationCheckBox rel : rList) {
					if (rel.getRdButton().isSelected()) {
						r1 = new Relation(rel.getRelation().getAttrJoint(), rel.getRelation().getDFJoint());
						r1.setName(rel.getRelation().getName());
					}	
				}
				
				KeyJoint keyJoint = r1.calculateKeyJoint();
				
				txtResultados.setText(null);
				
				for (AttributeJoint attrJoint : keyJoint) {
					txtResultados.append(attrJoint.toString()+"\n");
				}
			}
		});
		btnCalcular.setBounds(100, 280, 150, 25);
		panel.add(btnCalcular);

		
		for (int i = 0; i < rList.size(); i++) {
			
			JSeparator sep = new JSeparator();
			sep.setBounds(0, 10 + 90 *i, 850, 1);
			sep.setForeground(Color.BLACK);
			
			rList.get(i).getRdButton().setBounds(5, 10+90*i, 450, 25);
			
			JLabel attrJoint = new JLabel("Atributos: " + rList.get(i).getRelation().getAttrJoint().toString());
			attrJoint.setBounds(5, 40 + 90*i, 450, 20);
			attrJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel dfJoint = new JLabel("Dependencias: " + rList.get(i).getRelation().getDFJoint().toString());
			dfJoint.setBounds(5, 70 + 90 * i, 450, 20);
			dfJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			panel.add(sep);
			panel.add(rList.get(i).getRdButton());
			panel.add(attrJoint);
			panel.add(dfJoint);

			
			rdGroup.add(rList.get(i).getRdButton());
		}

		
		getContentPane().add(panel);
	}
}
