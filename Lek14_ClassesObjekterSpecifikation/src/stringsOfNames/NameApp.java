package stringsOfNames;

public class NameApp {
    public static void main(String[] args) {
        Name n1 = new Name("Sean", "Harboe", "Bateman");
        Name n2 = new Name("Kasper", "Kurup");


        System.out.println(n1);
        System.out.println(n2);

        n2.setFirstName("Henning");
        System.out.println(n2);

        System.out.println();
        System.out.println(n1.getFirstName());
        System.out.println(n1.getMiddleName());
        System.out.println(n1.getLastName());

        System.out.println();

        n2.setLastName("Riber");

        System.out.println(n1.getFullName());
        System.out.println(n2.getFullName());

        System.out.println();

        System.out.println(n1.getInit());
        System.out.println(n2.getInit());

        System.out.println();

        System.out.println(n1.getUserName());
        System.out.println(n2.getUserName());

        System.out.println();

        System.out.println(n1.getCryptoInit(2));
        System.out.println(n2.getCryptoInit(2));
    }
}
