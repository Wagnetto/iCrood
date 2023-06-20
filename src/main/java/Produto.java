import java.util.UUID;
import java.util.List;

//Classe dos produtos oferecidos pelos restaurantes
public class Produto {
    // Atributos
    private List<Produto> itens;
    private UUID idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double valor;

    // Construtor
    public Produto(UUID idProduto, String nomeProduto, String descricaoProduto, double valor) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valor = valor;
    }

    public UUID getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(UUID idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    //Métodos
    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }

    @Override
    public String toString() {
        return "Produto{" +
                " Nome do Produto: " + nomeProduto +
                " | Descricao do Produto: " + descricaoProduto +
                " | Valor: R$" + valor +
                '}';
    }

}
