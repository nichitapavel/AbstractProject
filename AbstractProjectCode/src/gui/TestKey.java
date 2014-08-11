package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.Relation;

public class TestKey extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestKey(ArrayList<Attribute> attrList, ArrayList<RelationCheckBox> relRdButton) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		final ArrayList<JCheckBox> aList = new ArrayList<>();
		final ArrayList<RelationCheckBox> relationList = new ArrayList<>(relRdButton);
		final ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(434, 261);
		panel.setLayout(null);
		
		final JTextArea txtResult = new JTextArea();
		txtResult.setMargin(new Insets(2, 5, 2, 2));
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResult.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtResult.setEditable(false);
		txtResult.setBounds(70, 220, 220, 25);
		panel.add(txtResult);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setBounds(10, 220, 60, 25);
		panel.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(300, 220, 90, 25);
		panel.add(btnCalcular);
		
		for (int i = 0; i < attrList.size(); i++) {
			JCheckBox attrChkBox = new JCheckBox(attrList.get(i).toString()); 
			attrChkBox.setBounds(10 + i * 55, 10, 50, 20);
			aList.add(attrChkBox);
			panel.add(attrChkBox);
		}
		
		for (int i = 0; i < relationList.size(); i++) {
			
			JSeparator sep = new JSeparator();
			sep.setBounds(0, 130 + 90 *i, 850, 1);
			sep.setForeground(Color.BLACK);
			
			relationList.get(i).getRdButton().setBounds(5, 45+90*i, 450, 25);
			
			JLabel attrJoint = new JLabel("Atributos: " + relationList.get(i).getRelation().getAttrJoint().toString());
			attrJoint.setBounds(5, 70 + 90*i, 450, 20);
			attrJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel dfJoint = new JLabel("Dependencias: " + relationList.get(i).getRelation().getDFJoint().toString());
			dfJoint.setBounds(5, 95 + 90 * i, 450, 20);
			dfJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			panel.add(sep);
			panel.add(relationList.get(i).getRdButton());
			panel.add(attrJoint);
			panel.add(dfJoint);

			
			rdGroup.add(relationList.get(i).getRdButton());
		}

		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttributeJoint attrJoint = new AttributeJoint();
				Relation r1 = new Relation();
				
				for (JCheckBox box : aList) {
					if (box.isSelected())
						attrJoint.addAttributes(new Attribute(box.getText()));
						box.setSelected(false);
				}
				
				for (RelationCheckBox rel : relationList) {
					if (rel.getRdButton().isSelected()) {
						r1 = new Relation(rel.getRelation().getAttrJoint(), rel.getRelation().getDFJoint());
						rdGroup.clearSelection();
					}	
				}
				
				switch (attrJoint.isKey(r1)) {
				case -1:
					txtResult.setForeground(Color.RED);
					txtResult.setText("No es clave");
					break;
				case 1:
					txtResult.setForeground(Color.GREEN);
					txtResult.setText("Es clave m\u00EDnima");
					break;
				default:
					txtResult.setForeground(Color.YELLOW);
					txtResult.setText("Es Superclave, pero no es m\u00EDnima");
					break;
				}	
			}
		});

		getContentPane().add(panel);
	}

}
