package exercise10;

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

        for (int i = 50; i <= 150; i+=25) {
            this.drawCircle(gc, i, 100, 40);
            this.drawCross(gc, i, 100);
        }
    }

    public void drawCircle(GraphicsContext gc, int x, int y, int r) {


        gc.strokeOval(x - r, y - r, 2 * r, 2 * r);


    }

    public void drawCross(GraphicsContext gc, int x, int y) {

        int size = 5;
        int x1 = x - size;
        int x2 = x + size;
        int y1 = y + size;
        int y2 = y - size;

        gc.strokeLine(x1, y, x2, y);
        gc.strokeLine(x, y1 , x, y2 );
    }

}
