import java.time.LocalDate;
import java.util.List;

//Classe do vendedor, pode realisar compras e greneciar seus estabelecimentos
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
    public void AdicionarRestaurante(Restaurante restauranteX){
        restauranteX.setProprietario(this);
        estabelecimentos.add(restauranteX);
    }
    public void RemoverRestaurante(Restaurante restauranteX) {
        restauranteX.setProprietario(null);
        estabelecimentos.remove(restauranteX);
    }
    @Override
    public String toString() {
        StringBuilder vendorInfo = new StringBuilder();
        vendorInfo.append("\n-----------------------------");
        vendorInfo.append("\n          Vendedor:\n");
        vendorInfo.append("\nNome: ").append(getNome());
        vendorInfo.append("\nCPF: ").append(getCpf());
        vendorInfo.append("\nData de Nascimento: ").append(getDataNascimento());
        vendorInfo.append("\nEndereço: ").append(getEndereco());
        vendorInfo.append("\nTelefone: ").append(getNumeroTelefone());
        vendorInfo.append("\nE-mail: ").append(getEmail());
        vendorInfo.append("\nSaldo: ").append(getSaldoCarteira());
        vendorInfo.append("\n-----------------------------");
        vendorInfo.append("\nRestaurantes Relacionados:\n");
        for (Restaurante restaurante : estabelecimentos) {
            vendorInfo.append(restaurante.toString());
            vendorInfo.append("\n");
        }
        vendorInfo.append("\n-----------------------------");
        vendorInfo.append("ID de Vendor: ").append(getIdVendor());
        return vendorInfo.toString();
    }
}