package opgave3;

public class AppCar {
    public static void main(String[] args) {
        Car firstCar = new Car("DK12345", 2020);
        Car secondCar = new Car("DK23456", 2021);
        Car thirdCar = new Car("DK34567", 2022);
        Car fourthCar = new Car("DK45678", 2023);
        Car fithtCar = new Car("DK56789", 2024);

        firstCar.setDayPrice(200);
        secondCar.setDayPrice(300);
        thirdCar.setDayPrice(350);
        fourthCar.setDayPrice(400);
        fithtCar.setDayPrice(500);

        Rental firstRental = new Rental(1, "06-11-2024", 5);
        firstRental.addCar(firstCar);
        firstRental.addCar(secondCar);
        firstRental.addCar(fourthCar);

        Rental secondRental = new Rental(2, "06-11-2024", 3);
        secondRental.addCar(thirdCar);
        secondRental.addCar(fithtCar);

        System.out.println("\nSamlet pris for de første biler, bil 1, 2 og 4 ((200+300+400) * 5 dage) = 4500kr");
        System.out.println("Samlet pris for de første biler: " + firstRental.getPrice() + "kr.");
        System.out.println();
        System.out.println("Samlet pris for de næste biler, bil 3 og 5 ((350 + 500) * 3 dage) = 2550kr");
        System.out.println("Samlet pris for de andre biler: " + secondRental.getPrice()+ "kr.");
    }
}
