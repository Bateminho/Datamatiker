package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import model.*;

import java.time.LocalDate;

public class TilmeldingTab {

    private Konference havOgHimmel = Controller.getKonference().getFirst();
    private TextField deltagerNavn = new TextField();
    private TextField adresse = new TextField();
    private TextField by = new TextField();
    private TextField land = new TextField();
    private TextField telefonNr = new TextField();
    private TextField deltagerFirma = new TextField();
    private TextField firmaTlfNr = new TextField();
    private DatePicker ankomstDato = new DatePicker();
    private DatePicker afrejseDato = new DatePicker();
    private CheckBox foredragsholder = new CheckBox("Foredragsholder");
    private Button tilfoejDeltager = new Button("Tilføj Deltager");

    private ComboBox<Udflugt> udflugt = new ComboBox<>();
    private ListView<Udflugt> udflugtList = new ListView<>();
    private TextField ledsagerNavn = new TextField();
    private Button tilføjUdflugt = new Button("Tilføj Udflugt");
    private Button fjernUdflugt = new Button("Fjern Udflugt");
    private Button tilfoejLedsager = new Button("Tilføj Ledsager");

    private ComboBox<Hotel> hotelNavn = new ComboBox<>();
    private ComboBox<Tilvalg> tilvalg = new ComboBox<>();
    private ListView<Tilvalg> tilvalgList = new ListView<>();
    private Button tilføjTillæg = new Button("Tilføj Tillæg");
    private Button fjernTillaeg = new Button("Fjern Tillæg");
    private Button tilføjHotel = new Button("Tilføj Hotel");

    // Summary fields
    private ListView<Deltager> deltagerSummary = new ListView<>();
    private ListView<Ledsager> ledsagerSummary = new ListView<>();
    private ListView<Hotel> hotelSummary = new ListView<>();

    public Pane createContent() {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20));

        // ---------------------------------Tilføj Deltager Sektion ----------------------------------------------
        VBox deltagerBox = createDeltagerBox();
        root.add(deltagerBox, 0, 1);

        // -------------------------------- Tilføj Ledsager Sektion ----------------------------------------------
        VBox ledsagerBox = createLedsagerBox();
        root.add(ledsagerBox, 1, 1);

        // --------------------------------- Tilføj Hotel Sektion ------------------------------------------------
        VBox hotelBox = createHotelBox();
        root.add(hotelBox, 2, 1);

        // --------------------------------- Summary Section -----------------------------------------------------
        HBox summaryBox = createSummaryBox();
        root.add(summaryBox, 0, 2, 3, 1);

        // Opret Tilmelding Button
        Button opretTilmelding = new Button("Opret Tilmelding");
        opretTilmelding.setOnAction(e -> opretTilmeldingAction());
        root.add(opretTilmelding, 0, 3, 3, 1);

        return root;
    }

    // ------------------------------------ Deltager Sektion -----------------------------------------------------
    private VBox createDeltagerBox() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        box.setPrefHeight(300);

        deltagerNavn.setPromptText("Navn");
        adresse.setPromptText("Adresse");
        by.setPromptText("By");
        land.setPromptText("Land");
        telefonNr.setPromptText("Telefonnummer");
        ankomstDato.setPromptText("Ankomst dato");
        afrejseDato.setPromptText("Afrejse dato");
        deltagerFirma.setPromptText("Firma");
        firmaTlfNr.setPromptText("Firma Telefonnummer");

        tilfoejDeltager.setOnAction(event -> tilføjDeltagerAction());

        box.getChildren().addAll(deltagerNavn, adresse, by, land, telefonNr, ankomstDato, afrejseDato, deltagerFirma, firmaTlfNr, foredragsholder, tilfoejDeltager);
        return box;
    }

    private void tilføjDeltagerAction() {
        String navn = deltagerNavn.getText().trim();
        String adresseDeltager = adresse.getText().trim();
        String firmaDeltager;
        if (deltagerFirma.getText().trim().isEmpty()){
            firmaDeltager = null;
        } else {
            firmaDeltager = deltagerFirma.getText().trim();
        }
        Deltager deltager = Controller.createDeltager(navn,
                adresseDeltager,
                by.getText(),
                land.getText(),
                telefonNr.getText(),
                firmaDeltager,
                firmaTlfNr.getText());
        deltagerSummary.getItems().add(deltager);
        tilfoejDeltager.setDisable(true);
        foredragsholder.setDisable(true);
    }

    // ---------------------------------- Ledsager Sektion -----------------------------------------------------
    private VBox createLedsagerBox() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        box.setPrefHeight(300);

        ledsagerNavn.setPromptText("Navn");
        udflugt.getItems().setAll(Controller.getUdflugter(Controller.getKonference().getFirst()));
        udflugt.setPromptText("Udflugt");

        tilføjUdflugt.setOnAction(event -> tilføjUdflugtAction());
        fjernUdflugt.setOnAction(event -> fjernUdflugtAction());
        tilfoejLedsager.setOnAction(event -> tilføjLedsagerAction());

        box.getChildren().addAll(ledsagerNavn, udflugt, tilføjUdflugt, fjernUdflugt, udflugtList, tilfoejLedsager);
        return box;
    }

    private void tilføjUdflugtAction() {
        Udflugt valgtUdflugt = udflugt.getValue();
        if (valgtUdflugt != null && !udflugtList.getItems().contains(valgtUdflugt)) {
            udflugtList.getItems().add(valgtUdflugt);
        }
    }

    private void fjernUdflugtAction() {
        udflugtList.getItems().remove(udflugtList.getSelectionModel().getSelectedItem());
    }

    private void tilføjLedsagerAction() {
        String navn = ledsagerNavn.getText();
        Ledsager ledsager = Controller.createLedsager(navn);

        if (navn.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Indtast venligst ledsagerens navn!", ButtonType.OK);
            alert.showAndWait();

        } else {
            ledsagerSummary.getItems().add(ledsager);
            ledsagerNavn.clear();
            tilfoejLedsager.setDisable(true);
            tilføjUdflugt.setDisable(true);
            fjernUdflugt.setDisable(true);
        }
    }

    // ----------------------------------------- Hotel Sektion -----------------------------------------------------
    private VBox createHotelBox() {
        VBox box = new VBox(10);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        box.setPrefHeight(300);

        hotelNavn.getItems().setAll(Controller.getHoteller());
        hotelNavn.setPromptText("Hotel");

        // Tilføj ChangeListener til ComboBox
        hotelNavn.valueProperty().addListener((observable, oldValue, newValue) -> {
            tilvalg.getItems().setAll(hotelNavn.getSelectionModel().getSelectedItem().getTilvalg());
            tilvalgList.getItems().clear();

        });

        tilvalg.setPromptText("Tilvalg");

        tilføjTillæg.setOnAction(event -> tilføjTilvalgAction());
        fjernTillaeg.setOnAction(event -> fjernTilvalgAction());
        tilføjHotel.setOnAction(event -> tilføjHotelAction());

        box.getChildren().addAll(hotelNavn, tilvalg, tilføjTillæg, fjernTillaeg, tilvalgList, tilføjHotel);
        return box;
    }

    private void tilføjTilvalgAction() {
        Tilvalg valgtTilvalg = tilvalg.getValue();
        if (valgtTilvalg != null && !tilvalgList.getItems().contains(valgtTilvalg)) {
            tilvalgList.getItems().add(valgtTilvalg);
        }
    }

    private void fjernTilvalgAction() {
        tilvalgList.getItems().remove(tilvalgList.getSelectionModel().getSelectedItem());
    }

    private void tilføjHotelAction() {

        Hotel hotel = hotelNavn.getValue();

        if (hotel == null) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Vælg venligst et hotel!", ButtonType.OK);
            alert.showAndWait();
        } else {
            hotelSummary.getItems().add(hotel);

            hotelNavn.setDisable(true);
            tilvalg.setDisable(true);
            tilføjTillæg.setDisable(true);
            fjernTillaeg.setDisable(true);
            tilføjHotel.setDisable(true);
        }

    }

    // ------------------------------------------ Summary Sektion -----------------------------------------------------
    private HBox createSummaryBox() {
        HBox box = new HBox(20);
        box.setPadding(new Insets(10));
        box.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");

        deltagerSummary.setPrefHeight(150);
        deltagerSummary.setPrefWidth(200);

        ledsagerSummary.setPrefHeight(150);
        ledsagerSummary.setPrefWidth(200);

        hotelSummary.setPrefHeight(150);
        hotelSummary.setPrefWidth(200);

        box.getChildren().addAll(deltagerSummary, ledsagerSummary, hotelSummary);
        return box;
    }

    private void opretTilmeldingAction() {
        // Valider, om deltager og konference er valgt
        if (deltagerSummary.getItems().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Tilmelding kan ikke oprettes. Sørg for at udfylde deltageroplysninger.", ButtonType.OK);
            alert.showAndWait();
            return;
        }

        // Hent deltager
        Deltager deltager = deltagerSummary.getItems().getFirst();

        // Hent hotel (hvis valgt)
        Hotel hotel = hotelSummary.getItems().isEmpty() ? null : hotelSummary.getItems().getFirst();

        // Hent ledsager (hvis valgt)
        Ledsager ledsager = ledsagerSummary.getItems().isEmpty() ? null : ledsagerSummary.getItems().getFirst();


        try {
            // Hent datoer og foredragsholder-status
            LocalDate ankomst = ankomstDato.getValue();
            LocalDate afrejse = afrejseDato.getValue();


            // Valider, om datoerne er blevet valgt
            if (ankomst == null || afrejse == null) {
                throw new IllegalArgumentException("Sørg for at vælge både ankomst- og afrejsedato.");
            }

            // Valider, om ankomstdato er før eller lig med afrejsedato
            if (ankomst.isAfter(afrejse)) {
                throw new IllegalArgumentException("Ankomstdato skal være før eller lig med afrejsedato.");
            }

        } catch (IllegalArgumentException e) {
            // Vis en advarsel, hvis der opstår en valideringsfejl
            Alert alert = new Alert(Alert.AlertType.WARNING, e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        } catch (Exception e) {
            // Håndter andre uforudsete fejl
            Alert alert = new Alert(Alert.AlertType.ERROR, "Der opstod en uventet fejl: " + e.getMessage(), ButtonType.OK);
            alert.showAndWait();
        }


        // Opret Tilmelding via Controller
        Tilmelding tilmelding = Controller.createTilmelding(
                havOgHimmel, hotel, deltager, ledsager, ankomstDato.getValue(), afrejseDato.getValue(), foredragsholder.isSelected()

        );

        // Tilføj valgte udflugter til tilmeldingen
        for (Udflugt udflugt : udflugtList.getItems()) {
            tilmelding.tilføjUdflugt(udflugt);
        }

        // Tilføj valgte tilvalg (hotel-tillæg) til tilmeldingen
        for (Tilvalg tilvalg : tilvalgList.getItems()) {
            tilmelding.tilføjTilvalg(tilvalg);
        }

        // Kald beregnSamletPris for at beregne og vise prisen
        Controller.beregnSamletPris(tilmelding);


        // Byg en besked for at vise oplysningerne i en Alert
        StringBuilder besked = new StringBuilder();
        besked.append("Tilmelding oprettet!\n\n");

        // Tilføj deltageroplysninger
        besked.append("Deltager:\n");
        besked.append("Navn: ").append(deltager.getNavn()).append("\n");
        besked.append("Telefon: ").append(deltager.getTelefonnr()).append("\n");
        besked.append("Foredragsholder: ").append(foredragsholder.isSelected() ? "Ja" : "Nej").append("\n\n");

        // Tilføj ledsageroplysninger (hvis valgt)
        if (ledsager != null) {
            besked.append("Ledsager:\n");
            besked.append("Navn: ").append(ledsager.getNavn()).append("\n");
            if (!udflugtList.getItems().isEmpty()) {
                besked.append("Udflugter:\n");
                for (Udflugt u : udflugtList.getItems()) {
                    besked.append("- ").append(u.getAktivitet()).append("\n");
                }
            }
            besked.append("\n");
        }

        // Tilføj hoteloplysninger (hvis valgt)
        if (hotel != null) {
            besked.append("Hotel:\n");
            besked.append("Navn: ").append(hotel.getNavn()).append("\n");
            if (!tilvalgList.getItems().isEmpty()) {
                besked.append("Tilvalg:\n");
                for (Tilvalg t : tilvalgList.getItems()) {
                    besked.append("- ").append(t.getType()).append("\n");
                }
            }
            besked.append("\n");
        }

        // Tilføj datoer og status
        besked.append("Datoer:\n");
        besked.append("Ankomst: ").append(ankomstDato.getValue()).append("\n");
        besked.append("Afrejse: ").append(afrejseDato.getValue()).append("\n");


        // Vis beskeden i en Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Tilmelding Oprettet");
        alert.setHeaderText("Tilmeldingen er oprettet med følgende oplysninger:");
        alert.setContentText(besked.toString());
        alert.showAndWait();

        // Ryd felter efter oprettelse
        clearFields();
        notifyTabsUpdate();
    }

    private Runnable updateTabsCallback;

    public void setUpdateTabsCallback(Runnable callback) {
        this.updateTabsCallback = callback;
    }

    private void notifyTabsUpdate() {
        if (updateTabsCallback != null) {
            updateTabsCallback.run();
        }
    }


    private void clearFields() {
       deltagerNavn.clear();
       adresse.clear();
       by.clear();
       land.clear();
       telefonNr.clear();
       firmaTlfNr.clear();
       deltagerFirma.clear();
       foredragsholder.setDisable(false);
       tilfoejDeltager.setDisable(false);


        deltagerSummary.getItems().clear();
        ledsagerSummary.getItems().clear();
        hotelSummary.getItems().clear();


        udflugtList.getItems().clear();
        tilvalgList.getItems().clear();
        ankomstDato.setValue(null);
        afrejseDato.setValue(null);
        foredragsholder.setSelected(false);

        udflugt.getSelectionModel().clearSelection();
        tilfoejLedsager.setDisable(false);
        tilføjUdflugt.setDisable(false);
        fjernUdflugt.setDisable(false);


        hotelNavn.setDisable(false);
        tilvalg.getSelectionModel().clearSelection();
        tilvalg.setDisable(false);

        tilføjTillæg.setDisable(false);
        fjernTillaeg.setDisable(false);
        tilføjHotel.setDisable(false);
    }
}



