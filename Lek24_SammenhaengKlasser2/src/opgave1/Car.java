package opgave1;

import java.util.ArrayList;

public class Car {

    private String license;
    private double pricePerDay;
    private int purchaseYear;
    private final ArrayList<Rental> rentals = new ArrayList<>();

    public Car(String license, int year) {
        this.license = license;
        this.purchaseYear = year;
    }

    public void setDayPrice(double price) {
       pricePerDay = price;
    }

    public double getDayPrice() {
        return pricePerDay;
    }

    public String getLicense() {
        return license;
    }

    public int getPurchaseYear() {
        return purchaseYear;
    }

    public int getMostDays() {
        int result = 0;

        for (Rental days : rentals) {
            if (days.getDays() > result) {
                result = days.getDays();
            }
        }
        return result;
    }

    public ArrayList<Rental> getRentals() {
        return new ArrayList<>(rentals);
    }

    public void addRental(Rental rental) {
        if(!rentals.contains(rental)) {
            rentals.add(rental);
            rental.addCar(this);
        }
    }
    public void removeRental(Rental rental) {
        if (rentals.contains(rental)) {
            rentals.remove(rental);
        }
    }

    @Override
    public String toString() {
        return license;
    }


}
