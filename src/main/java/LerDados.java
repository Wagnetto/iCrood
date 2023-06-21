import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerDados {
    public static List<String> lerEntregas() {
        List<String> entregas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("delivery.data"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Pedido>")) {
                    entregas.add(line.substring(7));
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler as entregas: " + e.getMessage());
        }
        return entregas;
    }

}
