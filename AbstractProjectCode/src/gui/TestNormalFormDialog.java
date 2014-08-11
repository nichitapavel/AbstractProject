package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;

import datastructures.Relation;

public class TestNormalFormDialog extends JDialog {

	public TestNormalFormDialog(ArrayList<RelationCheckBox> relChckBox) {
		setBounds(100, 100, 450, 300);
		
		final ButtonGroup rdGroup = new ButtonGroup();
		
		for (int i = 0; i < relChckBox.size(); i++) {
			this.add(relChckBox.get(i).getPanelRadioButton(i));
			rdGroup.add(relChckBox.get(i).getRdButton());
		}
		
	}

}
