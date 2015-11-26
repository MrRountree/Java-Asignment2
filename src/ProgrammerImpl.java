import java.util.Date;
import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.*;
import java.io.*;


public class ProgrammerImpl implements Serializable {
	
	private String name;
	private String language;
	private String speciality;
	
	public ProgrammerImpl(String aName, String aLanguage, String aSpeciality){
		name = aName;
		language = aLanguage;
		speciality = aSpeciality;
		
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	
	public String getlanguage() {
		return language;
	}
	public void setlanguage(String language) {
		language = language;
	}

	public String getspeciality() {
		return speciality;
	}
	public void setspeciality(String speciality) {
		this.speciality = speciality;
	}

	
	public void printProgrammerDetails(){
		System.out.println("Name: "+name);
		System.out.println("language: "+language);
		System.out.println("Speciality: "+speciality);
		
	}

}