package Exercitiul3;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainApp {
    public static List<Mobilier> citesteMobilier(String fisier) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(fisier), new TypeReference<List<Mobilier>>() {});
        } catch (IOException e) {
            System.err.println("Eroare la citirea din fisier: " + e.getMessage());
            return List.of();
        }
    }

    public static void afiseazaMobilier(List<Mobilier> mobilier) {
        mobilier.forEach(System.out::println);
    }

    public static void afiseazaPlaciPentruMobilier(List<Mobilier> mobilier, String numePiesa) {
        mobilier.stream()
                .filter(m -> m.getNume().equalsIgnoreCase(numePiesa))
                .findFirst()
                .ifPresentOrElse(
                        m -> m.getPlaci().forEach(System.out::println),
                        () -> System.out.println("Piesa de mobilier nu a fost gasita.")
                );
    }
    public static void estimeazaColiPal(List<Mobilier> mobilier, String numePiesa) {
        final int ARIE_COALA = 2800 * 2070; // mm²
        mobilier.stream()
                .filter(m -> m.getNume().equalsIgnoreCase(numePiesa))
                .findFirst()
                .ifPresentOrElse(m -> {
                    int arieTotala = m.getPlaci().stream()
                            .mapToInt(p -> p.getLungime() * p.getLatime() * p.getNrBucati())
                            .sum();
                    int coliNecesare = (int) Math.ceil((double) arieTotala / ARIE_COALA);
                    System.out.println("Numar estimat de coli necesare: " + coliNecesare);
                }, () -> System.out.println("Piesa de mobilier nu a fost gasita."));
    }

    public static void main(String[] args) {
        List<Mobilier> mobilier = citesteMobilier("mobilier.json");

        System.out.println("Toate piesele de mobilier:");
        afiseazaMobilier(mobilier);

        System.out.println("\nPlaci pentru piesa 'Dulap':");
        afiseazaPlaciPentruMobilier(mobilier, "Dulap");

        System.out.println("\nEstimare coli de PAL pentru 'Birou':");
        estimeazaColiPal(mobilier, "Birou");
    }

}
