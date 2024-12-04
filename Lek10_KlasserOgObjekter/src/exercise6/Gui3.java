package exercise6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Gui3 extends Application {

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

        Rectangle house = new Rectangle(40, 200, 160, 220);
        house.setHeight(120);
        house.setWidth(120);
        pane.getChildren().add(house);
        house.setFill(Color.RED);

        Rectangle window = new Rectangle(60, 220, 80, 80);
        pane.getChildren().add(window);
        window.setHeight(36);
        window.setWidth(36);

        Polygon roof = new Polygon();
        roof.getPoints().addAll(
                20.0, 200.0,    // Venstre hjørne af huset (bund af trekanten)
                100.0, 120.0,    // Toppen af trekanten (midtpunkt over huset)
                180.0, 200.0     // Højre hjørne af huset (bund af trekanten)
        );
        roof.setFill(Color.GREEN);
        pane.getChildren().add(roof);

        Circle sun = new Circle(240, 120, 40);
        pane.getChildren().add(sun);
        sun.setFill(Color.YELLOW);
        sun.setStroke(Color.BLACK);

        Line ground = new Line(20, 320, 300 ,320);
        pane.getChildren().add(ground);
        ground.setStroke(Color.BROWN);
        ground.setStrokeWidth(3);

        Line tableTop = new Line(220, 280, 280 ,280);
        pane.getChildren().add(tableTop);
        tableTop.setStroke(Color.BURLYWOOD);
        tableTop.setStrokeWidth(5);

        Line tableSeatLeft = new Line(200, 300, 220 ,300);
        pane.getChildren().add(tableSeatLeft);
        tableSeatLeft.setStroke(Color.BURLYWOOD);
        tableSeatLeft.setStrokeWidth(5);

        Line tableSeatRight = new Line(280, 300, 300 ,300);
        pane.getChildren().add(tableSeatRight);
        tableSeatRight.setStroke(Color.BURLYWOOD);
        tableSeatRight.setStrokeWidth(5);

        Line tableLeftSpare = new Line(210, 316, 240 ,284);
        pane.getChildren().add(tableLeftSpare);
        tableLeftSpare.setStroke(Color.BURLYWOOD);
        tableLeftSpare.setStrokeWidth(5);

        Line tableRightSpare = new Line(260, 284, 290 ,316);
        pane.getChildren().add(tableRightSpare);
        tableRightSpare.setStroke(Color.BURLYWOOD);
        tableRightSpare.setStrokeWidth(5);
    }

}
