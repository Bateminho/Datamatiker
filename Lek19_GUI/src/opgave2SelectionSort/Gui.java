package opgave2SelectionSort;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Swap frame");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfFirstText = new TextField();
	private final TextField txfLastText = new TextField();


	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);



		pane.add(txfFirstText, 0, 0);

		pane.add(txfLastText, 0, 1);


		// add a button to the pane (at col=1, row=1)
		Button btnSwitch = new Button("Ombyt");
		pane.add(btnSwitch, 0, 2);
		GridPane.setMargin(btnSwitch, new Insets(10, 10, 0, 10));

		btnSwitch.setOnAction(event -> this.switchFields());

	}

	private void switchFields() {
		String firstText = txfFirstText.getText().trim();
		String lastText = txfLastText.getText().trim();

		txfFirstText.setText (lastText);
		txfLastText.setText(firstText);
		}
	}

