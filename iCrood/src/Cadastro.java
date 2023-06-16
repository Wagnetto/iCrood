import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;


public class Cadastro {
    private static List<Client> clientes;
    private static List<Vendor> vendors;

    public static void cadastrarvendor() {

    }

    // Getters
    public List<Client> getClientes() {
        return clientes;
    }

    public int getClientesTamanho(){
        return clientes.size();
    }
    public List<Vendor> getVendors() {
        return vendors;
    }
    public int getVendorsTamanho(){
        return vendors.size();
    }

    // Métodos
    public static void cadastrarCliente(){
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

        clientes.add(new Client(nome, cpf, formatarDataRecebida(dataNascimento), endereco, numeroTelefone, email, 0, false, UUID.randomUUID(), null));

    }
    public static void cadastrarVendor(){
        Scanner scan = new Scanner(System.in);
        String nomeVendor = "", cpfVendor = "", dataNascimentoVendor = "", enderecoVendor = "", numeroTelefoneVendor = "", emailVendor = "";

        System.out.println("Entre seu Nome: ");
        nomeVendor = scan.nextLine();
        System.out.println("Entre seu CPF: ");
        cpfVendor = scan.nextLine();
        System.out.println("Entre sua Data de Nascimento: ");
        dataNascimentoVendor = scan.nextLine();
        System.out.println("Entre seu endereço: ");
        enderecoVendor = scan.nextLine();
        System.out.println("Entre seu Numero de Telefone: ");
        numeroTelefoneVendor = scan.nextLine();
        System.out.println("Entre seu E-mail: ");
        emailVendor = scan.nextLine();



        vendors.add(new Vendor(nomeVendor, cpfVendor, formatarDataRecebida(dataNascimentoVendor), enderecoVendor, numeroTelefoneVendor, emailVendor, 0, true, UUID.randomUUID(), new List<Restaurante>() , ""));

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
}


