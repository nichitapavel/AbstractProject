package gui;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import datastructures.Attribute;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MenuBar {
	
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenu mnFichero = new JMenu("Archivo");
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
	private JMenuItem mntm2FN = new JMenuItem("2FN (2 Forma Normal)");
	private JMenuItem mntm3FN = new JMenuItem("3FN (3 Forma Normal)");
	private JMenuItem mntmFNBC = new JMenuItem("FNBC (Formal Normal Boyce-Codd)");
	private JMenuItem mntm4FN = new JMenuItem("4FN (4 Forma Normal)");
	private JMenuItem mntmRecMinimo = new JMenuItem("Recubrimiento M\u00EDnimo");
	private JMenuItem mntmClaveRelacion = new JMenuItem("Calculo de claves");
	
	private JMenuItem mntmProyeccAJsobreDf = new JMenuItem("Proyecci\u00F3n sobre una dependencia funcional");
	private JMenuItem mntmDFAImplicaDFB = new JMenuItem("DF1 implica DF2?");
	private JMenuItem mntmEquivalenciaDosDF = new JMenuItem("Equivalencia entre 2 DF's");
	private JMenuItem mntmDfPerteneceDF = new JMenuItem("d.f. pertenece a DF?");
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
	
	//Variables
	ArrayList<Attribute> attrList = new ArrayList<Attribute>();
	ArrayList<DFJointCheckBox> dfJointList = new ArrayList<DFJointCheckBox>();
	ArrayList<RelationCheckBox> relChckBox = new ArrayList<>();
	
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
		mntmFormasNormales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog normalFormDialog = new TestNormalFormDialog(relChckBox, 0);
				normalFormDialog.setVisible(true);
				normalFormDialog.setAlwaysOnTop(true);
			}
		});
		
		mnTest.add(mntmFormasNormales);
		mntm2FN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog normalFormDialog = new TestNormalFormDialog(relChckBox, 1);
				normalFormDialog.setVisible(true);
				normalFormDialog.setAlwaysOnTop(true);
			}
		});
		mnTest.add(mntm2FN);
		mntm3FN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog normalFormDialog = new TestNormalFormDialog(relChckBox, 2);
				normalFormDialog.setVisible(true);
				normalFormDialog.setAlwaysOnTop(true);
			}
		});
		mnTest.add(mntm3FN);
		mntmFNBC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog normalFormDialog = new TestNormalFormDialog(relChckBox, 3);
				normalFormDialog.setVisible(true);
				normalFormDialog.setAlwaysOnTop(true);
			}
		});
		mnTest.add(mntmFNBC);
		mntm4FN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog normalFormDialog = new TestNormalFormDialog(relChckBox, 4);
				normalFormDialog.setVisible(true);
				normalFormDialog.setAlwaysOnTop(true);
			}
		});
		mnTest.add(mntm4FN);
		mntmClaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog keys = new TestKey(attrList, relChckBox);
				keys.setAlwaysOnTop(true);
				keys.setVisible(true);
			}
		});
		mnTest.add(mntmClaves);
		mntmRecMinimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog minimalTest = new TestMinimalDFJointDialog(dfJointList);
				minimalTest.setVisible(true);
				minimalTest.setAlwaysOnTop(true);
			}
		});
		mnTest.add(mntmRecMinimo);
				
		mnNormalizac.add(mn3FN);
		mnNormalizac.add(mnFNBC);
		mnNormalizac.add(mn4FN);
		mntmProyeccAJsobreDf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog projection = new ProjectionOnAttributeJointDialog(dfJointList);
				projection.setVisible(true);
				projection.setAlwaysOnTop(true);
			}
		});
		
		mnAnalisis.add(mntmProyeccAJsobreDf);
		mntmDFAImplicaDFB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog implied = new Compare2DFJoints(dfJointList, 0);
				implied.setVisible(true);
				implied.setAlwaysOnTop(true);
			}
		});
		mnAnalisis.add(mntmDFAImplicaDFB);
		mntmEquivalenciaDosDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog equivalent = new Compare2DFJoints(dfJointList, 1);
				equivalent.setVisible(true);
				equivalent.setAlwaysOnTop(true);
			}
		});
		mnAnalisis.add(mntmEquivalenciaDosDF);
		mntmDfPerteneceDF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog closure = new CFJointClosed(dfJointList, attrList);
				closure.setVisible(true);
				closure.setAlwaysOnTop(true);
			}
		});
		mnAnalisis.add(mntmDfPerteneceDF);
		mnAnalisis.add(mntmUllman);
		mnAnalisis.add(mnRecMinimo);
		mntmClaveRelacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog calculateKey = new CalculateKey(relChckBox);
				calculateKey.setVisible(true);
				calculateKey.setAlwaysOnTop(true);
			}
		});
		mnAnalisis.add(mntmClaveRelacion);
		
		mnAyuda.add(mntmAcercaDe);
		mntm3FNAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog normalize = new Normalize(relChckBox, 1);
				normalize.setAlwaysOnTop(true);
				normalize.setVisible(true);
			}
		});
		
		mn3FN.add(mntm3FNAutomatico);
		mntm3FNAsistido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog assisted3NFNormalization = new AssistedNormalization3NF(relChckBox);
				assisted3NFNormalization.setVisible(true);
				assisted3NFNormalization.setAlwaysOnTop(true);
			}
		});
		mn3FN.add(mntm3FNAsistido);
		mntmFNBCAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog normalize = new Normalize(relChckBox, 2);
				normalize.setAlwaysOnTop(true);
				normalize.setVisible(true);
			}
		});
		
		mnFNBC.add(mntmFNBCAutomatico);
		mntmFNBCAsistido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog assistedBCNF = new AssistedNormalizationBCNF(relChckBox);
				assistedBCNF.setAlwaysOnTop(true);
				assistedBCNF.setVisible(true);
			}
		});
		mnFNBC.add(mntmFNBCAsistido);
		mntm4FNAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog normalize = new Normalize(relChckBox, 0);
				normalize.setAlwaysOnTop(true);
				normalize.setVisible(true);
			}
		});
		
		mn4FN.add(mntm4FNAutomatico);
		mntm4FNAsistido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog assisted4NF = new AssistedNormalization4NF(relChckBox);
				assisted4NF.setVisible(true);
				assisted4NF.setAlwaysOnTop(true);
			}
		});
		mn4FN.add(mntm4FNAsistido);
		mntmRecMinAutomatico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog autoMinimalDFJoint = new MinimalDFAuto(dfJointList);
				autoMinimalDFJoint.setVisible(true);
				autoMinimalDFJoint.setAlwaysOnTop(true);
			}
		});
		
		mnRecMinimo.add(mntmRecMinAutomatico);
		mntmREcMinAsistido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog assistedMinDF = new AssistedMinimalDFJoint(dfJointList);
				assistedMinDF.setAlwaysOnTop(true);
				assistedMinDF.setVisible(true);
			}
		});
		mnRecMinimo.add(mntmREcMinAsistido);
		
		/*
		 * Eventos
		 */
		
		mntmUllman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JDialog ullman = new Ullman(attrList, dfJointList);
				ullman.setVisible(true);
				ullman.setAlwaysOnTop(true);
			}
		});
		
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame aboutFrame = new About();
				aboutFrame.setVisible(true);
			}
		});
	}
	
	public JMenuBar getMenuBar() {
		return this.menuBar;
	}
	
	public void setAttributes(ArrayList<Attribute> attrList) {
		this.attrList = attrList;
	}
	
	public void setDFJoint(ArrayList<DFJointCheckBox> dfJointList) {
		this.dfJointList = dfJointList;
	}
	
	public void setRelations(ArrayList<RelationCheckBox> relationList) {
		this.relChckBox = relationList;
	}
}