import java.util.List;
import java.util.Random;

//Classe dos produtos oferecidos pelos restaurantes
public class Produto {
    // Atributos
    private List<Produto> itens;
    private int idProduto;
    private String nomeProduto;
    private String descricaoProduto;
    private double valor;

    // Construtor
    public Produto(String nomeProduto, String descricaoProduto, double valor) {
        setIdProduto(gerarIdProduto());
        this.nomeProduto = nomeProduto;
        this.descricaoProduto = descricaoProduto;
        this.valor = valor;
    }

    public int getIdProduto() {
        return idProduto;
    }
    public int gerarIdProduto(){
        Random id = new Random();
        int idRestaurante = id.nextInt(3000) + 2000;

        return idRestaurante;
    }

    public void setIdProduto(int idProduto) {
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
        StringBuffer sb = new StringBuffer();
        sb.append("Produto\n");
        sb.append("Nome do Produto: ").append(nomeProduto);
        sb.append(" | ID do Produto: ").append(idProduto);
        sb.append(" | Descricao do Produto: ").append(descricaoProduto);
        sb.append(" | Valor: R$").append(valor).append("\n");
        return sb.toString();
    }
}
