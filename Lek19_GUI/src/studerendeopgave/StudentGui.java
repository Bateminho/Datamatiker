package studerendeopgave;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class StudentGui extends Application {

	@Override
	public void start(Stage stage) {
		stage.setTitle("Administrer studerende");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane, 300, 250);  // Justér størrelsen på scenen for ekstra luft
		stage.setScene(scene);
		stage.show();
	}

	// -------------------------------------------------------------------------

	private final TextField txfName = new TextField();
	private final TextField txfAge = new TextField();
	private final CheckBox chkActive = new CheckBox();
	private final TextArea txAInf = new TextArea();

	private final Button btnAdd = new Button("Opret");
	private final Button btnSave = new Button("Gem");
	private final Button btnGet = new Button("Hent");
	private final Button btnDelete = new Button("Slet");
	private final Button btnBirthday = new Button("Fødselsdag");

	private Student studerende = null;

	private void initContent(GridPane pane) {
		// Centrér hele panelet
		pane.setAlignment(Pos.CENTER);

		// Configure pane layout
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(20));  // Justér padding rundt om hele panelet
		pane.setHgap(10);                 // Justér vandret afstand mellem komponenter
		pane.setVgap(10);                 // Justér lodret afstand mellem komponenter

		// Text area for student information
		txAInf.setEditable(false);
		txAInf.setPrefWidth(250);         // Justér tekstområdets bredde
		txAInf.setPrefHeight(100);        // Justér tekstområdets højde
		pane.add(txAInf, 0, 0, 5, 1);

		// Labels and text fields
		Label lblName = new Label("Navn:");
		pane.add(lblName, 0, 1);
		pane.add(txfName, 1, 1, 4, 1);
		txfName.setPrefWidth(200);        // Justér bredden på tekstfeltet til navn

		Label lblAge = new Label("Alder:");
		pane.add(lblAge, 0, 2);
		pane.add(txfAge, 1, 2, 1, 1);
		txfAge.setPrefWidth(90);          // Justér bredden på tekstfeltet til alder

		Label lblActive = new Label("Aktiv:");
		pane.add(lblActive, 0, 3);
		pane.add(chkActive, 1, 3);

		pane.add(btnBirthday, 4, 2);
		btnBirthday.setPrefWidth(90);

		// Button panel
		HBox buttonBox = new HBox(10, btnAdd, btnSave, btnGet, btnDelete); // Justér knap-afstanden
		buttonBox.setAlignment(Pos.CENTER);  // Justér knapperne til at være centreret
		buttonBox.setPadding(new Insets(15, 0, 0, 0));  // Justér top-padding for knapperne
		pane.add(buttonBox, 0, 4, 5, 1);

		// Set button initial states
		btnSave.setDisable(true);
		btnGet.setDisable(true);
		btnDelete.setDisable(true);

		// Connect actions to buttons
		btnAdd.setOnAction(event -> this.addAction());
		btnSave.setOnAction(event -> this.saveAction());
		btnGet.setOnAction(event -> this.getAction());
		btnDelete.setOnAction(event -> this.deleteAction());
		btnBirthday.setOnAction(event -> this.birthdayAction());
	}

	private void addAction() {
		if (studerende == null) {
			int age = Integer.parseInt(txfAge.getText().trim());
			studerende = new Student(txfName.getText().trim(), age, chkActive.isSelected());
			clearFields();
			txAInf.setText(getDescription());
			btnGet.setDisable(false);
			btnAdd.setDisable(true);
		}
	}

	private void saveAction() {
		if (studerende != null) {
			studerende.setName(txfName.getText().trim());
			studerende.setActive(chkActive.isSelected());
			studerende.setAge(Integer.parseInt(String.valueOf(txfAge.getText())));
			clearFields();
			txAInf.setText(getDescription());
			btnSave.setDisable(true);
			btnDelete.setDisable(true);
			btnGet.setDisable(false);
		}
	}

	private void getAction() {
		if (studerende != null) {
			txfName.setText(studerende.getName());
			chkActive.setSelected(studerende.isActive());
			txfAge.setText(String.valueOf(studerende.getAge()));
			txAInf.setText(getDescription());
			btnSave.setDisable(false);
			btnDelete.setDisable(false);
			btnGet.setDisable(true);
			btnBirthday.setDisable(false);
		}
	}

	private void deleteAction() {
		if (studerende != null) {
			studerende = null;
			clearFields();
			txAInf.clear();
			btnDelete.setDisable(true);
			btnSave.setDisable(true);
			btnGet.setDisable(true);
			btnAdd.setDisable(false);
		}
	}

	private void birthdayAction() {
		if (studerende != null) {
			studerende.increaseAge(); // Øger alderen med 1
			txfAge.setText(String.valueOf(studerende.getAge())); // Opdaterer tekstfeltet med den nye alder
			txAInf.setText(getDescription()); // Opdaterer infoteksten
		}
	}


	private void clearFields() {
		txfName.clear();
		txfAge.clear();
		chkActive.setSelected(false);
	}

	private String getDescription() {
		String result = "Ingen studerende gemt";
		if (studerende != null) {
			result = studerende.toString();
		}
		return result;
	}
}
