package opgaveBog4_4_5;

public class BogØvelse {
    public static void main(String[] args) {

        String s1 = "Welcome";
        String s2 = "welcome";

        boolean isEqual = s1.compareTo(s2) == 0;

        System.out.println("Er S1 = S2: " + isEqual);

        isEqual = s1.compareToIgnoreCase(s2) == 0;

        System.out.println("\nEr S1 = S2, hvis man ignore case: " + isEqual);

        int x = s1.compareTo(s2);

        System.out.println("\nVærdien af x er: " + x);

        x = s1.compareToIgnoreCase(s2);

        System.out.println("\nVærdien af x er: " + x);
    }


}
