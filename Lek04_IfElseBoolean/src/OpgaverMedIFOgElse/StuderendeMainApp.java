package OpgaverMedIFOgElse;

import java.util.Scanner;

public  class StuderendeMainApp {


    public static void main(String[] args) {

        // alder læses og det afgøres hvad en person med denne alder skal gøre
        // der anvendes if-sætninger
        Scanner scan = new Scanner(System.in);
        System.out.print("Indtast alder: ");
        int alder = scan.nextInt();

        String result ="Arbejd hårdt";
        if (alder < 16) {
            result = "Gå i skole - du er jo kun et barn";
        }
        if (alder >=16 && alder < 20) {
            result = "Nyd din ungdom - og lær at studer";
        }
        if (alder == 20) {
            result = "Tag et sabbatår";
        }
        if (alder > 20 && alder <= 23) {
            result = "Kom igang med datamatikerudannelsen";
        }
        if (alder >23 && alder < 30) {
            result = "Tag nu dit studie seriøst";
        }
        System.out.println("Når du er " + alder +" skal du: "+ result );

    //    -------------------------------------------------------------------------------------------

        //Det afgøres hvad en person skal gøres. Der anvendes if-else sætninger

//        result = "";
//        if (alder < 16) {
//            result = "Gå i skole - du er jo kun et barn";
//        } else if (alder < 20) {
//            result = "Nyd din ungdom - og lær at studer";
//        } else if (alder == 20) {
//            result = "Tag et sabbatår";
//        } else if (alder <= 23) {
//            result = "Kom igang med datamatikerudannelsen";
//        } else if (alder < 30) {
//            result = "Tag nu dit studie seriøst";
//        } else {
//            result = "Arbejd hårdt";
//        }
//
//        System.out.println("Når du er " + alder +" skal du: "+ result );

//
        System.out.print("Aktiv ? ");
        boolean aktiv = scan.nextBoolean();

       result = "";
        if (aktiv) {
            result = "Flittig ";
            if (alder >= 68) {
                result = result + "pensionist";
            }
            else if(alder < 18) {
                result = result + "elev";
            }
        }
        else {
            result = "Ikke aktiv";
        }

        System.out.println( "Når du er " + alder + " og "+ aktiv +  " skal du: "+ result );


    }
}
