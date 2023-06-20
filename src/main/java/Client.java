import java.time.LocalDate;
import java.util.List;

//Classe do Cliente, podem realisar compras sem modificar restaurante e derivados
public class Client extends User {
    // Atributos
    private CarrinhoDeCompras carrinho;

    private int idCliente;
    private List<Produto> compras;

    public Client(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira, int idCliente) {
        super(nome, cpf, dataNascimento, endereco, numeroTelefone, email, saldoCarteira);
        this.idCliente = idCliente;
        this.compras = compras;
        this.idCliente = idCliente;
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

    public int getIdCliente() {
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
        cliente.append("\n------------------------------------");
        cliente.append("\n             Cliente:\n");
        cliente.append("Nome: ").append(getNome());
        cliente.append("\nCPF: ").append(getCpf());
        cliente.append("\nData de Nascimento: ").append(getDataNascimento());
        cliente.append("\nEndereço: ").append(getEndereco());
        cliente.append("\nTelefone: ").append(getNumeroTelefone());
        cliente.append("\nE-mail: ").append(getEmail());
        cliente.append("\nSaldo: ").append(getSaldoCarteira());
        cliente.append("\n------------------------------------");
        cliente.append("\nSeu código  é: ").append(getIdCliente());
        cliente.append("\n------------------------------------");
        return cliente.toString();
    }
}