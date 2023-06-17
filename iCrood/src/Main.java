import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        //TODO : ZONA DE TESTES
        LocalDate hoje = LocalDate.now();

        UUID id = UUID.randomUUID();

        Client fulanin = new Client("Carlos", "12345678901", hoje, "Casa do caralho", "99996969", "chuchu@gmail.com", 300, id);
        Vendor fulaninVendor = new Vendor("FulaninVendor", "123123-123", hoje,"endereço do fulano Vendor", "123vendo123", "vendorEmail", 0, UUID.randomUUID(), new ArrayList<>());

        fulaninVendor.toString();
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

            // código

        }
//      Caminho para Cadastrar Cliente ou Vendor
        else if (entrada == 2){
            System.out.println("Quer se cadastrar como Dono de Restaurante ou Cliente?\n"
                    +"1. Dono          2. Cliente");
            entrada = scan.nextInt();

            if (entrada == 1){
                System.out.println("Cadastrar Vendor: ");
                Cadastro.cadastrarVendor();

                // TODO após cadastrar vendor, pedir para cadastrar Restaurante?

            } else if(entrada == 2){
                System.out.println("Cadastrar Cliente: ");
                Cadastro.cadastrarCliente();
            } else {
                System.out.println("Entrada inválida, terminando programa...");
            }
        }

        cadastro.imprimirClientes();
        Restaurante restaurante1 = new Restaurante("FAgondi",UUID.randomUUID(), null, "", "12345-34", null);

    }
}