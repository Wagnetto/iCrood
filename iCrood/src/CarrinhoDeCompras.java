import java.util.ArrayList;
import java.util.List;
//Classe do carrinho de compras
public class  CarrinhoDeCompras {
    //Atributos
    private List<Produto> itens;

    //Métodos
    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }//Lista do carrinho de compras
    public void adicionarItem(Produto produto) {
        itens.add(produto);
    }//Adição de novos produtos
    public void removerItem(Produto produto) {
        itens.remove(produto);
    }//Remoção de produtos já existentes no Carrinho de compras (ArrayList)
    public void limparCarrinho() {
        itens.clear();
    }//Caso usuário não queira nada no carrinho de compras

    public List<Produto> getItens() {
        return itens;
    }//Getter da classe

    public double calcularTotal() {
        double total = 0.0;
        for (Produto produto : itens) {
            total += produto.getValor();
        }
        return total;
    }
    //TODO
    // Total do valor a ser pago de acordo com os produtos presentes no carrinho

    @Override
    public String toString() {
        return "Carrinho de compras:\n" + itens.toString();
    }
}
