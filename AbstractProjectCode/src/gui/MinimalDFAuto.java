package gui;

import java.awt.Font;
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

public class MinimalDFAuto extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public MinimalDFAuto(ArrayList<DFJointCheckBox> dfJointList) {
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);
		
		final ArrayList<DFJointCheckBox> dfJList = new ArrayList<>(dfJointList);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 584, 261);
		panel.setLayout(null);
		
		ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < dfJList.size(); i++) {
			DFJointCheckBox rd = dfJList.get(i);
			
			rd.getRdButton2().setBounds(10, 10 + i * 25, 1080, 25);
			
			panel.add(rd.getRdButton2());
			rdGroup.add(rd.getRdButton2());
		}
		
		getContentPane().add(panel);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 230, 584, 30);
		panel.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 195, 80, 25);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DFJoint dfJoint = new DFJoint();
				
				for (DFJointCheckBox df : dfJList) {
					if (df.getRdButton2().isSelected())
						dfJoint = new DFJoint(df.getDfJoint());
				}
				
				dfJoint.removeRareAttributes(true);
				
				textArea.setText(dfJoint.toString());
			}
		});
		btnNewButton.setBounds(470, 195, 100, 25);
		panel.add(btnNewButton);

	}

}
