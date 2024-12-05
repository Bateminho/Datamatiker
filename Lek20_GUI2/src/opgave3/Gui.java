package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Personer");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personWindow = new PersonInputWindow("Opret en person", stage);
    }

    // -------------------------------------------------------------------------

    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private PersonInputWindow personWindow;

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

        // add a listView to the pane(at col=1, row=0)
        pane.add(lvwPersons, 0, 0, 1, 5);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.getItems().setAll(persons);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add Person");
        pane.add(btnAdd, 3, 1);
        // connect a method to the button
        btnAdd.setOnAction(event -> this.addAction());


    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {

        personWindow.showAndWait();

        if (personWindow.getActualPerson() != null ) {
            Person person = personWindow.getActualPerson();
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        }

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



}
