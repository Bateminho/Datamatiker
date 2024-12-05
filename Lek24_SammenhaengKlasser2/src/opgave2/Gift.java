package opgave2;

public class Gift {

    private final String description;
    private double price;
    private Person giftGivenByPerson;


    public Gift(String description, double price, Person person) {
        this.description = description;
        this.price = price;
        this.giftGivenByPerson = person;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return description;
    }
}
