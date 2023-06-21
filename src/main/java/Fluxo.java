import java.util.Scanner;

public class Fluxo {
    // Métodos para tela Console
    public void exibeTelaInicial() {
        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄");
        System.out.println("█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");
    }

    public boolean jaTemCadastro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem-vindo! Já possui um cadastro?\n1. Sim          2. Não");
        if (input.nextInt() == 1) {
            System.out.println("Digite o ID para procurar o cadastro:");
            int id = input.nextInt();
            boolean encontrado = Cadastro.procuraCadastro(id);
            if (encontrado) {
                System.out.println("Cadastro encontrado!");
            } else {
                System.out.println("Cadastro não encontrado.");
            }
        }
        return false;
    }

    public void exibirFluxo() {
        Cadastro cadastro = new Cadastro();
        Scanner scan = new Scanner(System.in);

        if (jaTemCadastro()) {
            int id;
            System.out.println("Entre com seu ID: ");
            id = scan.nextInt();

            //VALIDA se é cliente POR ID, se for, bora gastar:
            if (Cadastro.procuraCadastro(id)) {
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio();

                // TODO testar se metodo funciona e incrementar escolha de pedido / terminar entrega logo após
            }
            // ou, se é Vendor, exibir menu respectivo
            else if (!Cadastro.procuraCadastro(id)) {
                System.out.println("ID não encontrado");
            }
        } else {
            int opcao = 0;
            scan.nextInt();
            System.out.println("------------  O que deseja fazer?  -------------");
            System.out.println("1: Criar pedido | 2: Ver carrinho | 3: Exibir Dados");
            switch (opcao) {
                case 1:
                    if (isCliente()) {
                        MenuPedido menu = new MenuPedido();
                        menu.exibirRestaurantes();
                        menu.selecionaRestaurante().mostraCardapio();
                    } else if(isVendedor()){
                        MenuPedido menu = new MenuPedido();
                        menu.exibirRestaurantes();
                        menu.selecionaRestaurante().mostraCardapio();
                    }else {
                        System.out.println("Acesso negado. Você não tem permissão para criar pedidos.");
                    }
                    break;
                case 2:
                    if (isCliente()) {
                        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
                        System.out.println(carrinho.toString());
                    } else if (isVendedor()){
                        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
                        System.out.println(carrinho.toString());

                    } else {
                        System.out.println("Acesso negado. Você não tem permissão para ver o carrinho.");
                    }
                    break;
                case 3:
                    if (isCliente()) {

                    }

          /*  //se não tem uma conta:
            //TODO terminar este fluxo, conectando com as funções de cadastro
            System.out.println("Você tem um Restaurante ou quer fazer um pedido?\n"
                    + "1. Restaurante          2. Cliente");
            int entrada;
            entrada = input.nextInt();
            if (entrada == 1) {
                toString(Vendor);
            } else{
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio();

            }*/
                    }
            }
        }

        public void criarVendorRestauranteConsole () {
            Scanner input = new Scanner(System.in);
            Cadastro cadastro = new Cadastro();

            // zera variavel restaurante para poder ser reutilizada
            Restaurante restaurantex = null;
            Vendor vendorX = null;
            int quantidadeItens;
            Cadastro.cadastrarVendor();
            Cadastro.cadastrarRestaurante();

            // Adiciona Produtos ao Cardápio do Restaurante
            System.out.println("Quer adicionar quantos itens ao cardápio? ");
            quantidadeItens = input.nextInt();

            // Pega ultimo restaurante e armazena em restauranteX
            restaurantex = cadastro.buscarUltimoRestauranteCriado();
            vendorX = cadastro.buscarUltimoVendorCriado();

            // vincula vendor recém criado ao restaurante recém-criado
            vendorX.AdicionarRestaurante(restaurantex);

            // cria itens e guarda na lista, logo após mostra cardápio de restaurante x
            restaurantex.PedeItensAdicionarLista(quantidadeItens);
            restaurantex.mostraCardapio();

            System.out.println("Você cadastrou seu restaurante, seu perfil junto e seu cardápio com sucesso");
            // TODO area de teste para verificar tudo ok

            // printa informações do restaurante para testar ver tudo ok
            System.out.println(restaurantex);
            // TODO fim area de teste
        }

    private boolean isVendedor() {
        return true;
    }

    private boolean isCliente() {
        return true;
    }
}