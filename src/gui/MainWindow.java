package gui;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

import datastructures.Attribute;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

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
		frmTrabajoFinDe.setTitle("Trabajo Fin de Grado");
		frmTrabajoFinDe.setBackground(new Color(240, 240, 240));
		frmTrabajoFinDe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTrabajoFinDe.getContentPane().setPreferredSize(frmTrabajoFinDe.getSize());
		frmTrabajoFinDe.getContentPane().setLayout(null);
		
		txtAttribute = new JTextField();
		txtAttribute.setToolTipText("Escribe el Atributo");
		txtAttribute.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtAttribute.setBounds(105, 35, 200, 30);
		frmTrabajoFinDe.getContentPane().add(txtAttribute);
		txtAttribute.setColumns(10);
		
		JTextPane txtpnAtributo = new JTextPane();
		txtpnAtributo.setEditable(false);
		txtpnAtributo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnAtributo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpnAtributo.setBackground(new Color(240, 240, 240));
		txtpnAtributo.setText("Atributo:");
		txtpnAtributo.setBounds(20, 40, 80, 30);
		frmTrabajoFinDe.getContentPane().add(txtpnAtributo);
		
		btnaddAttribute = new JButton("A\u00F1adir Atributo");
		btnaddAttribute.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Attribute attr = new Attribute(txtAttribute.getText());
				if (!attributes.contains(attr))
					attributes.add(attr);
				else {
					//mostrar "este atributo ya existe"
				}

				txtAttribute.setText(null);
			}
		});
		btnaddAttribute.setEnabled(false);
		btnaddAttribute.setBounds(325, 35, 125, 30);
		frmTrabajoFinDe.getContentPane().add(btnaddAttribute);

		txtAttribute.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
			}
			public void inputMethodTextChanged(InputMethodEvent arg0) {
				if (!txtAttribute.getText().isEmpty())
					btnaddAttribute.setEnabled(true);
				else
					btnaddAttribute.setEnabled(false);
			}
		});
		
		MenuBar menuBar = new MenuBar();
		frmTrabajoFinDe.setJMenuBar(menuBar.getMenuBar());
	}
	
	public JFrame getFrmTrabajoFinDe() {
		return frmTrabajoFinDe;
	}
}
