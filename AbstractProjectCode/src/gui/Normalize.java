package gui;



import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JButton;

import normalization.Normalization;
import datastructures.Relation;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Normalize extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public Normalize(ArrayList<RelationCheckBox> relList, final int proccess) {
		switch (proccess) {
			case 1:
				setTitle("Normalizaci\u00F3n hasta 3FN");
				break;
			case 2:
				setTitle("Normalizaci\u00F3n hasta FNBC");
				break;
			default:
				setTitle("Normalizaci\u00F3n hasta 4FN");
				break;
		}
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		
		final ArrayList<RelationCheckBox> rList = new ArrayList<>(relList);
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(584, 361);
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(120, 200, 310, 161);
		panel.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setBounds(10, 200, 60, 24);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Normalizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relation r1 = new Relation();
				
				for (RelationCheckBox rel : rList) {
					if (rel.getRdButton().isSelected()) {
						r1 = new Relation(rel.getRelation().getAttrJoint(), rel.getRelation().getDFJoint());
						r1.setName(rel.getRelation().getName());
					}	
				}
				
				rdGroup.clearSelection();
				
				ArrayList<Relation> result;
				
				switch (proccess) {
				case 1:
					result = Normalization.normalize3NF(r1, true);
					break;
				case 2:
					result = Normalization.normalizeBCNF(r1, true);
					break;
				default:
					result = Normalization.normalize4NF(r1, true);
					break;
				}				
				
				textArea.setText(null);			
				
				int i = 0;
				for (Relation r : result) {
					int j = i+1;
					textArea.append("R" + j + ": " + '\n' + r.getAttrJoint().toString() + '\n' + r.getDFJoint().toString() + '\n');
					i++;
				}
			}
		});
		btnNewButton.setBounds(460, 200, 100, 25);
		panel.add(btnNewButton);
		
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
	}
}
