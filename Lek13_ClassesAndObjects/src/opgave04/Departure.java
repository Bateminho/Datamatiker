package opgave04;

public class Departure {
    private final int perron;
    private final String destination;
    private final String arrival;
    private final String departure;

    public Departure(int inputPerron, String inputDestination, String inputArrival, String inputDeparture) {
        perron = inputPerron;
        destination = (inputDestination != null) ? inputDestination : "Not set!!!";
        arrival = (inputArrival != null) ? inputArrival : "Not set!!!";
        departure = (inputDeparture != null) ? inputDeparture : "Not set!!!";
    }

    public Departure(){
        perron = 0;
        destination = "Not set!!!";
        arrival = "Not set!!!";
        departure = "Not set!!!";
    }

    public int getPerron() {
        return perron;
    }

    public String getDestination() {
        return destination;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }
}
