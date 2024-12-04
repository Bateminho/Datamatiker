package exercise1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application
{
    

    @Override
    public void start(Stage stage)
    {
        GridPane root = this.initContent();
        Scene scene = new Scene(root);

        stage.setTitle("Loops");
        stage.setScene(scene);
        stage.show();
    }

    private GridPane initContent()
    {
        GridPane pane = new GridPane();
        Canvas canvas = new Canvas(200, 200);
        pane.add(canvas, 0, 0);
        this.drawShapes(canvas.getGraphicsContext2D());
        return pane;
    }

    // ------------------------------------------------------------------------

    private void drawShapes(GraphicsContext gc)
    {
        // draw an arrowhead at (100,75)
        int x = 100;
        int y = 75;
        int lengthX = 20;
        int lengthY = 8;

        gc.strokeLine(x, y, x + lengthX, y - lengthY);
        gc.strokeLine(x, y, x + lengthX, y + lengthY);

        // draw an arrowhead at (100,125)

        int x2 = 100;
        int y2 = 125;
        gc.strokeLine(x2, y2, x2 + lengthX, y2 - lengthY);
        gc.strokeLine(x2, y2, x2 + lengthX, y2 + lengthY);

        int x3 = 20;
        int y3 = 50;
        gc.strokeLine(x3, y3, x3 + lengthX, y3 - lengthY);
        gc.strokeLine(x3, y3, x3 + lengthX, y3 + lengthY);
    }

}
