

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {

        //TODO : ZONA DE TESTES
        LocalDate hoje = LocalDate.now();

        UUID id = UUID.randomUUID();
        Client fulanin = new Client("Carlos", "12345678901", hoje, "Casa do caralho", "99996969", "chuchu@gmail.com", 300, true, id);


        System.out.println(fulanin.toString());
        //TODO FIM DA ZONA DE TESTES

        Scanner scan = new Scanner(System.in);



        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄\n" +
                           "█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");

        // Cria cadastro
        Cadastro cadastro = new Cadastro();

        System.out.println("Cadastrar Cliente ");
        Cadastro.cadastrarCliente();

        System.out.println("Cadastrar Vendor: ");
        Cadastro.cadastrarVendor();

        // Iteração para criar clientes
//        cadastro.imprimirClientes();
// cadastro.imprimirVendors();

        System.out.println("Bem-vindo!"
                +"Ja possui um cadastro?\n"
                +"1. Sim          2. Não");




        Restaurante restaurante1 = new Restaurante("FAgondi",UUID.randomUUID(), null, enderecoUser, "12345-34", null);

    }

    public static int calcularIdade(LocalDate dataNascimento) {
        // Cria uma data com o horário atual e armazena em dataAtual
        LocalDate dataAtual = LocalDate.now();

        // Pega o periodo entre dataNascimento e dataAtual e armazena em periodoIdade
        Period periodoIdade = Period.between(dataNascimento, dataAtual);

        // Retorna o periodo só que apenas os anos (caso contrario retornaria o mes e o dia também)
        return periodoIdade.getYears();
    }





}