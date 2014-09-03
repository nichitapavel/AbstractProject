package gui;


import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ScrollPaneConstants;

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
		setTitle("Calculo de claves");
		setBounds(100, 100, 500, 290);
		getContentPane().setLayout(null);
		
		final ArrayList<RelationCheckBox> rList = new ArrayList<>(relList);
		final ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 484, 461);
		panel.setLayout(null);
		
		final JTextArea txtResultados = new JTextArea();
		txtResultados.setEditable(false);
		txtResultados.setBounds(100, 160, 374, 144);
		
		JScrollPane scroll = new JScrollPane(txtResultados);
		scroll.setBounds(100, 160, 374, 80);
	    scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.add(scroll);
		
		
		final JLabel info = new JLabel("");
		info.setBounds(10, 120, 300, 25);
		panel.add(info);
		
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
				
				rdGroup.clearSelection();
				
				KeyJoint keyJoint = r1.calculateKeyJoint();
				
				txtResultados.setText(null);
				
				int i = 0;
				for (AttributeJoint attrJoint : keyJoint) {
					txtResultados.append(i+1 + ". " + attrJoint.toString() + '\n');
					i++;
				}
				
				info.setText("Claves de la relaci\u00F3n " + '"' + r1.getName() + '"');
			}
		});
		btnCalcular.setBounds(330, 120, 140, 25);
		panel.add(btnCalcular);

		
		for (int i = 0; i < rList.size(); i++) {
			
			JSeparator sep = new JSeparator();
			sep.setBounds(0, 9 + 90 *i, 850, 1);
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
		
		JLabel lblNewLabel = new JLabel("Resultados:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 160, 80, 25);
		panel.add(lblNewLabel);
	}
}
