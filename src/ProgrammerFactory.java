import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;


public class ProgrammerFactory extends UnicastRemoteObject implements ProgrammerInterface, Serializable {


		public static ProgrammerFactory theInstance=null;
		public HashMap<String,ProgrammerImpl> theListOfProgrammers = new HashMap();

		private ProgrammerFactory() throws RemoteException{
			System.out.println("Constructor for factory has been called");
		}
		
		public static ProgrammerFactory getInstance() throws RemoteException{
			if(theInstance == null){
				theInstance = new ProgrammerFactory();
				return theInstance;
			}
			else{
				System.out.println("The factory does already exist");
				return theInstance;
			}
		}
		
		public void createProgrammer(String aName, String aLanguage, String aSpeciality)
		{
		    System.out.println("Creating a Programmer called "+aName);
		    ProgrammerImpl aProgrammerRef = new ProgrammerImpl(aName,aLanguage,aSpeciality);
		    theListOfProgrammers.put(aName, aProgrammerRef);

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

		}

		public int createProgrammer(String aName) throws RemoteException
		{
			return 0;
		}
		
}