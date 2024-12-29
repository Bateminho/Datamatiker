package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Dao;
import model.Hold;

public class Gui extends Application {
    private ListView<Hold> lvwHold = new ListView<>();
    private TextField txtNavn = new TextField();
    private TextField txtDisciplin = new TextField();
    private TextField txtMaxAntal = new TextField();
    private TextField txtAdresse = new TextField();
    private Label lblTilmeldinger = new Label();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hold Administration");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);

        initContent(root);

        stage.show();
    }

    private void initContent(BorderPane root) {
        // Venstre sektion - Liste over hold
        VBox leftPane = new VBox(10);
        leftPane.setPadding(new Insets(10));
        lvwHold.setPrefSize(300, 400);
        lvwHold.getItems().setAll(Dao.getAlleHold());
        lvwHold.getSelectionModel().selectedItemProperty().addListener((obs, oldHold, newHold) -> updateFields(newHold));
        leftPane.getChildren().addAll(new Label("Hold"), lvwHold);

        root.setLeft(leftPane);

        // Midtersektion - Detaljer og opdatering
        GridPane centerPane = new GridPane();
        centerPane.setPadding(new Insets(10));
        centerPane.setHgap(10);
        centerPane.setVgap(10);

        centerPane.add(new Label("Navn"), 0, 0);
        centerPane.add(txtNavn, 1, 0);

        centerPane.add(new Label("Disciplin"), 0, 1);
        centerPane.add(txtDisciplin, 1, 1);

        centerPane.add(new Label("Max Antal"), 0, 2);
        centerPane.add(txtMaxAntal, 1, 2);

        Button btnUpdate = new Button("Opdater Hold");
        btnUpdate.setOnAction(e -> opdaterHoldAction());
        centerPane.add(btnUpdate, 0, 3);

        root.setCenter(centerPane);

        // Højre sektion - Funktioner
        VBox rightPane = new VBox(10);
        rightPane.setPadding(new Insets(10));

        Button btnOpretHold = new Button("Opret Hold");
        btnOpretHold.setOnAction(e -> opretHoldAction());

        HBox adressePane = new HBox(10);
        txtAdresse.setPromptText("Indtast adresse");
        Button btnVisTilmeldinger = new Button("Vis Tilmeldinger");
        btnVisTilmeldinger.setOnAction(e -> visTilmeldingerAction());
        adressePane.getChildren().addAll(txtAdresse, btnVisTilmeldinger);

        rightPane.getChildren().addAll(btnOpretHold, adressePane, lblTilmeldinger);

        root.setRight(rightPane);
    }

    private void opretHoldAction() {
        try {
            String navn = txtNavn.getText().trim();
            String disciplin = txtDisciplin.getText().trim();
            int maxAntal = Integer.parseInt(txtMaxAntal.getText().trim());

            Hold hold = new Hold();
            hold.setNavn(navn);
            hold.setDisciplin(disciplin);
            hold.setMaxAntal(maxAntal);

            Dao.addHold(hold);
            lvwHold.getItems().setAll(Dao.getAlleHold());

            txtNavn.clear();
            txtDisciplin.clear();
            txtMaxAntal.clear();
        } catch (NumberFormatException e) {
            showError("Max antal skal være et heltal.");
        }
    }

    private void opdaterHoldAction() {
        Hold selectedHold = lvwHold.getSelectionModel().getSelectedItem();
        if (selectedHold != null) {
            try {
                selectedHold.setNavn(txtNavn.getText().trim());
                selectedHold.setDisciplin(txtDisciplin.getText().trim());
                selectedHold.setMaxAntal(Integer.parseInt(txtMaxAntal.getText().trim()));

                lvwHold.refresh();
            } catch (NumberFormatException e) {
                showError("Max antal skal være et heltal.");
            }
        } else {
            showError("Vælg et hold at opdatere.");
        }
    }

    private void visTilmeldingerAction() {
        Hold selectedHold = lvwHold.getSelectionModel().getSelectedItem();
        String adresse = txtAdresse.getText().trim();

        if (selectedHold != null && !adresse.isEmpty()) {
            int antal = selectedHold.getAntalTilmeldinger(adresse);
            lblTilmeldinger.setText("Antal tilmeldinger fra " + adresse + ": " + antal);
        } else {
            showError("Vælg et hold og indtast en adresse.");
        }
    }

    private void updateFields(Hold hold) {
        if (hold != null) {
            txtNavn.setText(hold.getNavn());
            txtDisciplin.setText(hold.getDisciplin());
            txtMaxAntal.setText(String.valueOf(hold.getMaxAntal()));
        } else {
            txtNavn.clear();
            txtDisciplin.clear();
            txtMaxAntal.clear();
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
