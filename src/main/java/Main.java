import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
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
        Vendor fulaninVendor = new Vendor("FulaninVendor", "123123-123", hoje,"endereço do fulano Vendor", "123vendo123", "vendorEmail", 0, idVendorTeste , new ArrayList<>());

        // TODO cardapío - retirar cardapio para evitar null no constructor. Alguém disse que é ruim deixar dessa maneira
        Restaurante restaurante1 = new Restaurante("FAgondi",idRestauranteTeste, null, "", "12345-34", null);

//        fulaninVendor.toString();
//        System.out.println(fulanin.toString());
        //TODO FIM DA ZONA DE TESTES

        Scanner scan = new Scanner(System.in);

//      Ja criar classe cadastro logo quando iniciar o programa
        Cadastro cadastro = new Cadastro();
        int entrada;

        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄\n" +
                "█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");
        System.out.println("Bem-vindo!"
                +"Ja possui um cadastro?\n"
                +"1. Sim          2. Não");
        entrada = scan.nextInt();
//      limpa scanner para não conflitar
        scan.nextLine();

//      Caminho caso já tenha uma conta
        if(entrada == 1){
            entrada = scan.nextInt();

            // TODO Fluxo já cadastrado
            //valida cliente ou dono
            //if(cliente) => MenuCliente.exibirMenu();
            //else (dono) => MenuRestaurante.exibirMenu();

        }
//      Caminho para Cadastrar Cliente ou Vendor
        else if (entrada == 2){
            System.out.println("Quer se cadastrar como Dono de Restaurante ou Cliente?\n"
                    +"1. Dono          2. Cliente");
            entrada = scan.nextInt();

            if (entrada == 1){
                System.out.println("Cadastrar Vendor: ");
                Cadastro.cadastrarVendor();


                System.out.println("Deseja cadastrar um Restaurante? ");
                entrada = scan.nextInt();
                if(entrada == 1){
                    Cadastro.cadastrarRestaurante();

                } else if (entrada == 0){
                    // TODO código para não cadastrar restaurante, fazer oq então?
                }

            } else if(entrada == 2){
                System.out.println("Cadastrar Cliente: ");
                Cadastro.cadastrarCliente();


            } else {
                System.out.println("Entrada inválida, terminando programa...");
            }
        }


    }
}