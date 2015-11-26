import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;

import javax.swing.*;

import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.*;

public class UpdateProgrammerWindow extends JFrame implements ActionListener {

	
	private JLabel ProgrammerName = new JLabel("Name:");
	private JTextField ProgrammerNameField = new JTextField();
	private JLabel ProgrammerLanguage = new JLabel("Language:");
	private JTextField ProgrammerLanguageField = new JTextField();
	private JLabel ProgrammerSpecialization = new JLabel("Specialisation:");
	private JTextField ProgrammerSpecializationField = new JTextField();
	private JButton theOKButton = new JButton("Ok");
	private JButton theCancelButton = new JButton("Cancel");
	private ProgrammerInterface theFactory;
	public UpdateProgrammerWindow(){
		super("Update Programmer Window");
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
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(theOKButton)) {
			try {
				String aProgrammerName = ProgrammerNameField.getText();
				String aLanguage = ProgrammerLanguageField.getText();
				String aSpeciality = ProgrammerSpecializationField.getText();
				
				FileInputStream aFileInStream = new FileInputStream("ProgrammerBackup.ser");
				ObjectInputStream aObjectInStream = new ObjectInputStream(aFileInStream);
				HashMap<String,ProgrammerImpl> theListOfProgrammers = (HashMap<String,ProgrammerImpl>) aObjectInStream.readObject();
				aObjectInStream.close();
				
				
				ProgrammerImpl aProgrammer = theListOfProgrammers.get(aProgrammerName);
				theListOfProgrammers.remove(aProgrammerName);
				theFactory.createProgrammer(aProgrammerName, aLanguage, aSpeciality);
				JOptionPane.showMessageDialog(new JFrame(), " Updated Programmer Details:\n Programmers Name: "+aProgrammer.getname()+"\n Programmers Language: "+aProgrammer.getlanguage()+"\n Programmers Speciality: "+aProgrammer.getspeciality());
				
				try
				{
					FileOutputStream aFileOutStream = new FileOutputStream("ProgrammerBackup.ser");
				  	  ObjectOutputStream aObjectOutStream = new ObjectOutputStream(aFileOutStream);
				  	  aObjectOutStream.writeObject(theListOfProgrammers);
				  	  aObjectOutStream.close();
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
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