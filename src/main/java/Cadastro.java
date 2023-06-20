import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    private List<Client> clientes;
    private List<Vendor> vendedores;
    private List<Restaurante> restaurantes;
    private List<Pedido> pedidos;

    public Cadastro() {
        this.clientes = new ArrayList<>();
        this.vendedores = new ArrayList<>();
        this.restaurantes = new ArrayList<>();
        this.pedidos = new ArrayList<>();
    }

    // Métodos para cadastrar cliente, vendor e restaurante

    public void cadastrarCliente() {
        Scanner input = new Scanner(System.in);
        System.out.println("Cadastro de Cliente");
        System.out.println("-------------------");
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("CPF: ");
        String cpf = input.nextLine();
        System.out.println("Email:");
        String email=input.nextLine();
        System.out.println("Data de Nascimento (Dia/Mês/Ano): ");
        String dataNascimentoStr = input.nextLine();

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNascimento = null;

        try {
            dataNascimento = formatter.parse(dataNascimentoStr);
        } catch (ParseException e) {
            System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yyyy.");
        }


            // Outros atributos do cliente

        double saldo = 0.0; // Defina o saldo inicial do cliente
        int identificador = 0; // Defina o identificador do cliente
        Client cliente = new Client(nome, cpf,email,);
        clientes.add(cliente);
    }

    public void cadastrarVendor() {
        Scanner input = new Scanner(System.in);
        System.out.println("Cadastro de Vendor");
        System.out.println("------------------");
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("CPF: ");
        String cpf = input.nextLine();
        // Outros atributos do vendor

        Vendor vendor = new Vendor(nome, cpf);
        vendors.add(vendor);
    }

    public void cadastrarRestaurante(User dono) {//TODO: Faz o cadastro de todos e restaurante, vou cuidar do client e Pedido
        Scanner input = new Scanner(System.in);
        System.out.println("Cadastro de Restaurante");
        System.out.println("-----------------------");
        System.out.println("Nome: ");
        String nome = input.nextLine();
        System.out.println("Endereço: ");
        String endereco = input.nextLine();
        System.out.println("CEP:");
        String cep=input.nextLine();

        Restaurante restaurante = new Restaurante(nome, endereco,cep,dono);
        restaurantes.add(restaurante);
    }

    // Métodos para gerenciar produtos e restaurantes dos vendors

    public void gerenciarProdutos(Vendor vendor) {
        // Implemente o código para gerenciar os produtos do vendor
    }

    public void gerenciarRestaurantes(Vendor vendor) {
        // Implemente o código para gerenciar os restaurantes do vendor
    }
//TODO Parte do armazenamento
    public void salvarDadosEmArquivo() {
       //Banco de Dados
    }

    public void carregarDadosDoArquivo() {
       //Banco de Dados
    }

    public boolean jaTemCadastro() {
        //Banco de Dados
        return false;
    }

    public boolean buscarClientePorId(int id) {
        // Implementar lógica para buscar um cliente pelo ID
        return false;
    }

    public boolean buscarVendorPorId(int id) {
        // Implementar lógica para buscar um vendor pelo ID
        return false;
    }

    public Vendor buscarUltimoVendorCriado() {
        // Implementar lógica para buscar o último vendor criado na lista
        return null;
    }

    public Restaurante buscarUltimoRestauranteCriado() {
        // Implementar lógica para buscar o último restaurante criado na lista
        return null;
    }
    public void exibeTelaInicial() {
        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄");
        System.out.println("█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");
    }
}