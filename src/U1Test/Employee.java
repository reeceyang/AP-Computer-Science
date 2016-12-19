// Reece Yang
//
// This class models an employee.

public class Employee {

	// Instance fields
	private String name;
	private double salary;

	// Default constructor
	public Employee() {

		name = "Hacker, Harry";
		salary = 55000;
	}

	// Accessor methods
	public String getName() {

		return name;
	}

	public double getSalary() {

		return salary;
	}

	// Raises the employee's salary
	// by a certain percentage
	public void raiseSalary(double byPercent) {

		salary *= 1 + (byPercent / 100);
	}

	// Adds the given integer amount
	// to the employee's salary
	public void bonus(int amount) {

		salary += amount;
	}
}