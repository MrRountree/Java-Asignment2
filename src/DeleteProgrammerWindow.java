import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;

import java.awt.Component;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.util.*;
import java.rmi.Naming;

public class DeleteProgrammerWindow extends JFrame implements ActionListener {

	
	private JLabel ProgrammerName = new JLabel("Programmer Name:");
	private JTextField ProgrammerNameField = new JTextField();
	private JButton theOKButton = new JButton("Ok");
	private JButton theCancelButton = new JButton("Cancel");
	private ProgrammerInterface theFactory;

	public DeleteProgrammerWindow(){
		super("Create Student Window");
		try {
			getContentPane().setLayout(new GridLayout(2, 2));
			
			getContentPane().add(ProgrammerName);
			getContentPane().add(ProgrammerNameField);
			getContentPane().add(theCancelButton);
			getContentPane().add(theOKButton);
			theOKButton.addActionListener(this);
			theCancelButton.addActionListener(this);
			theFactory = ProgrammerFactory.getInstance();
			setSize(300,300);
			setVisible(true);
		} catch (Exception aException) 
		{
			aException.printStackTrace();
		}
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource().equals(theOKButton)) 
		{
			try {
				String aProgrammerName = ProgrammerNameField.getText();
				
				FileInputStream aFileInStream = new FileInputStream("ProgrammerBackup.ser");
				ObjectInputStream aObjectInStream = new ObjectInputStream(aFileInStream);
				HashMap<String,ProgrammerImpl> theListOfProgrammers = (HashMap<String,ProgrammerImpl>) aObjectInStream.readObject();
				aObjectInStream.close();
				
				theListOfProgrammers.remove(aProgrammerName);
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
				
				JOptionPane.showMessageDialog(new JFrame(), "Programmer Deleted!");
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