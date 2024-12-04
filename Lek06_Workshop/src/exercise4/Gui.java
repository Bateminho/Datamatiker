package exercise4;

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
//        int x = 100; //Center: (x,y)
//        int y = 100;
//        int r = 20; // Radius: r
//
//        while(r <= 100) {
//            gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//            r = r + 20;
//        }

//        int x = 20;
//        int y = 100;
//        int r = 10;
//
//        while(r <= 80) {
//            gc.strokeOval(x - r, y - r, 2 * r, 2 * r);
//            x = x + 10;
//            r = r + 10;
//        }

        int placementOnX = 20;
        int widthOnX = 160;
        int placementOnY = 50;
        int heigthY = 65;

        while (widthOnX >= 20) {
            gc.strokeOval(placementOnX, placementOnY, widthOnX, heigthY);
            placementOnX = placementOnX + 10;
            widthOnX = widthOnX -20;
       }
    }

}
