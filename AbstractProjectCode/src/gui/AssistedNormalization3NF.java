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

import datastructures.Relation;
import datastructures.dependency.ADependency;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssistedNormalization3NF extends JDialog {
	private JPanel panel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JTextArea textArea = new JTextArea();
	private JLabel lblNewLabel = new JLabel("Resultado:");
	private JButton btnNewButton = new JButton("Siguiente");
	private JButton newButton = new JButton("Siguiente");
	private ArrayList<Relation> norm = new ArrayList<>();
	private ArrayList<DepCheckBox> depBoxList = new ArrayList<>();
	private ArrayList<ADependency> depList = new ArrayList<>();
	private Relation r1 = new Relation();
	int j = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AssistedNormalization3NF(ArrayList<RelationCheckBox> relList) {
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(null);

		final ArrayList<RelationCheckBox> rList = new ArrayList<>(relList);
		
		ButtonGroup rdGroup = new ButtonGroup();
		
		panel = new JPanel();
		panel.setLocation(0, 0);
		panel.setSize(584, 350);
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
		
		bottomPanel = new JPanel();
		bottomPanel.setLocation(0, 350);
		bottomPanel.setSize(584, 212);
		bottomPanel.setLayout(null);
		
		getContentPane().add(bottomPanel);
		
		textArea = new JTextArea();
		textArea.setBounds(90, 10, 368, 190);
		textArea.setEditable(false);
		bottomPanel.add(textArea);
		
		lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 80, 25);
		bottomPanel.add(lblNewLabel);
		
		btnNewButton = new JButton("Siguiente");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (RelationCheckBox rChBox : rList) {
					if (rChBox.getRdButton().isSelected()) {
						r1 = rChBox.getRelation();
					}
				}
				
				bottomPanel.remove(btnNewButton);
				bottomPanel.add(newButton);
				bottomPanel.repaint();
				
				norm.add(r1);
				nextPanel();
			}
		});
		btnNewButton.setBounds(470, 10, 90, 25);
		bottomPanel.add(btnNewButton);
		
		newButton = new JButton("Siguiente");
		newButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		newButton.setBounds(btnNewButton.getBounds());
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DepCheckBox dep = new DepCheckBox();
				
				ArrayList<Relation> result = new ArrayList<>();
				
				for (DepCheckBox dpBpx : depBoxList) {
					if (dpBpx.getRdButton().isSelected())
						dep = dpBpx;
				}

				result = r1.split(depList.get(dep.getPosition()));
				
				for (int i = 0; i < result.size(); i++) {
					r1 = result.get(i);
					if (!r1.is3NF()) {
						nextPanel();
					} else {
						j = j + 1;
						textArea.append("R" + j + ": " + '\n');
						textArea.append(r1.getAttrJoint().toString() + '\n' + r1.getDFJoint().toString() + '\n');
						if (i == 1) {
							JLabel finish = new JLabel("El proceso de normalizaci\u00F3n se ha acabado.");
							finish.setBounds(20,  20, 400, 25);
							panel.removeAll();
							newButton.setEnabled(false);
							panel.add(finish);
							panel.repaint();
						}
					}
				}
			}
		});
		
	}
	
	public void nextPanel() {
		panel.removeAll();
		panel.repaint();
		
		depBoxList = new ArrayList<>();
		ButtonGroup rdGroup = new ButtonGroup();
		
		depList = r1.getNon3NF_DFs();
		
		if (depList.size() != 0) {
			for (int i = 0; i < depList.size(); i++) {
				DepCheckBox dep = new DepCheckBox(i, depList.get(i));
				dep.getRdButton().setBounds(10, 10+i*25, 200, 25);
				rdGroup.add(dep.getRdButton());
				panel.add(dep.getRdButton());
				depBoxList.add(dep);
				panel.repaint();
			}
		} else {
			JLabel finish = new JLabel("El proceso de normalizaci\u00F3n se ha acabado.");
			finish.setBounds(20,  20, 400, 25);
			btnNewButton.setEnabled(false);
			panel.add(finish);
		}		
	}
}
