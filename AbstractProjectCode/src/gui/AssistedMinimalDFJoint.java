package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import datastructures.DFJoint;
import datastructures.RareElement;

public class AssistedMinimalDFJoint extends JDialog {
	private JPanel panel = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JTextArea textArea = new JTextArea();
	private JLabel lblNewLabel = new JLabel("Resultado:");
	private JButton btnNewButton = new JButton("Siguiente");
	private JButton newButton = new JButton("Siguiente");
	private DFJoint dfJoint = new DFJoint();
	private ArrayList<RareCheckBox> rareList = new ArrayList<>();
	private ArrayList<RareElement> depList = new ArrayList<>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the dialog.
	 */
	public AssistedMinimalDFJoint(final ArrayList<DFJointCheckBox> dfJList) {
		setTitle("Recubrimiento m\u00EDnimo asisitido");
		setBounds(100, 100, 600, 300);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 584, 220);
		panel.setLayout(null);
		
		ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < dfJList.size(); i++) {
			DFJointCheckBox rd = dfJList.get(i);
			
			rd.getRdButton2().setBounds(10, 10 + i * 25, 1080, 25);
			
			panel.add(rd.getRdButton2());
			rdGroup.add(rd.getRdButton2());
		}
		
		getContentPane().add(panel);
		
		bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 220, 584, 43);
		bottomPanel.setLayout(null);
		
		getContentPane().add(bottomPanel);
		
		lblNewLabel = new JLabel("Resultado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 80, 25);
		bottomPanel.add(lblNewLabel);
		
		
		textArea = new JTextArea();
		textArea.setBounds(100, 10, 347, 25);
		textArea.setEditable(false);
		bottomPanel.add(textArea);
		
		btnNewButton = new JButton("Siguiente");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for (DFJointCheckBox df : dfJList) {
					if (df.getRdButton2().isSelected())
						dfJoint = new DFJoint(df.getDfJoint());
				}
				
				bottomPanel.remove(btnNewButton);
				bottomPanel.add(newButton);
				bottomPanel.repaint();
				
				nextPanel();
			}
		});
		btnNewButton.setBounds(470, 10, 100, 25);
		bottomPanel.add(btnNewButton);
		
		newButton.setBounds(btnNewButton.getBounds());
		newButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RareCheckBox dep = new RareCheckBox();
				
				for (RareCheckBox dpBpx : rareList) {
					if (dpBpx.getRdButton().isSelected())
						dep = dpBpx;
				}
				
				dfJoint.removeAttribute(depList.get(dep.getPosition()));
				textArea.setText(dfJoint.getDFJoint().toString());
				nextPanel();
				
			}
		});
	}

	public void nextPanel() {
		panel.removeAll();
		panel.repaint();
		
		dfJoint.regroupDFJoint();
		
		depList = dfJoint.findRareAttributes();
		rareList = new ArrayList<>();		
		
		ButtonGroup rdGroup = new ButtonGroup();
		
		if (depList.size() != 0) {
			for (int i = 0; i < depList.size(); i++) {
				RareCheckBox rareChckBox = new RareCheckBox(i, depList.get(i).getAttribute(), depList.get(i).getFD());
				rareChckBox.getRdButton().setBounds(10, 10 + i * 25, 584, 25);
				rdGroup.add(rareChckBox.getRdButton());
				rareList.add(rareChckBox);
				panel.add(rareChckBox.getRdButton());
			}
		} else {
			JLabel finish = new JLabel("El conjunto de dependencias es m\u00EDnimo.");
			finish.setFont(new Font("Tahoma", Font.BOLD, 14));
			finish.setBounds(20,  20, 400, 25);
			panel.removeAll();
			newButton.setEnabled(false);
			panel.add(finish);
			panel.repaint();
			textArea.setText(dfJoint.getDFJoint().toString());
		}
			
		panel.repaint();
	}
}
