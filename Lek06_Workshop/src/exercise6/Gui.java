package exercise6;

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

        //Straight line
        gc.strokeLine(5, 175, 185, 175);

        //Arrowhead
        int xA = 185;
        int yA = 175;
        gc.strokeLine(xA, yA, xA - 10, yA - 6);
        gc.strokeLine(xA, yA, xA - 10, yA + 6);

        //Vertical strokes
        int y1 = 170;
        int y2 = 180;
        for (int i = 0; i <= 10; i++) {
            int x = 15 + i * 15;

            if (i % 5 == 0) {
                gc.strokeLine(x, y1 - 5, x, y2 + 5);
                // Add numbers at the long strokes
                gc.fillText(String.valueOf(i), x - 3, y2 + 17);

            } else gc.strokeLine(x, y1, x, y2);

        }
    }

}
