package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Salgsannonce;
import model.Vare;

import java.util.ArrayList;
import java.util.Locale;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Handelsplatform");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 950, 350);
        stage.setScene(scene);

        initContent(root);

        stage.show();
    }

    private ListView<Salgsannonce> lvwSalgsannonce = new ListView<>();
    private ListView<Vare> lvwVare = new ListView<>();
    private TextField txtKøber = new TextField();
    private TextField txtAftaltPris = new TextField();
    private TextField txtFilNavn = new TextField();

    private void initContent(BorderPane root) {
        // Venstre sektion: Aktive annoncer og varer ved siden af hinanden
        HBox listPane = new HBox(20); // Større mellemrum mellem de to ListViews
        listPane.setPadding(new Insets(10, 10, 10, 20)); // Lige afstand fra venstre kant

        // Aktive annoncer
        VBox vbAnnoncer = new VBox(5);
        Label lblAktiveAnnoncer = new Label("Aktive annoncer");
        lvwSalgsannonce.setPrefSize(300, 200);
        vbAnnoncer.getChildren().addAll(lblAktiveAnnoncer, lvwSalgsannonce);

        lvwSalgsannonce.getItems().setAll(Controller.getAktiveSalgannoncer() );

        lvwSalgsannonce.getSelectionModel().selectedItemProperty().addListener((obs, oldSalgsannonce, newSalgsannonce) -> {
            if (newSalgsannonce != null) {
                lvwVare.getItems().setAll(newSalgsannonce.getVarer());

            }
        });

        // Varer
        VBox vbVarer = new VBox(5);
        Label lblVarer = new Label("Varer");
        lvwVare.setPrefSize(300, 200);
        lvwVare.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        vbVarer.getChildren().addAll(lblVarer, lvwVare);

        // Tilføj annoncer og varer til venstre sektion
        listPane.getChildren().addAll(vbAnnoncer, vbVarer);
        root.setLeft(listPane);

        // Højre sektion: Køber, aftalt pris og filnavn
        GridPane rightPane = new GridPane();
        rightPane.setPadding(new Insets(10));
        rightPane.setHgap(10);
        rightPane.setVgap(10);

        Label lblKøber = new Label("Køber");
        txtKøber.setPromptText("Indtast købers navn");

        Label lblAftaltPris = new Label("Aftalt pris");
        txtAftaltPris.setPromptText("Indtast aftalt pris");

        Button btnOpretSalg = new Button("Opret salg");
        btnOpretSalg.setOnAction(event -> opretSalgAction());

        Label lblFilNavn = new Label("Fil navn");
        txtFilNavn.setPromptText("Indtast filnavn");

        Button btnSalgTilFil = new Button("Salg til fil");
        btnSalgTilFil.setOnAction(event -> opretSalgsFilAction());

        rightPane.add(lblKøber, 0, 2);
        rightPane.add(txtKøber, 1, 2);

        rightPane.add(lblAftaltPris, 0, 3);
        rightPane.add(txtAftaltPris, 1, 3);

        rightPane.add(btnOpretSalg, 0, 4);

        rightPane.add(lblFilNavn, 0, 16);
        rightPane.add(txtFilNavn, 1, 16);
        rightPane.add(btnSalgTilFil, 0, 17);

        root.setCenter(rightPane);
    }



    private void opretSalgAction() {
        // Hent inputværdier
        String købersnavn = txtKøber.getText().trim(); // Opdateret tekstfelt-navn
        String aftaltPrisStr = txtAftaltPris.getText().trim(); // Opdateret tekstfelt-navn
        ArrayList<Vare> valgteVarer = new ArrayList<>(lvwVare.getSelectionModel().getSelectedItems());

        // Kontrollér manglende input
        if (købersnavn.isEmpty()) {
            showErrorDialog("Du skal angive købers navn.");
            return;
        }

        if (aftaltPrisStr.isEmpty()) {
            showErrorDialog("Du skal angive en aftalt pris.");
            return;
        }

        int aftaltPris;
        try {
            aftaltPris = Integer.parseInt(aftaltPrisStr);
        } catch (NumberFormatException e) {
            showErrorDialog("Aftalt pris skal være et tal.");
            return;
        }

        if (aftaltPris <= 0) {
            showErrorDialog("Aftalt pris skal være større end 0.");
            return;
        }

        if (valgteVarer.isEmpty()) {
            showErrorDialog("Du skal vælge mindst én vare.");
            return;
        }

        // Kontrollér om nogle varer allerede er solgt
        for (Vare vare : valgteVarer) {
            if (vare.isSolgt()) {
                showErrorDialog("En eller flere af de valgte varer er allerede solgt.");
                return;
            }
        }

        // Opret salget via Controller
        Controller.createSalg(købersnavn, aftaltPris, valgteVarer);

        // Nulstil inputfelter
        txtKøber.clear();
        txtAftaltPris.clear();

        // Opdater ListViews
        lvwSalgsannonce.getItems().setAll(Controller.getAktiveSalgannoncer());
        lvwVare.getItems().clear();

        // Vis succesbesked
        Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
        successAlert.setTitle("Salg oprettet");
        successAlert.setHeaderText(null);
        successAlert.setContentText("Salget blev oprettet med succes.");
        successAlert.showAndWait();
    }

    private void opretSalgsFilAction() {
        String filnavn = txtFilNavn.getText().trim();

        if (filnavn.isEmpty()) {
            showErrorDialog("Du skal angive et filnavn.");
            return;
        }

        try {
            // Kald controllerens metode for at oprette filen
            Controller.salgTilFil(filnavn);

            // Nulstil tekstfeltet
            txtFilNavn.clear();

            // Vis en succesbesked
            Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
            successAlert.setTitle("Fil gemt");
            successAlert.setHeaderText(null);
            successAlert.setContentText("Filen \"" + filnavn + "\" blev oprettet med succes.");
            successAlert.showAndWait();
        } catch (Exception e) {
            // Håndter eventuelle fejl under filoprettelsen
            showErrorDialog("Der opstod en fejl ved oprettelse af filen: " + e.getMessage());
        }


    }

    private void showErrorDialog(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fejl");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
