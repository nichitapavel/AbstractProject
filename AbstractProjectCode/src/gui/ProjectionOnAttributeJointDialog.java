package gui;

import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;

import datastructures.AttributeJoint;
import datastructures.DFJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JTextArea;

public class ProjectionOnAttributeJointDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public ProjectionOnAttributeJointDialog(final ArrayList<DFJointCheckBox> dfList) {
		setTitle("Proyecci\u00F3n sobre una dependencia funcional");
		setBounds(100, 100, 554, 268);
		getContentPane().setLayout(null);
		
		JPanel panelDF = new JPanel();
		panelDF.setLayout(null);
		panelDF.setBounds(0, 0, 370, 100);
		getContentPane().add(panelDF);
		
		final JPanel paneldf = new JPanel();
		paneldf.setBounds(370, 0, 168, 100);
		getContentPane().add(paneldf);
		
		
		JPanel panelResult = new JPanel();
		panelResult.setLayout(null);
		panelResult.setBounds(0, 99, 538, 130);
		getContentPane().add(panelResult);
		
		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(10, 30, 70, 25);
		panelResult.add(lblResultado);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 65, 90, 25);
		panelResult.add(btnNewButton);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(110, 30, 424, 95);
		panelResult.add(textArea);
		
		final JLabel info = new JLabel("");
		info.setBounds(10, 5, 400, 25);
		panelResult.add(info);
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		final ButtonGroup rdGroupdf = new ButtonGroup();
		
		final ArrayList<DepCheckBox> dfs = new ArrayList<>();

		final DFJoint dfJoint = new DFJoint();
		
		for (int i = 0; i < dfList.size(); i++) {
			final DFJointCheckBox rd = dfList.get(i);
			
			rd.getRdButton2().setBounds(10, 10 + i * 25, 360, 25);
			rd.getRdButton2().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (rd.getRdButton2().isSelected()) {
						paneldf.removeAll();
						dfs.clear();
						
						for (DFJointCheckBox dfJ : dfList) {
							if (dfJ.getRdButton2().isSelected()) {
								dfJoint.setDFJoint(dfJ.getDfJoint().getDFJoint());
								dfJoint.setName(dfJ.getDfJoint().getName());
							}
								
						}
						
						for (int i = 0; i < dfJoint.getSize(); i++) {
							ADependency df = dfJoint.getDF(i);
							if (df.getClass() == new FunctionalDependency().getClass()){
								DepCheckBox dfRdButton = new DepCheckBox(i, df);
								dfRdButton.getRdButton().setBounds(10, 10+ i* 25, 100, 25);
								paneldf.add(dfRdButton.getRdButton());
								rdGroupdf.add(dfRdButton.getRdButton());
								dfs.add(dfRdButton);
							}
						}
						
						paneldf.repaint();
					}
						
				}
			});
			
			
			panelDF.add(rd.getRdButton2());
			rdGroup.add(rd.getRdButton2());
		}
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ADependency df = new FunctionalDependency();
				
				for (DepCheckBox dep : dfs) {
					if (dep.getRdButton().isSelected())
						df = dep.getDP();
				}
				
				rdGroup.clearSelection();
				
				paneldf.removeAll();
				paneldf.repaint();
				textArea.setText(null);
				
				DFJoint dfJoint_Res = dfJoint.projectionOnAttributeJoint(df.getAttributeJoint());
				
				textArea.append(dfJoint.getName() + "_A" + '\n');
				textArea.append("   " + dfJoint_Res.toString());
				
				AttributeJoint aux = dfJoint.getAttributesDFJoint().substract(df.getConsequent());
				
				dfJoint_Res = dfJoint.projectionOnAttributeJoint(aux);
				
				textArea.append('\n' + dfJoint.getName() + "_B" + '\n');
				textArea.append("   " + dfJoint_Res.toString());
				
				rdGroupdf.clearSelection();
				
				info.setText("Proyecci\u00F3n de " + '"' + dfJoint.getName() + '"' + " sobre " + '"' + df + '"');
			}
		});
	}
}
