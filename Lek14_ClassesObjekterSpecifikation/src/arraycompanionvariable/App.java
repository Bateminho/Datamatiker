package arraycompanionvariable;

public class App {
    public static void main(String[] args) {
        Timetabel timeTable = new Timetabel();
        Departure departure = new Departure(1, "København H", "07:57", "08:04");
        timeTable.addDeparture(departure);
        departure = new Departure(2, "Aalborg", "08:03", "08:10");
        timeTable.addDeparture(departure);
        departure = new Departure(1, "København H", "08:32", "08:40");
        timeTable.addDeparture(departure);
        departure = new Departure(2, "Skjern", "08:46", "08:52");
        timeTable.addDeparture(departure);
        departure = new Departure(1, "København H", "08:57", "09:04");
        timeTable.addDeparture(departure);
        departure = new Departure(2, "Aalborg", "09:03", "09:10");
        timeTable.addDeparture(departure);
        departure = new Departure(1, "København H", "09:32", "09:40");
        timeTable.addDeparture(departure);
        departure = new Departure(2, "Skjern", "09:46", "09:52");
        timeTable.addDeparture(departure);

        timeTable.printDepartures();

    }










}
