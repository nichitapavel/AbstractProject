package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.ComponentOrientation;
import java.awt.Font;

@SuppressWarnings("serial")
public class About extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					About frame = new About();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public About() {
		initialize();
	}
	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnProyectoRealizadoComo = new JTextPane();
		txtpnProyectoRealizadoComo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnProyectoRealizadoComo.setEditable(false);
		txtpnProyectoRealizadoComo.setBounds(190, 50, 420, 40);
		txtpnProyectoRealizadoComo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnProyectoRealizadoComo.setText("Proyecto realizado como Trabajo de Fin de Grado");
		txtpnProyectoRealizadoComo.setBackground(contentPane.getBackground());
		contentPane.add(txtpnProyectoRealizadoComo);
		
		JTextPane txtpnAlumnoPavelNichita = new JTextPane();
		txtpnAlumnoPavelNichita.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAlumnoPavelNichita.setEditable(false);
		txtpnAlumnoPavelNichita.setBounds(270, 120, 260, 40);
		txtpnAlumnoPavelNichita.setText("Alumno: Pavel Nichita");
		txtpnAlumnoPavelNichita.setBackground(contentPane.getBackground());
		contentPane.add(txtpnAlumnoPavelNichita);
		
		JTextPane txtpnTutorJessManuel = new JTextPane();
		txtpnTutorJessManuel.setEditable(false);
		txtpnTutorJessManuel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnTutorJessManuel.setText("Tutor: Jes\u00FAs Manuel Santiso");
		txtpnTutorJessManuel.setBounds(270, 180, 260, 40);
		txtpnTutorJessManuel.setBackground(contentPane.getBackground());
		contentPane.add(txtpnTutorJessManuel);
		
		setSize (800, 400);
		this.setLocation (400, 400);
		this.setTitle ("Acerca de");
		this.setVisible (true);
	}
	
	public JPanel getContentPanel() {
		return this.contentPane;
	}
}