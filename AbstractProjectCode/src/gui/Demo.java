package gui;

import javax.swing.JDialog;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Demo extends JDialog {
	private JTextField textField;

	/**
	 * Create the dialog.
	 */
	public Demo() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_Up = new JPanel();
		getContentPane().add(panel_Up);
		
		JLabel lblDemo = new JLabel("Demo");
		lblDemo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_Up.add(lblDemo);
		
		JPanel panel_Down = new JPanel();
		getContentPane().add(panel_Down);
		panel_Down.setLayout(new BoxLayout(panel_Down, BoxLayout.X_AXIS));
		
		textField = new JTextField();
		panel_Down.add(textField);
		textField.setColumns(10);
		
		JButton btnTest = new JButton("Calcular");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		panel_Down.add(btnTest);

	}

}
