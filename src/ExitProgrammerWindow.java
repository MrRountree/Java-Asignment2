import java.awt.event.*;

import javax.swing.*;

import java.awt.GridLayout;

public class ExitProgrammerWindow extends JFrame implements ActionListener 
{
	private JLabel ExitProgram = new JLabel("			Are you sure?");
	private JButton theOKButton = new JButton("Ok");
	private JButton theCancelButton = new JButton("Cancel");

	public ExitProgrammerWindow()
	{
		try
		{
			getContentPane().setLayout(new GridLayout(3,2));
			getContentPane().add(ExitProgram);
			getContentPane().add(theOKButton);
			getContentPane().add(theCancelButton);
			theOKButton.addActionListener(this);
		    theCancelButton.addActionListener(this);
		    setSize(300,300);
			setVisible(true);
			
		}
		catch(Exception aException){
		      aException.printStackTrace();
		    }
		
		
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource().equals(theOKButton))
		{
  	      try{
  	    	this.dispose();
  	      }
  	      catch(Exception aException){
	        aException.printStackTrace();
	      }
		}
		else if(e.getSource().equals(theCancelButton))
		{
	  	      try{
	  	    	this.dispose();
	  	    	new MainWindow(); 
	  	      }
	  	      catch(Exception aException){
		        aException.printStackTrace();
		      }
			}
	}

}
