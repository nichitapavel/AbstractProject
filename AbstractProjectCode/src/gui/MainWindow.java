package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
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

public class MainWindow {

	private ArrayList<Attribute> attributes;
	
	private JFrame frmTrabajoFinDe;
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
					window.frmTrabajoFinDe.setVisible(true);
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTrabajoFinDe = new JFrame();
		frmTrabajoFinDe.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmTrabajoFinDe.setTitle("DBN&U");
		frmTrabajoFinDe.setBackground(new Color(240, 240, 240));
		frmTrabajoFinDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrabajoFinDe.getContentPane().setPreferredSize(frmTrabajoFinDe.getSize());
		frmTrabajoFinDe.getContentPane().setLayout(null);
		
		txtAttribute = new JTextField();		
		txtAttribute.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				arg0.getKeyCode();
				String txt = txtAttribute.getText();
				if(!txt.isEmpty())
					btnaddAttribute.setEnabled(true);
				else
					btnaddAttribute.setEnabled(false);
			}
		});

		txtAttribute.setBounds(105, 35, 200, 30);
		txtAttribute.setToolTipText("Escribe el Atributo");
		txtAttribute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmTrabajoFinDe.getContentPane().add(txtAttribute);
		txtAttribute.setColumns(10);
		
		JTextPane txtpnAtributo = new JTextPane();
		txtpnAtributo.setBounds(20, 40, 80, 30);
		txtpnAtributo.setEditable(false);
		txtpnAtributo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnAtributo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnAtributo.setBackground(new Color(240, 240, 240));
		txtpnAtributo.setText("Atributo:");
		frmTrabajoFinDe.getContentPane().add(txtpnAtributo);
		
		btnaddAttribute = new JButton("A\u00F1adir Atributo");
		btnaddAttribute.setBounds(325, 35, 125, 30);
		btnaddAttribute.setEnabled(false);
		btnaddAttribute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Attribute attr = new Attribute(txtAttribute.getText());
				if (!attributes.contains(attr))
					attributes.add(attr);
				else {
					//mostrar "este atributo ya existe"
				}

				txtAttribute.setText(null);
				btnaddAttribute.setEnabled(false);
			}
		});
		frmTrabajoFinDe.getContentPane().add(btnaddAttribute);
		MenuBar menuBar = new MenuBar();
		frmTrabajoFinDe.setJMenuBar(menuBar.getMenuBar());
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTrabajoFinDe;
	}
}
