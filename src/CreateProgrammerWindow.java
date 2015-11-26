import java.awt.event.*;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.*;

import java.rmi.*;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.*;

public class CreateProgrammerWindow extends JFrame implements ActionListener {

	private JLabel ProgrammerName = new JLabel("Programmer Name:");
	private JTextField ProgrammerNameField = new JTextField();
	private JLabel ProgrammerLanguage = new JLabel("Programmer Language:");
	private JTextField ProgrammerLanguageField = new JTextField();
	private JLabel ProgrammerSpecialization = new JLabel("Programmer Specialisation:");
	private JTextField ProgrammerSpecializationField = new JTextField();
	private JButton theOKButton = new JButton("Ok");
	private JButton theCancelButton = new JButton("Cancel");
	private ProgrammerInterface theFactory;

	public CreateProgrammerWindow() {
		super("Create Programmer Window");
		try {
			getContentPane().setLayout(new GridLayout(5, 2));
			getContentPane().add(ProgrammerName);
			getContentPane().add(ProgrammerNameField);
			getContentPane().add(ProgrammerLanguage);
			getContentPane().add(ProgrammerLanguageField);
			getContentPane().add(ProgrammerSpecialization);
			getContentPane().add(ProgrammerSpecializationField);
			getContentPane().add(theCancelButton);
			getContentPane().add(theOKButton);
			theOKButton.addActionListener(this);
			theCancelButton.addActionListener(this);
			theFactory = ProgrammerFactory.getInstance();
			setSize(300,300);
			setVisible(true);
		} catch (Exception aException) {
			aException.printStackTrace();
		}
	}// Contd-->

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(theOKButton)) {
			try {
				String aProgrammerName = ProgrammerNameField.getText();
				String aLanguage = ProgrammerLanguageField.getText();
				String aSpeciality = ProgrammerSpecializationField.getText();
				theFactory.createProgrammer(aProgrammerName, aLanguage, aSpeciality);
				JOptionPane.showMessageDialog(new JFrame(), "Programmer created.");
			} catch (Exception aException) {
				aException.printStackTrace();
			}
		} else if (e.getSource().equals(theCancelButton)) {
			this.dispose();
			try {
				new MainWindow();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}