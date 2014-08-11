package gui;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;

import javax.swing.JButton;
import javax.swing.JTextArea;

import normalization.Normalization;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;

public class Ullman extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
	}

	/**
	 * Create the dialog.
	 */
	public Ullman(ArrayList<Attribute> attrList, ArrayList<DFJointCheckBox> dfJointList) {
		setBounds(100, 100, 450, 300);
		
		final ArrayList<JCheckBox> attrChckBoxList = new ArrayList<JCheckBox>();
		final ButtonGroup rdGroup = new ButtonGroup();
		final ArrayList<DFJointCheckBox> list = new ArrayList<DFJointCheckBox>(dfJointList);
		
		JPanel panelAttr = new JPanel();
		panelAttr.setLocation(0, 0);
		panelAttr.setSize(434, 261);
		
		for (int i = 0; i < attrList.size(); i++) {
			JCheckBox attrChkBox = new JCheckBox(attrList.get(i).toString()); 
			attrChkBox.setBounds(10 + i * 55, 10, 50, 20);
			attrChckBoxList.add(attrChkBox);
			panelAttr.add(attrChkBox);
		}
		
		for (int i = 0; i < list.size(); i++) {
			DFJointCheckBox rd = list.get(i);
			
			rd.getRdButton().setBounds(10, 40 + i * 25, 1080, 25);
			
			panelAttr.add(rd.getRdButton());
			rdGroup.add(rd.getRdButton());
		}
		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(panelAttr);
		
		panelAttr.setLayout(null);
		
		final JTextArea txtResult = new JTextArea();
		txtResult.setMargin(new Insets(2, 5, 2, 2));
		txtResult.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtResult.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtResult.setEditable(false);
		txtResult.setBounds(70, 220, 220, 25);
		panelAttr.add(txtResult);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setBounds(10, 220, 60, 25);
		panelAttr.add(lblNewLabel);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttributeJoint attrJoint = new AttributeJoint();
				DFJoint dfJoint = new DFJoint();
				
				for (JCheckBox box : attrChckBoxList) {
					if (box.isSelected())
						attrJoint.addAttributes(new Attribute(box.getText()));
						box.setSelected(false);
				}
				
				for (DFJointCheckBox dfRd : list) {
					if (dfRd.getRdButton().isSelected()) {
						dfJoint = new DFJoint(dfRd.getDfJoint());
						rdGroup.clearSelection();
					}	
				}
				
				AttributeJoint result = Normalization.simpleUllman(attrJoint, dfJoint);
				
				txtResult.setText(result.toString());
			}
		});

		btnCalcular.setBounds(300, 220, 90, 25);
		panelAttr.add(btnCalcular);
	}
}
