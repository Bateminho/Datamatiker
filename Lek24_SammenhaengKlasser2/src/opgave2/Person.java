package opgave2;

import java.util.ArrayList;

public class Person {
    private String name;
    private int age;
    private ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void addGift(Gift gift) {
        if (!gifts.contains(gift)) {
            gifts.add(gift);
        }
    }

    public ArrayList<Gift> getGifts() {
        return new ArrayList<>(gifts);
    }

    public ArrayList<Person> getPersonsGivingGifts() {
        ArrayList<Person> personsGivingGifts = new ArrayList<>();
        for (Gift gift : gifts) {
            if (!personsGivingGifts.contains(gift.getGiftGivenByPerson())) {
                personsGivingGifts.add(gift.getGiftGivenByPerson());
            }
        }
        return personsGivingGifts;
    }


    public double getTotalPriceOfGifts() {
        double totalPrice = 0;

        if (!gifts.isEmpty()) {

            for (Gift giftPrice : gifts) {
                totalPrice += giftPrice.getPrice();
            }
            return totalPrice;
        }
        return totalPrice;
    }

    @Override
    public String toString() {
        return name;
    }
}
