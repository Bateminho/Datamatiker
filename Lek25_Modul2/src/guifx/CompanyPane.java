package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import application.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class CompanyPane extends GridPane {
	private TextField txfName, txfHours;
	private TextArea txaEmps, txaCustomers;
	private ListView<Company> lvwCompanies;

	public CompanyPane() {
		this.setPadding(new Insets(20));
		this.setHgap(20);
		this.setVgap(10);
		this.setGridLinesVisible(false); // Aktiver denne til debugging

		// Label and ListView for Companies
		Label lblComp = new Label("Companies");
		this.add(lblComp, 0, 0);

		lvwCompanies = new ListView<>();
		this.add(lvwCompanies, 0, 1, 1, 4); // Companies span 4 rows
		lvwCompanies.setPrefWidth(200);
		lvwCompanies.setPrefHeight(200); // Matches combined height of Employees and Customers
		lvwCompanies.getItems().setAll(Controller.getCompanies());

		ChangeListener<Company> listener = (ov, oldCompny, newCompany) -> this.selectedCompanyChanged();
		lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

		// Name field
		Label lblName = new Label("Name:");
		this.add(lblName, 1, 1);

		txfName = new TextField();
		this.add(txfName, 2, 1);
		txfName.setEditable(false);

		// Weekly Hours field
		Label lblHours = new Label("Weekly Hours:");
		this.add(lblHours, 1, 2);

		txfHours = new TextField();
		this.add(txfHours, 2, 2);
		txfHours.setEditable(false);

		// Employees section
		Label lblEmps = new Label("Employees:");
		this.add(lblEmps, 1, 3);
		GridPane.setValignment(lblEmps, VPos.TOP);
		lblEmps.setPadding(new Insets(4, 0, 4, 0));

		txaEmps = new TextArea();
		this.add(txaEmps, 2, 3);
		txaEmps.setPrefWidth(200);
		txaEmps.setPrefHeight(100); // Half of ListView height
		txaEmps.setEditable(false);

		// Customers section
		Label lblCustomers = new Label("Customers:");
		this.add(lblCustomers, 1, 4);
		GridPane.setValignment(lblCustomers, VPos.TOP);
		lblCustomers.setPadding(new Insets(4, 0, 4, 0));

		txaCustomers = new TextArea();
		this.add(txaCustomers, 2, 4);
		txaCustomers.setPrefWidth(200);
		txaCustomers.setPrefHeight(100); // Half of ListView height
		txaCustomers.setEditable(false);

		// Buttons
		HBox hbxButtons = new HBox(40);
		this.add(hbxButtons, 0, 5, 3, 1); // Place HBox in a new row
		hbxButtons.setPadding(new Insets(10, 0, 0, 0));
		hbxButtons.setAlignment(Pos.BASELINE_CENTER);

		Button btnCreate = new Button("Create");
		hbxButtons.getChildren().add(btnCreate);
		btnCreate.setOnAction(event -> this.createAction());

		Button btnUpdate = new Button("Update");
		hbxButtons.getChildren().add(btnUpdate);
		btnUpdate.setOnAction(event -> this.updateAction());

		Button btnDelete = new Button("Delete");
		hbxButtons.getChildren().add(btnDelete);
		btnDelete.setOnAction(event -> this.deleteAction());

		Button btnCreateCustomer = new Button("Create Customer");
		hbxButtons.getChildren().add(btnCreateCustomer);
		btnCreateCustomer.setOnAction(event -> this.createCustomerAction());

		Button btnAddCustomer = new Button("Add Existing Customer");
		hbxButtons.getChildren().add(btnAddCustomer);
		btnAddCustomer.setOnAction(event -> this.addExistingCustomerAction());

		if (lvwCompanies.getItems().size() > 0) {
			lvwCompanies.getSelectionModel().select(0);
		}
	}

	// -------------------------------------------------------------------------

	private void createAction() {
		CompanyWindow dia = new CompanyWindow("Create Company");
		dia.showAndWait();

		lvwCompanies.getItems().setAll(Controller.getCompanies());
		int index = lvwCompanies.getItems().size() - 1;
		lvwCompanies.getSelectionModel().select(index);
	}

	private void updateAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			CompanyWindow dia = new CompanyWindow("Update Company", company);
			dia.showAndWait();

			int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
			lvwCompanies.getItems().setAll(Controller.getCompanies());
			lvwCompanies.getSelectionModel().select(selectIndex);
		}
	}

	private void deleteAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			if (company.employeesCount() == 0) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Delete Company");
				alert.setHeaderText("Are you sure?");
				Optional<ButtonType> result = alert.showAndWait();
				if ((result.isPresent()) && (result.get() == ButtonType.OK)) {
					Controller.deleteCompany(company);
					lvwCompanies.getItems().setAll(Controller.getCompanies());
					this.updateControls();
				}
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Delete Company");
				alert.setHeaderText("Can't delete a company that has employees");
				alert.show();
			}
		}
	}

	private void createCustomerAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			CustomerWindow customerWindow = new CustomerWindow("Create Customer", null, company);
			customerWindow.showAndWait();

			this.updateControls();
		} else {
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("No Company Selected");
			alert.setHeaderText("Please select a company before creating a customer.");
			alert.showAndWait();
		}
	}

	private void addExistingCustomerAction() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			SelectCustomersWindow selectCustomersWindow = new SelectCustomersWindow("Add Customers to " + company.getName(), company);
			selectCustomersWindow.showAndWait();

			this.updateControls();
		} else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("No Company Selected");
			alert.setHeaderText("Plese select a company before adding customers.");
			alert.showAndWait();
		}
	}


	// -------------------------------------------------------------------------

	private void selectedCompanyChanged() {
		this.updateControls();
	}

	public void updateControls() {
		Company company = lvwCompanies.getSelectionModel().getSelectedItem();
		if (company != null) {
			txfName.setText(company.getName());
			txfHours.setText("" + company.getHours());

			// Employees
			StringBuilder sbEmployees = new StringBuilder();
			for (Employee emp : company.getEmployees()) {
				sbEmployees.append(emp).append("\n");
			}
			txaEmps.setText(sbEmployees.toString());

			// Customers
			StringBuilder sbCustomers = new StringBuilder();
			for (Customer cust : company.getCustomers()) {
				sbCustomers.append(cust.getName()).append("\n");
			}
			txaCustomers.setText(sbCustomers.toString());
		} else {
			txfName.clear();
			txfHours.clear();
			txaEmps.clear();
			txaCustomers.clear();
		}
	}
}
