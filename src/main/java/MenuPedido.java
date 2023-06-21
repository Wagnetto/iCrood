import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class MenuPedido {
    private Client cliente;
    private Restaurante restaurante;
    private List<Restaurante> estabelecimentos;
    private List<Produto> itens;
    private boolean entregue;
    private Vendor vendor;

    public void MenuPedido(Client cliente, List<Restaurante> estabelecimentos, List<Produto> itens) {
        this.cliente = cliente;
        this.estabelecimentos = estabelecimentos;
        this.itens = itens;
        this.entregue = false;
    }

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

    public void exibirRestaurantes() {
        for (Restaurante estabelecimento : estabelecimentos) {
            System.out.println(estabelecimento.getNomeRestaurante());
        }
    }

    public Restaurante selecionaRestaurante() {
        Scanner input = new Scanner(System.in);
        int entrada;

        System.out.println("Entre o número do Restaurante: ");
        entrada = input.nextInt();

        if (entrada >= 1 && entrada <= estabelecimentos.size()) {
            Restaurante restauranteSelecionado = estabelecimentos.get(entrada - 1);
            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNomeRestaurante());
            this.restaurante = restauranteSelecionado;
            return restauranteSelecionado;
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            return selecionaRestaurante();
        }
    }
}