package exercise6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.zip.CheckedOutputStream;

public class Gui4 extends Application {

    @Override
    public void start(Stage stage) {
        Pane pane = new Pane();
        this.initContent(pane);
        Scene scene = new Scene(pane, 400, 400);

        stage.setTitle("Shapes");
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(Pane pane) {
        double x = 60; // Start x-position for pyramiden
        double y = 300; // Start y-position for pyramiden
        double length = 30; // Længden af hver kvadrat

        int rows = 10; // Antal rækker i pyramiden

        for (int row = 0; row < rows; row++) {
            // Beregn den startende x-position for hver række, så de er centrerede
            for (int i = 0; i < rows - row; i++) {
                Rectangle square = new Rectangle(x + i * length, y, length, length);
                square.setStroke(Color.WHITE);
                square.setStrokeWidth(2);
                square.setFill(Color.BURLYWOOD); // Gør firkanten synlig
                pane.getChildren().add(square);
            }
            // Opdater y-positionen for næste række og juster x-positionen
            y -= length; // Flyt opad for næste række
            x += length / 2; // Flyt til højre for næste række for at centrere den
        }
    }

}
