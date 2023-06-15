import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
//Classe do Cliente, podem realisar compras sem modificar restaurante e derivados
public class Client extends User {
    // Atributos
    private CarrinhoDeCompras carrinho;
    private UUID idCliente;
    private List<Produto> compras;

    // Construtor
    public Client(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira, boolean role, UUID idCliente, List<Produto> compras) {
        super(nome, cpf, dataNascimento, endereco, numeroTelefone, email, saldoCarteira, role);
        this.idCliente = idCliente;
        this.compras = compras;
    }


    // Métodos
    public void adicionarAoCarrinho(Produto produto, List<Produto> cardapio) {
        //Adiciona o produto desejado ao carrinho e impõe o valor no carrinho de compras
        if (cardapio.contains(produto)) {
            carrinho.adicionarItem(produto);
            double novoSaldo = getSaldoCarteira() - produto.getValor();
            setSaldoCarteira(novoSaldo);
            System.out.println("Produto adicionado ao carrinho com sucesso!");
        } else {
            System.out.println("Produto não encontrado no cardápio.");
        }
    }
    public void removerDoCarrinho(Produto produto) {
        //Remove o produto desejado presente no carrinho e desconta o valor aplicado
        carrinho.removerItem(produto);
        double novoSaldo = getSaldoCarteira() + produto.getValor();
        setSaldoCarteira(novoSaldo);
        System.out.println("Produto removido do carrinho com sucesso!");
    }
    public String toStringUser() {
        return "Client{" +
                "compras=" + compras +
                ", id=" + idCliente +
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
