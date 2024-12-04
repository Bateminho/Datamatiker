package smileyFace;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.util.Arrays;

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
        double headRadius = 150;

        Circle head = new Circle(headX, headY, headRadius);
        pane.getChildren().add(head);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);

        double eyeRadius = headRadius * 0.1;

        Ellipse leftEye = new Ellipse(headX - headRadius * 0.3, headY - headRadius * 0.3, 30, 22 );
        pane.getChildren().add(leftEye);
        leftEye.setFill(Color.TRANSPARENT);
        leftEye.setStroke(Color.BLACK);


        Ellipse rightEye = new Ellipse(headX + headRadius * 0.3, headY - headRadius * 0.3, 30, 22);
        pane.getChildren().add(rightEye);
        rightEye.setFill(Color.TRANSPARENT);
        rightEye.setStroke(Color.BLACK);

        Circle leftEyePupil = new Circle(headX - headRadius * 0.3, headY - headRadius * 0.3, eyeRadius);
        pane.getChildren().add(leftEyePupil);
        Circle rightEyePupil = new Circle(headX + headRadius * 0.3, headY - headRadius * 0.3, eyeRadius);
        pane.getChildren().add(rightEyePupil);
        leftEyePupil.setStroke(Color.BLACK);
        rightEyePupil.setStroke(Color.BLACK);

        Polygon nose = new Polygon();
        nose.getPoints().addAll(
                170.0, 240.0,    // Venstre hjørne af huset (bund af trekanten)
                200.0, 170.0,    // Toppen af trekanten (midtpunkt over huset)
                230.0, 240.0     // Højre hjørne af huset (bund af trekanten)
        );
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);
        pane.getChildren().add(nose);

        // Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
        Arc mouth = new Arc(200, 250, 60, 25, 0, 180-360);
        pane.getChildren().add(mouth);
        mouth.setStroke(Color.BLACK);
        mouth.setFill(Color.TRANSPARENT);
        mouth.setType(ArcType.OPEN);





    }
}
