package arraycompanionvariable;

public class Timetabel {
   private Departure[] departures;
   private int numberOfDepartures;

   public  Timetabel(){
    departures = new Departure[10];
    numberOfDepartures = 0;
   }

    public  void printDepartures() {
        System.out.println("Destination | Peron | Ankomst | Afgang");
        for (int i = 0; i <numberOfDepartures; i++) {
            Departure departure = departures[i];
            System.out.printf("%12s", departure.getDestination());
            System.out.printf("%6d", departure.getPerron());
            System.out.printf("%11s", departure.getArrival());
            System.out.printf("%9s\n", departure.getDeparture());
        }
    }

    public void addDeparture(Departure depature){
       if (numberOfDepartures < departures.length){
           departures[numberOfDepartures] = depature;
           numberOfDepartures++;
       }

    }

    public int getNumberOfDepartures() {
        return numberOfDepartures;
    }
}

