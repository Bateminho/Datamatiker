package exercise5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
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

        double circleX = 80;
        double circleY = 100;
        double circleRadius = 50;
        double moveRight = circleX + 2 * circleRadius;
        double moveDown = circleY + circleRadius;
        double moveRightDown = circleX + circleRadius;

        Circle circleBlue = new Circle(circleX, circleY, circleRadius);
        pane.getChildren().add(circleBlue);
        circleBlue.setFill(Color.WHITE);
        circleBlue.setStroke(Color.BLUE);
        circleBlue.setStrokeWidth(5);

        Circle circleBlack = new Circle(moveRight, circleY, circleRadius);
        pane.getChildren().add(circleBlack);
        circleBlack.setFill(Color.WHITE);
        circleBlack.setStroke(Color.BLACK);
        circleBlack.setStrokeWidth(5);

        Circle circleRed = new Circle(moveRight + 2 * circleRadius, circleY, circleRadius);
        pane.getChildren().add(circleRed);
        circleRed.setFill(Color.WHITE);
        circleRed.setStroke(Color.RED);
        circleRed.setStrokeWidth(5);

        Circle circleYellow = new Circle(moveRightDown, moveDown, circleRadius);
        pane.getChildren().add(circleYellow);
        circleYellow.setFill(Color.TRANSPARENT);
        circleYellow.setStroke(Color.YELLOW);
        circleYellow.setStrokeWidth(5);

        Circle circleGreen = new Circle(moveRightDown + 2 * circleRadius, moveDown, circleRadius);
        pane.getChildren().add(circleGreen);
        circleGreen.setFill(Color.TRANSPARENT);
        circleGreen.setStroke(Color.GREEN);
        circleGreen.setStrokeWidth(5);
        }

    }
