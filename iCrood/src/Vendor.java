import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//Classe do vendedor, pode realisar compras e greneciar seus estabelecimentos
public class Vendor extends User {
    private UUID idVendor;
    private List<Restaurante> estabelecimentos;

    // Construtor
    public Vendor(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira, boolean role, UUID idVendor, List<Restaurante> estabelecimentos) {
        super(nome, cpf, dataNascimento, endereco, numeroTelefone, email, saldoCarteira, role);
        this.idVendor = idVendor;
        this.estabelecimentos = estabelecimentos;
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
                ", role=" + role +
                '}';
    }
}
