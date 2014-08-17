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

public class AssistedNormalization extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AssistedNormalization(ArrayList<RelationCheckBox> relList) {
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);

		final ArrayList<RelationCheckBox> rList = new ArrayList<>(relList);
		
		ButtonGroup rdGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(584, 561);
		panel.setLayout(null);
		
		getContentPane().add(panel);
		
		
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
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(90, 450, 368, 110);
		panel.add(textArea);
		
		JLabel lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setBounds(10, 450, 60, 25);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Siguiente");
		btnNewButton.setBounds(470, 450, 90, 25);
		panel.add(btnNewButton);
	}
}
