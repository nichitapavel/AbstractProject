package gui;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;

import datastructures.Relation;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestNormalFormDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField result;

	public TestNormalFormDialog(ArrayList<RelationCheckBox> relChckBox, final int operation) {
		switch (operation) {
			case 1:
				setTitle("Comprobar 2FN");
				break;
			case 2:
				setTitle("Comprobar 3FN");
				break;
			case 3:
				setTitle("Comprobar FNBC");
				break;
			case 4:
				setTitle("Comprobar 4FN");
				break;
			default:
				setTitle("Detectar forma normal");
				break;
		}
		setBounds(100, 100, 450, 242);
		getContentPane().setLayout(null);
		
		final ArrayList<RelationCheckBox> relationList = new ArrayList<>(relChckBox);
		
		
		JPanel panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(784, 203);
		panel.setLayout(null);
		
		JButton btnTest = new JButton("Test");
		btnTest.setBounds(245, 150, 80, 25);
		panel.add(btnTest);
		
		result = new JTextField();
		result.setBounds(80, 150, 150, 25);
		panel.add(result);
		result.setColumns(10);
		result.setEditable(false);
		
		JLabel lblResultado = new JLabel("Resultado: ");
		lblResultado.setBounds(10, 150, 65, 25);
		panel.add(lblResultado);
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < relationList.size(); i++) {
			
			JSeparator sep = new JSeparator();
			sep.setBounds(0, 89 + 90 *i, 850, 1);
			sep.setForeground(Color.BLACK);
			
			relationList.get(i).getRdButton().setBounds(5, 5+90*i, 450, 25);
			
			JLabel attrJoint = new JLabel("Atributos: " + relationList.get(i).getRelation().getAttrJoint().toString());
			attrJoint.setBounds(5, 30 + 90*i, 450, 20);
			attrJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			JLabel dfJoint = new JLabel("Dependencias: " + relationList.get(i).getRelation().getDFJoint().toString());
			dfJoint.setBounds(5, 55 + 90 * i, 450, 20);
			dfJoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
			
			panel.add(sep);
			panel.add(relationList.get(i).getRdButton());
			panel.add(attrJoint);
			panel.add(dfJoint);

			
			rdGroup.add(relationList.get(i).getRdButton());
		}
		
		getContentPane().add(panel);
		
		final JLabel info = new JLabel("");
		info.setBounds(10, 120, 400, 25);
		panel.add(info);
		
		
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relation r1 = new Relation();
				for (RelationCheckBox rChBox : relationList) {
					if (rChBox.getRdButton().isSelected()) {
						r1 = rChBox.getRelation();
					}
				}
				
				
				switch (operation) {
				case 1:
					if (r1.is2NF()){
						result.setForeground(Color.GREEN);
						result.setText("Es 2FN");
					}
					else{
						result.setForeground(Color.RED);
						result.setText("No es 2FN");
					}
					break;
				case 2:
					if (r1.is3NF()){
						result.setForeground(Color.GREEN);
						result.setText("Es 3FN");
					}
					else{
						result.setForeground(Color.RED);
						result.setText("No es 3FN");
					}
					break;
				case 3:
					if (r1.isBCNF()){
						result.setForeground(Color.GREEN);
						result.setText("Es Boyce Codd FN");
					}
					else{
						result.setForeground(Color.RED);
						result.setText("No es Boyce Codd FN");
					}
					break;
				case 4:
					if (r1.is4NF()){
						result.setForeground(Color.GREEN);
						result.setText("Es 4FN");
					}
					else{
						result.setForeground(Color.RED);
						result.setText("No es 4FN");
					}
					break;
				default:
					result.setForeground(Color.BLACK);
					result.setText(r1.getNormalForm());
					break;
				}
				
				rdGroup.clearSelection();
				
				info.setText("Relaci\u00F3n " + '"' + r1.getName() + '"');
			}
		});
	}
}
