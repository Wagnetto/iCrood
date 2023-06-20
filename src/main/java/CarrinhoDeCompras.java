import java.util.ArrayList;
import java.util.List;

class CarrinhoDeCompras {
    // Atributos
    private List<Produto> itens;

    // Construtor
    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    // Getter
    public List<Produto> getItens() {
        return itens;
    }

    // Métodos
    public void adicionarProduto(Produto produto) {
        itens.add(produto);
    }

    public void removerProduto(Produto produto) {
        itens.remove(produto);
    }

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Produto produto : itens) {
            valorTotal += produto.getPreco();
        }
        return valorTotal;
    }
}