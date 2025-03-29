package stream_lab_03_03_2025;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Vector;
import java.util.stream.Collectors;

public class EmployeeTest 
{
	private static List<Employee> li = new Vector<Employee>();
	private static Scanner sc = new Scanner(System.in);
	
	public static boolean getValidSalary(String s)
	{
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i)>= '0' && s.charAt(i) <= '9')	continue;
				return false;
		}
		return true;
	}
	
	private static void addEmployee()
	{
		try
		{
			System.out.print("Enter Employee Name : ");
			String name = sc.nextLine();
			
			System.out.print("Enter Employee Gender : ");
			String gender = sc.nextLine();
			
			System.out.print("Enter Employee Department : ");
			String dept = sc.nextLine();
			
			System.out.print("Enter Employee Salary : ");
			String salary = sc.nextLine();
			
			System.out.print("Enter Employee Experience : ");
			int exp = Integer.parseInt(sc.nextLine());
			
			if(!getValidSalary(salary))
			{
				throw new SalaryInputException("Enter Salary In Numeric Format...");
			}
			else if(exp < 0)
			{
				throw new ExperienceException("Experience Can Not Be Negative...");
			}
			else
			{
				li.add(new Employee(name, gender, dept, salary, exp));
				System.out.println("\nEmployee Addedd Successfully...\n");
			}
		}
		catch(SalaryInputException | ExperienceException  e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("resource")
	private static void updateEmployee()
	{		
		System.out.print("Enter The Index You Want To Update : ");
		int index = Integer.parseInt(sc.nextLine());
		if (index < 0 || index >= li.size()) {
	        System.out.println("Invalid index. Please enter a valid index.");
	        return;
	    }
		
		Employee emp = li.get(index);
		
		try
		{
			System.out.print("Enter Employee Name : ");
			String name = sc.nextLine();
			
			System.out.print("Enter Employee Gender : ");
			String gender = sc.nextLine();
			
			System.out.print("Enter Employee Department : ");
			String dept = sc.nextLine();
			
			System.out.print("Enter Employee Salary : ");
			String salary = sc.nextLine();
			
			System.out.print("Enter Employee Experience : ");
			int exp = Integer.parseInt(sc.nextLine());
			
			if(!getValidSalary(salary))
			{
				throw new SalaryInputException("Enter Salary In Numeric Format...");
			}
			else if(exp < 0)
			{
				throw new ExperienceException("Experience Can Not Be Negative...");
			}
			else
			{
				emp.setName(name);
				emp.setGender(gender);
				emp.setDepartment(dept);
				emp.setSalary(salary);
				emp.setExperience(exp);
				System.out.println("\nEmployee Updated Successfully...\n");
			}
		}
		catch(SalaryInputException | ExperienceException  e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private static void deleteEmployee()
	{		
		try
		{
			System.out.print("Enter The Index You Want To Update : ");
			int index = Integer.parseInt(sc.nextLine());
			
			if (index < 0 || index >= li.size()) {
		        System.out.println("Invalid index. Please enter a valid index.");
		        return;
		    }
			
			li.remove(index);
			System.out.println("\nEmployee Deleted Successfully...\n");
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	private static void listAllEmployees()
	{
		li.forEach(System.out::println);
	}
	
	private static void sortEmployeesByName()
	{
		li.stream().sorted((e1,e2)-> e1.getName().compareTo(e2.getName())).forEach(System.out::println);
	}
	
	private static void findHighestSalaryByDepartment()
	{
		Map<String, Optional<Employee>> maxSalaryByDept = li.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparingInt(emp-> Integer.parseInt(emp.getSalary())))));
		
		maxSalaryByDept.forEach((department, employee)-> employee
				.ifPresent(emp -> System.out.println("Department: " + department + ", Employee: " + emp)));
	}
	
	private static void categorizeAndIncreaseSalary()
	{
		Map<String, Optional<Employee>> maxSalaryByCategory = li.stream().collect(Collectors.groupingBy(emp -> emp.getGender() + " - "+ emp.getDepartment(), Collectors.maxBy(Comparator.comparingInt(emp->Integer.parseInt(emp.getSalary())))));
		
		maxSalaryByCategory.forEach((category, employee) -> employee
				.ifPresent(emp -> System.out.println("Category: " + category + ", Employee: " + emp)));
	}
	
	public static void main(String[] args) 
	{
		

		while (true) 
		{
			System.out.println("Select an operation:");
			System.out.println("\t1. Add Employee");
			System.out.println("\t2. Update Employee");
			System.out.println("\t3. Delete Employee");
			System.out.println("\t4. Display Employees");
			System.out.println("\t5. Sort Employees by Name");
			System.out.println("\t6. Find Highest Salary Department-wise");	
			System.out.println("\t7. Categorize and IncreaseSalary");
			System.out.println("\t8. Exit");

			System.out.print("Enter your choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) 
			{
			case 1: {
				addEmployee();
				break;
			}
			case 2: {
				updateEmployee();
				break;
			}
			case 3: {
				deleteEmployee();
				break;
			}
			case 4: {
				listAllEmployees();
				break;
			}
			case 5: {
				sortEmployeesByName();
				break;
			}
			case 6: {
				findHighestSalaryByDepartment();
				break;
			}
			case 7: {
				categorizeAndIncreaseSalary();
				break;
			}
			case 8: {
				System.out.println("\nSystem Shutting Down....");
				System.exit(0);
				break;
			}
			default:
				System.out.println("Invalid Choice");
			}
			
		}
	}
}