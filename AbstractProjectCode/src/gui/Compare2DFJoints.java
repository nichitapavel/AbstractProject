package gui;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JButton;

import datastructures.DFJoint;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Compare2DFJoints extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public Compare2DFJoints(final ArrayList<DFJointCheckBox> dfjointLists, final int operation) {
		switch (operation) {
		case 1:
			setTitle("Equivalencia entre 2 DF's");
			break;
		default:
			setTitle("DF A implica DF B");
			break;
		}
		setBounds(100, 100, 660, 179);
		getContentPane().setLayout(null);
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBounds(0, 0, 321, 80);
		panelLeft.setLayout(null);
		getContentPane().add(panelLeft);
		
				JSeparator sep = new JSeparator();
				sep.setBounds(320, 0, 1, 320);
				panelLeft.add(sep);
				sep.setRequestFocusEnabled(false);
				sep.setOrientation(SwingConstants.VERTICAL);
		
		JPanel panelRight = new JPanel();
		panelRight.setBounds(322, 0, 322, 80);
		panelRight.setLayout(null);
		getContentPane().add(panelRight);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 110, 70, 25);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(80, 110, 100, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setBounds(190, 110, 89, 25);
		getContentPane().add(btnNewButton);
		
		final JLabel info = new JLabel("");
		info.setBounds(10, 85, 400, 25);
		getContentPane().add(info);
		
		
		final ButtonGroup rdGroupLeft = new ButtonGroup();
		final ButtonGroup rdGroupRight = new ButtonGroup();
		
		for (int i = 0; i < dfjointLists.size(); i++) {
			dfjointLists.get(i).getRdButton2().setBounds(10, 10+i*25, 280, 25);
			panelLeft.add(dfjointLists.get(i).getRdButton2());
			rdGroupLeft.add(dfjointLists.get(i).getRdButton2());
			
			dfjointLists.get(i).getRdButton3().setBounds(10, 10+i*25, 290, 25);
			panelRight.add(dfjointLists.get(i).getRdButton3());
			rdGroupRight.add(dfjointLists.get(i).getRdButton3());
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DFJoint dfA = new DFJoint();
				DFJoint dfB = new DFJoint();
				
				for (DFJointCheckBox df : dfjointLists) {
					if (df.getRdButton2().isSelected()) {
						dfA = new DFJoint(df.getDfJoint());
						rdGroupLeft.clearSelection();
					}
				}
				
				
				for (DFJointCheckBox df : dfjointLists) {
					if (df.getRdButton3().isSelected()) {
						dfB = new DFJoint(df.getDfJoint());
						rdGroupRight.clearSelection();
					}
				}
				
				switch (operation) {
					case 1:
						info.setText('"' + dfA.getName() + '"' + " es equivalente a " + '"' + dfB.getName() + '"');
						if (dfA.isEquivalent(dfB, null)) {
							textField.setForeground(Color.GREEN);
							textField.setText("Equivalentes");
						} else {
							textField.setForeground(Color.RED);
							textField.setText("No equivalentes");
						}
						break;
					default:
						info.setText('"' + dfA.getName() + '"' + " implica a " + '"' + dfB.getName() + '"');
						if (dfA.isImplied(dfB, null)) {
							textField.setForeground(Color.GREEN);
							textField.setText("Implica");
						} else {
							textField.setForeground(Color.RED);
							textField.setText("No implica");
						}
						break;
					}				
				}
		});
	}
}
