package OpgaverMedIFOgElse;

import java.util.Scanner;

public class ChildApp {

   // Metoden skal returenre en tekststreng der beskriver hvilken institution et barn skal gå i, afhængig af barnets alder.
   // Reglerne for dette kan ses på opgavedsedlen
   //
    public static String institution(int age) {
        String result = "";

        if (age < 0) {
           result = "Your child has not been born yet STUPID!!!!";
        } else if (age == 0){
            result = "Your child should stay at Home!";
        } else if (age <= 2) {
            result = "Your child should go to Nursery!";
        } else if (age <= 5) {
            result = "Your child should go to Kindergarten!";
        } else if (age <= 16) {
           result = "Your child should go to School!";
        }
        else result = "Your child has finished School!";


        return result;

    }



//    public static void main(String[] args) {
//
//        Scanner inputScan = new Scanner(System.in);
//
//        System.out.println("Dette program fortæller, hvilken institution dit barn skal gå  i");
//        int age = inputScan.nextInt();
//        System.out.println(institution(age));
//    }


    // Metoden skal returenre en tekststreng der beskriver hvilket gymnastikhold et barn skal gå på, afhængig af barnets alder og køn.
    // Reglerne for dette kan ses på opgavedsedlen
    //
    public static String team(boolean isBoy, int age) {
        if (isBoy) {
            return (age < 8) ? "Young cubs" : "Cool boys";
        } else {
            return (age < 8) ? "Tumbling girls" : "Springy girls";
        }
    }

    public static void main(String[] args) {
        System.out.println("A 5 skal i " + institution(5));
        System.out.println("En dreng på 8 skal i " + team(true, 7) + institution(7));
        System.out.println("En dreng på 8 skal i " + team(true,9));

    }
}
