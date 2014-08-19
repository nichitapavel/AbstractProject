package gui;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;

import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CFJointClosed extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public CFJointClosed(final ArrayList<DFJointCheckBox> dfList, ArrayList<Attribute> aList) {
		setTitle("d.f. pertenece a DF");
		setBounds(100, 100, 550, 400);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 534, 361);
		getContentPane().add(panel);
		
		final ArrayList<JCheckBox> antecedentChckBox = new ArrayList<>();
		final ArrayList<JCheckBox> consecuentChckBox = new ArrayList<>();
		
		JLabel lblAntecendente = new JLabel("Antecendente :");
		lblAntecendente.setBounds(10, 10, 100, 20);
		lblAntecendente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblAntecendente);
		
		JLabel lblConsecuente = new JLabel("Consecuente  :");
		lblConsecuente.setBounds(10, 30, 100, 20);
		lblConsecuente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblConsecuente);
		
		JButton btnNewButton = new JButton("Comprobar");
		btnNewButton.setBounds(210, 330, 110, 25);
		panel.add(btnNewButton);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(100, 330, 86, 25);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 330, 70, 25);
		panel.add(lblNewLabel);
		
		final JLabel info = new JLabel("");
		info.setBounds(10, 300, 400, 25);
		panel.add(info);
		
		for (int i = 0; i < aList.size(); i++) {
			JCheckBox anteChkBox = new JCheckBox(aList.get(i).toString()); 
			anteChkBox.setBounds(130 + i * 55, 10, 50, 20);				
			antecedentChckBox.add(anteChkBox);
			
			JCheckBox consChkBox = new JCheckBox(aList.get(i).toString());
			consChkBox.setBounds(130 + i * 55, 30, 50, 20);
			consecuentChckBox.add(consChkBox);
			
			panel.add(anteChkBox);
			panel.add(consChkBox);
		}
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < dfList.size(); i++) {
			DFJointCheckBox rd = dfList.get(i);
			
			rd.getRdButton2().setBounds(10, 55 + i * 25, 1080, 25);
			
			panel.add(rd.getRdButton2());
			rdGroup.add(rd.getRdButton2());
		}
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttributeJoint antecedent = new AttributeJoint();
				AttributeJoint consequent = new AttributeJoint();
				
				for (JCheckBox attr : antecedentChckBox) {
					if (attr.isSelected()) {
						antecedent.addAttributes(new Attribute(attr.getText()));
						attr.setSelected(false);
					}
				}
				
				for (JCheckBox attr : consecuentChckBox) {
					if (attr.isSelected()) {
						consequent.addAttributes(new Attribute(attr.getText()));
						attr.setSelected(false);	
					}
				}
				
				ADependency df = new FunctionalDependency(antecedent, consequent);
				
				DFJoint dfJoint = new DFJoint();
				
				for (DFJointCheckBox dfJ : dfList) {
					if (dfJ.getRdButton2().isSelected())
						dfJoint = new DFJoint(dfJ.getDfJoint());
				}
				
				if (df.belongsTo(dfJoint, null)) {
					textField.setForeground(Color.GREEN);
					textField.setText("S\u00ED");
				}
				else {
					textField.setForeground(Color.RED);
					textField.setText("No");
				}
				
				rdGroup.clearSelection();
				
				info.setText("Dependencia funcional " + '"' + df + '"' + " en " + '"' + dfJoint.getName() + '"');
			}
		});
	}
}
