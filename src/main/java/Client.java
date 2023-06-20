import java.util.ArrayList;
import java.util.List;

public class Client extends User {

    //Atributos
    private int identificador;
    private double saldo;
    private List<Produto> carrinho;
    private Conta conta;

    //Construtor
    public Client(String nome, String cpf, String email, String dataNascimento, String numeroContato, String endereco, String genero, String interesse, double saldo, int identificador) {
        super(nome, cpf, email, dataNascimento, numeroContato, endereco, genero, interesse);
        this.saldo = saldo;
        this.carrinho = new ArrayList<>();
        this.conta = new Conta(identificador, cpf);
        this.identificador = identificador;
    }
    //Getters e Setters
    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public void adicionarAoCarrinho(Produto produto) {
        carrinho.add(produto);
    }

    public void removerDoCarrinho(Produto produto) {
        carrinho.remove(produto);
    }

    public void limparCarrinho() {
        carrinho.clear();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public Conta getConta() {
        return conta;
    }
}