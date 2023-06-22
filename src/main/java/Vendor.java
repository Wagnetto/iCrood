import java.time.LocalDate;
import java.util.List;

//Classe do vendedor, pode realizar compras e gerenciar seus estabelecimentos
public class Vendor extends User {
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

    // Métodos
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