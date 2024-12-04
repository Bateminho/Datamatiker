package hangman;

import com.sun.source.tree.NewArrayTree;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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

        // Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
        Arc base = new Arc(70, 390, 60, 25, 0, 180);
        pane.getChildren().add(base);
        base.setStroke(Color.BLACK);
        base.setFill(Color.TRANSPARENT);
        base.setType(ArcType.OPEN);

        double xStartAndEnd = 70;
        double yStart = 10;
        double yEnd = 365;
        Line verticalLine = new Line(xStartAndEnd, yStart, xStartAndEnd, yEnd);
        pane.getChildren().add(verticalLine);
        verticalLine.setStroke(Color.BLACK);

        double xEnd = 280;
        Line horizontalLine = new Line(xStartAndEnd, yStart, xEnd, yStart);
        pane.getChildren().add(horizontalLine);
        horizontalLine.setStroke(Color.BLACK);

        double yEndRope = 40;
        Line rope = new Line(xEnd, yStart, xEnd, yEndRope);
        pane.getChildren().add(rope);
        rope.setStroke(Color.BLACK);

        double headY = 80;
        double headRadius = 40;
        Circle head = new Circle(xEnd, headY, headRadius);
        pane.getChildren().add(head);
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);

        double bodyStart = headY+headRadius;
        double bodyEnd = 250;

        Line body = new Line(xEnd, bodyStart, xEnd, bodyEnd);
        pane.getChildren().add(body);
        body.setStroke(Color.BLACK);

        double leftLimbStart = xEnd - 60;
        double leftArmStart = bodyStart + 80;
        double leftArmEndRightArmStart = bodyStart + 20;

        Line leftArm = new Line(leftLimbStart, leftArmStart, xEnd, leftArmEndRightArmStart);
        pane.getChildren().add(leftArm);
        leftArm.setStroke(Color.BLACK);

        double leftLegStartRightLegEnd = bodyEnd + 60;

        Line leftLeg = new Line(leftLimbStart, leftLegStartRightLegEnd, xEnd, bodyEnd);
        pane.getChildren().add(leftLeg);
        leftLeg.setStroke(Color.BLACK);

        double rightLimbEnd = xEnd + 60;

        Line rightArm = new Line(xEnd, leftArmEndRightArmStart, rightLimbEnd, leftArmStart);
        pane.getChildren().add(rightArm);
        rightArm.setStroke(Color.BLACK);

        Line rightLeg = new Line(xEnd, bodyEnd, rightLimbEnd, leftLegStartRightLegEnd);
        pane.getChildren().add(rightLeg);
        rightLeg.setStroke(Color.BLACK);


    }
}
