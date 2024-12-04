package opgave5celsiustofahrenheit;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Celsius til Fahrenheit");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private final TextField celsiusField = new TextField();
    private final TextField fahrenheitField = new TextField();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblCelsius = new Label("Celsius:");
        pane.add(lblCelsius, 0, 0);

        Label lblFahrenheit = new Label("Fahrenheit:");
        pane.add(lblFahrenheit, 0, 1);

        pane.add(celsiusField, 1, 0);
        pane.add(fahrenheitField, 1, 1);


        Button toFahrenheitButton = new Button("Konverter til Fahrenheit");
        pane.add(toFahrenheitButton, 2, 0);


        Button toCelsiusButton = new Button("Konverter til Celsius");
        pane.add(toCelsiusButton, 2, 1);

        double buttonWidth = 160;
        toCelsiusButton.setPrefWidth(buttonWidth);
        toFahrenheitButton.setPrefWidth(buttonWidth);

        toFahrenheitButton.setOnAction(e -> {
            if (!celsiusField.getText().isEmpty()) {
                try {
                    String celsiusText = celsiusField.getText().replace(",", ".");  // Erstat komma med punktum
                    double celsius = Double.parseDouble(celsiusText);
                    double fahrenheit = (9.0 / 5) * celsius + 32;
                    fahrenheitField.setText(String.format("%.2f", fahrenheit));
                    celsiusField.clear();  // Nulstil Celsius-feltet efter konvertering
                } catch (NumberFormatException ex) {
                    fahrenheitField.setText("Ugyldigt input");
                }
            } else {
                fahrenheitField.setText("");
            }
        });

        toCelsiusButton.setOnAction(e -> {
            if (!fahrenheitField.getText().isEmpty()) {
                try {
                    String fahrenheitText = fahrenheitField.getText().replace(",", ".");  // Erstat komma med punktum
                    double fahrenheit = Double.parseDouble(fahrenheitText);
                    double celsius = (fahrenheit - 32) * 5.0 / 9;
                    celsiusField.setText(String.format("%.2f", celsius));
                    fahrenheitField.clear();  // Nulstil Fahrenheit-feltet efter konvertering
                } catch (NumberFormatException ex) {
                    celsiusField.setText("Ugyldigt input");
                }
            } else {
                celsiusField.setText("");
            }
        });


    }

}
