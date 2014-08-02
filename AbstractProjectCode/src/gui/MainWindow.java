package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
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
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JEditorPane;

public class MainWindow {

	private ArrayList<Attribute> attributes;
	private ArrayList<ADependency> dependencys;
	private ArrayList<JCheckBox> antecedentChckBox;
	private ArrayList<JCheckBox> consecuentChckBox;
	int i = 0;
	
	private JFrame frmTFG;
	private JTextField txtAttribute;
	private JButton btnaddAttribute;

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
				
		Container jPanel = frmTFG.getContentPane();
		jPanel.setLayout(null);
		
		txtAttribute = new JTextField();		
		txtAttribute.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!txtAttribute.getText().isEmpty())
					btnaddAttribute.setEnabled(true);
				else
					btnaddAttribute.setEnabled(false);
			}
		});

		txtAttribute.setBounds(105, 35, 200, 30);
		txtAttribute.setToolTipText("Escribe el Atributo");
		txtAttribute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jPanel.add(txtAttribute);
		txtAttribute.setColumns(10);
		
		JTextPane txtpnAtributo = new JTextPane();
		txtpnAtributo.setBounds(20, 40, 80, 30);
		txtpnAtributo.setEditable(false);
		txtpnAtributo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnAtributo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnAtributo.setBackground(new Color(240, 240, 240));
		txtpnAtributo.setText("Atributo:");
		jPanel.add(txtpnAtributo);
		
		/*final JList list = new JList();
		list.setBounds(30, 100, 200, 39);
		jPanel.add(list);*/
		
		btnaddAttribute = new JButton("A\u00F1adir Atributo");
		btnaddAttribute.setBounds(325, 35, 125, 30);
		btnaddAttribute.setEnabled(false);
		btnaddAttribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int width = 130;
				
				Attribute attr = new Attribute(txtAttribute.getText());
				
				if (!attributes.contains(attr)) {
					attributes.add(attr);
					JCheckBox anteChkBox = new JCheckBox(attr.toString()); 
					anteChkBox.setBounds(width + i * 55, 90, 50, 20);
					
					anteChkBox.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
						}
					});
					
					antecedentChckBox.add(anteChkBox);
					
					JCheckBox consChkBox = new JCheckBox(attr.toString());
					consChkBox.setBounds(width + i * 55, 115, 50, 20);
					consecuentChckBox.add(consChkBox);
					
					frmTFG.getContentPane().add(anteChkBox);
					frmTFG.getContentPane().add(consChkBox);
					frmTFG.repaint();
					
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
		jPanel.add(btnaddAttribute);
		
		MenuBar menuBar = new MenuBar();
		frmTFG.setJMenuBar(menuBar.getMenuBar());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 180, 1920, 1);
		jPanel.add(separator);
		
		JLabel lblAntecendente = new JLabel("Antecendente :");
		lblAntecendente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAntecendente.setBounds(20, 90, 100, 20);
		frmTFG.getContentPane().add(lblAntecendente);
		
		JLabel lblConsecuente = new JLabel("Consecuente  :");
		lblConsecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConsecuente.setBounds(20, 115, 100, 20);
		frmTFG.getContentPane().add(lblConsecuente);
		
		JButton btnAddFuncDep = new JButton("A\u00F1adir Dependencia Funcional");
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
		btnAddFuncDep.setBounds(140, 140, 200, 30);
		frmTFG.getContentPane().add(btnAddFuncDep);
		
		JButton btnAddPlurDep = new JButton("A\u00F1adir Dependencia Plural");
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
		btnAddPlurDep.setBounds(373, 140, 200, 30);
		frmTFG.getContentPane().add(btnAddPlurDep);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(20, 198, 97, 23);
		frmTFG.getContentPane().add(chckbxNewCheckBox);
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTFG;
	}
}
