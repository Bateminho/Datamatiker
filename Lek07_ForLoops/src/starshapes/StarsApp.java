package starshapes;


public class StarsApp {
    final static int MAX_ROWS = 10;

    public static void starPicture() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void starPictureA() {
        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int star = MAX_ROWS; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void starPictureB() {

        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int blank = MAX_ROWS; blank > row; blank--) {
                System.out.print(" ");
            }
            for (int star = 1; star <= row; star++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }



    public static void starPictureC() {

        for (int row = 1; row <= MAX_ROWS; row++) {
            for (int sign = 1; sign < row; sign++) {
                System.out.print(" ");
            }
            for (int star = MAX_ROWS; star >= row; star--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void starPictureD() {
//    // Første del: Udskriv et stigende antal stjerner (1, 3, 5, 7, 9)
//    for (int row = 1; row <= MAX_ROWS / 2 + 1; row++) {
//        // Udskriv mellemrum (for at centrere stjernerne)
//        for (int space = MAX_ROWS / 2 + 1; space > row; space--) {
//            System.out.print(" ");
//        }
//
//        // Udskriv stjerner
//        for (int star = 1; star <= (2 * row - 1); star++) {
//            System.out.print("*");
//        }
//
//        // Gå til næste linje
//        System.out.println();
//    }
//
//    // Anden del: Udskriv et faldende antal stjerner (9, 7, 5, 3, 1)
//    for (int row = MAX_ROWS / 2; row >= 1; row--) {
//        // Udskriv mellemrum (for at centrere stjernerne)
//        for (int space = MAX_ROWS / 2 + 1; space > row; space--) {
//            System.out.print(" ");
//        }
//
//        // Udskriv stjerner
//        for (int star = 1; star <= (2 * row - 1); star++) {
//            System.out.print("*");
//        }
//
//        // Gå til næste linje
//        System.out.println();
//    }
    }

    /**
     * @param args fd
     */
    public static void main(String[] args) {
        System.out.println("Udleveret eksempel");
        starPicture();
        System.out.println("Opgave A\n");
        starPictureA();
        System.out.println("Opgave B\n");
        starPictureB();
        System.out.println("Opgave C\n");
        starPictureC();
        System.out.println("Opgave D\n");
        starPictureD();
    }

}
