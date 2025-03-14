package application.model;

import java.security.spec.EllipticCurve;
import java.util.ArrayList;

public class Company {
	private String name;
	private int hours; // weekly work hours

	// link to Employee class (--> 0..*)
	private final ArrayList<Employee> employees = new ArrayList<>();

	// link to Customer class (--> 0..*)
	private final ArrayList<Customer> customers = new ArrayList<>();

	public Company(String name, int hours) {
		this.name = name;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	@Override
	public String toString() {
		return name + " (" + hours + " hours)";
	}

	// -----------------------------------------------------------------------------

	public ArrayList<Employee> getEmployees() {
		return new ArrayList<>(employees);
	}

	/**
	 * Adds the employee to this comapy, if they aren't connected 
	 * 
	 * @param employee
	 */
	public void addEmployee(Employee employee) {
		if (!employees.contains(employee)) {
			employees.add(employee);
			employee.setCompany(this);
		}
	}

	/**
	 * Removes the employee from this company,
	 * if they are connected
	 * @param employee
	 */
	public void removeEmployee(Employee employee) {
		if (employees.contains(employee)) {
			employees.remove(employee);
			employee.setCompany(null);
		}
	}

	// -----------------------------------------------------------------------------

	/**
	 * Returns the count of employees in this company.
	 */
	public int employeesCount() {
		return employees.size();
	}

	/**
	 * Returns the total weekly salary of all employees in the company.
	 */
	public int totalWeeklySalary() {
		int total = 0;
		for (Employee emp : employees) {
			total += emp.weeklySalary();
		}
		return total;
	}

	// -----------------------------------------------------------------------------

	public ArrayList<Customer> getCustomers() {
		return new ArrayList<>(customers);
	}

	/**
	 * Adds the customer to this comapy, if they aren't connected
	 *
	 * @param customer
	 */
	public void addCustomer(Customer customer) {
		if (!customers.contains(customer)) {
			customers.add(customer);
			customer.setCompany(this);
		}
	}

	/**
	 * Removes the customer from this company,
	 * if the are connected
	 * @param customer
	 */
	public void removeCustomer(Customer customer) {
		if (customers.contains(customer)) {
			customers.remove(customer);
			customer.setCompany(null);
		}
	}

}
