import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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

    public String toStringUser() {
        return "Vendor{" +
                "id=" + idVendor +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", endereco='" + endereco + '\'' +
                ", numeroTelefone='" + numeroTelefone + '\'' +
                ", email='" + email + '\'' +
                ", saldoCarteira=" + saldoCarteira +
                '}';
    }

    @Override
    public String toString() {
        StringBuilder vendorInfo = new StringBuilder();
        vendorInfo.append("\nVendor:\n");
        vendorInfo.append("Nome: ");
        vendorInfo.append(this.getNome());
        vendorInfo.append("\nCPF: ");
        vendorInfo.append(this.getCpf());
        vendorInfo.append("\nData de Nascimento: ");
        vendorInfo.append(this.getDataNascimento());
        vendorInfo.append("\nEndereço: ");
        vendorInfo.append(this.getEndereco());
        vendorInfo.append("\nTelefone: ");
        vendorInfo.append(this.getNumeroTelefone());
        vendorInfo.append("\nE-mail: ");
        vendorInfo.append(this.getEmail());
        vendorInfo.append("\nSaldo: ");
        vendorInfo.append(this.getSaldoCarteira());
        vendorInfo.append("\nRestaurantes Relacionados:\n");

        for (Restaurante restaurante : estabelecimentos) {
            vendorInfo.append(restaurante.toString());
            vendorInfo.append("\n");
        }

        vendorInfo.append("ID de Vendor: ");
        vendorInfo.append(getIdVendor());

        return vendorInfo.toString();
    }

}
