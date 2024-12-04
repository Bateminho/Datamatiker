package exercise4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Gui extends Application {

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

        double circleX = 200;
        double circleY = 200;
        double circleRadius = 100;
        double change = circleRadius * 0.2;



        for (int i = 0; i < 5; i++) {
            Circle circle = new Circle(circleX, circleY, circleRadius);
            pane.getChildren().add(circle);
            if (i % 2 != 0) {
                circle.setFill(Color.WHITE);
            }
            circleRadius -= change;
        }

    }
}
