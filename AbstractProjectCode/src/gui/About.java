package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JLabel;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setMaximumSize(new Dimension(500, 900));
		contentPane.setMinimumSize(new Dimension(400, 800));
		contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JTextPane txtpnProyectoRealizadoComo = new JTextPane();
		txtpnProyectoRealizadoComo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnProyectoRealizadoComo.setEditable(false);
		txtpnProyectoRealizadoComo.setBounds(200, 113, 420, 40);
		txtpnProyectoRealizadoComo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtpnProyectoRealizadoComo.setText("Proyecto realizado como Trabajo de Fin de Grado");
		txtpnProyectoRealizadoComo.setBackground(contentPane.getBackground());
		contentPane.add(txtpnProyectoRealizadoComo);
		
		JTextPane txtpnAlumnoPavelNichita = new JTextPane();
		txtpnAlumnoPavelNichita.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnAlumnoPavelNichita.setEditable(false);
		txtpnAlumnoPavelNichita.setBounds(289, 164, 260, 40);
		txtpnAlumnoPavelNichita.setText("Alumno: Pavel Nichita");
		txtpnAlumnoPavelNichita.setBackground(contentPane.getBackground());
		contentPane.add(txtpnAlumnoPavelNichita);
		
		JTextPane txtpnTutorJessManuel = new JTextPane();
		txtpnTutorJessManuel.setEditable(false);
		txtpnTutorJessManuel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnTutorJessManuel.setText("Tutor: Jes\u00FAs Manuel Santiso");
		txtpnTutorJessManuel.setBounds(270, 215, 260, 40);
		txtpnTutorJessManuel.setBackground(contentPane.getBackground());
		contentPane.add(txtpnTutorJessManuel);
		
		JLabel lblDbnu = new JLabel("DBDStudio");
		lblDbnu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDbnu.setBounds(331, 11, 119, 40);
		contentPane.add(lblDbnu);
		
		JLabel lblDatabaseNormalizationAnd = new JLabel("Data Base Design");
		lblDatabaseNormalizationAnd.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDatabaseNormalizationAnd.setBounds(318, 62, 157, 40);
		contentPane.add(lblDatabaseNormalizationAnd);
		
		setSize (800, 400);
		this.setLocation (400, 400);
		this.setTitle ("Acerca de");
		this.setVisible (true);
	}
	
	public JPanel getContentPanel() {
		return this.contentPane;
	}
}