package eksempeltab;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GuiDemoTab extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("Demo Tab view");
        BorderPane pane = new BorderPane();
        initContent(pane);
        
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }
    
    // -------------------------------------------------------------------------
    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }
    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabDemo1 = new Tab("Demo1");
        tabPane.getTabs().add(tabDemo1);

        PaneDemo2 panedemo2 = new PaneDemo2();
        tabDemo1.setContent(panedemo2);
        tabDemo1.setOnSelectionChanged(event -> panedemo2.updateControls());

        Tab demoTextArea = new Tab("Demo text area");
        tabPane.getTabs().add(demoTextArea);

        PaneDemoTextArea txtAreaPane = new PaneDemoTextArea();
        demoTextArea.setContent(txtAreaPane);
        demoTextArea.setOnSelectionChanged(event -> txtAreaPane.updateControls());
    }

}
