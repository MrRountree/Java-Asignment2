import java.rmi.*;
import java.util.HashMap;


public interface ProgrammerInterface  extends Remote
{

	public void createProgrammer(String aName, String aLanguage, String aSpeciality) throws RemoteException;
	
}
