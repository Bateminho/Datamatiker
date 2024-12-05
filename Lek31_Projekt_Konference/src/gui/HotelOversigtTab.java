package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Hotel;
import model.Konference;
import model.Tilmelding;

public class HotelOversigtTab {

    private Konference konference = Controller.getKonference().getFirst();
    private ListView<Hotel> hotelListView = new ListView<>();
    private ListView<String> deltagerListView = new ListView<>();

    public Pane createContent() {
        HBox root = new HBox(10);
        root.setPadding(new Insets(20));

        // Hent hoteller og opdater listen
        updateHotelList();

        hotelListView.setPrefWidth(200);
        hotelListView.setPrefHeight(300);

        deltagerListView.setPrefWidth(600); // Øger bredden af deltager-listen
        deltagerListView.setPrefHeight(300); // Øger højden af deltager-listen

        hotelListView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> updateDeltagerList(newValue));
        // Konfigurer layout
        root.getChildren().addAll(
                new VBox(10, new Label("Hoteloversigt"), hotelListView),
                new VBox(10, new Label("Deltagere"), deltagerListView)
        );
        return root;
    }

    // Opdater listen over hoteller
    private void updateHotelList() {
        hotelListView.getItems().setAll(Controller.getHoteller());
    }

    //Opdater listen over deltager baseret på valgt udflugt
    private void updateDeltagerList(Hotel selectedHotel) {
        deltagerListView.getItems().clear();
        if (selectedHotel != null) {
            for (Tilmelding tilmelding : konference.getTilmeldinger()) {
                if (selectedHotel.equals(tilmelding.getHotel()) && tilmelding.getDeltager() != null ) {
                    StringBuilder deltagerInfo = new StringBuilder();
                    deltagerInfo.append("Deltager: ").append(tilmelding.getDeltager().getNavn());

                    if (tilmelding.getLedsager() != null) {
                        deltagerInfo.append(", Ledsager: ").append(tilmelding.getLedsager().getNavn());
                    }

                    deltagerInfo.append(" Ankomst: ").append(tilmelding.getAnkomstDato())
                            .append(", Afrejse: ").append(tilmelding.getAfrejseDato()).append(")");

                    deltagerListView.getItems().add(deltagerInfo.toString());

                }
            }
        }
    }

    // Offentlig metode til at opdatere hele tabben
    public void updateContent() {
        updateHotelList();
        deltagerListView.getItems().clear();
    }
}
