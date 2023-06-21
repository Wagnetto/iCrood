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

    public static void salvarCliente(Client client) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Client.data", true))) {
            writer.println(client.toString());
            writer.flush();
            System.out.println("Cliente salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o cliente: " + e.getMessage());
        }
    }

    public static void salvarVendor(Vendor vendor) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Vendor.data", true))) {
            writer.println(vendor.toString());
            writer.flush();
            System.out.println("Vendedor salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o vendedor: " + e.getMessage());
        }
    }

    public static void salvarRestaurante(Restaurante restaurante) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Restaurante.data", true))) {
            writer.println(restaurante.toString());
            System.out.println("Restaurante salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o restaurante: " + e.getMessage());
        }
    }
    public static void salvarCardapioRestaurante(Restaurante restaurante) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("CardapioRestaurante.data", true))) {
            writer.println("Cardápio do restaurante " + restaurante.getNomeRestaurante() + ":");
            for (Produto produto : restaurante.getCardapio()) {
                writer.println(produto.toString());
            }
            System.out.println("Cardápio do restaurante salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o cardápio do restaurante: " + e.getMessage());
        }
    }
}