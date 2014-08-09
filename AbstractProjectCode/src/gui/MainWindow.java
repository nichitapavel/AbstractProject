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
import datastructures.DFJoint;
import datastructures.Relation;
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

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Rectangle;

public class MainWindow {

	private ArrayList<Attribute> attributes;
	private ArrayList<DepCheckBox> dependencysChckBox;
	private ArrayList<ADependency> dependencys;
	private ArrayList<JCheckBox> antecedentChckBox;
	private ArrayList<JCheckBox> consecuentChckBox;
	private ArrayList<JCheckBox> relationChckBox;
	private ArrayList<DFJointCheckBox> dfJointsChkcBox;
	private ArrayList<DFJoint> dfJoints;
	
	private ButtonGroup rdGroup;
	
	int iAttr = 0;
	int iDep = 0;
	int iDEP = 0;
	int panelDepSize = 75;
	int panelDEPSize = 100;
	
	private JFrame frmTFG;
	private JTextField txtAttribute;
	private JButton btnaddAttribute;
	
	//paneles
	JPanel panelAttr = new JPanel();
	JPanel panelDep = new JPanel();
	JPanel panelDEP = new JPanel();
	JPanel panelRel = new JPanel();

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
					window.relationChckBox = new ArrayList<JCheckBox>();
					window.dependencysChckBox = new ArrayList<DepCheckBox>();
					window.dependencys = new ArrayList<ADependency>();
					window.dfJointsChkcBox = new ArrayList<DFJointCheckBox>();
					window.dfJoints = new ArrayList<DFJoint>();
					window.rdGroup = new ButtonGroup();
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
		btnaddAttribute.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnaddAttribute.setBounds(220, 10, 150, 25);
		btnaddAttribute.setEnabled(false);
				
		JLabel lblAntecendente = new JLabel("Antecendente :");
		lblAntecendente.setBounds(10, 50, 100, 20);
		lblAntecendente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblConsecuente = new JLabel("Consecuente  :");
		lblConsecuente.setBounds(10, 70, 100, 20);
		lblConsecuente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnAddFuncDep = new JButton("A\u00F1adir Dependencia Funcional");
		btnAddFuncDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddFuncDep.setBounds(110, 100, 250, 25);
				
		JButton btnAddPlurDep = new JButton("A\u00F1adir Dependencia Plural");
		btnAddPlurDep.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
		
		/*
		 * eventos panel de atributos
		 */
		
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

					JCheckBox rltChkBox = new JCheckBox(attr.toString()); 
					rltChkBox.setBounds(15 + iAttr * 55, 40, 50, 20);
					relationChckBox.add(rltChkBox);
					
					panelDEP.add(rltChkBox);
					
					panelDEP.setSize(1920, 50 + 20);
					panelDEP.repaint();
					
					panelRel.setLocation(0, panelAttr.getHeight() + panelDep.getHeight() + panelDEP.getHeight());
					panelRel.repaint();
					
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
				int height = 40;

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
				
				ADependency dep = new FunctionalDependency(antecendent, consecuent);
				DepCheckBox depChckBox = new DepCheckBox(dependencysChckBox.size(), dep);
				
				if (!dependencys.contains(dep)) {
					depChckBox.getChckBox().setBounds(15, height + iDep * 25, 200, 20);				
					//antecedentChckBox.add(dfChkBox);
					
					panelDep.add(depChckBox.getChckBox());
					panelDep.setSize(new Dimension(1920, panelDepSize + 25 * iDep));
					panelDep.repaint();
					
					panelDEP.setLocation(0, 150 + panelDep.getHeight());
					panelDEP.repaint();
					
					panelRel.setLocation(0, 150 + panelDep.getHeight() + panelDEP.getHeight());
					panelRel.repaint();
					
					dependencys.add(dep);
					dependencysChckBox.add(depChckBox);
					
					iDep++;
				}
				else {
					JOptionPane.showMessageDialog(frmTFG, 
							"La dependencia funcional \"" + depChckBox.getDP() + "\" ya existe!", 
							"Duplicidad de dependencias", 
							JOptionPane.INFORMATION_MESSAGE);
					depChckBox = null;
				}
			}
		});

		//evento al anadir una dependencias plural
		btnAddPlurDep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int height = 40;
				
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
				
				ADependency dep = new PluralDependency(antecendent, consecuent);
				DepCheckBox depChckBox = new DepCheckBox(dependencysChckBox.size(), dep);
				
				if (!dependencys.contains(dep)) {
					depChckBox.getChckBox().setBounds(15, height + iDep * 25, 200, 20);				
					//antecedentChckBox.add(dfChkBox);
					
					panelDep.add(depChckBox.getChckBox());
					panelDep.setSize(new Dimension(1920, panelDepSize + 25 * iDep));
					panelDep.repaint();
					
					panelDEP.setLocation(0, 150 + panelDep.getHeight());
					panelDEP.repaint();
					
					panelRel.setLocation(0, 150 + panelDep.getHeight() + panelDEP.getHeight());
					panelRel.repaint();
					
					dependencys.add(dep);
					dependencysChckBox.add(depChckBox);
					
					iDep++;
				}
				else {
					JOptionPane.showMessageDialog(frmTFG, 
							"La dependencia plural \"" + depChckBox.getDP() + "\" ya existe!", 
							"Duplicidad de dependencias", 
							JOptionPane.INFORMATION_MESSAGE);
					depChckBox = null;
				}
			}
		});
		
		/*
		 * Panel de depencias
		 */
		
		//inicializar el panel de las dependencias
		panelDep.setSize(new Dimension(1920, 50));
		panelDep.setLocation(0, 150);
		//panelDep.setBackground(new Color(15, 90, 100));
		panelDep.setLayout(null);
		
		//creando los elementos del panel
		JSeparator separatorDep = new JSeparator();
		separatorDep.setBounds(0, 0, 1920, 1);
		
		JLabel lblNameDEP = new JLabel("Nombre Conjunto de Dependencias:");
		lblNameDEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameDEP.setBounds(10, 10, 230, 25);
		
		final JTextField txtNameDEP = new JTextField();
		txtNameDEP.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNameDEP.setBounds(240, 10, 140, 25);
		txtNameDEP.setColumns(10);
		
		JButton btnAddDEP = new JButton("A\u00F1adir Conjunto de Dependencias");
		btnAddDEP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddDEP.setBounds(385, 10, 270, 25);
		
		//añadiendo los elementos de panel de dependencias
		panelDep.add(lblNameDEP);		
		panelDep.add(txtNameDEP);
		panelDep.add(btnAddDEP);
		panelDep.add(separatorDep);
		
		//anadir el panel de dependencias a la ventana
		frmTFG.getContentPane().add(panelDep, BorderLayout.CENTER);
		
		/*
		 * eventos botones panel de dependencias
		 */
		
		//anadiendo conjuntos de dependencias
		btnAddDEP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int height = 65;
				
				DFJoint dfJoint = new DFJoint();
				dfJoint.setName(txtNameDEP.getText());
				
				for (DepCheckBox depChckBox : dependencysChckBox) {
					if (depChckBox.getChckBox().isSelected()) {
						dfJoint.addDependency(depChckBox.getDP());
						depChckBox.getChckBox().setSelected(false);
					}
				}
				
				if (!dfJoints.contains(dfJoint)) {
					txtNameDEP.setText(null);
					
					String name = dfJoint.getName() + ": ";
					if (dfJoint.getSize() != 0)
						name += dfJoint.getDFJoint();
					else
						name += "Sin dependencias funcionales";				
					
					DFJointCheckBox chckBox = new DFJointCheckBox(dfJoints.size(), dfJoint, name);
					chckBox.getRdButton().setBounds(15, height + iDEP * 25, 1080, 25);
									
					panelDEP.add(chckBox.getRdButton());
					panelDEP.setSize(1920, panelDEPSize + iDEP * 25);
					
					panelRel.setLocation(0, 150 + panelDep.getHeight() + panelDEP.getHeight());
					panelRel.repaint();
					
					dfJointsChkcBox.add(chckBox);
					rdGroup.add(chckBox.getRdButton());
					
					panelDEP.repaint();
					iDEP++;
				}
				else {
					JOptionPane.showMessageDialog(frmTFG, 
							"El conjunto de dependencias \"" + dfJoint + "\" ya existe!", 
							"Duplicidad de conjuntos de dependencias", 
							JOptionPane.INFORMATION_MESSAGE);
				}				
			}
		});
		
		/*
		 * Panel de Conjuntos de dependencias
		 */
		
		//inicializar el panel de los conjuntos de dependencias
		panelDEP.setSize(new Dimension(1920, 50));
		panelDEP.setLocation(0, 200);
		panelDEP.setLayout(null);
		
		//Creando los elementos de panel de conjunto depencias
		JSeparator separatorDEP = new JSeparator();
		separatorDEP.setBounds(0, 0, 1920, 1);	
		
		JLabel lblNameR = new JLabel("Nombre Relación:");
		lblNameR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNameR.setBounds(10, 10, 110, 25);
		
		final JTextField txtNameR = new JTextField();
		txtNameR.setBounds(125, 10, 140, 25);
		txtNameR.setColumns(10);
		
		JButton btnAddR = new JButton("Añadir Relación");
		btnAddR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddR.setBounds(270, 10, 140, 25);
		
		//añadiendo los elementos de panel de conjunto depencias
		panelDEP.add(separatorDEP);
		panelDEP.add(lblNameR);
		panelDEP.add(txtNameR);
		panelDEP.add(btnAddR);
		
		//anadir el panel de conjunto de dependencias a la ventana
		frmTFG.getContentPane().add(panelDEP, BorderLayout.CENTER);
		
		/*
		 * Evento de los botones del panel de conjunto de dependencias
		 */
		
		btnAddR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AttributeJoint relAttrJoint = new AttributeJoint(); 
				DFJoint dfJoint = new DFJoint();
				
				for (JCheckBox chckBox : relationChckBox) {
					if (chckBox.isSelected()) {
						relAttrJoint.addAttributes(new Attribute(chckBox.getText()));
						chckBox.setSelected(false);
					}
				}
				
				for (DFJointCheckBox dfRd : dfJointsChkcBox) {
					if (dfRd.getRdButton().isSelected()) {
						dfJoint = new DFJoint(dfRd.getDfJoint());
						rdGroup.clearSelection();
					}	
				}
				
				relAttrJoint.addAttributes(dfJoint.getAttributesDFJoint());
				
				Relation rel = new Relation(relAttrJoint, dfJoint);
				rel.setName(txtNameR.getText());
				
				txtNameR.setText(null);
			}
		});
		
			
		/*
		 * Panel de Relacione
		 */
		
		// inicializando el panel de relaciones
		panelRel = new JPanel();
		panelRel.setSize(new Dimension(1920, 100));
		panelRel.setLocation(0, 250);
		panelRel.setLayout(null);
		
		//creando los componentes del panel de relaciones
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1920, 1);
		
		JLabel label = new JLabel("Relaciones");
		label.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		label.setBounds(new Rectangle(10, 10, 100, 25));
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		//anadiendo los componentes al panel de relaciones
		panelRel.add(separator);
		panelRel.add(label);
		
		//anadiendo el panel al ContentPane
		frmTFG.getContentPane().add(panelRel);
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTFG;
	}
}
