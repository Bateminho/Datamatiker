package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gui extends Application {

    // Felter for deltager-sektionen
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

    //Felter for ledsager-sektion
    private Button tilføjUdflugt = new Button("Tilføj Udflugt");
    private Button fjernUdflugt = new Button("Fjern Udflugt");
    private Button tilfoejLedsager = new Button("Tilføj Ledsager");
    private TextField ledsagerNavn = new TextField();
    private ComboBox<Udflugt> udflugt = new ComboBox<>();
    private ListView<Udflugt> udflugtList = new ListView<>();


    //Felter for hotel-sektion
    private ComboBox<Hotel> hotelNavn = new ComboBox<>();
    private ComboBox<Tilvalg> tilvalg = new ComboBox<>();
    private Button tilfoejTillaeg = new Button("Tilføj Tillæg");
    private Button fjernTillaeg = new Button("Fjern Tillæg");
    private ListView<Tilvalg> tillægList = new ListView<>();
    private Button tilfoejHotel = new Button("Tilføj Hotel");

    // Felter for oversigter
    private ListView<Deltager> deltagerSummary = new ListView<>();
    private ListView<Ledsager> ledsagerSummary = new ListView<>();
    private ListView<Hotel> hotelSummary = new ListView<>();


    //Deltagerliste
    private ListView<Tilmelding> tilmeldingListView = new ListView<>();

    //Udflugtslist
    private ListView<Udflugt> fuldUdflugtsliste = new ListView<>();
    private ListView<String> deltagendeLedsagere = new ListView<>();

    public void start(Stage stage) {
        stage.setTitle("Konference Administrations System");

        // Root layout with TabPane
        TabPane tabPane = new TabPane();

        // Tab: Tilmelding
        Tab tilmeldingTab = new Tab("Tilmelding");
        tilmeldingTab.setClosable(false);
        tilmeldingTab.setContent(createTilmeldingPane());

        // Tab: Deltageroversigt
        Tab deltagerOversigtTab = new Tab("Deltageroversigt");
        deltagerOversigtTab.setClosable(false);
        deltagerOversigtTab.setContent(createDeltagerOversigtPane());

        // Tab: Udflugtsoversigt
        Tab udflugtsOversigtTab = new Tab("Udflugtsoversigt");
        udflugtsOversigtTab.setClosable(false);
        udflugtsOversigtTab.setContent(createUdflugtsOversigtPane());

        // Tab: Hoteloversigt
        Tab hotelOversigtTab = new Tab("Hoteloversigt");
        hotelOversigtTab.setClosable(false);
        hotelOversigtTab.setContent(createHotelOversigtPane());

        // Add tabs to TabPane
        tabPane.getTabs().addAll(tilmeldingTab, deltagerOversigtTab, udflugtsOversigtTab, hotelOversigtTab);

        // Scene setup
        Scene scene = new Scene(tabPane, 900, 650);
        stage.setScene(scene);
        stage.show();
    }

    // Pane for "Tilmelding" Tab
    private Pane createTilmeldingPane() {
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(20));

        // Header
        Label header = new Label("Prototype KAS - Konference Administrations System");
        header.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        root.add(header, 0, 0, 3, 1);

        // --------------------------------Tilføj Deltager Section -------------------------------------------------
        VBox deltagerBox = new VBox();
        deltagerBox.setSpacing(10);
        deltagerBox.setPadding(new Insets(10));
        deltagerBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        deltagerBox.setPrefHeight(400);

        Label deltagerHeader = new Label("Tilføj Deltager");
        deltagerHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        deltagerBox.getChildren().add(deltagerHeader);

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

        deltagerBox.getChildren().addAll(
                deltagerNavn, adresse, by, land, telefonNr, ankomstDato, afrejseDato, deltagerFirma, firmaTlfNr, foredragsholder, tilfoejDeltager
        );

        root.add(deltagerBox, 0, 1);

        // --------------------------------Tilføj Ledsager Section ----------------------------------------------------
        VBox ledsagerBox = new VBox();
        ledsagerBox.setSpacing(10);
        ledsagerBox.setPadding(new Insets(10));
        ledsagerBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        ledsagerBox.setPrefHeight(300);

        Label ledsagerHeader = new Label("Tilføj Ledsager");
        ledsagerHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        ledsagerBox.getChildren().add(ledsagerHeader);

        ledsagerNavn.setPromptText("Navn");

        udflugt.getItems().setAll(Controller.getUdflugter(Controller.getKonference().getFirst()));
        udflugt.setPromptText("Udflugt");


        tilføjUdflugt.setOnAction(e -> tilføjUdflugtAction());

        fjernUdflugt.setOnAction(e -> fjernUdflugtAction());

        tilfoejLedsager.setOnAction(e -> tilføjLedsagerAction());

        ledsagerBox.getChildren().addAll(ledsagerNavn, udflugt, tilføjUdflugt, fjernUdflugt, udflugtList, tilfoejLedsager);

        root.add(ledsagerBox, 1, 1);

        // --------------------------------Hotel Section -------------------------------------------------------------
        VBox hotelBox = new VBox();
        hotelBox.setSpacing(10);
        hotelBox.setPadding(new Insets(10));
        hotelBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        hotelBox.setPrefHeight(300);

        Label hotelHeader = new Label("Vælg Hotel");
        hotelHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        hotelBox.getChildren().add(hotelHeader);

        hotelNavn.getItems().setAll(Controller.getHoteller());
        hotelNavn.setPromptText("Hotel");

        // Tilføj ChangeListener til ComboBox
        hotelNavn.valueProperty().addListener((observable, oldValue, newValue) -> {
            tilvalg.getItems().setAll(hotelNavn.getSelectionModel().getSelectedItem().getTilvalg());
            tillægList.getItems().clear();

        });

        tilvalg.setPromptText("Tillæg");

        tilfoejTillaeg.setOnAction(e -> tilføjTillægAction());
        fjernTillaeg.setOnAction(e -> fjernTillaegAction());
        tilfoejHotel.setOnAction(e -> tilfoejHotelAction());

        hotelBox.getChildren().addAll(hotelNavn, tilvalg, tilfoejTillaeg, fjernTillaeg, tillægList, tilfoejHotel);

        root.add(hotelBox, 2, 1);

        // -------------------------Summary Fields---------------------------------------------------------
        HBox summaryContainer = new HBox(20);
        summaryContainer.setSpacing(20);
        summaryContainer.setPadding(new Insets(10));
        summaryContainer.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");

        deltagerSummary.setPrefHeight(150);
        deltagerSummary.setPrefWidth(200);

        ledsagerSummary.setPrefHeight(150);
        ledsagerSummary.setPrefWidth(200);

        hotelSummary.setPrefHeight(150);
        hotelSummary.setPrefWidth(200);

        summaryContainer.getChildren().addAll(deltagerSummary, ledsagerSummary, hotelSummary);
        root.add(summaryContainer, 0, 2, 3, 1);

        // Add "Opret Tilmelding" Button
        Button opretTilmelding = new Button("Opret Tilmelding");

        opretTilmelding.setOnAction(e -> opretTilmeldingAction());

        root.add(opretTilmelding, 0, 3, 3, 1);

        return root;
    }

    //--------------------------------- Pane for "Deltageroversigt" Tab ---------------------------------------
    private Pane createDeltagerOversigtPane() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.getChildren().add(tilmeldingListView);
        tilmeldingListView.getItems().setAll(havOgHimmel.getTilmeldinger());
        return root;
    }

    // ----------------------------Pane for "Udflugtsoversigt" Tab ---------------------------------------------
    private Pane createUdflugtsOversigtPane() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        HBox listholder = new HBox(20);
        listholder.setSpacing(20);
        listholder.setPadding(new Insets(10));
        listholder.getChildren().addAll(fuldUdflugtsliste, deltagendeLedsagere);
        fuldUdflugtsliste.getItems().setAll(havOgHimmel.getUdflugter());
        fuldUdflugtsliste.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            deltagendeLedsagere.getItems().clear();
            for (Tilmelding tilmelding : havOgHimmel.getTilmeldinger()) {
                if (tilmelding.getLedsager() != null) {
                    for (Udflugt udflugt : tilmelding.getUdflugter()) {
                        if (udflugt.equals(newValue)) {
                            deltagendeLedsagere.getItems().add(tilmelding.getLedsager().getNavn() + " (" + tilmelding.getDeltager() + ", tlfnr: " + tilmelding.getDeltager().getTelefonnr() + ")");
                        }
                    }
                }
            }
        });

        deltagendeLedsagere.getItems().setAll();
        root.getChildren().add(listholder);
        return root;
    }

    // Pane for "Hoteloversigt" Tab
    private Pane createHotelOversigtPane() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.getChildren().add(new Label("Hoteloversigt - Her vises en liste over hoteller."));
        return root;
    }

    public void tilføjDeltagerAction(){
        String navn = deltagerNavn.getText().trim();
        String adresseDeltager = adresse.getText().trim();
        String byDeltager = by.getText().trim();
        String landDeltager = land.getText().trim();
        String telefon = telefonNr.getText().trim();
        String firma = deltagerFirma.getText().trim();
        String firmaTlf = firmaTlfNr.getText().trim();


        Deltager deltager = Controller.createDeltager(navn, adresseDeltager, byDeltager, landDeltager, telefon, firma, firmaTlf);

        deltagerSummary.getItems().add(deltager);
        ankomstDato.setDisable(true);
        afrejseDato.setDisable(true);
        tilfoejDeltager.setDisable(true);
        foredragsholder.setDisable(true);
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

        if (!navn.isEmpty()) {
            ledsagerSummary.getItems().add(ledsager);
            ledsagerNavn.clear();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Indtast venligst ledsagerens navn!", ButtonType.OK);
            alert.showAndWait();
        }


        tilfoejLedsager.setDisable(true);
        tilføjUdflugt.setDisable(true);
        fjernUdflugt.setDisable(true);

    }

    //---------------------------------------------------------------------------------

    private void tilføjTillægAction() {
        Tilvalg valgtTilvalg = tilvalg.getValue();
        if (valgtTilvalg != null && !tillægList.getItems().contains(valgtTilvalg)) {
            tillægList.getItems().add(valgtTilvalg);
        }
    }

    private void fjernTillaegAction() {
        tillægList.getItems().remove(tillægList.getSelectionModel().getSelectedItem());
    }

    private void tilfoejHotelAction(){
        Hotel hotel = hotelNavn.getValue();

        hotelSummary.getItems().add(hotel);

        hotelNavn.setDisable(true);
        tilvalg.setDisable(true);
        tilfoejTillaeg.setDisable(true);
        fjernTillaeg.setDisable(true);
        tilfoejHotel.setDisable(true);

    }

    //--------------------------------------------------------------------------------------------

    private void opretTilmeldingAction() {
        Konference konference = Controller.getKonference().getFirst();
        Deltager deltager = deltagerSummary.getItems().getFirst();
        Ledsager ledsager = ledsagerSummary.getItems().getFirst();
        Hotel hotel = hotelSummary.getItems().getFirst();
        boolean foredragsHolder = foredragsholder.isSelected();
        LocalDate ankomst = ankomstDato.getValue();
        LocalDate afrejse = afrejseDato.getValue();

       Tilmelding tilmelding = Controller.createTilmelding(konference, hotel, deltager, ledsager, ankomst, afrejse, foredragsHolder);

        for (Udflugt udflugt1 : udflugtList.getItems()) {
            tilmelding.tilføjUdflugt(udflugt1);
        }

    }
}
