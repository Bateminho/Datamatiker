package exercise1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui2 extends Application {

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
        Circle circle = new Circle(70, 70, 30);
        pane.getChildren().add(circle);
        circle.setFill(Color.CORNFLOWERBLUE);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(30, 150, 60, 30);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.RED);

        Line line = new Line(30, 30, 100, 30);
        pane.getChildren().add(line);

        double move = 100;

        circle.setCenterX(circle.getCenterX() + move);
        rectangle.setX(rectangle.getX() + move);
        line.setStartX(line.getStartX() + move);
        line.setEndX(line.getEndX() + move);

        Color color = Color.YELLOW;

        circle.setFill(color);
        circle.setStroke(color);
        rectangle.setFill(color);
        line.setStroke(color);

    }
}
