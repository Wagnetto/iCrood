import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


public class SalvarDados {
    private static int idCliente;
    private static int idRestaurante;
    private LocalDateTime dataEntrega;

    public SalvarDados(int idCliente, int idRestaurante, LocalDateTime dataEntrega) {
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.dataEntrega = dataEntrega;
    }

    public void salvarEntrega() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("delivery.data", true))) {
            writer.println("Pedido>" + idCliente + "," + idRestaurante + "," + dataEntrega);
            writer.flush();
            System.out.println("Entrega salva com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a entrega: " + e.getMessage());
        }
    }

    public static void salvarID(int idCliente, int idVendor, int idRestaurante) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("idList.data", true))) {
            writer.println("ID Cliente: " + idCliente);
            writer.println("ID Vendor: " + idVendor);
            writer.println("ID Restaurante: " + idRestaurante);
            writer.println();
            writer.flush();
            System.out.println("IDs salvos com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar IDs: " + e.getMessage());
        }
    }
}