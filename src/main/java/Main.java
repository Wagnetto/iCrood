import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        //TODO : ZONA DE TESTES
        Random random = new Random();
        LocalDate hoje = LocalDate.now();
        int idClienteTeste = random.nextInt(999)+ 201;
        int idVendorTeste = random.nextInt(200)+1;
        int idRestauranteTeste = random.nextInt(1500)+1000;
        Client fulanin = new Client("Carlos", "12345678901", hoje, "Casa do caralho", "99996969", "chuchu@gmail.com", 300, idClienteTeste);
        //TODO lembrar de tirar o ArrayList do Construtor
        Vendor fulaninVendor = new Vendor("FulaninVendor", "123123-123", hoje,"endereço do fulano Vendor", "123vendo123", "vendorEmail", 0, idVendorTeste , new ArrayList<Restaurante>());


        // TODO FIM DA ZONA DE TESTES

        Scanner input = new Scanner(System.in);
        int idinserido = 0;

//      Cria cadastro no começo do programa
        Cadastro cadastro = new Cadastro();
        cadastro.exibeTelaInicial();

        if(cadastro.jaTemCadastro()){
            int idInserido;
            System.out.println("Entre seu ID: ");
            idInserido = input.nextInt();

            //VALIDA se é cliente POR ID, se for, bora gastar:
            if(cadastro.buscarClientePorId(idinserido) == true) {
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();

                // TODO mostrar restaurantes, poder escolher o restaurante poder escolher pedido terminar entrega
            }
            // ou, se é Vendor, exibir menu respectivo
            else if(!cadastro.buscarVendorPorId(idinserido)){

            }
            //TODO exibirMenuVendor() ? a ser criado
        } else {
            //se não tem uma conta:
            //TODO terminar este fluxo, conectando com as funções de cadastro
            System.out.println("Você tem um Restaurante ou quer fazer um pedido?\n"
                    +"1. Restaurante          2. Cliente");
            int entrada;
            entrada = input.nextInt();
            if(entrada == 1){
                // zera variavel restaurante para poder ser reutilizada
                Restaurante restaurantex = null;
                int quantidadeItens;
                Cadastro.cadastrarVendor();
                Cadastro.cadastrarRestaurante();

                // Adiciona Produtos ao Cardápio do Restaurante
                System.out.println("Quer adicionar quantos itens ao cardápio? ");
                quantidadeItens = input.nextInt();

                // Pega ultimo restaurante e armazena em X
                restaurantex = cadastro.buscarUltimoRestauranteCriado();

                // Verifica se o restaurante existe
                if (restaurantex != null) {
                    // Define o proprietário do restaurante com o último vendor criado
                    restaurantex.setProprietario(cadastro.buscarUltimoVendorCriado());

                    // Adiciona a quantidade de itens solicitados ao cardápio do restaurante
                    restaurantex.PedeItensAdicionarLista(quantidadeItens);

                    System.out.println("Seu restaurante foi criado com sucesso! E seus itens foram adicionados!");
                } else {
                    System.out.println("Não foi possível encontrar o restaurante criado.");
                }

                // TODO não aparece estabelecimentos de vendor
                System.out.println(cadastro.buscarUltimoVendorCriado().toString());
                System.out.println(restaurantex.toString());
            } else if(entrada == 2){
                Cadastro.cadastrarCliente();
                // menu.exibirRestaurantes(); -> método já criado
            }


        }


    }
}