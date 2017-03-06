
package PlacementManagementPortal;
import java.util.List;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class AdminPortal {

	public static double SSCPercentage,HSCPercentage,aggregatePercentage;
	static Scanner sc = new Scanner(System.in);
	static File f;
	static File f1;

	AdminPortal(String username,String password) throws Exception
	{
	System.out.println("Admin login and registration page: ");
	UserRegistration.main(null);
	}

	AdminPortal() throws Exception
	{
	//System.out.println("Admin login and registration page: ");
	//UserRegistration.main(null);

	int ch;
	while(true)
	{
	System.out.println("admin enter your choice");
	System.out.println(" A. STUDENT DETAILS "+"\t"+" B. COMPANY DETAILS  ");

	char ch1;
	Scanner sc1=new Scanner(System.in);
	ch1=sc1.next().charAt(0);
	if(ch1=='A')
	{
	System.out.println("-----------------------");
	System.out.println("| A. STUDENT DETAILS    |");
	System.out.println("-----------------------");
	System.out.println("| 1.Add Student      |");
	System.out.println("| 2.View Student     |");
	System.out.println("| 3.Edit Student     |");
	System.out.println("| 4.Delete Student   |");

	System.out.println("-----------------------");
	System.out.println("|5. Back for student details |");

	}

	else if(ch1=='B')
	{
	System.out.println("-----------------------");
	System.out.println("|B.  Company DETAILS    |");
	System.out.println("-----------------------");
	System.out.println("| 6.Add Company      |");
	System.out.println("| 7.View Company     |");
	System.out.println("| 8.Delete Company   |");

	System.out.println("-----------------------");
	System.out.println("|9. Back for company details |");
	System.out.println("-----------------------");
	}
	else
	{
	System.out.println("select A or B");
	}
	System.out.println("Enter Your Choice ?");
	ch=sc.nextInt();

	switch(ch)
	{
	case 1:addStudent();
	break;
	case 2:viewStudent();
	break;
	case 3:editStudent();
	break;
	case 4:deleteStduent();
	break;
	case 5:back();
	break;
	case 6:addCompany();
	break;
	case 7:viewCompany();
	break;
	case 8: deleteCompany();
	break;

	case 9: back1();
	break;
	default : System.out.println("Enter choice range value 1-8 only");
	}
	}
	}
	/*public void noOfAttendedPlacement(int No_of_Attaneded_Placement)
	{
	try {
	StudentPortal s=new StudentPortal();

	this.No_of_Attended_Placement=No_of_Attaneded_Placement;
	if(No_of_Attaneded_Placement>5)
	{
	System.out.println(s.name+"  is exceeded number of chance for placement");
	}
	} catch (Exception e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();

	}
	}*/
	public static void addStudent() throws Exception
	{
	int noOfRecords=0;

	f = new File("user.txt");
	if(!f.exists())
	{
	f.createNewFile();
	}

	FileOutputStream fos = new FileOutputStream(f);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	String ch ="y";
	while(ch.equalsIgnoreCase("Y"))
	{
	System.out.println("Enter Student Name ?");
	String student_name=sc.next();
	while(!student_name.matches("[A-Z][a-z]*"))
	{
	System.out.println("first character must be capital");
	student_name=sc.next();
	}

	System.out.println("Enter Student Father ?");
	String father_name=sc.next();

	while(!father_name.matches("[A-Z][a-z]*"))
	{
	System.out.println("first character must be capital");
	father_name=sc.next();
	}


	System.out.println("Enter email ?");
	String emailID=sc.next();
	while(!emailID.matches("[A-Z][a-zA-Z0-9]*[_]?[a-zA-Z0-9]*[.]?[a-zA-Z0-9]*[_]?[a-zA-Z0-9]*[@]{1,1}[a-z]+[.]{1,1}[a-z]{3}"))
	{
	System.out.println("Enter the Correct format for email");
	emailID=sc.next();
	}
	System.out.println("Enter Student gender ?");
	String gender=sc.next();
	System.out.println("Enter Student branch ?");
	String branch=sc.next();

	System.out.println("Enter Student mobile number ?");
	String mobileNo=sc.next();
	while(!mobileNo.matches("[7|8|9][0-9]*"))
	{

	System.out.println("enter valid mobile number");
	mobileNo=sc.next();

	}
	System.out.println("Enter Student 10th percentage ?");
	SSCPercentage=sc.nextDouble();

	System.out.println("Enter Student 12th percentage ?");
	HSCPercentage=sc.nextDouble();

	System.out.println("Enter Student aggregate percentage ?");
	aggregatePercentage=sc.nextDouble();
	System.out.println("Enter address ?");
	String address=sc.next();

	System.out.println("Enter Student skills: ");
	String skills=sc.next();

	System.out.println("enter college name: ");
	String collegeName=sc.next();

	StudentPortal student = new StudentPortal(student_name, father_name, emailID, mobileNo, gender, branch, address, skills, collegeName);
	//student.studentSetDate(student_name, father_name, emailID, mobileNo, gender, branch, HSCPercentage, SSCPercentage, aggregatePercentage, address, skills, collegeName);
	student.display();

	oos.writeObject(student);
	oos.flush();

	noOfRecords++;	
	System.out.println("Do you want to enter another record press Y else N");
	ch=sc.next();
	System.out.println("Student Information Successfully  Stored in to the file");

	}

	System.out.println("You added "+noOfRecords+" Records Now");
	oos.close();
	fos.close();

	StudentPortal.main(null);

	}

	public static void addCompany() throws Exception
	{
	int NoOfCompany = 0;

	f1= new File("company.txt");
	if(!f1.exists())
	{
	f1.createNewFile();
	}

	FileOutputStream fos = new FileOutputStream(f1);
	ObjectOutputStream oos = new ObjectOutputStream(fos);

	String ch ="y";

	while(ch.equalsIgnoreCase("Y"))
	{
	System.out.println("Enter company Name ?");
	String companyName=sc.next();
	while(!companyName.matches("[A-Z]*[a-z]*"))
	{
	System.out.println("enter correct format");
	companyName=sc.next();
	}
	System.out.println("Enter company location ?");
	String companyLocation=sc.next();
	System.out.println("Enter company average package ?");
	String avgPackage=sc.next();

	System.out.println("Enter eligibility criteria: 10th ?");
	double HSCPercentage=sc.nextDouble();
	System.out.println("Enter eligibility criteria: 12th ?");
	double SSCPercentage=sc.nextDouble();
	System.out.println("Enter eligibility criteria: aggregate ?");
	double aggregatePercentage=sc.nextDouble();

	System.out.println("skills required for job?");
	String skills=sc.next();
	System.out.println("job profile?");
	String jobProfile=sc.next();
	System.out.println("job location?");
	String jobLocation=sc.next();
	System.out.println("interview date?");
	String date=sc.next();
	System.out.println("interview venue?");
	String venue=sc.next();
	System.out.println("package?");
	String annualSalary=sc.next();

	while(!avgPackage.matches("[0-9]*"))
	{
	System.out.println("enter correct format of package");
	avgPackage=sc.next();
	}
	CompanyPortal company = new CompanyPortal(companyName, companyLocation, avgPackage);
	//company.companySetData(companyName, companyLocation, avgPackage);
	company.display();
	company.eligibilityCriteria(HSCPercentage, SSCPercentage, aggregatePercentage);
	company.jobProfile(skills, jobLocation, jobProfile, date, venue, annualSalary);
	oos.writeObject(company);
	oos.flush();
	NoOfCompany++;
	System.out.println("Do you want to enter another record press Y else N");
	ch=sc.next();
	}


	System.out.println("You added "+NoOfCompany+" Records Now");
	oos.close();
	fos.close();

	CompanyPortal.main(null);
	}

	public static void viewStudent() throws Exception
	{
	System.out.println("************************");
	System.out.println("* View student Details *");
	System.out.println("************************");
	File f1 = new File("user.txt");
	if ( ! f1.exists()  ){
	System.out.println("There are no students available to view. Please add.");
	return;
	}
	FileInputStream fis=new FileInputStream(f1);
	ObjectInputStream ois = new ObjectInputStream(fis);
	try {

	StudentPortal student;
	while((student=(StudentPortal)ois.readObject())!=null)
	{

	System.out.println(student);	
	}
	} 

	catch(EOFException e)
	{
	//	System.out.println("End of File Reached");
	}

	catch (NullPointerException e) {
	// TODO Auto-generated catch block
	System.out.println("Student Record not found");
	}


	fis.close();
	ois.close();

	}


	public static void viewCompany() throws Exception
	{
	System.out.println("************************");
	System.out.println("* View company Details *");
	System.out.println("************************");
	f1 = new File("company.txt");

	if ( ! f1.exists()  ){
	System.out.println("There are no company available to view. Please add.");
	return;
	}
	FileInputStream fis=new FileInputStream(f1);
	ObjectInputStream ois = new ObjectInputStream(fis);
	
	//student.display();
	try {
	CompanyPortal company;
	while((company=(CompanyPortal)ois.readObject())!=null)
	{

	System.out.println(company);	
	}
	}


	catch(EOFException e)
	{
	//	System.out.println("End of File Reached");
	}
	catch (NullPointerException e) {
	// TODO Auto-generated catch block
	System.out.println("company Record not found");
	}

	ois.close();
	fis.close();
	}

	public static void editStudent() throws Exception
	{
	System.out.println("***************************");
	System.out.println("* Student Editing Details *");
	System.out.println("***************************");
	f = new File("user.txt");
	FileInputStream fis=new FileInputStream(f);
	ObjectInputStream ois = new ObjectInputStream(fis);
	StudentPortal student=(StudentPortal) ois.readObject();
	//student.display();
	System.out.println("Enter Student Name ?");
	String student_name=sc.next();
	if(student.name.equals(student_name))
	{

	System.out.println("Enter Student Name ?");
	String name=sc.next();
	while(!name.matches("[A-Z][a-z]*"))
	{
	System.out.println("first character must be capital");
	name=sc.next();
	}

	System.out.println("Enter Student Father ?");
	String father_name=sc.next();
	while(!father_name.matches("[A-Z][a-z]*"))
	{
	System.out.println("first character must be capital");
	father_name=sc.next();
	}
	System.out.println("Enter email ?");
	String emailID=sc.next();
	while(!emailID.matches("[A-Z][a-zA-Z0-9]*[_]?[a-zA-Z0-9]*[.]?[a-zA-Z0-9]*[_]?[a-zA-Z0-9]*[@]{1,1}[a-z]+[.]{1,1}[a-z]{3}"))
	{
	System.out.println("Enter the Correct format for email");
	emailID=sc.next();
	}
	System.out.println("Enter Student gender ?");
	String gender=sc.next();
	System.out.println("Enter Student branch ?");
	String branch=sc.next();
	System.out.println("Enter Student mobile number ?");
	String mobileNo=sc.next();
	while(!mobileNo.matches("[7|8|9][0-9]{9}"))
	{
	System.out.println("enter valid mobile number");
	mobileNo=sc.next();
	}
	System.out.println("Enter Student 10th percentage ?");
	double SSCPercentage=sc.nextDouble();

	System.out.println("Enter Student 12th percentage ?");
	double HSCPercentage=sc.nextDouble();

	System.out.println("Enter Student aggregate percentage ?");
	double aggregatePercentage=sc.nextDouble();
	System.out.println("Enter address ?");
	String address=sc.next();

	System.out.println("Enter Student skills: ");
	String skills=sc.next();

	System.out.println("enter college name: ");
	String collegeName=sc.next();

	student.studentSetDate(name, father_name, emailID, mobileNo, gender, branch, HSCPercentage, SSCPercentage, aggregatePercentage, address, skills, collegeName);

	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
	oos.writeObject(student);
	System.out.println("Student Details Successfully Edited.."); 
	}
	else
	{
	System.out.println("student doesn't exist");
	}

	}
	public static void deleteStduent()throws Exception
	{
	System.out.println("***************************");
	System.out.println("* Student Record Deleting *");
	System.out.println("***************************");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the student name");
	String name = sc.next();
	File f2= new File("user.txt");
	FileInputStream fis2 = new FileInputStream(f2);
	ObjectInputStream ois2 = new ObjectInputStream(fis2);
	StudentPortal student=new StudentPortal();
	boolean b;
	List<StudentPortal> leftOutStudents = new ArrayList<StudentPortal>();
	//File f1=null;
	try {
	while(true)
	{
	b=false;
	StudentPortal studentFromFile = (StudentPortal) ois2.readObject();
	if(student.equals(studentFromFile))
	{

	b=true;
	}else{
	leftOutStudents.add(studentFromFile);
	}
	}


	} catch (EOFException e) {
	// TODO Auto-generated catch block
	System.out.println("Successfully Record Deleted");
	}
	finally{
	ois2.close();
	fis2.close();
	f2.delete();
	}

	File f3=new File("student.txt");
	if ( ! f3.exists() ){
	f3.createNewFile();
	}
	FileOutputStream fis3 = new FileOutputStream(f3);
	ObjectOutputStream ois3 = new ObjectOutputStream(fis3);
	for(StudentPortal s : leftOutStudents){
	ois3.writeObject(s);
	ois3.flush();
	}
	ois3.close();
	fis3.close();
	}
	public static void deleteCompany()throws Exception
	{
	System.out.println("***************************");
	System.out.println("* Company Record Deleting *");
	System.out.println("***************************");
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter the company name");
	String name = sc.next();
	File f2= new File("company1.txt");
	FileInputStream fis2 = new FileInputStream(f2);
	ObjectInputStream ois2 = new ObjectInputStream(fis2);
	CompanyPortal company=new CompanyPortal();
	boolean b;
	List<CompanyPortal> leftOutCompanies = new ArrayList<CompanyPortal>();

	//File f1=null;
	/*try {
	while(true)
	{
	b=false;

	if(company.equals((CompanyPortal) ois2.readObject()))
	{
	b=true;
	}
	if(b==false)
	{
	f1=new File("temp1.txt");
	FileOutputStream fos = new FileOutputStream(f1,true);
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(company);
	oos.flush();
	//System.out.println("Record stored in temp file");
	f2.delete();
	//System.out.println("--file deleted---");
	f1.renameTo(f2);
	//	System.out.println("--file name renamed temp to student.txt");

	}

	}*/

	try {
	while(true)
	{
	b=false;
	CompanyPortal companyFromFile = (CompanyPortal) ois2.readObject();
	if(company.equals(companyFromFile))
	{

	b=true;
	}else{
	leftOutCompanies.add(companyFromFile);
	}
	}
	} catch (EOFException e) {
	// TODO Auto-generated catch block
	System.out.println("Successfully Record Deleted");
	}
	finally{
	ois2.close();
	fis2.close();
	f2.delete();
	}

	File f3= new File("company1.txt");
	if ( ! f3.exists() ){
	f3.createNewFile();
	}
	FileOutputStream fis3 = new FileOutputStream(f3);
	ObjectOutputStream ois3 = new ObjectOutputStream(fis3);
	for(CompanyPortal s : leftOutCompanies){
	ois3.writeObject(s);
	ois3.flush();
	}
	ois3.close();
	fis3.close();


	}

	public static void deleteRecord(StudentPortal s1) throws IOException
	{
	File f1 = new File("temp1.txt");
	f1.createNewFile();
	System.out.println("--temp file is created---");
	FileOutputStream fod = new FileOutputStream(f1,true);
	ObjectOutputStream ood = new ObjectOutputStream(fod);
	/*
	 * here we are writing the data into temporary file
	 */
	ood.writeObject(s1);
	ood.flush();
	System.out.println("Record inserted");
	}
	public static void back() throws Exception
	{
	StudentPortal.main(null);
	}

	public static void back1() throws Exception
	{
	CompanyPortal.main(null);
	}


	public void eligibleStudent()
	{

	CompanyPortal c=new CompanyPortal();

	/*Scanner sc=new Scanner(System.in);
	System.out.println("higher secondary percentage: ");
	double HSCPercentage1=sc.nextDouble();

	System.out.println("senior secondary percentage: ");
	double SSCPercentage1=sc.nextDouble();
	System.out.println("Aggregate percentage: ");
	double aggregatePercentage=sc.nextDouble();*/
	StudentPortal sp=new StudentPortal( HSCPercentage, SSCPercentage, aggregatePercentage);
	if(HSCPercentage>=c.HSCPercentage && SSCPercentage>=c.SSCPercentage && aggregatePercentage>=c.aggregate)
	{
	System.out.println(sp.name+" is eligible for this company: "+c.companyName);
	}

	System.out.println("SSC percentage: "+SSCPercentage+"\t"+ "HSC Percentage: "+HSCPercentage+"\t"+"aggregate percentage: "+aggregatePercentage);

	}


	public static void main(String[] args) {
	try {
	AdminPortal ap=new AdminPortal();
	} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

	}

}


