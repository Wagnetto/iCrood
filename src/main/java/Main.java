import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Cadastro cadastro = new Cadastro();
        cadastro.carregarDadosDoArquivo();

        cadastro.exibeTelaInicial();

        if (cadastro.jaTemCadastro()) {
            System.out.println("Entre com seu ID: ");
            int idInserido = input.nextInt();

            if (cadastro.buscarClientePorId(idInserido)) {
                MenuPedido menu = new MenuPedido(cadastro);
                menu.exibirRestaurantes();
            } else if (cadastro.buscarVendorPorId(idInserido)) {
                // Lógica para o vendor
                // ...
            }
        } else {
            System.out.println("Você possui um Restaurante? (s/n)");
            String opcao = input.next();

            if (opcao.equalsIgnoreCase("s")) {
                cadastro.cadastrarVendor();
                Vendor novoVendor = cadastro.buscarUltimoVendorCriado();
                System.out.println("Você é o proprietário do Restaurante? (s/n)");
                opcao = input.next();
                if (opcao.equalsIgnoreCase("s")) {
                    cadastro.cadastrarRestaurante();
                    Restaurante novoRestaurante = cadastro.buscarUltimoRestauranteCriado();
                    novoRestaurante.setProprietario(novoVendor);
                    System.out.println("Restaurante cadastrado com sucesso!");
                } else {
                    System.out.println("Cadastro do Restaurante cancelado.");
                }
            } else if (opcao.equalsIgnoreCase("n")) {
                cadastro.cadastrarCliente();
                System.out.println("Cliente cadastrado com sucesso!");
            } else {
                System.out.println("Opção inválida. Cadastro cancelado.");
            }
        }
        cadastro.salvarDadosEmArquivo();
    }
}