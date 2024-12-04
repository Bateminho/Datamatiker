package theFan;

public class Fan {

    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int Fast = 3;

    private int speed;
    private Boolean on;
    private double radius;
    private String color = "blue";

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Boolean getOn() {
        return on;
    }

    public void setOn(Boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fan() {
        speed = SLOW;
        on = false;
        radius = 5.0;
        color = "Blue";

    }

    @Override
    public String toString() {
        if (on) {
            return String.format(
                    "Fan is ON - Speed: %d, Color: %s, Radius: %.2f",
                    getSpeed(), getColor(), getRadius()
            );
        } else {
            return String.format(
                    "Fan is OFF - Color: %s, Radius: %.2f",
                    getColor(), getRadius()
            );
        }
    }

}
