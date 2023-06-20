import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fluxo {
    // Métodos para tela Console
    public void exibeTelaInicial() {
        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄\n" +
                            "█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");
    }
    public boolean jaTemCadastro() {
        Scanner input = new Scanner(System.in);
        System.out.println("Bem-vindo!"
                + "Ja possui um cadastro?\n"
                + "1. Sim          2. Não");
        if (input.nextInt() == 1) {
            return true;
        }
        return false;
    }

    public void exibirFluxo(boolean entradaCadastradoOuNao) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);

        if (entradaCadastradoOuNao = true){

            System.out.println("Entre seu ID: ");
            int idInserido = input.nextInt();
            // VALIDA se é cliente POR ID, se for, bora gastar:
            if (cadastro.buscarClientePorId(idInserido)) { // está funcionando
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio(); // da pra selecionar o restaurante mas não foi adicionado cardapio em restaurante teste


                // TODO testar se metodo funciona e incrementar escolha de pedido / terminar entrega logo após
            }
            // ou, se é Vendor, exibir menu respectivo
            else if (!Cadastro.buscarVendorPorId(idInserido)) {
                System.out.println("ID não encontrado, deseja criar outra conta?");

            }
            //TODO exibirMenuVendor() ? a ser criadote
        } else {
            //se não tem uma conta:
            //TODO terminar este fluxo, conectando com as funções de cadastro
            System.out.println("Você tem um Restaurante ou quer fazer um pedido?\n"
                    + "1. Restaurante          2. Cliente");
            int entrada;
            entrada = input.nextInt();
            if (entrada == 1) {
                criarVendorRestauranteConsole();
            } else if (entrada == 2) {
                MenuPedido menu = new MenuPedido();
                Cadastro.cadastrarCliente();
                menu.exibirRestaurantes();
                // TODO criar método para e caminho pra adicionar itens do cardapio de restaurante tal etc etc
            }
        }
    }

    public void criarVendorRestauranteConsole() {
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

        // vincula vendor recém criado ao restaurante recém criado
        vendorX.AdicionarRestaurante(restaurantex);

        // cria itens e guarda na lista, logo após mostra cardápio de restaurante x
        restaurantex.PedeItensAdicionarLista(quantidadeItens);
        restaurantex.mostraCardapio();

        System.out.println("Você cadastrou seu restaurante, seu perfil junto e seu cardápio com sucesso");
        // TODO area de teste para verificar tudo ok

        // printa informações do restaurante pra testar ver tudo ok
        System.out.println(restaurantex);
        // TODO fim area de teste
    }

    public void verificaIdConsole(int idInserido) {
        Cadastro cadastro = new Cadastro();
        Scanner input = new Scanner(System.in);


        if (cadastro.buscarClientePorId(idInserido)) {
            System.out.println("Entre seu ID: ");
            idInserido = input.nextInt();

            //VALIDA se é cliente POR ID, se for, bora gastar:
            if (cadastro.buscarClientePorId(idInserido)) {
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio();

                // TODO testar se metodo funciona e incrementar escolha de pedido / terminar entrega logo após
            }
            // ou, se é Vendor, exibir menu respectivo
            else if (!cadastro.buscarVendorPorId(idInserido)) {
                System.out.println("ID não encontrado, deseja criar outra conta?");

            }
        }
    }

    public void exibirEntradaInvalida(){
        System.out.println("Entrada Inválida");
    }

}
