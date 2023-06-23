import java.util.Arrays;
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
        int iteracaoRestaurantes = 1;

        exibeTelaInicial();

        System.out.println("Bem-vindo! Já possui um cadastro?\n1. Sim          2. Não");
        int resposta = scan.nextInt();

        if (resposta == 1) {
            System.out.println("Digite o ID para procurar o cadastro:");
            int id = scan.nextInt();
            int validacao = Cadastro.procurarCadastro(id, Arrays.asList("Client.data", "Vendor.data"));
            if (validacao == 0) {
                System.out.println("Cadastro não encontrado.");
                criarConta();
            } else if (validacao == 1) {
                //é cliente
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes(iteracaoRestaurantes);

                menu.selecionaRestaurante().mostraCardapio();

                // TODO: Testar se o método funciona e incrementar a escolha de pedido / terminar a entrega
            } else if (validacao == 2) {
                //é vendor
                int entrada2;
                entrada2 = scan.nextInt();
                Vendor.possuiRestaurante();
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
            System.out.println("Cadastrar um restaurante ou quer fazer um pedido?\n1. Restaurante    2. Pedido");
            int opcao = scan.nextInt();

            if (opcao == 1) {
                primeiroCadastroVendor();
            } else if (opcao == 2) {
                primeiroCadastroCliente();
                MenuPedido menu = new MenuPedido();
                int iteracaoRestaurantes = 1;
                menu.exibirRestaurantes(iteracaoRestaurantes);
                System.out.println("Digite o Número do Restaurante");
            } else {
                System.out.println("Opção inválida!");
            }
        } else if (resposta == 2) {
            System.out.println("Fechando programa");
        } else {
            System.out.println("Opção inválida!");
        }

    }
    //primeiros cadastros (cliente e vendors)
    public void primeiroCadastroCliente() {
        Cadastro.cadastrarCliente();
    }

    public void primeiroCadastroVendor() {
        Scanner input = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        // Cadastra o Vendor
        cadastro.cadastrarVendor();
        Vendor vendor = cadastro.buscarUltimoVendorCriado();

        // Cadastra o Restaurante
        cadastro.cadastrarRestaurante();
        Restaurante restaurante = cadastro.buscarUltimoRestauranteCriado();

        // Adiciona Restaurante à lista do Vendor
        vendor.adicionarRestaurante(restaurante);

        // Adicionar itens ao cardápio
        System.out.println("Quantos itens você deseja adicionar ao cardápio? ");
        int quantidadeItens = input.nextInt();
        // Limpar o buffer do scanner
        input.nextLine();

        restaurante.pedeItensAdicionarLista(quantidadeItens);

        SalvarDados.salvarVendor(vendor);
        SalvarDados.salvarRestaurante(restaurante);
        SalvarDados.salvarCardapioRestaurante(restaurante);

        // Mostrar o cardápio do restaurante
        restaurante.mostraCardapio();

        System.out.println("Você cadastrou seu restaurante, seu perfil junto e seu cardápio com sucesso");
        System.out.println(restaurante); // Área de teste para verificar se está tudo ok
    }
    // TODO: Fim da área de teste


}
