package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Deltager;

public class Gui extends Application {

    // Felter for deltager-sektionen
    private TextField deltagerNavn = new TextField();
    private TextField adresse = new TextField();
    private TextField by = new TextField();
    private TextField land = new TextField();
    private TextField telefonNr = new TextField();
    private TextField deltagerFirma = new TextField();
    private TextField firmaTlfNr = new TextField();
    private CheckBox foredragsholder = new CheckBox("Foredragsholder");
    private Button tilfoejDeltager = new Button("Tilføj Deltager");

    // Felter for oversigter
    private ListView<Deltager> deltagerSummary = new ListView<>();
    private ListView<String> ledsagerSummary = new ListView<>();
    private ListView<String> hotelSummary = new ListView<>();

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
        Scene scene = new Scene(tabPane, 900, 600);
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

        // Tilføj Deltager Section
        VBox deltagerBox = new VBox();
        deltagerBox.setSpacing(10);
        deltagerBox.setPadding(new Insets(10));
        deltagerBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        deltagerBox.setPrefHeight(300);

        Label deltagerHeader = new Label("Tilføj Deltager");
        deltagerHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        deltagerBox.getChildren().add(deltagerHeader);

        deltagerNavn.setPromptText("Navn");
        adresse.setPromptText("Adresse");
        by.setPromptText("By");
        land.setPromptText("Land");
        telefonNr.setPromptText("Telefonnummer");
        deltagerFirma.setPromptText("Firma");
        firmaTlfNr.setPromptText("Firma Telefonnummer");


        tilfoejDeltager.setOnAction(event -> tilføjDeltagerAction());

        deltagerBox.getChildren().addAll(
                deltagerNavn, adresse, by, land, telefonNr, deltagerFirma, firmaTlfNr, foredragsholder, tilfoejDeltager
        );

        root.add(deltagerBox, 0, 1);

        // Tilføj Ledsager Section
        VBox ledsagerBox = new VBox();
        ledsagerBox.setSpacing(10);
        ledsagerBox.setPadding(new Insets(10));
        ledsagerBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        ledsagerBox.setPrefHeight(300);

        Label ledsagerHeader = new Label("Tilføj Ledsager");
        ledsagerHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        ledsagerBox.getChildren().add(ledsagerHeader);

        TextField ledsagerNavn = new TextField();
        ledsagerNavn.setPromptText("Navn");

        ComboBox<String> udflugt = new ComboBox<>();
        udflugt.getItems().addAll("Byrundtur", "Egeskov", "Trapholt Museum");
        udflugt.setPromptText("Udflugt");

        Button tilfoejUdflugt = new Button("Tilføj Udflugt");
        Button fjernUdflugt = new Button("Fjern Udflugt");

        ListView<String> udflugtList = new ListView<>();
        udflugtList.getItems().addAll("Byrundtur", "Egeskov");

        Button tilfoejLedsager = new Button("Tilføj Ledsager");
        tilfoejLedsager.setOnAction(e -> {
            if (!ledsagerNavn.getText().isEmpty()) {
                ledsagerSummary.getItems().add("Ledsager: " + ledsagerNavn.getText());
                ledsagerNavn.clear();
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "Indtast venligst ledsagerens navn!", ButtonType.OK);
                alert.showAndWait();
            }
        });

        ledsagerBox.getChildren().addAll(ledsagerNavn, udflugt, tilfoejUdflugt, fjernUdflugt, udflugtList, tilfoejLedsager);

        root.add(ledsagerBox, 1, 1);

        // Hotel Section
        VBox hotelBox = new VBox();
        hotelBox.setSpacing(10);
        hotelBox.setPadding(new Insets(10));
        hotelBox.setStyle("-fx-border-color: #ccc; -fx-border-radius: 8px; -fx-background-color: #f9f9f9;");
        hotelBox.setPrefHeight(300);

        Label hotelHeader = new Label("Vælg Hotel");
        hotelHeader.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
        hotelBox.getChildren().add(hotelHeader);

        ComboBox<String> hotelNavn = new ComboBox<>();
        hotelNavn.getItems().addAll("Den Hvide Svane", "Hotel Phønix", "Pension Tusindfryd");
        hotelNavn.setPromptText("Hotel");

        ComboBox<String> tillaeg = new ComboBox<>();
        tillaeg.getItems().addAll("WiFi", "Morgenmad", "Bad på værelset");
        tillaeg.setPromptText("Tillæg");

        Button tilfoejTillaeg = new Button("Tilføj Tillæg");
        Button fjernTillaeg = new Button("Fjern Tillæg");

        ListView<String> tillaegList = new ListView<>();
        tillaegList.getItems().addAll("WiFi", "Morgenmad");

        Button tilfoejHotel = new Button("Tilføj Hotel");

        hotelBox.getChildren().addAll(hotelNavn, tillaeg, tilfoejTillaeg, fjernTillaeg, tillaegList, tilfoejHotel);

        root.add(hotelBox, 2, 1);

        // Summary Fields
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
        opretTilmelding.setOnAction(e -> {
            //deltagerSummary.getItems().add("Deltager: " + deltagerNavn.getText());
            ledsagerSummary.getItems().add("Ledsager: " + ledsagerNavn.getText());
            hotelSummary.getItems().add("Hotel: " + hotelNavn.getValue());
        });
        root.add(opretTilmelding, 0, 3, 3, 1);

        return root;
    }

    // Pane for "Deltageroversigt" Tab
    private Pane createDeltagerOversigtPane() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.getChildren().add(new Label("Deltageroversigt - Her vises en liste over deltagere."));
        return root;
    }

    // Pane for "Udflugtsoversigt" Tab
    private Pane createUdflugtsOversigtPane() {
        VBox root = new VBox();
        root.setSpacing(10);
        root.setPadding(new Insets(20));
        root.getChildren().add(new Label("Udflugtsoversigt - Her vises en liste over udflugter."));
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
        tilfoejDeltager.setDisable(true);
        foredragsholder.setDisable(true);
    }



}
