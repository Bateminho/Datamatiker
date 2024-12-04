package guifx;

import application.controller.Controller;
import application.model.Company;
import application.model.Customer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class SelectCustomersWindow extends Stage {
    private Company company;
    private ListView<Customer> lvwCustomers;
    private Label lblError;

    public SelectCustomersWindow(String title, Company company) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.company = company;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        // Label for customers
        Label lblCustomers = new Label("Select Customers:");
        pane.add(lblCustomers, 0, 0);

        // ListView for all customers
        lvwCustomers = new ListView<>();
        pane.add(lvwCustomers, 0, 1);
        lvwCustomers.setPrefSize(300, 200);
        lvwCustomers.getItems().setAll(Controller.getCustomers()); // Get all customers
        lvwCustomers.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        // Error label
        lblError = new Label();
        pane.add(lblError, 0, 2);
        lblError.setStyle("-fx-text-fill: red");

        // Buttons
        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 3);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 3);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());
    }

    private void okAction() {
        List<Customer> selectedCustomers = lvwCustomers.getSelectionModel().getSelectedItems();
        if (selectedCustomers.isEmpty()) {
            lblError.setText("No customers selected!");
        } else {
            for (Customer customer : selectedCustomers) {
                Controller.addCustomerToCompany(customer, company);
            }
            this.hide();
        }
    }

    private void cancelAction() {
        this.hide();
    }
}
