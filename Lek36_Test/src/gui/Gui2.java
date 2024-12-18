package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

public class Gui2 extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Fraværssystem");

        // Root GridPane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10)); // Padding rundt om hele panelet
        pane.setHgap(10); // Vandret mellemrum mellem kolonner
        pane.setVgap(10); // Lodret mellemrum mellem rækker

        Scene scene = new Scene(pane, 900, 300);
        stage.setScene(scene);

        initContent(pane);
        stage.show();
    }

    // ListViews til visning af data
    private ListView<Fag> lvwFag = new ListView<>();
    private ListView<Lektion> lvwLektion = new ListView<>();
    private ListView<Deltagelse> lvwDeltagelse = new ListView<>();
    private final ToggleGroup group = new ToggleGroup(); // ToggleGroup til RadioButtons

    private void initContent(GridPane pane) {
        // ---------------------------------------
        // 1. Konfiguration af ListView-sektioner
        // ---------------------------------------

        Label lblFag = new Label("Fag");
        Label lblLektion = new Label("Lektion");
        Label lblDeltagelse = new Label("Deltagelse");

        lvwFag.setPrefSize(250, 250);
        lvwLektion.setPrefSize(250, 250);
        lvwDeltagelse.setPrefSize(250, 250);

        pane.add(lblFag, 0, 0);
        pane.add(lvwFag, 0, 1);

        pane.add(lblLektion, 1, 0);
        pane.add(lvwLektion, 1, 1);

        pane.add(lblDeltagelse, 2, 0);
        pane.add(lvwDeltagelse, 2, 1);

        // ---------------------------------------
        // 2. Radioknapper og Fravær-knap i VBox
        // ---------------------------------------

        Label lblFravaers = new Label("Fraværsårsager");
        RadioButton rbTilstede = createRadioButton("Tilstede");
        RadioButton rbSyg = createRadioButton("Syg");
        RadioButton rbFravaer = createRadioButton("Fravær");
        RadioButton rbAfbud = createRadioButton("Afbud");
        Button btnFravaer = new Button("Fravær");

        // Opret en VBox til radioknapper og knappen (lodret layout)
        VBox radioButtonBox = new VBox(10, rbTilstede, rbSyg, rbFravaer, rbAfbud, btnFravaer);
        radioButtonBox.setAlignment(Pos.TOP_LEFT);

        // Tilføj label og VBox til GridPane
        pane.add(lblFravaers, 3, 0);       // Fraværsårsag label i kolonne 3, række 0
        pane.add(radioButtonBox, 3, 1);    // VBox med radioknapper og knap i kolonne 3, række 1

        // ---------------------------------------
        // 3. Action handler til knappen
        // ---------------------------------------
        btnFravaer.setOnAction(event -> handleFravaerAction());

        // ---------------------------------------
        // 4. Indlæs data i lvwFag
        // ---------------------------------------
        lvwFag.getItems().setAll(Controller.getFag());

        // Listener til opdatering af Lektioner
        lvwFag.getSelectionModel().selectedItemProperty().addListener((obs, oldFag, newFag) -> {
            if (newFag != null) {
                lvwLektion.getItems().setAll(newFag.getLektioner());
                lvwDeltagelse.getItems().clear();
            }
        });

        // Listener til opdatering af Deltagelser
        lvwLektion.getSelectionModel().selectedItemProperty().addListener((obs, oldLektion, newLektion) -> {
            if (newLektion != null) {
                lvwDeltagelse.getItems().setAll(newLektion.getDeltagelser());
            }
        });
    }



    private void handleFravaerAction() {
        // Hent valgt RadioButton og deltagelse
        RadioButton selectedRadio = (RadioButton) group.getSelectedToggle();
        Deltagelse selectedDeltagelse = lvwDeltagelse.getSelectionModel().getSelectedItem();

        if (selectedRadio != null && selectedDeltagelse != null) {
            switch (selectedRadio.getText()) {
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
            }
            lvwDeltagelse.refresh();
        }
    }

    /**
     * Hjælpemetode til at oprette radiobuttons.
     */
    private RadioButton createRadioButton(String text) {
        RadioButton rb = new RadioButton(text);
        rb.setToggleGroup(group); // Tilføj til fælles ToggleGroup
        return rb;
    }
}
