import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

//Classe do vendedor, pode realizar compras e gerenciar seus estabelecimentos
public class Vendor extends User {
    static Scanner input = new Scanner(System.in);
    private int idVendor;
    private List<Restaurante> estabelecimentos;

    // Construtor
    public Vendor(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira, int idVendor, List<Restaurante> estabelecimentos) {
        super(nome, cpf, dataNascimento, endereco, numeroTelefone, email, saldoCarteira);
        this.idVendor = idVendor;
        this.estabelecimentos = estabelecimentos;
    }


    public int getIdVendor() {
        return idVendor;
    }

    public List<Restaurante> getEstabelecimentos() {
        return estabelecimentos;
    }

    // Métodos
    public static void possuiRestaurante(){
        System.out.println("Você possui Restaurante? 1-Sim       2-Não ");
        int resposta = input.nextInt();

        if (resposta == 1){
            System.out.println("Restaurante: ");
            Restaurante.exibirMenuDeRestaurante();
            }
        else if(resposta == 2){
            System.out.println("Cadastre seu restaurante: ");
            Cadastro.cadastrarRestaurante();
            // TODO não salva restaurante e nem cria pratos
            //SalvarDados.salvarRestaurante(restaurante);
        } else {
            System.out.println("Entrada Inválida. ");
            possuiRestaurante();
        }
    }
    public void adicionarRestaurante(Restaurante restaurante) {
        restaurante.setProprietario(this);
        estabelecimentos.add(restaurante);
    }

    public void removerRestaurante(Restaurante restaurante) {
        restaurante.setProprietario(null);
        estabelecimentos.remove(restaurante);
    }

    @Override
    public String toString() {

        return "-----------------------------" +
                "\n          Vendedor:\n" +
                "\nNome: " + getNome() +
                "\nCPF: " + getCpf() +
                "\nData de Nascimento: " + getDataNascimento() +
                "\nEndereço: " + getEndereco() +
                "\nTelefone: " + getNumeroTelefone() +
                "\nE-mail: " + getEmail() +
                "\nSaldo: " + getSaldoCarteira() +
                "\n-----------------------------" +
                "\nID Dono: " + getIdVendor() +
                "\n-----------------------------";
    }
}