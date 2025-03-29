package stream_lab_03_03_2025;

public class Employee
{
	private String name;
	private String gender;
	private String department;
	private String salary;
	private int experience;
	public Employee(String name, String gender, String department, String salary, int experience) 
	{
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.salary = salary;
		this.experience = experience;
	}
	
	public String getName() 
	{
		return name;
	}
	public String getGender() 
	{
		return gender;
	}
	public String getDepartment() 
	{
		return department;
	}
	public String getSalary() 
	{
		return salary;
	}
	public int getExperience() 
	{
		return experience;
	}

	
	public void setName(String name) 
	{
		this.name = name;
	}

	public void setGender(String gender) 
	{
		this.gender = gender;
	}

	public void setDepartment(String department) 
	{
		this.department = department;
	}

	public void setSalary(String salary) 
	{
		this.salary = salary;
	}

	public void setExperience(int experience) 
	{
		this.experience = experience;
	}

	@Override
	public String toString() 
	{
		return "Employee [name=" + name + ", gender=" + gender + ", department=" + department + ", salary=" + salary
				+ ", experience=" + experience + "]";
	}
	
}
