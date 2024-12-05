package eksempeltab;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class PaneDemo2 extends GridPane {
    private static final TextField txfName = new TextField();

    public PaneDemo2() {
        // show or hide grid lines
        setGridLinesVisible(false);

        // set padding of the pane
        setPadding(new Insets(20));
        // set horizontal gap between components
        setHgap(10);
        // set vertical gap between components
        setVgap(10);

        // add a label to the pane (at col=0, row=0)
        Label lblName = new Label("Name:");
        add(lblName, 0, 0);

        // add a text field to the pane (at col=1, row=0, extending 2 columns and 1 row)

        add(txfName, 1, 0, 2, 1);

        // add a button to the pane (at col=1, row=1)
        Button btnUpperCase = new Button("Upper Case");
        add(btnUpperCase, 1, 1);
        GridPane.setMargin(btnUpperCase, new Insets(10, 10, 0, 10));

        // connect a method to the button
        btnUpperCase.setOnAction(event -> upperCaseAction());

        // add a button to the pane (at col=2, row=1)
        Button btnLowerCase = new Button("Lower Case");
        add(btnLowerCase, 2, 1);
        GridPane.setMargin(btnLowerCase, new Insets(10, 10, 0, 10));


        // connect a method to the button
        btnLowerCase.setOnAction(event -> this.lowerCaseAction());
    }
    private void upperCaseAction() {
        String name = txfName.getText().trim();
        txfName.setText(name.toUpperCase());
    }

    private void lowerCaseAction() {
        String name = txfName.getText().trim();
        txfName.setText(name.toLowerCase());
    }
    public void updateControls(){
        txfName.clear();
    }
}
