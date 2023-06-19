import javax.swing.*;
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
        //TODO lembrar de tirar o ArrayList do Construtor
        Vendor fulaninVendor = new Vendor("FulaninVendor", "123123-123", hoje,"endereço do fulano Vendor", "123vendo123", "vendorEmail", 0, idVendorTeste , new ArrayList<>());


        //FIM DA ZONA DE TESTES

        Scanner input = new Scanner(System.in);

//      Ja criar classe cadastro logo quando iniciar o programa
        Cadastro cadastro = new Cadastro();
        cadastro.exibeTelaInicial();
        if(cadastro.jaTemCadastro()){
            //se já tem cadastro
            //TODO VALIDAR se é cliente, se for, bora gastar:
            MenuPedido menu = new MenuPedido();
            menu.exibirRestaurantes();
            // ou, se é Vendor, exibir menu respectivo
            //TODO exibirMenuVendor() ? a ser criado
        } else {
            //se não tem uma conta:
            //TODO terminar este fluxo, conectando com as funções de cadastro
            System.out.println("Você tem um Restaurante ou quer fazer um pedido?\n"
                    +"1. Restaurante          2. Cliente");
            //if 1:
            // Cadastro.cadastrarVendor();
            // Cadastro.cadastrarRestaurante();

            //if 2:
            //Cadastro.cadastrarCliente();
            //menu.exibirRestaurantes(); -> método já criado

        };


    }
}