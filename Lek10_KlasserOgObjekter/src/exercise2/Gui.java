package exercise2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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

        // Opret en rektangel
        Rectangle rectangle = new Rectangle(60, 150, 100, 40);
        pane.getChildren().add(rectangle);
        rectangle.setFill(Color.BLUE);

        // Beregn x og y koordinaterne for at centrere teksten
        double x = rectangle.getX() + rectangle.getWidth() / 2;
        double y = rectangle.getY() + rectangle.getHeight() / 2;

        // Opret teksten og centrér den
        Text text = new Text("Sean");
        text.setFill(Color.RED);

        // Sæt teksten til at være fed med en størrelse på 20 (du kan ændre størrelsen)
        text.setFont(Font.font("Arial", FontWeight.BOLD, 20));


        // Justér teksten, så den er centreret i forhold til midten af rektanglen
        // Brug 'text.getBoundsInLocal()' til at få bredden og højden af teksten
        text.setX(x - text.getBoundsInLocal().getWidth() / 2); // For at centrere vandret
        text.setY(y + text.getBoundsInLocal().getHeight() / 4); // For at centrere lodret (plus højdejustering)

        pane.getChildren().add(text);
    }
}
