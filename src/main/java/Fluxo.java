import java.util.Scanner;

public class Fluxo {
    // Métodos para tela Console
    public void exibeTelaInicial() {
        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄");
        System.out.println("█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");
    }

    public void exibirFluxo() {
        Scanner scan = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        System.out.println("Bem-vindo! Já possui um cadastro?\n1. Sim          2. Não");
        int resposta = scan.nextInt();

        if (resposta == 1) {
            System.out.println("Digite o ID para procurar o cadastro:");
            int id = scan.nextInt();

            if (Cadastro.procuraCadastro(id)) {
                System.out.println("Cadastro encontrado!");

                // VALIDA se é cliente POR ID, se for, bora gastar:
                if (isCliente()) {
                    MenuPedido menu = new MenuPedido();
                    menu.exibirRestaurantes();
                    menu.selecionaRestaurante().mostraCardapio();

                    // TODO: Testar se o método funciona e incrementar a escolha de pedido / terminar a entrega
                }
                // ou, se é Vendor, exibir menu respectivo
                else if (isVendedor()) {
                    MenuPedido menu = new MenuPedido();
                    menu.exibirRestaurantes();
                    menu.selecionaRestaurante().mostraCardapio();
                } else {
                    System.out.println("Parâmetro não existente!");
                }
            } else {
                System.out.println("Cadastro não encontrado.");
                criarConta();
            }
        } else if (resposta == 2) {
            criarConta();
        } else {
            System.out.println("Opção inválida!");
        }
    }

    public void criarConta() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Deseja criar uma conta?\n1. Sim       2. Não");
        int resposta = scan.nextInt();

        if (resposta == 1) {
            Cadastro.cadastrarPessoa();
            System.out.println("Você tem um Restaurante ou quer fazer um pedido?\n1. Restaurante    2. Cliente");
            int opcao = scan.nextInt();

            if (opcao == 1) {
                criarVendorRestauranteConsole();
            } else if (opcao == 2) {
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio();
            } else {
                System.out.println("Opção inválida!");
            }
        } else if (resposta == 2) {

        } else {
            System.out.println("Opção inválida!");
        }
    }

    public void criarVendorRestauranteConsole() {
        Scanner input = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        // Zera variável restaurante para poder ser reutilizada
        Restaurante restaurante = null;
        Vendor vendor = null;

        Cadastro.cadastrarVendor();
        Cadastro.cadastrarRestaurante();

        System.out.println("Quer adicionar quantos itens ao cardápio? ");
        int quantidadeItens = input.nextInt();

        // Pega o último restaurante e armazena em restaurante
        restaurante = cadastro.buscarUltimoRestauranteCriado();
        vendor = cadastro.buscarUltimoVendorCriado();

        // Vincula o vendor recém-criado ao restaurante recém-criado
        vendor.AdicionarRestaurante(restaurante);

        // Cria itens e guarda na lista, em seguida mostra o cardápio do restaurante
        restaurante.PedeItensAdicionarLista(quantidadeItens);
        restaurante.mostraCardapio();

        System.out.println("Você cadastrou seu restaurante, seu perfil junto e seu cardápio com sucesso");
        // TODO: Área de teste para verificar se está tudo ok

        // Printa informações do restaurante para testar se está tudo ok
        System.out.println(restaurante);
        // TODO: Fim da área de teste
    }

    private boolean isVendedor() {
        return true;
    }

    private boolean isCliente() {
        return true;
    }
}
