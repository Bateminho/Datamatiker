package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

public class Gui extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        // Titel på vinduet
        stage.setTitle("Fraværssystem");

        // Root GridPane til struktur
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10)); // Sæt padding rundt om hele layoutet
        pane.setHgap(15); // Vandret mellemrum mellem elementer
        pane.setVgap(10); // Lodret mellemrum mellem elementer

        // Opret en Scene og tilknyt den til vinduet
        Scene scene = new Scene(pane, 900, 300);
        stage.setScene(scene);

        // Initialiser indholdet i pane
        initContent(pane);

        // Vis vinduet
        stage.show();
    }

    // ListViews til visning af data
    private ListView<Fag> lvwFag = new ListView<>();
    private ListView<Lektion> lvwLektion = new ListView<>();
    private ListView<Deltagelse> lvwDeltagelse = new ListView<>();

    // ToggleGroup til Radiobuttons (vælg kun én årsag ad gangen)
    private final ToggleGroup group = new ToggleGroup();

    private void initContent(GridPane pane) {
        // ---------------------------------------
        // 1. Konfigurering af ListView-sektioner
        // ---------------------------------------

        // ListView størrelse
        lvwFag.setPrefSize(250, 250); // Fag-liste
        lvwLektion.setPrefSize(250, 250); // Lektion-liste
        lvwDeltagelse.setPrefSize(250, 250); // Deltagelse-liste

        // Labels og ListView i VBox (lodret layout)
        VBox fagBox = new VBox(5, new Label("Fag"), lvwFag); // Label + Fag-listen
        VBox lektionBox = new VBox(5, new Label("Lektion"), lvwLektion); // Label + Lektion-listen
        VBox deltagelseBox = new VBox(5, new Label("Deltagelse"), lvwDeltagelse); // Label + Deltagelse-listen

        // Saml alle sektioner i en HBox (vandret layout)
        HBox listSection = new HBox(15, fagBox, lektionBox, deltagelseBox);
        listSection.setAlignment(Pos.CENTER); // Centrer sektionerne

        // ---------------------------------------
        // 2. Radiobuttons til fraværsårsager
        // ---------------------------------------

        Label lblFravaers = new Label("Fraværsårsager");
        RadioButton rbTilstede = createRadioButton("Tilstede");
        RadioButton rbSyg = createRadioButton("Syg");
        RadioButton rbFravaer = createRadioButton("Fravær");
        RadioButton rbAfbud = createRadioButton("Afbud");
        Button btnFravaer = new Button("Fravær");

        btnFravaer.setOnAction(event -> handleFravaerAction());


        // Saml radiobuttons i en VBox (lodret layout)
        VBox radioBox = new VBox(10, lblFravaers, rbTilstede, rbSyg, rbFravaer, rbAfbud, btnFravaer);
        radioBox.setAlignment(Pos.TOP_LEFT);
        radioBox.setPadding(new Insets(10)); // Luft rundt om radiobuttons

        // ---------------------------------------
        // 3. Tilføj elementer til pane (layout)
        // ---------------------------------------
        pane.add(listSection, 0, 0); // Tilføj ListView-sektionerne til GridPane
        pane.add(radioBox, 1, 0); // Tilføj radiobuttons til GridPane

        // ---------------------------------------
        // 4. Indlæs data i lvwFag (Fag-listen)
        // ---------------------------------------
        // Hent data fra Controller (skal returnere en liste med Fag)
        lvwFag.getItems().setAll(Controller.getFag());

        // ---------------------------------------
        // 5. Listener til Fag (opdater Lektioner)
        // ---------------------------------------
        lvwFag.getSelectionModel().selectedItemProperty().addListener((obs, oldFag, newFag) -> {
            if (newFag != null) { // Sørg for, at et Fag er valgt
                // Hent lektioner fra det valgte Fag og vis dem i lvwLektion
                lvwLektion.getItems().setAll(newFag.getLektioner());

                // Ryd Deltagelse-listen, når et nyt Fag vælges
                lvwDeltagelse.getItems().clear();
            }
        });

        // ---------------------------------------
        // 6. Listener til Lektion (opdater Deltagelser)
        // ---------------------------------------
        lvwLektion.getSelectionModel().selectedItemProperty().addListener((obs, oldLektion, newLektion) -> {
            if (newLektion != null) { // Sørg for, at en Lektion er valgt
                // Hent deltagelser fra den valgte Lektion og vis dem i lvwDeltagelse
                lvwDeltagelse.getItems().setAll(newLektion.getDeltagelser());
            }
        });
    }

    private void handleFravaerAction() {
        // 1. Få fat i den valgte RadioButton fra ToggleGroup
        RadioButton selectedRadio = (RadioButton) group.getSelectedToggle();
        if (selectedRadio == null) {
            System.out.println("Ingen fraværsårsag valgt.");
            return;
        }

        // 2. Hent den valgte Deltagelse fra lvwDeltagelse
        Deltagelse selectedDeltagelse = lvwDeltagelse.getSelectionModel().getSelectedItem();
        if (selectedDeltagelse == null) {
            System.out.println("Ingen deltagelse valgt.");
            return;
        }

        // 3. Opdater status på deltagelsen baseret på radiobuttonens tekst
        String radioText = selectedRadio.getText();
        switch (radioText) {
            case "Tilstede":
                selectedDeltagelse.setStatus(DeltagerStatus.TILSTEDE);
                break;
            case "Syg":
                selectedDeltagelse.setStatus(DeltagerStatus.SYG);
                break;
            case "Fravær":
                selectedDeltagelse.setStatus(DeltagerStatus.FRAVÆR);
                break;
            case "Afbud":
                selectedDeltagelse.setStatus(DeltagerStatus.AFBUD);
                break;
            default:
                System.out.println("Ukendt status valgt.");
                return;
        }

        // 4. Opdater ListView for at vise den nye status
        lvwDeltagelse.refresh();

//        // 5. Bekræft ændringen i konsollen (valgfrit)
//        System.out.println("Status ændret til " + selectedDeltagelse.getStatus() +
//                " for " + selectedDeltagelse.getStuderende().getNavn());
    }


    /**
     * Hjælpemetode til at oprette en radiobutton med fælles ToggleGroup.
     * @param text Teksten, der vises på radiobuttonen.
     * @return En ny RadioButton.
     */
    private RadioButton createRadioButton(String text) {
        RadioButton rb = new RadioButton(text);
        rb.setToggleGroup(group); // Tilføj til fælles ToggleGroup
        return rb;
    }


}
