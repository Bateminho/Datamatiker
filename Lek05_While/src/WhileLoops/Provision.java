package WhileLoops;

public class Provision {
    public static void main(String[] args) {

        int salg = 150000;
        int i = 10000;
        int j = 10000;


        System.out.println("\nSalg \tProvision");
        while (i <= salg)
        {
            System.out.println(i + "\t" + provision(i));
            i += j;

        }
        System.out.println("Done!!!");
    }

    public static double provision(double salg) {

        double result;

        if (salg <= 40000)
            result = salg * 0.06;
        else if (salg <= 100000)
            result = ((salg-40000) * 0.08) + (40000 * 0.06);
        else
            result = ((salg - 100000) * 0.1) + ((100000-40000) * 0.08) + (40000 * 0.06);
        return result;
    }
}
