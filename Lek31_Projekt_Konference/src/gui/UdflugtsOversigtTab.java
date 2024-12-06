package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.*;

import java.io.IOException;
import java.io.PrintWriter;

public class UdflugtsOversigtTab {

    private ListView<Udflugt> udflugtsListView = new ListView<>();
    private ListView<String> ledsagereListView = new ListView<>();
    private Konference konference = Controller.getKonference().getFirst();

    public Pane createContent() {
        HBox root = new HBox(20);
        root.setPadding(new Insets(20));

        // Hent udflugter
        updateUdflugtsList();

        // Lyt efter valg af udflugt
        udflugtsListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> updateLedsagereList(newValue));

        // Knappen "Gem"
        Button gemUdflugter = new Button("Gem");
        gemUdflugter.setOnAction(e -> gemAction());

        // VBox til udflugtsoversigt
        VBox udflugtsBox = new VBox(10, new Label("Udflugter"), udflugtsListView, gemUdflugter);

        // VBox til ledsageroversigt
        VBox ledsagerBox = new VBox(10, new Label("Deltagende Ledsagere"), ledsagereListView);

        // Konfigurer layout
        root.getChildren().addAll(udflugtsBox, ledsagerBox);

        return root;
    }

    // Opdater listen over udflugter
    private void updateUdflugtsList() {
        udflugtsListView.getItems().setAll(konference.getUdflugter());
    }

    // Opdater listen over ledsagere baseret på valgt udflugt
    private void updateLedsagereList(Udflugt selectedUdflugt) {
        ledsagereListView.getItems().clear();
        if (selectedUdflugt != null) {
            for (Tilmelding tilmelding : konference.getTilmeldinger()) {
                if (tilmelding.getUdflugter().contains(selectedUdflugt) && tilmelding.getLedsager() != null) {
                    ledsagereListView.getItems().add(
                            tilmelding.getLedsager().getNavn() +
                                    " (" + tilmelding.getDeltager().getNavn() + ", tlfnr.: " + tilmelding.getDeltager().getTelefonnr() + ")"
                    );
                }
            }
        }
    }

    public void gemAction() {
        String filePath = System.getProperty("user.home") + "/konference_data.txt";

        try {
            PrintWriter printWriter = new PrintWriter(filePath);

            for (Udflugt udflugt : udflugtsListView.getItems()) {
                printWriter.println("Udflugt:");
                printWriter.println(udflugt);
                printWriter.println("\nDeltagere:");

                for (Tilmelding tilmelding : konference.getTilmeldinger()) {
                    if (tilmelding.getUdflugter().contains(udflugt) && tilmelding.getLedsager() != null) {
                        printWriter.println(tilmelding.getLedsager().getNavn() +
                                " (" + tilmelding.getDeltager().getNavn() + ", tlfnr.: " + tilmelding.getDeltager().getTelefonnr() + ")");
                    }
                }
                printWriter.println();
            }
            printWriter.close();

        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Gem data");
        alert.setHeaderText("Succes");
        alert.setContentText("Du har gemt dine data!");
        alert.showAndWait();
    }

    // Offentlig metode til at opdatere hele tabben (kald fra andre steder)
    public void updateContent() {
        updateUdflugtsList();
        ledsagereListView.getItems().clear(); // Ryd ledsagerlisten ved opdatering
    }
}
