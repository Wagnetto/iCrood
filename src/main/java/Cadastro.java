import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Cadastro {
    private int idCliente;
    private static List<Client> clientes = new ArrayList<>();
    private static List<Vendor> vendors = new ArrayList<>();
    private static List<Restaurante> restaurantes = new ArrayList<>();
    Scanner input = new Scanner(System.in);



    // Getters
    public int getIdCliente() {
        return idCliente;
    }

    public static List<Client> getClientes() {
        return clientes;
    }

    public int getClientesTamanho() {
        return clientes.size();
    }

    public static List<Vendor> getVendors() {
        return vendors;
    }

    public int getVendorsTamanho() {
        return vendors.size();
    }

    public static List<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    // Métodos

    public static boolean procuraCadastro(int id) {
        try (Scanner fileScanner = new Scanner(new File("idList.data"))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if ((line.startsWith("ID Cliente:") || line.startsWith("ID Vendor:")) && line.contains(String.valueOf(id))) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("ID não encontrado: " + e.getMessage());
        }
        return false;
    }

    public static void cadastrarPessoa() {//Método de entrada
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que bom que quer criar uma conta!");
        System.out.println("E para qual funcionalidade teria essa conta?");
        System.out.println("1. Gerenciar estabelecimentos    2. Cliente");

        int opcao = scanner.nextInt();

        if (opcao == 1) {
            cadastrarVendor();
        } else if (opcao == 2) {
            cadastrarCliente();
        } else {
            System.out.println("Não foi possível completar a ação, opção não existente!");
        }
    }

    public static void cadastrarCliente() {
        Scanner scan = new Scanner(System.in);
        Random id = new Random();

        // Guarda todos atributos que serão usados
        String nome = "", cpf = "", dataNascimento = "", endereco = "", numeroTelefone = "", email = "";

        // armazena eles nas variaveis
        System.out.println("Cadastro de Cliente");
        System.out.println("-----------------------");
        System.out.println("Nome: ");
        nome = scan.nextLine();
        System.out.println("CPF: ");
        cpf = scan.nextLine();

        LocalDate dataNascimentoLocalDate = pedirDataNascimentoMostrarErro();

        System.out.println("Endereço: ");
        endereco = scan.nextLine();
        System.out.println("Número de Telefone: ");
        numeroTelefone = scan.nextLine();
        System.out.println("E-mail: ");
        email = scan.nextLine();

        int idCliente = id.nextInt(9999) + 1000;
        // Atribui os dados instanciando um Cliente e adicionando esse cliente à lista de clientes
        clientes.add(new Client(nome, cpf, dataNascimentoLocalDate, endereco, numeroTelefone, email, 0, idCliente));
        SalvarDados.salvarID(idCliente, 0, 0);
        // Printa mensagem e mostra ID
        System.out.println("Conta criada com sucesso! Seu ID é: " + idCliente);

    }

    public static void cadastrarVendor() {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // Guarda todos atributos que serão usados
        String nomeVendor = "", cpfVendor = "", dataNascimentoVendor = "", enderecoVendor = "", numeroTelefoneVendor = "", emailVendor = "";

        System.out.println("Cadastro de Vendedor");
        System.out.println("-----------------------");
        System.out.println("Nome: ");
        nomeVendor = scan.nextLine();
        System.out.println("CPF: ");
        cpfVendor = scan.nextLine();
        
        LocalDate dataNascimentoLocalDate = pedirDataNascimentoMostrarErro();

        System.out.println("Endereço: ");
        enderecoVendor = scan.nextLine();
        System.out.println("Número de Telefone: ");
        numeroTelefoneVendor = scan.nextLine();
        System.out.println("E-mail: ");
        emailVendor = scan.nextLine();

        // atribui random ID como inteiro, para passar ao construtor
        int idVendor = random.nextInt(999) + 100;
        Vendor vendor = new Vendor(nomeVendor, cpfVendor,dataNascimentoLocalDate , enderecoVendor, numeroTelefoneVendor, emailVendor, 0, idVendor, new ArrayList<Restaurante>());
        //printa dados Vendor
        System.out.println(vendor.toString());
        // Atribui os dados instanciando um Vendor e adicionando esse Vendor à lista de vendors
        vendors.add(vendor);

    }

    public static void cadastrarRestaurante() {
        Random id = new Random();
        Scanner scan = new Scanner(System.in);

        // Guarda todos atributos que serão usados
        String nomeRestaurante = "", endereco = "", cep = "";
        
        System.out.println("Cadastro de Restaurante");
        System.out.println("-----------------------");
        System.out.println("Nome: ");
        nomeRestaurante= scan.nextLine();
        System.out.println("Endereço: ");
        endereco = scan.nextLine();
        System.out.println("CEP: ");
        cep = scan.nextLine();

        // atribui random ID como inteiro, para passar ao construtor
        int idRestaurante = id.nextInt(99) + 1;

        // Atribui os dados instanciando um Restaurante e adicionando esse Restaurante à lista de restaurantes
        restaurantes.add(new Restaurante(nomeRestaurante, idRestaurante, endereco, cep, new ArrayList<>()));
    }

    public Restaurante buscarUltimoRestauranteCriado() {
        if (!restaurantes.isEmpty()) {
            // Percorre a lista de restaurantes em ordem reversa
            for (int i = restaurantes.size() - 1; i >= 0; i--) {
                Restaurante restaurante = restaurantes.get(i);
                if (restaurante != null) {
                    return restaurante; // Retorna o primeiro restaurante encontrado
                }
            }
        }
        return null; // Caso a lista esteja vazia ou não haja restaurante válido
    }

    public Vendor buscarUltimoVendorCriado() {
        if (!vendors.isEmpty()) {
            // Varre a lista de vendors em ordem reversa
            for (int i = vendors.size() - 1; i >= 0; i--) {
                Vendor vendor = vendors.get(i);
                if (vendor != null) {
                    return vendor; // Retorna o primeiro vendor encontrado
                }
            }
        }
        return null; // Caso a lista esteja vazia ou não haja vendor válido
    }

    public Client buscarUltimoClienteCriado() {
        if (!clientes.isEmpty()) {
            // Percorre a lista de Cliente em ordem reversa
            for (int i = clientes.size() - 1; i >= 0; i--) {
                Client client = clientes.get(i);
                if (client != null) {
                    return client; // Retorna o primeiro Cliente encontrado
                }
            }
        }
        return null; // Caso a lista esteja vazia ou não haja restaurante válido
    }

    public static LocalDate formatarDataRecebida(String dataRecebida) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataRecebida, formatador);
    }

    public static LocalDate pedirDataNascimentoMostrarErro(){
        Scanner input = new Scanner(System.in);

        String dataNascimento;
        LocalDate dataNascimentoLocalDate = null;
        boolean dataFormatoValido = false;

        do {
            System.out.println("Entre sua Data de Nascimento: ");
            dataNascimento = input.nextLine();

            try {
                dataNascimentoLocalDate = LocalDate.parse(dataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                dataFormatoValido = true;
                return dataNascimentoLocalDate;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/mm/aaaa.");
            }
        }while (!dataFormatoValido);
        return null;
    }
}