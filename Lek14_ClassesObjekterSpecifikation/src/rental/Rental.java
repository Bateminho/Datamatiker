package rental;

import java.time.*;


public class Rental {
    private int number;
    private int days;
    private double price;
    LocalDate startDate;

    Rental(int _number, int _days, double _price, LocalDate _startDate) {
        number = _number;
        days = _days;
        price = _price;
        startDate = _startDate;
    }

    public int getNumber() {
        return number;
    }

    public double getPricePrDay() {
        return price;
    }

    public void setDays(int _days) {
        days = _days;
    }

    public int getDays() {
        return days;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return startDate.plusDays(days);
    }

    public double getTotalPrice() {
        return price * days + 1000;
    }

    public void printRentalInfo() {
        System.out.println("\n------------------------------");
        System.out.println("Rental number: " + getNumber());
        System.out.println("Start for rental period: " + getStartDate());
        System.out.println("Rental period ends: " + getEndDate());
        System.out.println("Rental period in days: " + getDays());
        System.out.println("The price pr. day is: " + getPricePrDay());
        System.out.println("The total price is: " + getTotalPrice());
        System.out.println("------------------------------");

    }
}
