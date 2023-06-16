import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄\n" +
                           "█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");

        Cadastro cadastro = new Cadastro;
        cadastro.inserirDados();
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