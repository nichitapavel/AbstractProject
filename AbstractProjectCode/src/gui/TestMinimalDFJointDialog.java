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
		setTitle("Comprobar recubrimiento m\u00EDnimo");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		final ArrayList<DFJointCheckBox> dfJList = new ArrayList<DFJointCheckBox>(dfJointList);
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
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
		
		final JLabel info = new JLabel("");
		info.setBounds(10, 190, 400, 25);
		panel.add(info);
		
		JButton btnCalcular = new JButton("Test");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DFJoint dfJoint = new DFJoint();
				for (DFJointCheckBox dfRd : dfJList) {
					if (dfRd.getRdButton2().isSelected()) {
						dfJoint = new DFJoint(dfRd.getDfJoint());
					}	
				}
				
				rdGroup.clearSelection();
				
				if (dfJoint.isMinimal()) {
					txtResult.setForeground(Color.GREEN);
					txtResult.setText("Es m\u00EDnimo");
				}
				else {
					txtResult.setForeground(Color.RED);
					txtResult.setText("No es m\u00EDnimo");
				}
					
				info.setText("Es m\u00EDnimo " + '"' + dfJoint.getName() + '"');
			}
		});
		btnCalcular.setBounds(300, 220, 90, 25);
		panel.add(btnCalcular);
		
		for (int i = 0; i < dfJList.size(); i++) {
			dfJList.get(i).getRdButton2().setBounds(10, 10 + i * 25, 1080, 25);
			
			panel.add(dfJList.get(i).getRdButton2());
			rdGroup.add(dfJList.get(i).getRdButton2());
		}
	}

}
