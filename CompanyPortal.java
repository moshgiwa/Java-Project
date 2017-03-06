
package PlacementManagementPortal;

import java.io.Serializable;
import java.util.Scanner;

public class CompanyPortal implements Serializable{
	String companyName,jobLocation,CompanyReview,interviewExperience, avgPackage, skills,venue,date,jobProfile, annualSalary;
	double SSCPercentage, HSCPercentage, aggregate;
	CompanyPortal()
	{

	}	
	CompanyPortal(String login, String password) throws Exception
	{
	System.out.println("Company login and registration page: ");
	UserRegistration.main(null);
	}
	CompanyPortal(String companyName, String jobLocation, String avgPackage)
	{
	this.companyName=companyName;
	this.jobLocation=jobLocation;
	this.avgPackage=avgPackage;
	}
	public void companySetData(String companyName, String jobLocation, String avgPackage)
	{
	this.companyName=companyName;
	this.jobLocation=jobLocation;
	this.avgPackage=avgPackage;
	}
	public void display()
	{
	System.out.println("company name: "+companyName);
	System.out.println("company location: "+jobLocation);
	System.out.println("average package : "+avgPackage);
	}
	public String toString()
	{
	return "Company name :"+companyName+"\n"+
	"company location: "+jobLocation+"\n"+
	"average package : "+avgPackage;	
	}
	void jobProfile(String skills, String jobLocation, String jobProfile,String date, String venue, String annualSalary)
	{
	System.out.println("skills: "+skills);
	System.out.println("jobProfile: "+jobProfile);
	System.out.println("annualSalary: "+annualSalary);
	System.out.println("jobLocation: "+jobLocation);
	System.out.println("date: "+date);
	System.out.println("venue: "+venue);
	}
	void eligibilityCriteria(double SSCPercentage, double HSCPercentage, double aggregate)
	{
	System.out.println("eligibility criteria of: "+companyName);
	System.out.println("SSC percentage: "+SSCPercentage+"\t"+ "HSC Percentage: "+HSCPercentage+"\t"+"aggregate: "+aggregate);
	}
	
	public static void main(String[] args) throws Exception {
	CompanyPortal cp=new CompanyPortal();
	}
}
