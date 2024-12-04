package exercise3;

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
//        int x1 = 20; // start point: (x1,y1)
//        int y1 = 10;
//        int x2 = 20; // end point: (x2,y2)
//        int y2 = 180;
//        while (x1 <= 180) {
//            gc.strokeLine(x1, y1, x2, y2);
//            x1 = x1 + 40;
//            x2 = x2 + 40;
//        }

//        int x1 = 20;
//        int y1 = 10;  // start point: (x1,y1)
//        int x2 = 180;
//        int y2 = 10; // end point: (x2,y2)
//        while (y1 <= 180) {
//            gc.strokeLine(x1, y1, x2, y2);
//            y1 = y1 + 40;
//            y2 = y2 + 40;
//        }

        int x1 = 90; // start point: (x1,y1)
        int y1 = 10;
        int x2 = 110; // end point: (x2,y2)
        int y2 = 10;
        int spaceY = 40;
        int lengthX = 20;

        while (y1 <= 180) {
            gc.strokeLine(x1, y1, x2, y2);

            y1 = y1 + spaceY;
            y2 = y2 + spaceY;

            x1 = x1 - lengthX;
            x2 = x2 + lengthX;
        }
    }

}
