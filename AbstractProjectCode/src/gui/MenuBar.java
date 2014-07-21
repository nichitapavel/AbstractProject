package gui;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuBar {
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu mnFichero = new JMenu("Fichero");
	private JMenu mnTest = new JMenu("Test");
	private JMenu mnNormalizac = new JMenu("Normalizar");
	private JMenu mnAnalisis = new JMenu("An\u00E1lisis");
	private JMenu mnAyuda = new JMenu("Ayuda");
	
	private JMenu mn3FN = new JMenu("3FN (3 Forma Normal)");
	private JMenu mnFNBC = new JMenu("FNBC (Formal Normal Boyce-Codd)");
	private JMenu mn4FN = new JMenu("4FN (4 Forma Normal)");
	
	private JMenu mnRecMinimo = new JMenu("Recubrimiento M\u00EDnimo");
	
	private JMenuItem mntmGuardarSesion = new JMenuItem("Crear Nuevo Dise\u00F1o");
	private JMenuItem mntmCargarSesion = new JMenuItem("Cargar Dise\u00F1o");
	
	private JMenuItem mntmFormasNormales = new JMenuItem("Detectar Forma Normal");
	private JMenuItem mntm3FN = new JMenuItem("3FN (3 Forma Normal)");
	private JMenuItem mntmFNBC = new JMenuItem("FNBC (Formal Normal Boyce-Codd)");
	private JMenuItem mntm4FN = new JMenuItem("4FN (4 Forma Normal)");
	private JMenuItem mntmRecMinimo = new JMenuItem("Recubrimiento M\u00EDnimo");
	private JMenuItem mntmClaveRelacion = new JMenuItem("Clave de una relaci\u00F3n");
	
	private JMenuItem mntmProyeccAJsobreDf = new JMenuItem("Proyecci\u00F3n de DF sobre un conjunto de atributos");
	private JMenuItem mntmDFAImplicaDFB = new JMenuItem("DF A implica DF B");
	private JMenuItem mntmEquivalenciaDosDF = new JMenuItem("Equivalencia entre 2 DF's");
	private JMenuItem mntmDfPerteneceDF = new JMenuItem("d.f. pertenece a DF");
	private JMenuItem mntmUllman = new JMenuItem("Cierre de un conjunto de atributos (Ullman)");
	private JMenuItem mntmClaves = new JMenuItem("Claves");
	
	private JMenuItem mntmAcercaDe = new JMenuItem("Acerca de");
	
	private JMenuItem mntm3FNAutomatico = new JMenuItem("Autom\u00E1tico");
	private JMenuItem mntm3FNAsistido = new JMenuItem("Asistido");
	private JMenuItem mntmFNBCAutomatico = new JMenuItem("Autom\u00E1tico");
	private JMenuItem mntmFNBCAsistido = new JMenuItem("Asistido");
	private JMenuItem mntm4FNAutomatico = new JMenuItem("Autom\u00E1tico");
	private JMenuItem mntm4FNAsistido = new JMenuItem("Asistido");
	private JMenuItem mntmRecMinAutomatico = new JMenuItem("Autom\u00E1tico");
	private JMenuItem mntmREcMinAsistido = new JMenuItem("Asistido");
	private final JMenuItem mntmGuardarDiseno = new JMenuItem("Guardar Dise\u00F1o");
	private final JMenuItem mntmSalir = new JMenuItem("Salir");
	
	
	public MenuBar () {
		initialize();
	}
	
	public void initialize() {
		this.menuBar.add(this.mnFichero);
		menuBar.add(mnTest);
		menuBar.add(mnNormalizac);
		menuBar.add(mnAnalisis);
		menuBar.add(mnAyuda);
		
		mnFichero.add(mntmGuardarSesion);
		mnFichero.add(mntmCargarSesion);
		
		mnFichero.add(mntmGuardarDiseno);
		
		mnFichero.add(mntmSalir);
		
		mnTest.add(mntmFormasNormales);
		mnTest.add(mntm3FN);
		mnTest.add(mntmFNBC);
		mnTest.add(mntm4FN);
		mnTest.add(mntmClaves);
		mnTest.add(mntmRecMinimo);
				
		mnNormalizac.add(mn3FN);
		mnNormalizac.add(mnFNBC);
		mnNormalizac.add(mn4FN);
		
		mnAnalisis.add(mntmProyeccAJsobreDf);
		mnAnalisis.add(mntmDFAImplicaDFB);
		mnAnalisis.add(mntmEquivalenciaDosDF);
		mnAnalisis.add(mntmDfPerteneceDF);
		mnAnalisis.add(mntmUllman);
		mnAnalisis.add(mnRecMinimo);
		mnAnalisis.add(mntmClaveRelacion);

		mnAyuda.add(mntmAcercaDe);
		
		mn3FN.add(mntm3FNAutomatico);
		mn3FN.add(mntm3FNAsistido);
		
		mnFNBC.add(mntmFNBCAutomatico);
		mnFNBC.add(mntmFNBCAsistido);
		
		mn4FN.add(mntm4FNAutomatico);
		mn4FN.add(mntm4FNAsistido);
		
		mnRecMinimo.add(mntmRecMinAutomatico);
		mnRecMinimo.add(mntmREcMinAsistido);
		
		mntmAcercaDe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				JFrame aboutFrame = new About();
				aboutFrame.setContentPane(aboutFrame.getContentPane());
				aboutFrame.pack();
				aboutFrame.setVisible(true);
				*/
				JFrame aboutFrame = new JFrame();
				aboutFrame.setSize (1200, 700);
				aboutFrame.setLocation (50, 50);
				aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				aboutFrame.setTitle ("Pavel");
				aboutFrame.getContentPane().setBackground(Color.BLUE);
				aboutFrame.setVisible (true);
			}
		});
	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
}