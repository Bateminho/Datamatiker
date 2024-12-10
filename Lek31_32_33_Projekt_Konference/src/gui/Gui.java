package gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Konference Administrations System");

        // TabPane til at holde tabs
        TabPane tabPane = new TabPane();

        // Opret tabs
        TilmeldingTab tilmeldingTab = new TilmeldingTab();
        DeltagerOversigtTab deltagerOversigtTab = new DeltagerOversigtTab();
        UdflugtsOversigtTab udflugtsOversigtTab = new UdflugtsOversigtTab();
        HotelOversigtTab hotelOversigtTab = new HotelOversigtTab();

        // Sæt callback for at opdatere andre tabs fra TilmeldingTab
        tilmeldingTab.setUpdateTabsCallback(() -> {
            deltagerOversigtTab.updateContent();
            udflugtsOversigtTab.updateContent();
            hotelOversigtTab.updateContent();
        });

        // Tilføj Tabs
        tabPane.getTabs().add(createTab("Tilmelding", tilmeldingTab.createContent()));
        tabPane.getTabs().add(createTab("Deltageroversigt", deltagerOversigtTab.createContent()));
        tabPane.getTabs().add(createTab("Udflugtsoversigt", udflugtsOversigtTab.createContent()));
        tabPane.getTabs().add(createTab("Hoteloversigt", hotelOversigtTab.createContent()));

        // Scene setup
        Scene scene = new Scene(tabPane, 900, 650);
        stage.setScene(scene);
        stage.show();
    }

    // Hjælpefunktion til at oprette tabs
    private Tab createTab(String title, javafx.scene.layout.Pane content) {
        Tab tab = new Tab(title);
        tab.setClosable(false);
        tab.setContent(content);
        return tab;
    }


}
