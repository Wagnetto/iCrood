import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();

        //TODO : ZONA DE TESTES
        Random random = new Random();
        LocalDate hoje = LocalDate.now();
        int idClienteTeste = random.nextInt(999)+ 201;
        int idVendorTeste = random.nextInt(200)+1;
        int idRestauranteTeste = random.nextInt(1500)+1000;

        Client fulanin = new Client("Carlos", "12345678901", hoje, "Casa do caralho", "99996969", "chuchu@gmail.com", 300, idClienteTeste);
        //TODO lembrar de tirar o ArrayList do Construtor
        Vendor fulaninVendor = new Vendor("FulaninVendor", "123123-123", hoje,"endereço do fulano Vendor", "123vendo123", "vendorEmail", 0, idVendorTeste , new ArrayList<Restaurante>());

        System.out.println(fulanin.getIdCliente());
        // TODO FIM DA ZONA DE TESTES


        // TODO precisamos reduzir a Main denovo, não fiz pq n sei em qual classe botar, fiz um esboço em MenuPedido

        Scanner input = new Scanner(System.in);
        int idinserido = 0;

//      Cria cadastro no começo do programa
//      Cadastro cadastro = new Cadastro();
        cadastro.exibeTelaInicial();

        if(cadastro.buscarClientePorId(idinserido) == true){
            int idInserido;
            System.out.println("Entre seu ID: ");
            idInserido = input.nextInt();

            //VALIDA se é cliente POR ID, se for, bora gastar:
            if(cadastro.buscarClientePorId(idinserido) == true) {
                MenuPedido menu = new MenuPedido();
                menu.exibirRestaurantes();
                menu.selecionaRestaurante().mostraCardapio();

                // TODO testar se metodo funciona e incrementar escolha de pedido / terminar entrega logo após
            }
            // ou, se é Vendor, exibir menu respectivo
            else if(cadastro.buscarVendorPorId(idinserido) == false){
                System.out.println("ID não encontrado, deseja criar outra conta?");

            }
            //TODO exibirMenuVendor() ? a ser criadote
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
                System.out.println(restaurantex.toString());
                // TODO fim area de teste
            } else if(entrada == 2){
                MenuPedido menu = new MenuPedido();
                Cadastro.cadastrarCliente();
                menu.exibirRestaurantes();

            }


        }


    }
}