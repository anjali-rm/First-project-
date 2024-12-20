package edbms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import customexception.EmployeeNotFoundException;
import customexception.InvalidChoiceException;
import customsorting.SortEmployeeByAge;
import customsorting.SortEmployeeById;
import customsorting.SortEmployeeByName;
import customsorting.SortEmployeeBySalary;
import edbms.Employee;
import edbms.Employee;
import edbms.Employee;
import edbms.Employee;

public class EmployeeManagementSystemImpl implements EmployeeManagementSystem {
	Scanner sc=new Scanner(System.in);
	Map<String,Employee> db=new LinkedHashMap<String,Employee>();
	@Override
	public void addEmployee() {
		System.out.println("Enter The Age: ");
		int age=sc.nextInt();
		System.out.println("Enter The Name: ");
		String name =sc.next();
		System.out.println("Enter The Salary: ");
		double salary=sc.nextDouble();
		Employee emp=new Employee(age,name,salary);
		db.put(emp.getId(), emp);
		System.out.println("Employee Details Inserted SuccessFully!..");
		System.out.println("Employee Id id "+emp.getId());
	}
	@Override
	public void displayEmployee() {
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			Employee emp=db.get(id);//getting student object
			System.out.println("Employee details are as follows");
			System.out.println("Employee Id: "+emp.getId());
			System.out.println("Employee Age: "+emp.getAge());
			System.out.println("Employee Name: "+emp.getName());
			System.out.println("Employee Marks: "+emp.getSalary());
		}
		else
		{
			try {
				String message="Employee with the Id "+id+" is not found!!..";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void displayAllEmployee() {
		if(db.size()!=0){
			System.out.println("Employee details are as follows...");
			System.out.println("-------------------");
			Set<String> keys=db.keySet();
			for(String key:keys){
				Employee e=db.get(key);
				System.out.println(e);//System.out.println(key+" "+db.get(key));
			}
		}
		else{	
			try {
				String message="Employee Database is Empty, Nothing to Display";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeEmployee() {
		System.out.println("Enter Employee Id: ");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id))
		{
			System.out.println("Employee Record Found!");
			System.out.println(db.get(id));//getting & printing student Object
			db.remove(id);//Removing the student object
			System.out.println("Employee Record Deleted SuccessFully!...");
		}
		else {
			try {
				String message="Employee with the Id "+id+" is not found!!..";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void removeAllEmployee() {
		if(db.size()!=0) {
			System.out.println("Available Employee Records: "+db.size());
			db.clear();
			System.out.println("All the Employee Records Deleted Successfully! ");
		}
		else
		{
			try {
				String message="Employee Database is Empty, Nothing to Delete";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void updateEmployee() {
		System.out.println("Enter Employee Id: ");
		String id=sc.next().toUpperCase();
		if(db.containsKey(id)){
			Employee std=db.get(id);

			System.out.println("1:Update Age\n2:Update Name\n3:Update Marks\nEnter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Age: ");
				int age=sc.nextInt();
				std.setAge(age);//std.setName(sc.nextInt())
				System.out.println("Age Updated Successfullly!");
				break;

			case 2:
				System.out.println("Enter Name: ");
				String name=sc.next();
				std.setName(name);
				System.out.println("Name Updated Successfully!");
				break;

			case 3:
				System.out.println("Enter Salary: ");
				double salary=sc.nextDouble();
				std.setSalary(salary);
				System.out.println("Salary Updated Successfully!");
				break;
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice!");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				String message="Employee with the Id "+id+" is not Found!!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void countEmployee() {
		System.out.println("No. of Employee Records: "+db.size());
	}
	@Override
	public void sortEmployee() {
		if(db.size()>=2) {
			List<Employee> list=new ArrayList<Employee>();//s1 s2

			Set<String>keys=db.keySet();//JSP101 JSP102

			for(String key:keys) {
				list.add(db.get(key));//getting & adding employee object in ArrayList
			}
			System.out.println("1:sort Employee by Id\n2:sort Employee by Age\n3:sort Employee by Name\n4:sort Employee by Salary\nEnter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				Collections.sort(list, new SortEmployeeById());
				display(list);
				break;
			case 2:
				Collections.sort(list, new SortEmployeeByAge());
				display(list);
				break;
			case 3:
				Collections.sort(list, new SortEmployeeByName());
				display(list);
				break;
			case 4:
				Collections.sort(list, new SortEmployeeBySalary());
				display(list);
				break;
			default:
				try {
					String message="Invalid choice!... Kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}	
			}
		}
		else {
			try {
				String message="No Sufficeient employee Records to Sort!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}

		}
	}
	@Override
	public void getEmployeeWithHighestSalary() {
		if(db.size()>=2) {
			List<Employee> list=new ArrayList<Employee>();//s1 s2

			Set<String>keys=db.keySet();//JSP101 JSP102

			for(String key:keys) {
				list.add(db.get(key));//getting & adding employee object in ArrayList
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(list.size()-1));
		}
		else {
			try {
				String message="No Sufficeient Employee Records to Sort!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public void getEmployeeWithLowestSalary() {
		if(db.size()>=2) {
			List<Employee> list=new ArrayList<Employee>();//s1 s2

			Set<String>keys=db.keySet();//JSP101 JSP102

			for(String key:keys) {
				list.add(db.get(key));//getting & adding employee object in ArrayList
			}
			Collections.sort(list, new SortEmployeeBySalary());
			System.out.println(list.get(0));
		}
		else {
			try {
				String message="No Sufficeient Employee Records to Sort!";
				throw new EmployeeNotFoundException(message);
			}
			catch(EmployeeNotFoundException e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	private static void display(List<Employee> list) {
		for(Employee s:list)
			System.out.println(s);
	}
}