package gui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import datastructures.DFJoint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestMinimalDFJointDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public TestMinimalDFJointDialog(ArrayList<DFJointCheckBox> dfJointList) {
		setBounds(100, 100, 450, 300);

		final ArrayList<DFJointCheckBox> dfJList = new ArrayList<>(dfJointList);
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(434, 261);
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < dfJList.size(); i++) {
			DFJointCheckBox rd = dfJList.get(i);
			
			rd.getRdButton().setBounds(10, 10 + i * 25, 1080, 25);
			
			panel.add(rd.getRdButton());
			rdGroup.add(rd.getRdButton());
		}
		
		
		getContentPane().setLayout(null);
		
		getContentPane().add(panel);
		
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
		
		JButton btnCalcular = new JButton("Test");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DFJoint dfJoint = new DFJoint();
				for (DFJointCheckBox dfRd : dfJList) {
					if (dfRd.getRdButton().isSelected()) {
						dfJoint = new DFJoint(dfRd.getDfJoint());
					}	
				}
				
				if (dfJoint.isMinimal()) {
					txtResult.setForeground(Color.GREEN);
					txtResult.setText("Es m\u00EDnimo");
				}
				else {
					txtResult.setForeground(Color.RED);
					txtResult.setText("No es m\u00EDnimo");
				}
					
				
			}
		});
		btnCalcular.setBounds(300, 220, 90, 25);
		panel.add(btnCalcular);
		
	}

}
