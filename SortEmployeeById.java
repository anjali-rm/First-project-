package customsorting;

import java.util.Comparator;

import edbms.Employee;

public class SortEmployeeById implements Comparator<Employee>{
	@Override
	public int compare(Employee e1, Employee e2) {
		String x=e1.getId();
		String y=e2.getId();
		return x.compareTo(y);
//		return e1.getId().compareTo(e2.getId());
	}
}
//e1 -> Object to be Inserted e2 -> Already Existing Object.
