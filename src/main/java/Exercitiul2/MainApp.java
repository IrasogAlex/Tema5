package Exercitiul2;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void scriere(List<PerecheNumere> lista) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("perechi.json"), lista);
            System.out.println("Lista a fost salvata in fisierul perechi.json.");
        } catch (IOException e) {
            System.err.println("Eroare la scrierea in fisier: " + e.getMessage());
        }
    }

    public static List<PerecheNumere> citire() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return List.of(objectMapper.readValue(new File("perechi.json"), PerecheNumere[].class));
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisier: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // Crearea listei de perechi
        List<PerecheNumere> lista = new ArrayList<>();
        lista.add(new PerecheNumere(8, 13)); // consecutive Fibonacci
        lista.add(new PerecheNumere(12, 15)); // CMMC: 60
        lista.add(new PerecheNumere(22, 40)); // cifre pare egale

        // Salvarea în fișier JSON
        scriere(lista);

        // Citirea din fișier JSON
        List<PerecheNumere> perechiDinFisier = citire();
        System.out.println("\nPerechile citite din fisier:");
        perechiDinFisier.forEach(System.out::println);

        // Verificări pe fiecare pereche
        for (PerecheNumere pereche : perechiDinFisier) {
            System.out.println("\n" + pereche);
            System.out.println("Sunt consecutive in Fibonacci? " + pereche.suntConsecutiveFibonacci());
            System.out.println("CMMC: " + pereche.calculeazaCMMC());
            System.out.println("Au suma cifrelor egala? " + pereche.auSumaCifrelorEgala());
            System.out.println("Au acelasi numar de cifre pare? " + pereche.auAcelasiNumarDeCifrePare());
        }
    }
}