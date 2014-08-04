package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JTextField;

import datastructures.Attribute;
import datastructures.AttributeJoint;
import datastructures.dependency.ADependency;
import datastructures.dependency.FunctionalDependency;
import datastructures.dependency.PluralDependency;

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
import java.awt.BorderLayout;

public class MainWindow {

	private ArrayList<Attribute> attributes;
	private ArrayList<ADependency> dependencys;
	private ArrayList<JCheckBox> antecedentChckBox;
	private ArrayList<JCheckBox> consecuentChckBox;
	int iAttr = 0;
	int iDep = 0;
	int panelDepSize = 100;
	
	private JFrame frmTFG;
	private JTextField txtAttribute;
	private JButton btnaddAttribute;
	
	//paneles
	JPanel panelAttr = new JPanel();
	JPanel panelDep = new JPanel();

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
		//Inicializar la ventana
		frmTFG.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmTFG.setTitle("DBN&U");
		frmTFG.setBackground(new Color(240, 240, 240));
		frmTFG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTFG.getContentPane().setLayout(null);
		
		//Poner la barra de menus
		MenuBar menuBar = new MenuBar();
		frmTFG.setJMenuBar(menuBar.getMenuBar());
		
		//inicializar el panel donde aparecen y se ven los attributos
		panelAttr.setSize(new Dimension(1920, 150));
		panelAttr.setLayout(null);
		
		//Los elementos del panel de Attributos
		JLabel txtpnAtributo = new JLabel();
		txtpnAtributo.setBounds(10, 10, 60, 25);
		txtpnAtributo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnAtributo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		//txtpnAtributo.setBackground(new Color(240, 240, 240));
		txtpnAtributo.setText("Atributo:");
		
		txtAttribute = new JTextField();		
		txtAttribute.setBounds(75, 10, 140, 25);
		txtAttribute.setToolTipText("Escribe el Atributo");
		txtAttribute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAttribute.setColumns(10);
		
		btnaddAttribute = new JButton("A\u00F1adir Atributo");
		btnaddAttribute.setBounds(220, 10, 150, 25);
		btnaddAttribute.setEnabled(false);
				
		JLabel lblAntecendente = new JLabel("Antecendente :");
		lblAntecendente.setBounds(10, 50, 100, 20);
		lblAntecendente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblConsecuente = new JLabel("Consecuente  :");
		lblConsecuente.setBounds(10, 70, 100, 20);
		lblConsecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAddFuncDep = new JButton("A\u00F1adir Dependencia Funcional");
		btnAddFuncDep.setBounds(110, 100, 250, 25);
				
		JButton btnAddPlurDep = new JButton("A\u00F1adir Dependencia Plural");
		btnAddPlurDep.setBounds(380, 100, 250, 25);

		//Anadiendo los elementos al panel de atributos
		panelAttr.add(txtpnAtributo);
		panelAttr.add(txtAttribute);
		panelAttr.add(btnaddAttribute);
		panelAttr.add(lblAntecendente);
		panelAttr.add(lblConsecuente);
		panelAttr.add(btnAddFuncDep);
		panelAttr.add(btnAddPlurDep);

		//añadiendo el panel de attributos a la ventana
		frmTFG.getContentPane().add(panelAttr, BorderLayout.CENTER);
		
		//evento para activar y desactivar el boton de anadir attributos
		txtAttribute.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(!txtAttribute.getText().isEmpty())
					btnaddAttribute.setEnabled(true);
				else
					btnaddAttribute.setEnabled(false);
			}
		});
		
		//evento al pulsar el boton de anadir attributos
		btnaddAttribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int width = 130;
				Attribute attr = new Attribute(txtAttribute.getText());
				
				if (!attributes.contains(attr)) {
					attributes.add(attr);
					JCheckBox anteChkBox = new JCheckBox(attr.toString()); 
					anteChkBox.setBounds(width + iAttr * 55, 50, 50, 20);				
					antecedentChckBox.add(anteChkBox);
					
					JCheckBox consChkBox = new JCheckBox(attr.toString());
					consChkBox.setBounds(width + iAttr * 55, 70, 50, 20);
					consecuentChckBox.add(consChkBox);
					
					panelAttr.add(anteChkBox);
					panelAttr.add(consChkBox);
					panelAttr.repaint();
					
					iAttr++;
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

		//evento al anadir una dependencia funcional
		btnAddFuncDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int height = 25;

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
				
				ADependency newDep = new FunctionalDependency(antecendent, consecuent);
				
				if (!dependencys.contains(newDep)) {
					dependencys.add(newDep);
					JCheckBox dfChkBox = new JCheckBox(newDep.toString()); 
					dfChkBox.setBounds(50, height + iDep * 25, 100, 20);				
					antecedentChckBox.add(dfChkBox);
					
					panelDep.add(dfChkBox);
					panelDep.setSize(new Dimension(1920, panelDepSize + height * iDep));
					panelDep.repaint();
					
					dependencys.add(new FunctionalDependency(antecendent, consecuent));
					
					iDep++;
				}
				else {
					JOptionPane.showMessageDialog(frmTFG, 
							"La dependencia funcional \"" + newDep + "\" ya existe!", 
							"Duplicidad de dependencias", 
							JOptionPane.INFORMATION_MESSAGE);
					newDep = null;
				}
			}
		});

		//evento al anadir una dependencias plural
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
		
		//inicializar el panel de las dependencias
		panelDep.setSize(new Dimension(1920, panelDepSize));
		panelDep.setLocation(0, 150);
		//panelDep.setBackground(new Color(150, 90, 200));
		panelDep.setLayout(null);
		
		//
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1920, 1);
		
		//
		panelDep.add(separator);
		
		//anadir el panel de dependencias a la ventana
		frmTFG.getContentPane().add(panelDep, BorderLayout.CENTER);
		
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTFG;
	}
}
