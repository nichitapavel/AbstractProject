package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JTextField;

import datastructures.Attribute;

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

public class MainWindow {

	private ArrayList<Attribute> attributes;
	
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
				Attribute attr = new Attribute(txtAttribute.getText());
				if (!attributes.contains(attr))
					attributes.add(attr);
				else {
					JOptionPane.showMessageDialog(frmTFG, 
							"El attributo \"" + attr + "\" ya existe!", 
							"Duplicidad de Atributos", 
							JOptionPane.INFORMATION_MESSAGE);
				}
				
				btnaddAttribute.setEnabled(false);
				txtAttribute.setText(null);
				txtAttribute.requestFocus(true);
				
				int width = 60;
				int i = 0;
				for (Attribute atr : attributes) {
					JCheckBox checkBox = new JCheckBox(atr.toString());
					checkBox.setBounds(width * i + 15, 100, 50, 20);
					frmTFG.repaint();
					MainWindow.this.frmTFG.add(checkBox);
					i++;
				}
			}
		});
		jPanel.add(btnaddAttribute);
		
		MenuBar menuBar = new MenuBar();
		frmTFG.setJMenuBar(menuBar.getMenuBar());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 150, 1920, 1);
		jPanel.add(separator);
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTFG;
	}
}
