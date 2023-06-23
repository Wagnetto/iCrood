import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

class MenuCliente {
    static Scanner input = new Scanner(System.in);
    private Client cliente;
    private Restaurante restaurante;
    private boolean entregue;
    private Vendor vendor;



    public void exibirListaRestaurantes(int i) { // exibe todos os restaurantes puxando de Cadastro

        for (Restaurante restaurante : ListaDeRestaurantes.estabelecimentosCadastrados) {
            System.out.println(i + ". " + restaurante.getNomeRestaurante());
            i++;
        }
    }

    //TODO ING exibir cardapio restaurante

    public void exibirMenuClienteJacadastrado() {
        System.out.println("Digite 1 para procurar um restaurante e fazer pedido.\nDigite 2 para visualizar seu histórico de pedidos");
        int opcaoMenu = input.nextInt();
        if(opcaoMenu == 1){
            pedidoFluxo();

        } else if(opcaoMenu ==2) {
            exibirHistoricoCliente();
        }

    }

    public static Restaurante selecionaRestaurante() {
        System.out.println("Seleciona restaurante foi chamado");
        System.out.println("Digite o Número do Restaurante");
        Scanner input = new Scanner(System.in);
        int entrada = input.nextInt();

        List<Restaurante> restaurantes = ListaDeRestaurantes.estabelecimentosCadastrados;

        if (entrada >= 1 && entrada <= ListaDeRestaurantes.estabelecimentosCadastrados.size()) {
            // Restaurante válido selecionado
            Restaurante restauranteSelecionado = restaurantes.get(entrada - 1);
            System.out.println("Restaurante selecionado: " + restauranteSelecionado.getNomeRestaurante());  //OK até aqui

            //Iniciar a instância de um pedido. Salvar Nome Restaurante
            String nomeRestaurantePedido = restauranteSelecionado.getNomeRestaurante();


            return restauranteSelecionado;
        } else {
            System.out.println("Opção inválida. Tente novamente.");

            // Chamada recursiva para selecionar novamente o restaurante, (fallback)
            return selecionaRestaurante();
        }


    }


    public void pedidoFluxo(){
        exibirListaRestaurantes(1);
        String restaurante = MenuCliente.selecionaRestaurante().getNomeRestaurante();
        ListaDeRestaurantes.exibirListaProdutos();

    }

    //TODO
    public void exibirHistoricoCliente(){

    }





}
