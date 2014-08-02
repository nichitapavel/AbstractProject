package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.LayoutManager;
import java.util.ArrayList;

import javax.swing.JTextField;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;
import datastructures.dependency.PluralDependency;

import javax.swing.JTextPane;

import java.awt.Font;
import java.awt.ComponentOrientation;

import javax.swing.JButton;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Panel;
import java.awt.BorderLayout;

public class MainWindow {

	private ArrayList<Attribute> attributes;
	private ArrayList<ADependency> dependencys;
	private ArrayList<JCheckBox> antecedentChckBox;
	private ArrayList<JCheckBox> consecuentChckBox;
	int i = 0;
	
	private JFrame frmTFG;
	private JTextField txtAttribute;
	private JButton btnaddAttribute;
	private final JPanel panelDep = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frmTFG.pack();
					window.frmTFG.setVisible(true);
					window.attributes = new ArrayList<>();
					window.antecedentChckBox = new ArrayList<JCheckBox>();
					window.consecuentChckBox = new ArrayList<JCheckBox>();
					window.dependencys = new ArrayList<ADependency>();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		frmTFG = new JFrame();
		initialize(frmTFG);		
	}

	/**
	 * Initialize the contents of the frame.
	 * @param frmTFG TODO
	 */
	private void initialize(final JFrame frmTFG) {
		frmTFG.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmTFG.setTitle("DBN&U");
		frmTFG.setBackground(new Color(240, 240, 240));
		frmTFG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JPanel panelAttr = new JPanel();
		
		txtAttribute = new JTextField();		
		txtAttribute.setBounds(75, 10, 140, 25);
		txtAttribute.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!txtAttribute.getText().isEmpty())
					btnaddAttribute.setEnabled(true);
				else
					btnaddAttribute.setEnabled(false);
			}
		});
		txtAttribute.setToolTipText("Escribe el Atributo");
		txtAttribute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAttribute.setColumns(10);
		
		/*final JList list = new JList();
		list.setBounds(30, 100, 200, 39);
		jPanel.add(list);*/
		
		btnaddAttribute = new JButton("A\u00F1adir Atributo");
		btnaddAttribute.setBounds(220, 10, 150, 25);
		btnaddAttribute.setEnabled(false);
		btnaddAttribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int width = 130;
				
				Attribute attr = new Attribute(txtAttribute.getText());
				
				if (!attributes.contains(attr)) {
					attributes.add(attr);
					JCheckBox anteChkBox = new JCheckBox(attr.toString()); 
					anteChkBox.setBounds(width + i * 55, 50, 50, 20);				
					antecedentChckBox.add(anteChkBox);
					
					JCheckBox consChkBox = new JCheckBox(attr.toString());
					consChkBox.setBounds(width + i * 55, 70, 50, 20);
					consecuentChckBox.add(consChkBox);
					
					panelAttr.add(anteChkBox);
					panelAttr.add(consChkBox);
					panelAttr.repaint();
					
					i++;
				}
				else {
					JOptionPane.showMessageDialog(frmTFG, 
							"El attributo \"" + attr + "\" ya existe!", 
							"Duplicidad de Atributos", 
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				btnaddAttribute.setEnabled(false);
				txtAttribute.setText(null);
				txtAttribute.requestFocus(true);
			}
		});
		
		MenuBar menuBar = new MenuBar();
		frmTFG.setJMenuBar(menuBar.getMenuBar());
		
		JLabel lblAntecendente = new JLabel("Antecendente :");
		lblAntecendente.setBounds(10, 50, 100, 20);
		lblAntecendente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblConsecuente = new JLabel("Consecuente  :");
		lblConsecuente.setBounds(10, 70, 100, 20);
		lblConsecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAddFuncDep = new JButton("A\u00F1adir Dependencia Funcional");
		btnAddFuncDep.setBounds(110, 100, 250, 25);
		btnAddFuncDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttributeJoint antecendent = new AttributeJoint();
				AttributeJoint consecuent = new AttributeJoint();
				for (JCheckBox chkBoxAttr : antecedentChckBox)
					if (chkBoxAttr.isSelected()) {
						antecendent.addAttributes(new Attribute(chkBoxAttr.getText()));
						chkBoxAttr.setSelected(false);
					}
				
				for (JCheckBox chkBoxAttr : consecuentChckBox)
					if (chkBoxAttr.isSelected()) {
						consecuent.addAttributes(new Attribute(chkBoxAttr.getText()));
						chkBoxAttr.setSelected(false);
					}
				
				dependencys.add(new FunctionalDependency(antecendent, consecuent));
			}
		});
		
		JButton btnAddPlurDep = new JButton("A\u00F1adir Dependencia Plural");
		btnAddPlurDep.setBounds(380, 100, 250, 25);
		btnAddPlurDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttributeJoint antecendent = new AttributeJoint();
				AttributeJoint consecuent = new AttributeJoint();
				for (JCheckBox chkBoxAttr : antecedentChckBox)
					if (chkBoxAttr.isSelected()) {
						antecendent.addAttributes(new Attribute(chkBoxAttr.getText()));
						chkBoxAttr.setSelected(false);
					}
				
				for (JCheckBox chkBoxAttr : consecuentChckBox)
					if (chkBoxAttr.isSelected()) {
						consecuent.addAttributes(new Attribute(chkBoxAttr.getText()));
						chkBoxAttr.setSelected(false);
					}
				
				dependencys.add(new PluralDependency(antecendent, consecuent));
			}
		});

		JTextPane txtpnAtributo = new JTextPane();
		txtpnAtributo.setBounds(10, 10, 60, 25);
		txtpnAtributo.setEditable(false);
		txtpnAtributo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnAtributo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnAtributo.setBackground(new Color(240, 240, 240));
		txtpnAtributo.setText("Atributo:");
		
		panelAttr.setLayout(null);
		panelAttr.add(txtpnAtributo);
		panelAttr.add(txtAttribute);
		panelAttr.add(btnaddAttribute);
		panelAttr.add(lblAntecendente);
		panelAttr.add(lblConsecuente);
		panelAttr.add(btnAddFuncDep);
		panelAttr.add(btnAddPlurDep);
		
		frmTFG.getContentPane().add(panelAttr);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 150, 1920, 1);
		panelAttr.add(separator);
		
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(10, 178, 97, 23);
		panelDep.setBounds(0, 163, 434, 66);
		panelAttr.add(panelDep);
		
		panelDep.add(chckbxNewCheckBox);
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTFG;
	}
}
