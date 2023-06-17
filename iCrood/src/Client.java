import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
//Classe do Cliente, podem realisar compras sem modificar restaurante e derivados
public class Client extends User {
    // Atributos
    private CarrinhoDeCompras carrinho;

    private UUID idCliente;
    private List<Produto> compras;

    //TODO UUID não deve fazer parte de construtor inserido manualmente
    //TODO RETIREI lista de compras no do construtor do cliente: , List<Produto> compras
    // Construtor
    public Client(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira, UUID idCliente) {
        super(nome, cpf, dataNascimento, endereco, numeroTelefone, email, saldoCarteira);
        this.idCliente = idCliente;
        this.compras = compras;
    }

    //getters herdados de User
    public String getNome(){
        return super.getNome();
    }

    public String getCpf(){
        return super.getCpf();
    }

    public LocalDate getDataNascimento(){
        return super.getDataNascimento();
    }

    public String getEndereco(){
        return super.getEndereco();
    }

    public String getNumeroTelefone() {
        return super.getNumeroTelefone();
    }

    public String getEmail() {
        return super.getEmail();
    }

    public double getSaldoCarteira() {
        return super.getSaldoCarteira();
    }

    public CarrinhoDeCompras getCarrinho() {
        return carrinho;
    }

    public UUID getIdCliente() {
        return idCliente;
    }

    public List<Produto> getCompras() {
        return compras;
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
    @Override
    public String toString() {
        StringBuilder cliente = new StringBuilder();
        cliente.append("\nCliente:\n");
        cliente.append("Nome: ");
        cliente.append(this.getNome());
        cliente.append("\nCPF: ");
        cliente.append(this.getCpf());
        cliente.append("\nData de Nascimento: ");
        cliente.append(this.getDataNascimento());
        cliente.append("\nEndereço: ");
        cliente.append(this.getEndereco());
        cliente.append("\nTelefone: ");
        cliente.append(this.getNumeroTelefone());
        cliente.append("\nE-mail: ");
        cliente.append(this.getEmail());
        cliente.append("\nSaldo: ");
        cliente.append(this.getSaldoCarteira());
        return cliente.toString();
    }
}
