
package PlacementManagementPortal;

import java.io.Serializable;
import java.util.Scanner;

public class StudentPortal implements Serializable{
	public String name,fathername, gender, branch, address, skills, collegeName,emailID, mobileNo;
	public double aggregatePercentage,SSCPercentage, HSCPercentage;
	StudentPortal()
	{

	}

	StudentPortal(String name, String fathername, String emailID, String mobileNo, String gender, String branch, String address, String skills, String collegeName)
	{
	this.name=name;
	this.fathername=fathername;
	this.emailID=emailID;
	this.mobileNo=mobileNo;
	this.gender=gender;
	this.branch=branch;

	this.address=address;
	this.skills=skills;
	this.collegeName=collegeName;
	}
	StudentPortal(double HSCPercentage, double SSCPercentage, double aggregatePercentage)
	{
	this.HSCPercentage=HSCPercentage;
	this.SSCPercentage=SSCPercentage;
	this.aggregatePercentage=aggregatePercentage;
	}

	StudentPortal(String username,String password) throws Exception
	{
	System.out.println("Student login and registration page: ");
	UserRegistration.main(null);
	}




	public void studentSetDate(String name, String fathername, String emailID,String mobileNo, String gender, String branch, double HSCPercentage, double SSCPercentage, double aggregatePercentage, String address, String skills, String collegeName)
	{
	this.name=name;
	this.fathername=fathername;
	this.emailID=emailID;
	this.HSCPercentage=HSCPercentage;
	this.SSCPercentage=SSCPercentage;
	this.aggregatePercentage=aggregatePercentage;
	this.mobileNo=mobileNo;
	this.gender=gender;
	this.HSCPercentage=HSCPercentage;
	this.SSCPercentage=SSCPercentage;
	this.aggregatePercentage=aggregatePercentage;
	this.branch=branch;
	this.address=address;
	this.skills=skills;
	this.collegeName=collegeName;

	}

	/*public void StudentRegistration(String name, String fathername, String emailID, String mobileNo, String gender, String branch, double HSCPercentage, double SSCPercentage, double aggregatePercentage, String address, String skills, String collegeName)

	{
	Scanner sc=new Scanner(System.in);
	System.out.println("enter name: ");	
	name=sc.next();
	System.out.println("enter father name: ");
	fathername=sc.next();
	System.out.println("enter email id: ");
	emailID=sc.next();
	System.out.println("enter mobile number: ");
	mobileNo=sc.next();
	System.out.println("enter gender: ");
	gender=sc.next();
	System.out.println("enter branch: ");
	branch=sc.next();
	System.out.println("HSC percentage: ");
	HSCPercentage=sc.nextDouble();
	System.out.println("SSC percentage: ");
	SSCPercentage=sc.nextDouble();
	System.out.println("aggregate percentage: ");
	aggregatePercentage=sc.nextDouble();
	System.out.println("address: ");
	address=sc.next();
	System.out.println("skills: ");
	skills=sc.next();
	System.out.println("college name: ");
	collegeName=sc.next();
	
	System.out.println("registration is completed: ");
	
	}*/
	
	


	public void display()
	{
	System.out.println("Student name :"+name);
	System.out.println("Student father name    :"+fathername);
	System.out.println("Student email id:"+emailID);
	System.out.println(" student mobileNo :"+mobileNo);
	System.out.println("gender :"+gender);
	System.out.println("branch:"+branch);
	System.out.println(" 12th Percentage:"+HSCPercentage);
	System.out.println(" 10th Percentage:"+SSCPercentage);
	System.out.println("aggregate Percentage:"+aggregatePercentage);
	System.out.println("address:"+address);
	System.out.println("skills:"+skills);
	System.out.println("collegeName:"+collegeName);
	}

	public String toString()
	{
	return "Student name:"+name+"\n"+
	"Student father Name    :"+fathername+"\n"+
	"email id:"+emailID+"\n"+
	"mobile no :"+mobileNo+"\n"+
	"gender :"+gender+"\n"+
	"HSC percentage :"+HSCPercentage+"\n"+
	"SSCPercentage"+SSCPercentage+"\n"+
	"aggregatePercentage"+aggregatePercentage+"\n"+"address"+address+"\n"+"skills"+skills+"\n"+"collegeName"+collegeName;

	}


	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
	StudentPortal sp1=new StudentPortal();
	
	StudentPortal sp=new StudentPortal("sneha", "lalan", "sneha313singh@gmail.com", "8874730083", "female", "CSE", "hyderabad", "java", "utm");
	System.out.println(sp);
	sp1.display();
	//System.out.println("");


	}

}
