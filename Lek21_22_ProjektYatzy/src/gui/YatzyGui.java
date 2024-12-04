package gui;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.YatzyDice;

import java.util.Optional;

public class YatzyGui extends Application {


	@Override
	public void start(Stage stage) {
		stage.setTitle("Yatzy");
		GridPane pane = new GridPane();
		this.initContent(pane);

		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}

	// -------------------------------------------------------------------------

	// Shows the face values of the 5 dice.
	private TextField[] txfValues;
	// Shows the hold status of the 5 dice.
	private CheckBox[] chbHolds;
	// Shows the results previously selected .
	// For free results (results not set yet), the results
	// corresponding to the actual face values of the 5 dice are shown.
	private TextField[] txfResults;
	// Shows points in sums, bonus and total.
	private TextField txfSumOneToSix, txfBonus, txfSumPairToYatzy, txfTotal;
	// Shows the number of times the dice has been rolled.
	private Label lblRolled;

	private Button btnRoll;
	private YatzyDice yatzyDice;


	private void initContent(GridPane pane) {
		yatzyDice = new YatzyDice();
		pane.setGridLinesVisible(false);
		pane.setPadding(new Insets(10));
		pane.setHgap(10);
		pane.setVgap(10);

		// ---------------------------------------------------------------------

		GridPane dicePane = new GridPane();
		pane.add(dicePane, 0, 0);
		dicePane.setGridLinesVisible(false);
		dicePane.setPadding(new Insets(10));
		dicePane.setHgap(10);
		dicePane.setVgap(10);
		dicePane.setStyle("-fx-border-color: black");

		// initialize txfValues, chbHolds, btnRoll and lblRolled

		// Array til at gemme terningernes TextFields
		txfValues = new TextField[5];
		chbHolds = new CheckBox[5];

		// Loop til at initialisere, tilføje til panelet og indstille dimensioner
		for (int i = 0; i < 5; i++) {
			txfValues[i] = new TextField();
			txfValues[i].setPrefWidth(70);
			txfValues[i].setPrefHeight(70);
			txfValues[i].setEditable(false);  // Gør tekstfelterne ikke-redigerbare
			txfValues[i].setStyle("-fx-font-size: 18; -fx-alignment: center;");

			dicePane.add(txfValues[i], i, 0);  // Tilføj TextField til panelet i rækken

			// Opret CheckBox for "Hold" og indstil lidt margin
			chbHolds[i] = new CheckBox("Hold");
			chbHolds[i].setPadding(new Insets(5, 0, 0, 0));  // Justér placering under TextField

			// Tilføj CheckBox til dicePane lige under TextField
			dicePane.add(chbHolds[i], i, 1);

			// Sæt justering til centreret for CheckBox i GridPane-cellen
			GridPane.setHalignment(chbHolds[i], HPos.CENTER);
		}

		btnRoll = new Button("Roll");
		lblRolled = new Label("Rolled: " + yatzyDice.getThrowCount());

		// Tilføj Roll-knappen i den midterste kolonne, under CheckBox-rækken
		dicePane.add(btnRoll, 3, 2);  // Placer Roll-knappen i kolonne 2, række 2
		btnRoll.setPrefHeight(50);
		btnRoll.setPrefWidth(60);
		btnRoll.setFont(Font.font("Arial", 18));  // Sæt skriftstørrelse til 18 og gør teksten fed

		GridPane.setHalignment(btnRoll, HPos.CENTER);  // Centrér Roll-knappen

		// Tilføj Rolled-etiketten til højre for Roll-knappen
		dicePane.add(lblRolled, 4, 2);  // Placer lblRolled i kolonne 4, samme række som Roll-knappen
		GridPane.setHalignment(lblRolled, HPos.CENTER);  // Justér Rolled-etiketten til venstre

		btnRoll.setOnAction(event -> handleRollAction());

		// ---------------------------------------------------------------------

		GridPane scorePane = new GridPane();
		pane.add(scorePane, 0, 1);
		scorePane.setGridLinesVisible(false);
		scorePane.setPadding(new Insets(10));
		scorePane.setVgap(5);
		scorePane.setHgap(10);
		scorePane.setStyle("-fx-border-color: black");
		int presetWidth = 50; // width of the text fields

		// Initialize labels for results, txfResults,
		// labels and text fields for sums, bonus and total.
		// Labels for the scoring categories
		String[] scoreCategories = {
				"1-s", "2-s", "3-s", "4-s", "5-s", "6-s", "One pair", "Two pairs",
				"Three Same", "Four Same", "Full House", "Small Straight",
				"Large Straight", "Chance", "Yatzy"
		};

		txfResults = new TextField[15];
		for (int i = 0; i < scoreCategories.length; i++) {
			Label lbl = new Label(scoreCategories[i]);
			scorePane.add(lbl, 0, i);

			txfResults[i] = new TextField();
			txfResults[i].setPrefWidth(50);
			txfResults[i].setEditable(false);  // Gør feltet ikke-redigerbart af brugeren
			int index = i;  // Opret en final variabel til indekset, så vi kan bruge den i lambda
			txfResults[i].setOnMouseClicked(event -> handleScoreCategoryClick(index));
			scorePane.add(txfResults[i], 1, i);
		}

		// Sum, Bonus, and Total fields
		Label lblSumOneToSix = new Label("Sum:");
		scorePane.add(lblSumOneToSix, 2, 5);
		txfSumOneToSix = new TextField("0");
		txfSumOneToSix.setPrefWidth(presetWidth);
		txfSumOneToSix.setEditable(false);
		scorePane.add(txfSumOneToSix, 3, 5);

		Label lblBonus = new Label("Bonus:");
		scorePane.add(lblBonus, 4, 5);
		txfBonus = new TextField("0");
		txfBonus.setPrefWidth(presetWidth);
		txfBonus.setEditable(false);
		scorePane.add(txfBonus, 5, 5);

		Label lblSumPairToYatzy = new Label("Sum:");
		scorePane.add(lblSumPairToYatzy, 2, 14);
		txfSumPairToYatzy = new TextField("0");
		txfSumPairToYatzy.setPrefWidth(presetWidth);
		txfSumPairToYatzy.setEditable(false);
		scorePane.add(txfSumPairToYatzy, 3, 14);

		Label lblTotal = new Label("Total:");
		scorePane.add(lblTotal, 4, 14);
		txfTotal = new TextField("0");
		txfTotal.setPrefWidth(presetWidth);
		txfTotal.setEditable(false);
		scorePane.add(txfTotal, 5, 14);
	}

	// -------------------------------------------------------------------------

	// Create a method for btnRoll's action.
	// Hint: Create small helper methods to be used in the action method.
	/**
	 * Håndterer kast-knappens handling ved at udføre et terningekast,
	 * opdatere terningeværdierne på skærmen, og kontrollere "ThrowCount".
	 * Når det tredje kast er nået, deaktiveres kast-knappen.
	 */
	private void handleRollAction() {
		boolean[] holds = getHoldStatus();  // Hent status for alle hold-knapper
		yatzyDice.throwDice(holds);         // Kast terninger, der ikke holdes

		updateDiceValues();                 // Opdater visningen af terninger

		updatePotentialScores();

		// Efter tredje kast deaktiver "Roll"
		if (yatzyDice.getThrowCount() >= 3) {
			btnRoll.setDisable(true);
		}
	}

	/**
	 * Returnerer et array af boolean-værdier, der angiver, om hver terning er "holdt" eller ej.
	 * Hvis en terning er "holdt" (markeret med en checkboks), vil det tilsvarende element i arrayet være true.
	 * Dette array kan bruges til at bestemme, hvilke terninger der skal rulles igen.
	 */
	private boolean[] getHoldStatus() {
		boolean[] holds = new boolean[5];
		for (int i = 0; i < chbHolds.length; i++) {
			holds[i] = chbHolds[i].isSelected();
		}
		return holds;
	}

	/**
	 * Opdaterer visningen af terningernes værdier i tekstfelterne (txfValues).
	 * Henter de aktuelle værdier fra YatzyDice-objektet og viser dem i de tilsvarende felter.
	 */
	private void updateDiceValues() {
		int[] values = yatzyDice.getValues();
		for (int i = 0; i < values.length; i++) {
			txfValues[i].setText(String.valueOf(values[i]));
		}
	}

	/**
	 * Nulstiller runden ved at opdatere terningernes visning og "hold"-indstillinger.
	 * Nulstiller også antallet af kast og opdaterer "Rolled"-etiketten.
	 * Hvis spillet er slut (alle felter er udfyldt), vises en afslutningsmodal.
	 */
	private void resetRound() {
		yatzyDice.resetThrowCount();
		lblRolled.setText("Rolled: 0");

		for (TextField txfValue : txfValues) {
			txfValue.setText("");
		}

		for (CheckBox chbHold : chbHolds) {
			chbHold.setSelected(false);
		}

		btnRoll.setDisable(false);

		// Tjek om spillet er slut
		if (yatzyDice.isGameOver()) {
			showEndGameModal();
		}
	}


	// -------------------------------------------------------------------------

	// Create a method for mouse click on one of the text fields in txfResults.
	// Hint: Create small helper methods to be used in the mouse click method.

	/**
	 * Håndterer klik på en scorekategori ved at kontrollere betingelserne og beregne score,
	 * opdaterer resultater og nulstiller runden, hvis betingelserne er opfyldt.
	 */
	private void handleScoreCategoryClick(int categoryIndex) {

		// Tjek om spilleren har kastet mindst én gang og ikke allerede har valgt en kategori
		if (yatzyDice.getThrowCount() == 0) {
			showAlert("Handling ikke tilladt", "Du skal kaste terningerne først!");
			return;
		}

		if (!txfResults[categoryIndex].getText().isEmpty()) {
			showAlert("Kategori udfyldt", "Denne kategori er allerede udfyldt. Vælg en anden.");
			return;
		}

		// Beregn scoren baseret på den valgte kategori
		int score = calculateScoreForCategory(categoryIndex);

		// Gem scoren i den valgte kategori (TextField i txfResults)
		txfResults[categoryIndex].setText(String.valueOf(score));
		txfResults[categoryIndex].setStyle("-fx-text-fill: blue;");
		// Hvis kategorien er 1-6, opdateres sum og bonus

		if (categoryIndex <= 5) {
			updateSumAndBonus();
		} else
			updateSumAndTotal();
		// Afslut runden og nulstil for næste runde
		clearPotentialScores();

		resetRound();
	}

	/**
	 * Beregner scoren for en given kategori baseret på terningens aktuelle værdier.
	 * Returnerer scoren for den specificerede kategori ved at kalde den relevante metode i YatzyDice.
	 */
	private int calculateScoreForCategory(int categoryIndex) {
		int score = 0;
		switch (categoryIndex) {
			case 0 -> score = yatzyDice.sameValuePoints(1); // 1-s
			case 1 -> score = yatzyDice.sameValuePoints(2); // 2-s
			case 2 -> score = yatzyDice.sameValuePoints(3); // 3-s
			case 3 -> score = yatzyDice.sameValuePoints(4); // 4-s
			case 4 -> score = yatzyDice.sameValuePoints(5); // 5-s
			case 5 -> score = yatzyDice.sameValuePoints(6); // 6-s
			case 6 -> score = yatzyDice.onePairPoints();    // One pair
			case 7 -> score = yatzyDice.twoPairPoints();    // Two pairs
			case 8 -> score = yatzyDice.threeSamePoints();  // Three of a kind
			case 9 -> score = yatzyDice.fourSamePoints();   // Four of a kind
			case 10 -> score = yatzyDice.fullHousePoints(); // Full house
			case 11 -> score = yatzyDice.smallStraightPoints(); // Small straight
			case 12 -> score = yatzyDice.largeStraightPoints(); // Large straight
			case 13 -> score = yatzyDice.chancePoints();    // Chance
			case 14 -> score = yatzyDice.yatzyPoints();     // Yatzy
			default -> System.out.println("Ugyldig kategori");
		}
		return score;
	}

	/**
	 * Opdaterer summen af felterne fra 1's til 6's og tjekker for bonus.
	 * Hvis summen er mindst 63, gives en bonus på 50 point.
	 */
	private void updateSumAndBonus() {

		int sum = 0;

		// Summér værdierne i felterne for 1's til 6's
		for (int i = 0; i <= 5; i++) {
			if (!txfResults[i].getText().isEmpty()) {
				sum += Integer.parseInt(txfResults[i].getText());
			}
		}

		// Opdater summen
		txfSumOneToSix.setText(String.valueOf(sum));
		txfSumOneToSix.setStyle("-fx-text-fill: blue;");
		updateTotalScore();

		// Tjek for bonus
		if (sum >= 63) {
			txfBonus.setText("50");
		} else {
			txfBonus.setText("0");
		}
		txfBonus.setStyle("-fx-text-fill: blue;");
	}

	/**
	 * Opdaterer summen af felterne fra "One Pair" til "Yatzy".
	 */
	private void updateSumAndTotal() {

		int sum = 0;

		for (int i = 6; i < 15; i ++) {
			if (!txfResults[i].getText().isEmpty()) {
				sum += Integer.parseInt(txfResults[i].getText());
			}
		}

		// Opdatere sum for "One Pair" til "Yatzy"
		txfSumPairToYatzy.setText(String.valueOf((sum)));
		updateTotalScore();
	}

	/**
	 * Beregner og opdaterer den totale score baseret på summen af 1's til 6's,
	 * bonus og summen af "One Pair" til "Yatzy".
	 */
	private void updateTotalScore() {
		int sumOneToSix = Integer.parseInt(txfSumOneToSix.getText().isEmpty() ? "0" : txfSumOneToSix.getText());
		int bonus = Integer.parseInt(txfBonus.getText().isEmpty() ? "0" : txfBonus.getText());
		int sumPairToYatzy = Integer.parseInt(txfSumPairToYatzy.getText().isEmpty() ? "0" : txfSumPairToYatzy.getText());

		int total = sumOneToSix + bonus + sumPairToYatzy;
		txfTotal.setText(String.valueOf(total));
	}

	// Opdaterer hvert scorefelt med mulige point baseret på terningernes aktuelle værdier
	private void updatePotentialScores() {
		int[] potentialScores = yatzyDice.getResults(); // Hent mulige scores for hver kategori

		for (int i = 0; i < txfResults.length; i++) {
			if (txfResults[i].getText().isEmpty()) {
				txfResults[i].setPromptText(String.valueOf(potentialScores[i]));

			}
		}
	}


	/**
	 * Viser en modal (Alert) ved spillets afslutning, der giver spilleren mulighed for
	 * at starte et nyt spil eller afslutte programmet.
	 */
	public void showEndGameModal() {
		// Beregn total score ved at summere alle txfResults værdier
//		int totalScore = 0;
//		for (TextField txf : txfResults) {
//			if (!txf.getText().isEmpty()) {
//				totalScore += Integer.parseInt(txf.getText());
//			}
//		}

		// Opret en Alert-dialog
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Spil afsluttet");
		alert.setHeaderText("Din totale score er: " + txfTotal.getText());
		alert.setContentText("Vil du spille igen eller afslutte?");

		// Tilføj knapper til valgmulighederne
		ButtonType playAgainButton = new ButtonType("Spil igen");
		ButtonType exitButton = new ButtonType("Afslut");
		alert.getButtonTypes().setAll(playAgainButton, exitButton);

		// Håndter valget
		Optional<ButtonType> result = alert.showAndWait();
		if (result.isPresent() && result.get() == playAgainButton) {
			resetGame();  // Nulstil spillet
		} else {
			System.exit(0);  // Afslut programmet
		}
	}

	/**
	 * Viser en informationsmodal (Alert) med en given titel og besked.
	 */
	private void showAlert(String title, String message) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);  // Ingen overskrift
		alert.setContentText(message);
		alert.showAndWait();
	}

	/**
	 * Nulstiller spillet ved at rydde tællere og scorefelter, samt starte en ny runde.
	 */
	private void resetGame() {
		// Nulstil tællere og scorefelter
		yatzyDice.resetRoundCount();

		for (TextField txf : txfResults) {
			txf.setText("");
		}
		txfSumOneToSix.setText("0");
		txfBonus.setText("0");
		txfSumPairToYatzy.setText("0");
		txfTotal.setText("0");

		// Nulstil terninger og runder
		resetRound();
	}

	// Ryd de midlertidige scores ved at nulstille prompttekst
	private void clearPotentialScores() {
		for (TextField txf : txfResults) {
			txf.setPromptText("");

		}
	}


}
