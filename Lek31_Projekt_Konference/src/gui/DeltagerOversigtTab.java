package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.Deltager;
import model.Konference;
import model.Tilmelding;

import java.util.ArrayList;
import java.util.Locale;

public class DeltagerOversigtTab {

    private ListView<String> tilmeldingListView = new ListView<>();
    private ListView<String> samletPrisView = new ListView<>();
    private Konference konference = Controller.getKonference().getFirst();
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>(konference.getTilmeldinger());
    private TextField søgeFelt = new TextField();

    public Pane createContent() {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // Initial opdatering af indhold
        updateContent();

        tilmeldingListView.setPrefWidth(450);
        tilmeldingListView.setPrefHeight(300);
        samletPrisView.setPrefWidth(450);
        samletPrisView.setPrefHeight(300);

        // Opret sektioner
        HBox listSection = createListSection();
        HBox searchSection = createSearchSection();

        // Konfigurer oversigten
        root.getChildren().addAll(
                new Label("Deltageroversigt"),
                listSection,
                searchSection // Tilføj søgefelt og knap under listen
        );

        return root;
    }

    private HBox createListSection() {
        HBox listSection = new HBox(20);
        listSection.getChildren().addAll(
                new VBox(10, new Label("Deltageroversigt"), tilmeldingListView),
                new VBox(10, new Label("Samlet Pris"), samletPrisView)
        );
        return listSection;
    }

    private HBox createSearchSection() {
        søgeFelt.setPromptText("Indtast navn...");
        Button søgKnap = new Button("Søg Deltager");

        søgKnap.setOnAction(event -> søgDeltager());

        HBox søgeContainer = new HBox(10);
        søgeContainer.setPadding(new Insets(10, 0, 0, 0));
        søgeContainer.getChildren().addAll(søgeFelt, søgKnap);

        return søgeContainer;
    }

    private void søgDeltager() {
        String deltagerNavn = søgeFelt.getText().trim();
        samletPrisView.getItems().clear();

        if(deltagerNavn.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Indtast venligst et navn for at søge!", ButtonType.OK);
            alert.showAndWait();
        }

        boolean fundet = false;
        for (Tilmelding tilmelding : tilmeldinger) {
            if (tilmelding.getDeltager().getNavn().equalsIgnoreCase(deltagerNavn)) {
                fundet = true;

                // Vis deltagerens oplysninger
                StringBuilder sb = new StringBuilder();
                sb.append("Deltager: ").append(tilmelding.getDeltager().getNavn())
                        .append("\nTelefon: ").append(tilmelding.getDeltager().getTelefonnr())
                        .append("\nForedragsholder: ").append(tilmelding.isForedragsholder() ? "Ja" : "Nej");

                if (tilmelding.getLedsager() != null) {
                    sb.append("\nLedsager: ").append(tilmelding.getLedsager().getNavn());
                }

                if (tilmelding.getHotel() != null) {
                    sb.append("\nHotel: ").append(tilmelding.getHotel().getNavn());
                }

                // Beregn samlet pris
                double samletPris = Controller.beregnSamletPris(tilmelding);
                sb.append("\nSamlet Pris: ").append(samletPris).append(" DKK");

                samletPrisView.getItems().add(sb.toString());
            }
        }

        if (!fundet) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Ingen deltager med navnet \"" + deltagerNavn + "\" fundet.", ButtonType.OK);
            alert.showAndWait();
        }
    }

    // Insertion sort til sortering af deltagerlisten
    public void insertionSort(ArrayList<Tilmelding> list) {
        for (int i = 1; i < list.size(); i++) {
            Tilmelding next = list.get(i);
            int j = i;
            while (j > 0 && next.getDeltager().getNavn().compareTo(list.get(j - 1).getDeltager().getNavn()) < 0) {
                list.set(j, list.get(j - 1));
                j--;
            }
            list.set(j, next);
        }
    }

    // Opdater indholdet i ListView og sortér efter deltagerens navn
    public void updateContent() {
       // ArrayList<Tilmelding> tilmeldinger = new ArrayList<>(konference.getTilmeldinger());
        insertionSort(tilmeldinger); // Sorter tilmeldingerne

        ArrayList<String> deltagerInfo = new ArrayList<>();
        for (Tilmelding tilmelding : tilmeldinger) {
            StringBuilder sb = new StringBuilder();
            sb.append("Deltager: ").append(tilmelding.getDeltager().getNavn())
                    .append(" (Telefon: ").append(tilmelding.getDeltager().getTelefonnr()).append(")");

            if (tilmelding.isForedragsholder()) {
                sb.append(" [Foredragsholder]");
            }

            if (tilmelding.getLedsager() != null) {
                sb.append("\n Ledsager: ").append(tilmelding.getLedsager().getNavn());
            }

            if (tilmelding.getHotel() != null) {
                sb.append("\n Hotel: ").append(tilmelding.getHotel().getNavn());
            }

            deltagerInfo.add(sb.toString());
        }
        tilmeldingListView.getItems().setAll(deltagerInfo); // Opdater ListView med sorterede tilmeldinger
    }
}
