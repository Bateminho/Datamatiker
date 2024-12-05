package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.*;

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

        // Konfigurer layout
        root.getChildren().addAll(
                new VBox(10, new Label("Udflugter"), udflugtsListView),
                new VBox(10, new Label("Deltagende Ledsagere"), ledsagereListView)
        );

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

    // Offentlig metode til at opdatere hele tabben (kald fra andre steder)
    public void updateContent() {
        updateUdflugtsList();
        ledsagereListView.getItems().clear(); // Ryd ledsagerlisten ved opdatering
    }
}
