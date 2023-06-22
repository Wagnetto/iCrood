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

    public void exibirRestaurantes(int i) { // exibe todos os restaurantes puxando de Cadastro
        for (LerDados.Restaurante restaurante : LerDados.lerRestaurantesDoArquivo()) {
            System.out.println(i+". " + restaurante.getNome());
            i++;
        }
    }

    public Restaurante selecionaRestaurante() {
        Scanner input = new Scanner(System.in);
        int entrada;
        System.out.println("APARECI");

        System.out.println("Entre o número do Restaurante: ");
        entrada = input.nextInt();

        List<LerDados.Restaurante> restaurantes = LerDados.lerRestaurantesDoArquivo();

        if (entrada >= 1 && entrada <= restaurantes.size()) {
            // Restaurante válido selecionado
            LerDados.Restaurante restauranteSelecionado = restaurantes.get(entrada - 1);
            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNome());

            // Defina o restaurante selecionado como o restaurante atual
            // this.restaurante = restauranteSelecionado;

            // Retorna o restaurante selecionado
            return null;
        } else {
            System.out.println("Opção inválida. Tente novamente.");

            // Chamada recursiva para selecionar novamente o restaurante
            return selecionaRestaurante();
        }
//    public Restaurante selecionaRestaurante() {
//        Scanner input = new Scanner(System.in);
//        int entrada;
//        System.out.println("APARECI");
//
//        System.out.println("Entre o número do Restaurante: ");
//        entrada = input.nextInt();
//
//        List<LerDados.Restaurante> restaurantes = LerDados.lerRestaurantesDoArquivo();
//
//        if (entrada >= 1 && entrada <= restaurantes.size()) {
//            LerDados.Restaurante restauranteSelecionado = restaurantes.get(entrada - 1);
//            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNome());
////            this.restaurante = restauranteSelecionado;
////            return (LerDados)restauranteSelecionado;
//            return null;
//        } else {
//            System.out.println("Opção inválida. Tente novamente.");
//            return selecionaRestaurante();
//        }
    }
    }
