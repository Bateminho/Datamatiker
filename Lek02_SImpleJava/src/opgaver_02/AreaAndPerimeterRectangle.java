package opgaver_02;

public class AreaAndPerimeterRectangle {
    public static void main(String[] args) {
        double width = 5.3;
        double height = 8.6;

        double perimeter = 2 * (width + height) ;
        double area = width * height;

        System.out.println("Arealet af rektanglen er: " + area);
        System.out.println("Omkredsen af rektanglen er: " + perimeter);
    }
 }
