package edbms;

public class Employee {
	private String Id;
	private int Age;
	private String Name;
	private double Salary;
	static int count=101;
	public Employee(int Age,String Name,double Salary) {
		this.Id="JSP"+101;
		this.Age=Age;
		this.Name=Name;
		this.Salary=Salary;
		count++;
	}
	public String getId() {
		return Id;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSalary() {
		return Salary;
	}
	public void setSalary(double salary) {
		Salary = salary;
	}
	@Override
	public String toString() {
		return "Id:"+Id+ " Age:" +Age+ " Name:" +Name+ " Salary:"+Salary ;
	}
}
