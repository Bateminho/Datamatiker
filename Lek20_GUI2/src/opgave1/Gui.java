package opgave1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("ListView Demo3");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chkSenior = new CheckBox();

    private void initContent(GridPane pane) {
        this.initPersons();

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title: ");
        pane.add(lblTitle, 0 , 1);

        Label lblNames = new Label("Persons:");
        pane.add(lblNames, 0, 4);

        pane.add(txfName, 1, 0, 2, 1);
        pane.add(txfTitle, 1, 1, 2, 1);

        // Create an HBox to hold the CheckBox and Label
        HBox hBoxSenior = new HBox(5); // Spacing of 5 pixels between CheckBox and Label
        hBoxSenior.getChildren().addAll(chkSenior, new Label("Senior"));
        pane.add(hBoxSenior, 1, 3);


        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 1, 4, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        ChangeListener<Person> listener = (ov, oldPerson, newPerson) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 6, 0);

        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());



    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = chkSenior.isSelected();
        if (!name.isEmpty()) {
            Person p = new Person(title, name, senior);
            persons.add(p);
            lvwPersons.getItems().setAll(persons);

        }
        clearFields();
    }

    private void clearFields() {
        txfName.clear();
        txfTitle.clear();
        chkSenior.setSelected(false);
    }



    private void initPersons() {
        persons.add(new Person("Doktor", "Jan Petersen", true));
        persons.add(new Person("Underviser", "Hans Madsen", false));
        persons.add(new Person("Mekaniker", "Pia Madsen", true));
        persons.add(new Person("Landmand", "Søren Sørensen", false));
        persons.add(new Person("Politimand", "Birgitte Jensen", false));
    }

    // -------------------------------------------------------------------------
    // Selection changed action

    private void selectionChanged() {
        Person newPerson = lvwPersons.getSelectionModel().getSelectedItem();
        if (newPerson != null) {
            txfName.setText(newPerson.getName());
        } else {
            txfName.clear();
        }
    }
}
