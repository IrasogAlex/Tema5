package Exercitiul2;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class PerecheNumere {
    private int numar1;
    private int numar2;

    // Constructor fără parametri
    public PerecheNumere() {}

    // Constructor cu parametri
    public PerecheNumere(int numar1, int numar2) {
        this.numar1 = numar1;
        this.numar2 = numar2;
    }

    // Getteri și setteri
    public int getNumar1() {
        return numar1;
    }

    public void setNumar1(int numar1) {
        this.numar1 = numar1;
    }

    public int getNumar2() {
        return numar2;
    }

    public void setNumar2(int numar2) {
        this.numar2 = numar2;
    }

    // Metoda toString
    @Override
    public String toString() {
        return "PerecheNumere{" +
                "numar1=" + numar1 +
                ", numar2=" + numar2 +
                '}';
    }

    // Metoda care verifică dacă numerele sunt consecutive în șirul lui Fibonacci
    @JsonIgnore
    public boolean suntConsecutiveFibonacci() {
        return esteInFibonacci(numar1) && esteInFibonacci(numar2) &&
                Math.abs(numar1 - numar2) == 1;
    }

    private boolean esteInFibonacci(int n) {
        if (n < 0) return false;
        int a = 0, b = 1;
        while (b < n) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b == n || n == 0;
    }

    // Metoda care calculează cel mai mic multiplu comun (CMMC)
    public int calculeazaCMMC() {
        return (numar1 * numar2) / calculeazaCMMDC(numar1, numar2);
    }

    private int calculeazaCMMDC(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // Metoda care verifică dacă suma cifrelor este egală
    public boolean auSumaCifrelorEgala() {
        return sumaCifrelor(numar1) == sumaCifrelor(numar2);
    }

    private int sumaCifrelor(int n) {
        int suma = 0;
        while (n != 0) {
            suma += n % 10;
            n /= 10;
        }
        return suma;
    }

    // Metoda care verifică dacă au același număr de cifre pare
    public boolean auAcelasiNumarDeCifrePare() {
        return numarCifrePare(numar1) == numarCifrePare(numar2);
    }

    private int numarCifrePare(int n) {
        int count = 0;
        while (n != 0) {
            if ((n % 10) % 2 == 0) {
                count++;
            }
            n /= 10;
        }
        return count;
    }
}
