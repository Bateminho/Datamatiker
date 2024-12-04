package theFan;

public class FanApp {
    public static void main(String[] args) {
        Fan f1 = new Fan();
        Fan f2 = new Fan();

        f1.setColor("Yellow");
        f1.setSpeed(3);
        f1.setRadius(10);
        f1.setOn(true);

        f2.setSpeed(2);


        System.out.println(f1);
        System.out.println(f2);
    }
}
