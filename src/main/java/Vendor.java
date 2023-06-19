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
        StringBuilder Vendor = new StringBuilder();
        Vendor.append("\nVendor:\n");
        Vendor.append("Nome: ");
        Vendor.append(this.getNome());
        Vendor.append("\nCPF: ");
        Vendor.append(this.getCpf());
        Vendor.append("\nData de Nascimento: ");
        Vendor.append(this.getDataNascimento());
        Vendor.append("\nEndereço: ");
        Vendor.append(this.getEndereco());
        Vendor.append("\nTelefone: ");
        Vendor.append(this.getNumeroTelefone());
        Vendor.append("\nE-mail: ");
        Vendor.append(this.getEmail());
        Vendor.append("\nSaldo: ");
        Vendor.append(this.getSaldoCarteira());
        // TODO incluir restaurantes e atributos relacionados
        //todo incluir print do ID
        return Vendor.toString();
    }
}