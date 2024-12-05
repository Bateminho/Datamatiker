package opgave3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Split tekst");

		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfFirstName = new TextField();
	private final TextField txfLastName = new TextField();
	private final TextField txfFullName = new TextField();

	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);



		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(10);
		// set vertical gap between components
		pane.setVgap(10);

		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)
		pane.add(txfFullName, 0, 0,2,1);
		pane.add(txfFirstName, 0, 1);
		pane.add(txfLastName, 1, 1);


//		// add a button to the pane (at col=1, row=1)
		Button btnCombineName = new Button("Split");
		pane.add(btnCombineName, 0, 2);
		GridPane.setMargin(btnCombineName, new Insets(10, 10, 0, 10));

		btnCombineName.setOnAction(event -> this.splitName(txfFullName.getText().trim()));

	}

	private void splitName(String fullName) {
		String[] parts = fullName.split(" ");
		String firstname = parts[0];
		txfFirstName.setText(firstname);

		String lastName = parts.length > 1 ? parts[1] : "";
		txfLastName.setText(lastName);
	}
}
