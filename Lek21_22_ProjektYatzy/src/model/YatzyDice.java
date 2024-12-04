package model;

import gui.YatzyGui;

import java.util.Arrays;
import java.util.Random;

public class YatzyDice {
	// Face values of the 5 dice.
	// 1 <= values[i] <= 6.
	private int[] values = new int[5];

	// Number of times the 5 dice have been thrown.
	// 0 <= throwCount <= 3.
	private int throwCount = 0;
	private int roundCount = 0;

	// Random number generator.
	private final Random random = new Random();

	public YatzyDice() {
		//
	}

	/**
	 * Returns the 5 face values of the dice.
	 */
	public int[] getValues() {
		return values;
	}

	/**
	 * Sets the 5 face values of the dice. Pre: values contains 5 face values in
	 * [1..6]. Note: This method is only meant to be used for test, and
	 * therefore has package visibility.
	 */
	void setValues(int[] values) {
		this.values = values;
	}

	/**
	 * Returns the number of times the 5 dice has been thrown.
	 */
	public int getThrowCount() {
		return throwCount;
	}

	/**
	 * Resets the throw count.
	 */
	public void resetThrowCount() {
		throwCount = 0;
		roundCount++;

	}

	/**
	 * Nulstiller runde-tælleren, så spillet starter forfra.
	 */
	public void resetRoundCount() {
		roundCount = 0;
	}

	/**
	 * Kontrollerer, om spillet er afsluttet ved at tjekke, om der er spillet 15 runder.
	 * @return true, hvis runde-tælleren er 15 eller højere, ellers false.
	 */
	public boolean isGameOver() {
		return roundCount >= 15;
	}

	/**
	 * Rolls the 5 dice. Only roll dice that are not hold. Pre: holds contain 5
	 * boolean values.
	 */
	public void throwDice(boolean[] holds) {

		for (int i = 0; i < values.length; i++) {
			if (!holds[i]) {
				values[i] = random.nextInt(6) + 1;
			}
		}
		throwCount++;
	}

	// -------------------------------------------------------------------------

	/**
	 * Return all results possible with the current face values.<br/>
	 * The order of the results is the same as on the score board.<br/>
	 * Note: This is an optional method. Comment this method out,<br/>
	 * if you don't want use it.
	 */
	public int[] getResults() {
		int[] results = new int[15];
		for (int i = 0; i <= 5; i++) {
			results[i] = this.sameValuePoints(i + 1);
		}
		results[6] = this.onePairPoints();
		results[7] = this.twoPairPoints();
		results[8] = this.threeSamePoints();
		results[9] = this.fourSamePoints();
		results[10] = this.fullHousePoints();
		results[11] = this.smallStraightPoints();
		results[12] = this.largeStraightPoints();
		results[13] = this.chancePoints();
		results[14] = this.yatzyPoints();

		return results;
	}

	// -------------------------------------------------------------------------

	// Return an int[7] containing the frequency of face values.
	// Frequency at index v is the number of dice with the face value v, 1 <= v <= 6.
	// Index 0 is not used.
	// Note: This method can be used in several of the following methods.

	/**
	 * Beregner hyppigheden af hver terningeværdi (1 til 6) baseret på
	 * de terningernes værdi (Øjne).
	 * @return Et int-array, hvor hver indeksværdi repræsenterer antallet
	 *         af forekomster for hver terningeværdi (f.eks. index 1 repræsenterer antallet af 1'ere).
	 *         Arrayet har en længde på 7, hvor index 0 ikke anvendes.
	 */
	private int[] frequency() {

		int[] result = new int[7];

		for (int value : values) {
			result[value]++;
		}

		return result;
	}

	/**
	 * Return same-value points for the given face value.<br/>
	 * Returns 0, if no dice has the given face value.<br/>
	 * Pre: 1 <= value <= 6;
	 */
	public int sameValuePoints(int value) {
		int[] sameValue = frequency();
		return sameValue[value] * value;
	}

	/**
	 * Return points for one pair (for the face value giving the highest points).<br/>
	 * Return 0, if there aren't 2 dice with the same face value.
	 */
	public int onePairPoints() {
		int[] frequency = frequency();
		int result = 0;

		for (int i = frequency.length - 1; i > 1; i--) {
			if (frequency[i] >= 2) {
				result = i * 2;
				return result;
			}
		}
		return result;
	}

	/**
	 * Return points for two pairs<br/>
	 * (for the 2 face values giving the highest points).<br/>
	 * Return 0, if there aren't 2 dice with the same face value<br/>
	 * and 2 other dice with the same but different face value.
	 */
	public int twoPairPoints() {
		int[] frequency = frequency();
		int result = 0;
		int resultTwoPair = 0;
		int pairCount = 0;

		for (int i = frequency.length - 1; i >= 1; i--) {
			if (frequency[i] >= 2) {
				resultTwoPair += i * 2;
				pairCount++;

				if (pairCount == 2) {
					result = resultTwoPair;
				}
			}
		}
		return result;
	}

	/**
	 * Return points for 3 of a kind.<br/>
	 * Return 0, if there aren't 3 dice with the same face value.
	 */
	public int threeSamePoints() {
		int result = 0;

		int[] frequency = frequency();

		for (int i = 1; i < frequency.length; i++) {
			if (frequency[i] >= 3)
				result = i * 3;
		}
		return result;
	}

	/**
	 * Return points for 4 of a kind.<br/>
	 * Return 0, if there aren't 4 dice with the same face value.
	 */
	public int fourSamePoints() {
		int result = 0;

		int[] frequency = frequency();

		for (int i = 1; i < frequency.length; i++) {
			if (frequency[i] >= 4)
				result =  i * 4;
		}
		return result;
	}

	/**
	 * Return points for full house.<br/>
	 * Return 0, if there aren't 3 dice with the same face value<br/>
	 * and 2 other dice with the same but different face value.
	 */
	public int fullHousePoints() {

		int[] fullHouse = frequency();
		int sumThreeOfAKind = 0;
		int sumPair = 0;
		int result = 0;

		for (int i = 1; i < fullHouse.length; i++) {

			if (fullHouse[i] == 3) {
				sumThreeOfAKind = i;
			} else if (fullHouse[i] == 2) {
				sumPair = i;
			}
			if (sumThreeOfAKind > 0 && sumPair > 0)
				result = (sumThreeOfAKind * 3) + (sumPair * 2);
		}
		return result;

	}

	/**
	 * Return points for small straight.<br/>
	 * Return 0, if the dice aren't showing 1,2,3,4,5.
	 */
	public int smallStraightPoints() {
		int[] smallStraight = frequency();

		// Tjekker om værdierne fra 1 til 5 hver har en hyppighed på 1
		for (int i = 1; i <= 5; i++) {
			if (smallStraight[i] != 1) {
				return 0;  // Hvis nogen af dem ikke er lig 1, er det ikke en lille straight
			}
		}
		// Hvis alle værdier fra 1 til 5 har en hyppighed på 1, sæt points til 15
		return 15;
	}

	/**
	 * Return points for large straight.<br/>
	 * Return 0, if the dice aren't showing 2,3,4,5,6.
	 */
	public int largeStraightPoints() {

		int[] highStraight = frequency();

		// Tjekker om værdierne fra 2 til 6 hver har en hyppighed på 1
		for (int i = 2; i <= 6; i++) {
			if (highStraight[i] != 1) {
				return 0;  // Hvis nogen af dem ikke er lig 1, er det ikke en stor straight
			}
		}

		// Hvis alle værdier fra 2 til 6 har en hyppighed på 1, sæt points til 20
		return 20;
	}


	/**
	 * Return points for chance (the sum of face values).
	 */
	public int chancePoints() {

		int chanceScore = 0;

		for (int value : values)
			chanceScore += value;

		return chanceScore;
	}

	/**
	 * Return points for yatzy (50 points).<br/>
	 * Return 0, if there aren't 5 dice with the same face value.
	 */
	public int yatzyPoints() {
		int result = 0;
		int[] frequency = frequency();

		for (int i = 1; i <= 6; i++) {
            if (frequency[i] == 5) {
                result = 50;

            }
		}
		return result;
	}

}
