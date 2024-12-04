package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.application.Application;

import javax.naming.ldap.Control;

public class App {

	public static void main(String[] args) {
		initStorage();
		Application.launch(StartWindow.class);
	}
	/**
	 * Initializes the storage with some objects.
	 */
	public static void initStorage() {
		Company c1 = Controller.createCompany("IBM", 37);
		Company c2 = Controller.createCompany("AMD", 40);
		Controller.createCompany("SLED", 45);
		Controller.createCompany("Vector", 32);

		Controller.createEmployee("Bob Dole", 210, 2020, c2);
		Controller.createEmployee("Alice Schmidt", 250, 2021, c1);
		Controller.createEmployee("George Down", 150, 2019, c2);

		Controller.createEmployee("Rita Uphill", 300, 2018);

		Customer customer1 = Controller.createCustomer("Sean Bateman");
		Customer customer2 = Controller.createCustomer("Henning Riber");
		Customer customer3 = Controller.createCustomer("Mark Hansen");

		Controller.addCustomerToCompany(customer1, c1);
		Controller.addCustomerToCompany(customer2, c1);

		Controller.addCustomerToCompany(customer1, c2);
		Controller.addCustomerToCompany(customer2, c2);
	}


}
