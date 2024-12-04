package momsprocentstatic;

public class VareApp {
    
    public static void main(String[] args) {
        
        Vare v1 = new Vare("Fars", 100);
        Vare v2 = new Vare("Fisk", 200);
        Vare v3 = new Vare("Havregyn", 1);
        Vare v4 = new Vare("Mel", 12);
        System.out.println(v1.getMomsProcent());
        Vare.setMomsProcent(20);
        // Momsprocent for alle varer er 20   ????
        System.out.println(v1.getMomsProcent());
        System.out.println(v2.getMomsProcent());
               
    }
    
}
