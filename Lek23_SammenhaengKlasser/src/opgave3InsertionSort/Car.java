package opgave3InsertionSort;



public class Car {

    private String license;
    private double pricePerDay;
    private int purchaseYear;

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
}
