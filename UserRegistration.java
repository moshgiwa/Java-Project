package PlacementManagementPortal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class UserRegistration implements Serializable{
	static String userName;

	public static void main(String[] args) throws Exception {

	// System.out.println("registration");
	while (true) {
	int choice=0;
	try {
	System.out.print("login type: 1");
	System.out.print("\t register: 2");
	System.out.println("\t Reset password: 3");
	System.out.println("enter your choice Login Type or Register or Reset assword");
	Scanner s = new Scanner(System.in);
	choice = s.nextInt();
	} catch (InputMismatchException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	System.out.println("only numeric value between 1 to 3 are acceptable");
	}

	switch (choice) {
	case 1:
	System.out.println("login type: ");
	new Login(1);
	break;
	case 2:
	System.out.println("register: ");
	new Register();
	break;
	case 3:
	System.out.println("Reset password: ");

	PasswordForget pf1=new PasswordForget();
	pf1.forgetPassword();
	break;
	case 4:
	System.out.println("Exit");
	System.exit(0);
	default:
	System.out.println("please select right choice");

	}
	}

	}

}
class Register {

	String username, password;
	int ch;
	Register() throws Exception {
	try {
	System.out.println("enter register type:");
	System.out.println("1. admin" + "\t" + "2.Student" + "\t" + "3.company");

	Scanner s1 = new Scanner(System.in);
	ch = s1.nextInt();
	} catch (InputMismatchException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	System.out.println("character not acceptable");
	}
	System.out.println("enter username");
	Scanner s=new Scanner(System.in);
	username=s.next();
	while (!username.matches("[A-Z][a-z]*")) {
	System.err.println("first letter must be capital ");
	username = s.next();

	}

	System.out.println("enter password");
	password = s.next();
	while (!password.matches("[a-zA-Z0-9]*")) {
	System.err.println("entered incorrect pattern ");
	password = s.next();

	}
	writeToFile();

	}

	public void writeToFile() throws Exception {
	File f = new File("user.txt");
	try {
	f.createNewFile();
	FileWriter writer = new FileWriter(f, true);
	writer.append("\n");
	writer.write(username);

	writer.append(":");
	writer.write(password);

	writer.close();
	// for going back to menu
	UserRegistration.main(null);
	} catch (IOException e) {
	e.printStackTrace();
	}
	// FileOutputStream fos=new FileOutputStream(f,true);

	// fos.write(username, password);
	}

}


class Login {
	String user, pass;
	public static int ch;
	int count1;

	public Login() {
	// TODO Auto-generated constructor stub
	}
	Login(int type) throws Exception {

	try {
	System.out.println("enter login type:");
	System.out.println("1. admin" + "\t" + "2.Student" + "\t" + "3.company");

	Scanner s1 = new Scanner(System.in);
	ch = s1.nextInt();


	System.out.println("enter username");
	Scanner s = new Scanner(System.in);
	user = s.next();
	while (!user.matches("[A-Z][a-z]*")) {
	System.err.println("first letter must be capital ");
	user = s.next();
	}
	System.out.println("enter password");
	pass = s.next();
	while (!pass.matches("[a-zA-Z0-9]*")) {
	System.err.println("entered incorrect pattern ");
	pass = s.next();
	//over writing password into file
	FileReader fr=new FileReader("user.txt");
	BufferedReader br=new BufferedReader(fr);
	StringBuffer sb=new StringBuffer();
	String k=br.readLine();

	while(k!=null)
	{
	StringTokenizer st = new StringTokenizer(k, ":");

	while (st.hasMoreElements()) {
	if (count1 % 2 == 0) {

	user = (String) st.nextElement();
	count1++;
	} else if (count1 % 2 != 0) {

	pass = (String) st.nextElement();
	count1++;
	PasswordForget p=new PasswordForget();
	pass=p.newPassword;
	}
	}
	}
	}
	} catch (InputMismatchException e) {
	// TODO Auto-generated catch block
	//e.printStackTrace();
	System.out.println("enter numeric value between 1 to 3");
	UserRegistration.main(null);
	}
	readToFile();

	}
	public void readToFile() throws Exception {

	try {
	FileReader f1 = new FileReader("user.txt");
	// read string from file
	BufferedReader b1 = new BufferedReader(f1);
	String s = (String) b1.readLine();
	// for string splitting
	int count = 0;
	String user1 = null;
	String pass1 = null;
	while (s != null) {
	// string tokenizer is used for split string
	StringTokenizer st = new StringTokenizer(s, ":");
	while (st.hasMoreElements()) {
	if (count % 2 == 0) {
	user1 = (String) st.nextElement();
	count++;
	} else if (count % 2 != 0) {

	pass1 = (String) st.nextElement();
	count++;
	}
	if (user.equals(user1) && pass.equals(pass1)) {
	Scanner sc1=new Scanner(System.in);
	Login l=new Login();
	if(l.ch==1)
	{
	System.out.println("welcome to admin portal");
	AdminPortal a=new AdminPortal();
	}
	else if(l.ch==2)
	{

	System.out.println("welcome to student portal");
	StudentPortal sp=new StudentPortal();

	sp.studentSetDate("sneha","xyz", "abc@gmail.com", "893473728","F", "CSE", 67, 87, 70, "hyd", "java", "utm");
	sp.display();
	}
	else if(l.ch==3)
	{
	System.out.println("welcome to company portal");
	CompanyPortal cp=new CompanyPortal();
	CompanyPortal cp1=new CompanyPortal("IBM","Hyderabad","3.00LPA");
	System.out.println("company description: ");
	System.out.println(cp1);

	cp.jobProfile("java","hyderabad","java developer","20th october 2016","cyber tower","3.00 LPA");
	System.out.println("eligibility criteria of "+cp1.companyName+" is");
	cp.eligibilityCriteria(60.00, 70.00, 68.00);
	}
	else
	{
	System.out.println("enter between 1 to 3");
	}

	System.exit(0);
	} else {
	continue;

	}
	}
	// b.append("\n");
	s = b1.readLine();
	}
	b1.close();
	System.out.println("Invalid Usrename Or Password");

	PasswordForget pf=new PasswordForget();
	pf.forgetPassword();


	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	}
}

class PasswordForget
{
	static int ch;
	String username,newPassword,confirmPassword;


	public void writeFile() throws Exception {
	File f = new File("user.txt");
	try {
	f.createNewFile();
	FileWriter writer = new FileWriter(f, true);
	writer.append("\n");
	writer.write(username);

	writer.append(":");
	writer.write(newPassword);

	writer.append(":");
	writer.write(confirmPassword);

	writer.close();
	// for going back to menu
	//UserRegistration.main(null);
	} catch (IOException e) {
	e.printStackTrace();
	}
	// FileOutputStream fos=new FileOutputStream(f,true);

	// fos.write(username, password);
	}
	PasswordForget()
	{

	}
	/*PasswordForget(int type)
	{
	System.out.println("enter field type for forget password:");
	System.out.println("1. admin" + "\t" + "2.Student" + "\t" + "3.company");
	Scanner scan = new Scanner(System.in);
	ch = scan.nextInt();

	}*/
	void forgetPassword() throws Exception
	{
	try {
	System.out.println("forget password press y else press n");
	Scanner sc=new Scanner(System.in);
	char choice=sc.next().charAt(0);
	boolean b=true;
	while(b)
	{
	if(choice=='y')
	{

	System.out.println("enter user name: ");
	username=sc.next();
	while (!username.matches("[A-Z][a-z]*")) {
	System.err.println("first letter must be capital ");
	username = sc.next();
	}
	System.out.println("enter new password: ");
	newPassword=sc.next();
	while (!newPassword.matches("[a-zA-Z0-9]*")) 
	{
	System.err.println("entered incorrect pattern ");
	newPassword = sc.next();
	}
	System.out.println("enter confirm password: ");
	confirmPassword=sc.next();
	while (!confirmPassword.matches("[a-zA-Z0-9]*")) {
	System.err.println("entered incorrect pattern ");
	confirmPassword = sc.next();
	}
	writeFile();
	if(newPassword.equals(confirmPassword))
	{

	System.out.println("successfully password reset");
	//AdminPortal a=new AdminPortal();
	}
	else
	{
	System.out.println("new password and confirm password didn't match");
	System.exit(0);
	}
	PasswordForget fp=new PasswordForget();
	System.out.println("enter your choice");

	System.out.println("1. admin" + "\t" + "2.Student" + "\t" + "3.company");
	Scanner sc2=new Scanner(System.in);
	ch=sc2.nextInt();
	if(PasswordForget.ch==1)
	{
	System.out.println("welcome to admin portal");
	AdminPortal a=new AdminPortal();
	b=false;
	}
	else if(PasswordForget.ch==2)
	{
	System.out.println("welcome to student portal");
	StudentPortal sp=new StudentPortal();
	sp.display();
	b=false;
	}
	else if(fp.ch==3)
	{
	System.out.println("welcome to company portal");
	CompanyPortal cp=new CompanyPortal();
	CompanyPortal cp1=new CompanyPortal("IBM","Hyderabad","3.00LPA");
	System.out.println("company description: ");
	System.out.println(cp1);

	cp.jobProfile("java","hyderabad","java developer","20th october 2016","cyber tower","3.00 LPA");
	System.out.println("eligibility criteria of "+cp1.companyName+" is");
	cp.eligibilityCriteria(60.00, 70.00, 68.00);
	b=false;
	}
	else
	{
	System.out.println("enter between 1 to 3");
	}
	}
	}
	}
	 catch (Exception e) {
	System.out.println("enter valid choice y or n");
	}
	}
	}


