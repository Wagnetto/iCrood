import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Cadastro {
    private static List<Client> clientes = new ArrayList<>();
    private static List<Vendor> vendors = new ArrayList<>();
    private static List<Restaurante> restaurantes = new ArrayList<>();
    Scanner input = new Scanner(System.in);


    // Getters

    public static List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public static List<Client> getClientes() {
        return clientes;
    }
    public static List<Vendor> getVendors() {
        return vendors;
    }

    public int getClientesTamanho() {
        return clientes.size();
    }

    public int getVendorsTamanho() {
        return vendors.size();
    }

    // Métodos

    public boolean jaTemCadastro() {
        System.out.println("Bem-vindo!"
                + "Ja possui um cadastro?\n"
                + "1. Sim          2. Não");
        if (input.nextInt() == 1) {
            return true;
        }
        return false;
    }

    public static void cadastrarCliente() {
        Scanner scan = new Scanner(System.in);
        Random id = new Random();

        // Guarda todos atributos que serão usados
        String nome = "", cpf = "", dataNascimento = "", endereco = "", numeroTelefone = "", email = "";

        // armazena eles nas variaveis
        System.out.println("Entre seu Nome: ");
        nome = scan.nextLine();
        System.out.println("Entre seu CPF: ");
        cpf = scan.nextLine();


        LocalDate dataNascimentoLocalDate = pedirDataNascimentoMostrarErro();

        System.out.println("Entre seu endereço: ");
        endereco = scan.nextLine();
        System.out.println("Entre seu Numero de Telefone: ");
        numeroTelefone = scan.nextLine();
        System.out.println("Entre seu E-mail: ");
        email = scan.nextLine();


        // atribui random ID como inteiro, para passar ao construtor
        int idCliente = id.nextInt(999) + 201;

        // Atribui os dados instanciando um Cliente e adicionando esse cliente à lista de clientes
        clientes.add(new Client(nome, cpf, dataNascimentoLocalDate, endereco, numeroTelefone, email, 0, idCliente));

        // Printa mensagem e mostra ID
        System.out.println("Conta criada com sucesso! Seu ID é: " + idCliente);

    }

    public static void cadastrarVendor() {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // Guarda todos atributos que serão usados
        String nomeVendor = "", cpfVendor = "", dataNascimentoVendor = "", enderecoVendor = "", numeroTelefoneVendor = "", emailVendor = "";

        // Armazena eles nas variaveis
        System.out.println("Entre seu Nome: ");
        nomeVendor = scan.nextLine();
        System.out.println("Entre seu CPF: ");
        cpfVendor = scan.nextLine();

        LocalDate dataNascimentoLocalDate = pedirDataNascimentoMostrarErro();

        System.out.println("Entre seu endereço: ");
        enderecoVendor = scan.nextLine();
        System.out.println("Entre seu Numero de Telefone: ");
        numeroTelefoneVendor = scan.nextLine();
        System.out.println("Entre seu E-mail: ");
        emailVendor = scan.nextLine();

        // atribui random ID como inteiro, para passar ao construtor
        int idVendor = random.nextInt(200) + 1;

        // Atribui os dados instanciando um Vendor e adicionando esse Vendor à lista de vendors
        vendors.add(new Vendor(nomeVendor, cpfVendor,dataNascimentoLocalDate , enderecoVendor, numeroTelefoneVendor, emailVendor, 0, idVendor, new ArrayList<Restaurante>()));
    }

    public static void cadastrarRestaurante() {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        // Guarda todos atributos que serão usados
        String nomeRestaurante = "", endereco = "", cep = "";

        System.out.println("\nEntre o nome de seu restaurante: ");
        nomeRestaurante = scan.nextLine();
        System.out.println("Entre o CEP de seu restaurante: ");
        cep = scan.nextLine();
        System.out.println("Entre seu endereço: ");
        endereco = scan.nextLine();

        // atribui random ID como inteiro, para passar ao construtor
        int idRestaurante = random.nextInt(1500) + 1000;

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

    public boolean buscarClientePorId(int idCliente) {
        for (Client cliente : clientes) {
            if (cliente.getIdCliente() == idCliente) {
                System.out.println(cliente.toString());
                return true; // Encerra o loop assim que encontrar o cliente
            }
        }
        System.out.println("Cliente não encontrado.");
        return false;
    }

    public static boolean buscarVendorPorId(int idVendor) {
        for (Vendor vendor : vendors) {
            if (vendor.getIdVendor() == idVendor) {
                System.out.println(vendor.toString());
                return true; // Encerra o loop assim que encontrar o cliente
            }
        }
        System.out.println("Vendor não encontrado.");
        return false;
    }

    public static boolean buscarRestaurantePorId(int idRestaurante) {
        for (Restaurante restaurante : restaurantes) {
            if (restaurante.getIdRestaurante() == idRestaurante) {
                System.out.println(restaurante.toString());
                return true;
            }
        }
        System.out.println("Restaurante não encontrado.");
        return false;
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

