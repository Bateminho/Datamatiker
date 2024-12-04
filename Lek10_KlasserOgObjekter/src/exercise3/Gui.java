package exercise3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
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

        double headX = 200;
        double headY = 200;
        double headRadius = 100;

        Circle head = new Circle(headX, headY, headRadius);
        pane.getChildren().add(head);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);

        double eyeRadius = headRadius * 0.1;

        Circle leftEye = new Circle(headX - headRadius * 0.3, headY - headRadius * 0.3, eyeRadius);
        pane.getChildren().add(leftEye);
        Circle rightEye = new Circle(headX + headRadius * 0.3, headY - headRadius * 0.3, eyeRadius);
        pane.getChildren().add(rightEye);
        leftEye.setFill(Color.WHITE);
        leftEye.setStroke(Color.BLACK);
        rightEye.setFill(Color.WHITE);
        rightEye.setStroke(Color.BLACK);

        Line mouth = new Line(headX - headRadius * 0.4,
                headY + headRadius * 0.3,
                headX + headRadius * 0.4,
                headY + headRadius * 0.3);

        pane.getChildren().add(mouth);
        mouth.setStroke(Color.BLACK);
    }
}
