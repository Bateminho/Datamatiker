package model;

public class EksempelForEach {
    public static void main(String[] args) {

        String[] navne = {"Jan", "Per", "Ib", "Mads"};

        // Almindelig for løkke
        for (int i = 0; i < navne.length; i++){
            System.out.println(navne[i]);
        }

        System.out.println();

        // forEach løkke
        for(String tekst: navne){
            System.out.println(tekst);
        }



        int[] alleTal = {3,2,5,3,6,2};
        int sum = 0;
        for(int tal: alleTal){
            sum = sum + tal;
        }
        System.out.println(sum);


        sum = 0;
        for(int i = 0; i<alleTal.length; i++){
            sum = sum + alleTal[i];
        }
        System.out.println(sum);

    }
}
