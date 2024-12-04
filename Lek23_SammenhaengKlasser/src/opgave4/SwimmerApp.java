package opgave4;

import java.util.ArrayList;

public class SwimmerApp {
    
    public static void main(String[] args) {

        TrainingPlan t1 = new TrainingPlan('A', 16, 10);
        TrainingPlan t2 = new TrainingPlan('B', 10, 6);


        ArrayList<Double> lapTimes = new ArrayList<>();
        lapTimes.add(1.02);
        lapTimes.add(1.01);
        lapTimes.add(0.99);
        lapTimes.add(0.98);
        lapTimes.add(1.02);
        lapTimes.add(1.04);
        lapTimes.add(0.99);
        Swimmer jan = t1.createSwimmer("Jan", 1994, lapTimes, "AGF");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.05);
        lapTimes.add(1.01);
        lapTimes.add(1.04);
        lapTimes.add(1.06);
        lapTimes.add(1.08);
        lapTimes.add(1.04);
        lapTimes.add(1.02);
        Swimmer bo = t1.createSwimmer("Bo", 1995, lapTimes, "Lyseng");

        lapTimes = new ArrayList<>();
        lapTimes.add(1.03);
        lapTimes.add(1.01);
        lapTimes.add(1.02);
        lapTimes.add(1.05);
        lapTimes.add(1.03);
        lapTimes.add(1.06);
        lapTimes.add(1.03);
        Swimmer mikkel = t2.createSwimmer("Mikkel", 1993, lapTimes, "AIA-Tranbjerg");
        

        // Udskriv svømmere tilknyttet den 1. træningsplan
        System.out.println("Svømmere tilknyttet træningsplan " + t1.getLevel() + ":");
        for (Swimmer swimmer : t1.getSwimmers()) {
            System.out.println(swimmer);
        }

        System.out.println();

        // Udskriv svømmere tilknyttet den 2. træningsplan
        System.out.println("Svømmere tilknyttet træningsplan " + t2.getLevel() + ":");
        for (Swimmer swimmer : t2.getSwimmers()) {
            System.out.println(swimmer);
        }

        System.out.println("\nPrint af 1. træningsplan efter en svømmer er fjernet");

        t1.removeSwimmer(bo);

        System.out.println("Svømmere tilknyttet træningsplan " + t1.getLevel() + ":");
        for (Swimmer swimmer : t1.getSwimmers()) {
            System.out.println(swimmer);
        }
    }
    
}
