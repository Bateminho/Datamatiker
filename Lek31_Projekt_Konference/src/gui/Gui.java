package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Gui extends Application {

    public void start(Stage stage) {
        stage.setTitle("Konference Administrations System");

        // Root layout
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

        TextField deltagerNavn = new TextField();
        deltagerNavn.setPromptText("Navn");
        TextField adresse = new TextField();
        adresse.setPromptText("Adresse");
        TextField by = new TextField();
        by.setPromptText("By");
        TextField land = new TextField();
        land.setPromptText("Land");
        TextField telefonNr = new TextField();
        telefonNr.setPromptText("Telefonnummer");
        TextField deltagerFirma = new TextField();
        deltagerFirma.setPromptText("Firma");
        TextField firmaTlfNr = new TextField();
        firmaTlfNr.setPromptText("Firma Telefonnummer");

        CheckBox foredragsholder = new CheckBox("Foredragsholder");

        Button tilfoejDeltager = new Button("Tilføj Deltager");

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

        ListView<String> deltagerSummary = new ListView<>();
        deltagerSummary.setPrefHeight(150);
        deltagerSummary.setPrefWidth(200);

        ListView<String> ledsagerSummary = new ListView<>();
        ledsagerSummary.setPrefHeight(150);
        ledsagerSummary.setPrefWidth(200);

        ListView<String> hotelSummary = new ListView<>();
        hotelSummary.setPrefHeight(150);
        hotelSummary.setPrefWidth(200);

        summaryContainer.getChildren().addAll(deltagerSummary, ledsagerSummary, hotelSummary);
        root.add(summaryContainer, 0, 2, 3, 1);

        // Add "Opret Tilmelding" Button
        Button opretTilmelding = new Button("Opret Tilmelding");
        opretTilmelding.setOnAction(e -> {
            deltagerSummary.getItems().add("Deltager: " + deltagerNavn.getText());
            ledsagerSummary.getItems().add("Ledsager: " + ledsagerNavn.getText());
            hotelSummary.getItems().add("Hotel: " + hotelNavn.getValue());
        });

        root.add(opretTilmelding, 0, 3, 3, 1);

        // Scene setup
        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }


}
