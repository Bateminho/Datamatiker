package personeksempel;

public class PersonApp {
    public static void main(String[] args) {

        Person p1 = new Person("Craig David");
        p1.printPerson();
        p1.setAddress("Abbey Road");
        p1.printPerson();
        p1.setMonthlySalary(200000);
        p1.printPerson();

        System.out.println(p1.getName());
        System.out.println(p1.getAddress());
        System.out.println(p1.getMonthlySalary());

        p1.yearlySalary();
        p1.printPerson();

        Person p2 = new Person("Sean Bateman", "Skovvangsvej 184, 1.mf, 8200 Aarhus N", 6000, 2, true );
        p2.printPerson();
    }
}
