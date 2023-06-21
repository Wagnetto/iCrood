import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class MenuPedido {
    private Client cliente;
    private Restaurante restaurante;
    private boolean entregue;
    private Vendor vendor;

    public void realizarEntrega(String cidade) {
        if (cidade.equalsIgnoreCase("Porto Alegre") || cidade.equalsIgnoreCase("POA")) {
            // Lógica para realizar a entrega
            this.entregue = true;
            System.out.println("Pedido realizado com sucesso!");

            // Salvar a entrega no arquivo de dados
            SalvarDados entrega = new SalvarDados(this.cliente.getIdCliente(), this.restaurante.getIdRestaurante(), LocalDateTime.now());
            entrega.salvarEntrega();

        } else {
            System.out.println("Desculpe, as entregas só podem ser feitas em Porto Alegre.");
        }
    }

    public void exibirRestaurantes() { // exibe todos os restaurantes puxando de Cadastro
        for (Restaurante restaurante : Cadastro.getRestaurantes()) {
            System.out.println(restaurante.getNomeRestaurante());
        }
    }

    public Restaurante selecionaRestaurante() {
        Scanner input = new Scanner(System.in);
        int entrada;

        System.out.println("Entre o número do Restaurante: ");
        entrada = input.nextInt();

        List<Restaurante> restaurantes = Cadastro.getRestaurantes();

        if (entrada >= 1 && entrada <= restaurantes.size()) {
            Restaurante restauranteSelecionado = restaurantes.get(entrada - 1);
            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNomeRestaurante());
            this.restaurante = restauranteSelecionado;
            return restauranteSelecionado;
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return selecionaRestaurante();
        }
    }
}