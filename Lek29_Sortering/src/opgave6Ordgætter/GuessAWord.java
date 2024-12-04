package opgave6Ordgætter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static java.util.Arrays.asList;

public class GuessAWord {

    private static String hiddenWord; // Det hemmelige ord
    private static HashSet<Character> usedLetters = new HashSet<>(); // Brugte bogstaver
    private static StringBuilder currentGuess; // Status for gættet ord

    static ArrayList<String> words = new ArrayList<>(asList(
            "skolebog", "jordbær", "hestemule", "køkkenur", "sommerhus",
            "efterår", "trænings", "strålelys", "vinterkulde", "blomstereng",
            "bibliotek", "familieferie", "håndværker", "computeren",
            "landskaber", "sygeplejerske", "sommerfugl", "paradisfugl",
            "vandstrøm", "drivhusgas"
    ));

    // Vælg et tilfældigt ord
    public static void findWord() {
        int randomInt = (int) (Math.random() * words.size());
        hiddenWord = words.get(randomInt);
        currentGuess = new StringBuilder("*".repeat(hiddenWord.length())); // Initialt gæt med stjerner
    }

    // Velkomstbesked
    public static void welcomeToGame() {
        System.out.println("Velkommen til Ord Gætter");
        System.out.printf("Længden af ordet er %d%n", hiddenWord.length());
    }


    public static int findChar(String sm, String m, int start) {
        int index = -1;
        int i = start;
        while (index == -1 && i <= sm.length() - m.length()) {
            boolean matchFound = match(sm, m, i);
            if (matchFound)
                index = i;
            else
                i++;
        }
        return index;
    }


    public static boolean match(String sm, String m, int start) {
        return sm.substring(start, start + m.length()).equals(m);
    }


    public static void updateWord(char guess) {
        String guessString = String.valueOf(guess);
        int index = findChar(hiddenWord, guessString, 0);
        while (index != -1) {
            currentGuess.setCharAt(index, guess);
            index = findChar(hiddenWord, guessString, index + 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        findWord();
        welcomeToGame();

        int attempts = 0;

        while (currentGuess.toString().contains("*")) {
            System.out.println(currentGuess + " Brugt " + usedLetters + ". Gæt: ");
            char guess = scanner.next().toLowerCase().charAt(0);

            if (usedLetters.contains(guess)) {
                System.out.println("Du har allerede brugt dette bogstav!");
                continue;
            }

            usedLetters.add(guess);
            updateWord(guess);
            attempts++;
        }

        System.out.printf("Du gættede ordet '%s' med kun %d gæt!%n", hiddenWord, attempts);
    }
}
