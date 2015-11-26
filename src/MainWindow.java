import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class MainWindow extends JFrame implements ActionListener{
	
	private JButton theCreateWindowButton = new JButton("Create Programmer");
	private JButton theReadWindowButton = new JButton("Read Programmer Details");
	private JButton theUpdateWindowButton = new JButton("Update Programmer Details");
	private JButton theDeleteWindowButton = new JButton("Delete a Programmer");
	private JButton theExitButton = new JButton("Exit");
	private ProgrammerInterface theFactory;
	
	public MainWindow() throws MalformedURLException, RemoteException, NotBoundException{
		super("Main Programmer Window");
		getContentPane().setLayout(new GridLayout(3,1));
		getContentPane().add(theCreateWindowButton);
		getContentPane().add(theReadWindowButton);
		getContentPane().add(theUpdateWindowButton);
		getContentPane().add(theDeleteWindowButton);
		getContentPane().add(theExitButton);
		
		theCreateWindowButton.addActionListener(this);
		theReadWindowButton.addActionListener(this);
		theUpdateWindowButton.addActionListener(this);
		theDeleteWindowButton.addActionListener(this);
		theExitButton.addActionListener(this);
		theFactory = ProgrammerFactory.getInstance();
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource().equals(theCreateWindowButton)){
			this.dispose();
			new CreateProgrammerWindow();	
			
		}
		
		else if(e.getSource().equals(theReadWindowButton)){
			this.dispose();
			new ReadProgrammerWindow();	
			
		}
		else if(e.getSource().equals(theDeleteWindowButton)){
			this.dispose();
			new DeleteProgrammerWindow();	
			
		}
		else if(e.getSource().equals(theUpdateWindowButton)){
			this.dispose();
			new UpdateProgrammerWindow();	
			
		}
		else if(e.getSource().equals(theExitButton))
		{
			this.dispose();
			new ExitProgrammerWindow();
		}
		
		
		
	}
	
	

}