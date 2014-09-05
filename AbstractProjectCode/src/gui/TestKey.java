package gui;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.JTextField;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.Relation;

public class TestKey extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TestKey(ArrayList<Attribute> attrList, ArrayList<RelationCheckBox> relRdButton) {
		setTitle("Comprobar claves");
		setBounds(100, 100, 450, 236);
		getContentPane().setLayout(null);
		
		final ArrayList<JCheckBox> aList = new ArrayList<>();
		final ArrayList<RelationCheckBox> relationList = new ArrayList<>(relRdButton);
		final ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(455, 200);
		panel.setLayout(null);
		
		JButton btnTest = new JButton("Test");
		btnTest.setBounds(295, 160, 80, 25);
		panel.add(btnTest);
		
		final JTextField txtResult = new JTextField();
		txtResult.setBounds(80, 160, 200, 25);
		panel.add(txtResult);
		txtResult.setColumns(10);
		txtResult.setEditable(false);
		
		JLabel lblResultado = new JLabel("Resultado: ");
		lblResultado.setBounds(10, 160, 65, 25);
		panel.add(lblResultado);
		
		final JLabel info = new JLabel();
		info.setBounds(10, 130, 600, 25);
		panel.add(info);
	
		
		for (int i = 0; i < attrList.size(); i++) {
			JCheckBox attrChkBox = new JCheckBox(attrList.get(i).toString()); 
			attrChkBox.setBounds(10 + i * 55, 10, 50, 20);
			aList.add(attrChkBox);
			panel.add(attrChkBox);
		}
		
		for (int i = 0; i < relationList.size(); i++) {
			
			JSeparator sep = new JSeparator();
			sep.setBounds(0, 129 + 90 *i, 850, 1);
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

		btnTest.addActionListener(new ActionListener() {
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
						r1.setName(rel.getRelation().getName());
						rdGroup.clearSelection();
					}	
				}
				
				info.setText("Conjunto de Atributos " + '"' +attrJoint.toString() + '"' + " en " + '"' + r1.getName() + '"');
				
				switch (attrJoint.isKey(r1)) {
				case -1:
					txtResult.setForeground(Color.RED);
					txtResult.setText("No es clave");
					break;
				case 1:
					txtResult.setForeground(Color.GREEN);
					txtResult.setText("Es clave");
					break;
				default:
					txtResult.setForeground(Color.ORANGE);
					txtResult.setText("Es Superclave, pero no es m\u00EDnima");
					break;
				}	
			}
		});

		getContentPane().add(panel);
		
	}

}
