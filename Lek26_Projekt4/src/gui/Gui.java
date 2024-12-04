package gui;

import application.controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import storage.Storage;

import java.time.LocalDate;


public class Gui extends Application {
    public void start(Stage stage) {
        stage.setTitle("Forstilling bestillinger");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    private ListView<Forestilling> lvwForestillinger;
    private ListView<Kunde> lvwKunder;
    private ListView<Plads> lvwPladser;

    private TextField txfForstilNavn, txfStartDato, txfSlutDato, txfKundeNavn, txfKundeMobil, txfBestillingsDato;

    private Label lblError, lblForstilNavn, lblStartDato, lblSlutDato, lblKundeNavn, lblKundeMobil, lblBestillingsDato;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        lvwForestillinger = new ListView<>();
        pane.add(lvwForestillinger, 0, 1, 2, 3);
        lvwForestillinger.setPrefWidth(200);
        lvwForestillinger.setPrefHeight(200);
        lvwForestillinger.getItems().setAll(Storage.getForestillinger());

        lvwKunder = new ListView<>();
        pane.add(lvwKunder, 2, 1, 2, 3);
        lvwKunder.setPrefWidth(200);
        lvwKunder.setPrefHeight(200);
        lvwKunder.getItems().setAll(Storage.getKunder());

        lvwPladser = new ListView<>();
        pane.add(lvwPladser, 4, 1, 2, 3);
        lvwPladser.setPrefWidth(200);
        lvwPladser.setPrefHeight(200);
        lvwPladser.getItems().setAll(Storage.getPladser());


        lblForstilNavn = new Label("Forstilling Navn:");
        pane.add(lblForstilNavn, 0,4);
        txfForstilNavn = new TextField();
        pane.add(txfForstilNavn,1,4);

        lblStartDato = new Label("Start Dato:");
        pane.add(lblStartDato, 0, 5);
        txfStartDato = new TextField();
        pane.add(txfStartDato,1,5);

        lblSlutDato = new Label("Slut Dato:");
        pane.add(lblSlutDato,0,6);
        txfSlutDato = new TextField();
        pane.add(txfSlutDato,1,6);

        lblKundeNavn = new Label("Kunde Navn:");
        pane.add(lblKundeNavn,2,4);
        txfKundeNavn = new TextField();
        pane.add(txfKundeNavn,3,4);

        lblKundeMobil = new Label("Kunde Mobil:");
        pane.add(lblKundeMobil,2,5);
        txfKundeMobil = new TextField();
        pane.add(txfKundeMobil,3,5);


        Button btnOpretForstil = new Button("Opret Forstilling");
        pane.add(btnOpretForstil,1,7);
        btnOpretForstil.setOnAction(event -> this.OpretForstilling());

        Button btnOpretKunde = new Button("Opret Kunde");
        pane.add(btnOpretKunde,3,6);
        btnOpretKunde.setOnAction(event -> this.opretKunde());


    }
    private void OpretForstilling() {
        Forestilling f = Controller.createForestilling(txfForstilNavn.getText(), LocalDate.parse(txfStartDato.getText()), LocalDate.parse(txfSlutDato.getText()));
        lvwForestillinger.getItems().setAll(Storage.getForestillinger());
    }

    private void opretKunde () {
        String name = txfKundeNavn.getText().trim();
        String mobil = txfKundeMobil.getText().trim();

        if (name.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("No name written");
            alert.setHeaderText("Please write a name.");
            alert.showAndWait();
        } else {
            if (mobil.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("No mobil number written");
                alert.setHeaderText("Please write a number.");
                alert.showAndWait();
            } else {
                 Controller.createKunde(name, mobil);
            }
        }
        lvwKunder.getItems().setAll(Storage.getKunder());
    }
}
