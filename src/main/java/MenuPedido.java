
import java.util.List;
import java.util.Scanner;

//Classe para todos os pedidos
class MenuPedido {
    //Atributos
    private Client cliente;
    private Restaurante restaurante;
    private List<Produto> itens;
    private boolean entregue;

    //Getters
    public Client getCliente() {
        return cliente;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    //Métodos
    public void MenuPedido(Client cliente, Restaurante restaurante, List<Produto> itens) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.itens = itens;
        this.entregue = false;
    }

    public void realizarEntrega(String cidade) {
        if (cidade.equalsIgnoreCase("Porto Alegre")) {
            // Lógica para realizar a entrega
            this.entregue = true;
            System.out.println("Pedido realizado com sucesso em Porto Alegre.");
        } else {
            System.out.println("Desculpe, as entregas só podem ser feitas em Porto Alegre.");
        }
    }

    //TODO - trocar esta lista por dados reais do banco ou de uma implementação melhor
    String restaurantes[] = {"1 - Mc Donalds", "2 - Subway", "3 - A la minuta da Bia"};

    public void exibirRestaurantes() {
        for (int i = 0; i < restaurantes.length; i++) {
            System.out.println(restaurantes[i]);
        }
    }

    public Restaurante selecionaRestaurante() {
        Scanner input = new Scanner(System.in);
        int entrada;

        System.out.println("Entre o número do Restaurante: ");
        entrada = input.nextInt();

        if (entrada >= 1 && entrada <= restaurantes.length) {
            String restauranteSelecionado = restaurantes[entrada - 1];
            System.out.println("Restaurante selecionado: " + restauranteSelecionado);

            // Crie um objeto Restaurante com base na escolha do usuário
            // Aqui você pode substituir o construtor de Restaurante com os valores reais
            Restaurante restaurante = new Restaurante(restauranteSelecionado, entrada, "", "", null);
            return restaurante;
        } else {
            System.out.println("Opção inválida. Tente novamente.");
            // Chama o método recursivamente em caso de opção inválida.
            return selecionaRestaurante();
        }
    }

    public void perguntarPedidoOuConsultarDados() {
        Scanner input = new Scanner(System.in);
        int entrada;

        System.out.println("Deseja consultar dados ou fazer um pedido? \n 1- Consultar Dados     2- Fazer Pedido");
        entrada = input.nextInt();

        if (entrada == 1) { // Consulta dados
            System.out.println("Entre seu ID");
            if (Cadastro.buscarVendorPorId(entrada) == true) { // Se vendor existir


            } else if (Cadastro.buscarVendorPorId(entrada) == false) { // Se vendor não existir iniciar compra

                // TODO talvez puxar castrarCliente/vendor? mas como fazer voltar tudo?

            }
        } else if (entrada == 2) { // Faz Pedido
            exibirRestaurantes();
            selecionaRestaurante();


        } else {
            System.out.println("Entrada inválida");
            perguntarPedidoOuConsultarDados();
        }
    }
}