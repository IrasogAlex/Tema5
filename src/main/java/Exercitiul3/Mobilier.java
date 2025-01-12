package Exercitiul3;
import java.util.List;

public class Mobilier {
    private String nume; // Nume piesa de mobilier, ex.: birou, dulap
    private List<Placa> placi; // Lista plăcilor care compun mobilierul

    // Constructor fără parametri
    public Mobilier() {}

    // Constructor cu parametri
    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }

    // Getteri și setteri
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<Placa> getPlaci() {
        return placi;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
