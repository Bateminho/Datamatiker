package opgave4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {

	private int number = 50;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Tæl op");

		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfNumber = new TextField();


	private void initContent(GridPane pane) {
		// show or hide grid lines
		pane.setGridLinesVisible(false);

		// set padding of the pane
		pane.setPadding(new Insets(20));
		// set horizontal gap between components
		pane.setHgap(5);
		// set vertical gap between components
		pane.setVgap(5);



		// add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)

		Label lblName = new Label("Number: ");
		pane.add(lblName, 0, 1);

		pane.add(txfNumber, 1, 1,1,1);
		txfNumber.setText(String.valueOf(number));
		txfNumber.setEditable(false);


		// add a button to the pane (at col=1, row=1)
		Button btnAdd = new Button("+");
		Button btnSubtract = new Button("-");

		double buttonWidth = 50;
		btnAdd.setPrefWidth(buttonWidth);
		btnSubtract.setPrefWidth(buttonWidth);

		pane.add(btnAdd, 3, 0);
		pane.add(btnSubtract, 3, 2);

		GridPane.setMargin(btnAdd, new Insets(5));
		GridPane.setMargin(btnSubtract, new Insets(5));

		btnAdd.setOnAction(event -> incrementNumber());
		btnSubtract.setOnAction(event -> decrementNumber());

	}

	private void incrementNumber() {
		number++;
		txfNumber.setText(String.valueOf(number));
	}

	private void decrementNumber() {
		number--;
		txfNumber.setText(String.valueOf(number));
	}


}
