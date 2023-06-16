import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class Cadastro(){
    private List<Client> clientes = new ArrayList<>;
    private List<Vendor> vendors = new ArrayList<>;

    public void inserirDados(){
    Scanner scan = new Scanner(System.in);
    String nome = "", cpf = "", dataNascimento = "", endereco = "", numeroTelefone = "", email = "";

    System.out.println("Entre seu Nome: ");
    nome = scan.nextLine();
    System.out.println("Entre seu CPF: ");
    cpf = scan.nextLine();
    System.out.println("Entre sua Data de Nascimento: ");
    dataNascimento = scan.nextLine();
    System.out.println("Entre seu endereço: ");
    endereco = scan.nextLine();
    System.out.println("Entre seu Numero de Telefone: ");
    numeroTelefone = scan.nextLine();
    System.out.println("Entre seu E-mail: ");
    email = scan.nextLine();
    }

    public static LocalDate formatarDataRecebida(String dataRecebida) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(dataRecebida, formatador);
    }
    public static int calcularIdade(LocalDate dataNascimento) {
        // Cria uma data com o horário atual e armazena em dataAtual
        LocalDate dataAtual = LocalDate.now();

        // Pega o periodo entre dataNascimento e dataAtual e armazena em periodoIdade
        Period periodoIdade = Period.between(dataNascimento, dataAtual);

        // Retorna o periodo só que apenas os anos (caso contrario retornaria o mes e o dia também)
        return periodoIdade.getYears();
    }

    public void cadastrarVendor(String nomeCliente, String cpfCliente, String nascimentoCliente, String enderecoCliente, String numeroTelefoneCliente, String emailCliente){
        vendors.add(new Vendor(nomeCliente, cpfCliente, formatarDataRecebida(nascimentoCliente), enderecoCliente, numeroTelefoneCliente, emailCliente, 0, true, UUID.randomUUID(), new ArrayList<>()));

    }
    public void cadastrarCliente(String nomeCliente, String cpfCliente, String nascimentoCliente, String enderecoCliente, String numeroTelefoneCliente, String emailCliente){
        clientes.add(new Client(nomeCliente, cpfCliente, formatarDataRecebida(nascimentoCliente), enderecoCliente, numeroTelefoneCliente, emailCliente, 0, false, UUID.randomUUID(), null));

    }
}


