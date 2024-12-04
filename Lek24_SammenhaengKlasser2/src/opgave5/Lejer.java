package opgave5;

public class Lejer {
    private String navn;
    private String uddannelse;

    public Lejer(String navn, String uddannelse) {
        this.navn = navn;
        this.uddannelse = uddannelse;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getNavn() {
        return navn;
    }

    public void setUddannelse(String uddannelse) {
        this.uddannelse = uddannelse;
    }

    public String getUddannelse() {
        return uddannelse;
    }

    @Override
    public String toString() {
        return "Lejer{" +
                "navn='" + navn + '\'' +
                ", uddannelse='" + uddannelse + '\'' +
                '}';
    }
}
