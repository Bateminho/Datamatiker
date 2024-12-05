package opgave3;

import java.util.ArrayList;

public class Rental {
    private int number;
    private int days;
    private String date;
    private ArrayList<Car> cars = new ArrayList<>();

    public Rental(int number, String date, int days) {
        this.number = number;
        this.date = date;
        this.days = days;
    }

    public double getPrice() {
        double totalPrice = 0;
        for (Car car : cars) {
            totalPrice += car.getDayPrice() * days;
        }
        return totalPrice;
    }

    public void setDays (int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public ArrayList<Car> getCars() {
        return new ArrayList<>(cars);
    }

    public void addCar(Car car) {
        if(!cars.contains(car)) {
            cars.add(car);

        }
    }

    public void removeCar(Car car) {
        if (cars.contains(car)) {
            cars.remove(car);
        }
    }


}
