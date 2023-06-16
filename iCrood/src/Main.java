import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);


        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄\n" +
                           "█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");

        // Cria cadastro
        Cadastro cadastro = new Cadastro();

        System.out.println("Cadastrar Cliente ");
        Cadastro.cadastrarCliente();

        System.out.println("Cadastrar Vendor: ");
        Cadastro.cadastrarvendor();
        // Iteração para criar clientes
        for(int i = 0; i < cadastro.getClientesTamanho(); i++){
        Cadastro.cadastrarCliente();


        System.out.println(Arrays.toString(cadastro.getClientes().toArray(new Client[0])));
        }
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