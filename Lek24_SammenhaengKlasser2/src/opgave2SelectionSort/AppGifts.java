package opgave2SelectionSort;

public class AppGifts {
    public static void main(String[] args) {

        Person sean = new Person("Sean", 41);
        Person clive = new Person("Clive", 65);

        Gift giftGuitar = new Gift("Guitar", 6750, clive);
        Gift giftPS5 = new Gift("Playstation5", 4000, clive);


        sean.addGift(giftGuitar);
        sean.addGift(giftPS5);

        System.out.println("Totale pris af gaver: " + sean.getTotalPriceOfGifts());


        System.out.println(sean.getPersonsGivingGifts());
    }
}
