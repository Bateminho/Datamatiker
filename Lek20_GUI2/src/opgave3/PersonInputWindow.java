package opgave3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class PersonInputWindow extends Stage {

    public PersonInputWindow(String name, Stage owner) {
        this.initOwner(owner);
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setMinHeight(100);
        this.setMinWidth(200);
        this.setResizable(false);

        this.setTitle(name);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);

    }

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final CheckBox chkSenior = new CheckBox();

    private Person actualPerson = null;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Label og tekstfelt til navn
        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);
        pane.add(txfName, 1, 0, 3, 1);

        // Label og tekstfelt til titel
        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);
        pane.add(txfTitle, 1, 1, 3, 1);

        // CheckBox til senior
        chkSenior.setText("Senior");
        pane.add(chkSenior, 0, 2);

        // HBox til knapperne og centrering af dem
        HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER); // Centrer knapperne
        pane.add(buttonBox, 0, 4, 3, 1); // Strækker sig over tre kolonner

        // Cancel og OK knapper
        Button btnCancel = new Button("Cancel");
        buttonBox.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        buttonBox.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());
    }

    //-----------------------------------------------------------------

    private void okAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = chkSenior.isSelected();

        if (!name.isEmpty() && !title.isEmpty()) {
            actualPerson = new Person(name, title, senior);
            clearFields();
            PersonInputWindow.this.hide();
        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Opret person");
            alert.setHeaderText("Information missing");
            alert.setContentText("Indtast navn og titel");
            alert.show();
        }
    }

    private void cancelAction() {
        clearFields();
        actualPerson = null;
        PersonInputWindow.this.hide();
    }

    private void clearFields() {
        txfName.clear();
        txfTitle.clear();
        chkSenior.setSelected(false);
    }


    public Person getActualPerson() {return actualPerson; };
}


