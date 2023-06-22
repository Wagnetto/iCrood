import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
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
        Cadastro cadastro = new Cadastro();

        System.out.println("Bem-vindo! Já possui um cadastro?\n1. Sim          2. Não");
        int resposta = scan.nextInt();

        if (resposta == 1) {
            System.out.println("Digite o ID para procurar o cadastro:");
            int id = scan.nextInt();

            if (Cadastro.procurarCadastro(id, Arrays.asList("Client.data", "Vendor.data"))) {
                System.out.println("Cadastro encontrado!");

                if (isCliente()) {
                    MenuPedido menu = new MenuPedido();
                    menu.exibirRestaurantes();
                    menu.selecionaRestaurante().mostraCardapio();

                    // TODO: Testar se o método funciona e incrementar a escolha de pedido / terminar a entrega
                } else if (isVendedor()) {
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
        }
        else if (resposta == 2) {
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
                criarVendorRestauranteConsole();
            } else if (opcao == 2) {
                criarClienteConsole();
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio();
            } else {
                System.out.println("Opção inválida!");
            }
        } else if (resposta == 2) {
                System.out.println("Fechando programa");
            } else {
                System.out.println("Opção inválida!");
            }

        }


    public void criarClienteConsole() {
        Cadastro cadastro = new Cadastro();

        // Zera variável restaurante para poder ser reutilizada
        Client client=null;

        Cadastro.cadastrarCliente();
    }

    public void criarVendorRestauranteConsole() {
        Scanner input = new Scanner(System.in);
        Cadastro cadastro = new Cadastro();

        // Cadastrar o Vendor
        Cadastro.cadastrarVendor();
        Vendor vendor = cadastro.buscarUltimoVendorCriado();

        // Cadastrar o Restaurante
        Cadastro.cadastrarRestaurante();
        Restaurante restaurante = cadastro.buscarUltimoRestauranteCriado();

        // Adicionar o Restaurante ao Vendor
        vendor.adicionarRestaurante(restaurante);

        // Adicionar itens ao cardápio
        System.out.println("Quantos itens você deseja adicionar ao cardápio? ");
        int quantidadeItens = input.nextInt();
        input.nextLine(); // Limpar o buffer do scanner

        restaurante.pedeItensAdicionarLista(quantidadeItens);

        SalvarDados.salvarRestaurante(restaurante);
        SalvarDados.salvarVendor(vendor);
        SalvarDados.salvarCardapioRestaurante(restaurante);

        // Mostrar o cardápio do restaurante
        restaurante.mostraCardapio();

        System.out.println("Você cadastrou seu restaurante, seu perfil junto e seu cardápio com sucesso");
        System.out.println(restaurante); // Área de teste para verificar se está tudo ok
    }
        // TODO: Fim da área de teste

    private boolean isVendedor() {
        return true;
    }

    private boolean isCliente() {
        return true;
    }
}
