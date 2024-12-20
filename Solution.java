package edbms;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to Employee Database Project");
		System.out.println("-----------------------");
		Scanner sc=new Scanner(System.in);
		EmployeeManagementSystem emp=new EmployeeManagementSystemImpl();
		while(true) {
			System.out.println("1:Add Employee\n2:Display Employee\n3:Display All Employee");
			System.out.println("4:Remove Employee\n5:Remove All Employee\n6:Update Employee\n7:Count Employee");
			System.out.println("8:Sort Employee\n9:Get Employee With Highest Salary\n10:Get Employee With Lowest Salary");
			System.out.println("11:EXIT\nEnter Choice");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				emp.addEmployee();
				break;
			case 2:
				emp.displayEmployee();
				break;
			case 3:
				emp.displayAllEmployee();
				break;
			case 4:
				emp.removeEmployee();
				break;
			case 5:
				emp.removeAllEmployee();
				break;
			case 6:
				emp.updateEmployee();
				break;
			case 7:
				emp.countEmployee();
				break;
			case 8:
				emp.sortEmployee();
				break;
			case 9:
				emp.getEmployeeWithHighestSalary();
				break;
			case 10:
				emp.getEmployeeWithLowestSalary();
				break;
			case 11:
				System.out.println("Thank You!...");
				System.exit(0);
			default:
				try {
					String message="Invalid choice! kindly enter valid choice";
					throw new InvalidChoiceException(message);
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}	
			}
			System.out.println("-----------------------");
		}
	}
}























