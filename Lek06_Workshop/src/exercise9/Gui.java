package exercise9;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {


    @Override
    public void start(Stage stage) {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent() {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc) {
        double x = 180; // Start ved x = 180
        double y2 = 190; // Startposition for bunden af linjen (y2)
        double y1; // Toppen af linjen (y1)

        while (x > 5) {
            // Beregn toppen af linjen baseret på x-værdien (x / 2 + x / 5)
            y1 = y2 - (x / 2 + x / 5);

            // Tegn linjen
            gc.strokeLine(x, y1, x, y2);

            // Reducer x-værdien med 25% (x = x * 0.75)
            x = x * 0.75;

            // Juster y2 (bunden) lidt op for næste iteration
            y2 = y2 - (x / 5); // Juster bunden baseret på x's ændring

        }
    }


}
