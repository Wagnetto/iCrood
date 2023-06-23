import java.util.ArrayList;
import java.util.List;

//TODO ainda faz sentido esta classe existir, VICTO, HELIO ?

public class CarrinhoDeCompras {
    // Atributos
    private List<Produto> itens;

    public CarrinhoDeCompras(Restaurante restaurante) {
        this.itens = restaurante.getCardapio();
    }

    // Construtor


    // Adicionar um produto ao carrinho de compras
    public void adicionarItem(Produto produtox) {
        itens.add(produtox);
    }

    // Remover um produto do carrinho de compras
    public void removerItem(Produto produto) {
        itens.remove(produto);
    }

    // Limpar o carrinho de compras
    public void limparCarrinho() {
        itens.clear();
    }

    // Obter a lista de itens do carrinho de compras
    public List<Produto> getItens() {
        return itens;
    }




    //TODO LEVEI ESSES 2 MÉTODOS para a classe Pedido. Podemos excluir a classe toda?
    // Calcular o preço total dos produtos no carrinho de compras
    public double calcularPrecoTotal() {
        double precoTotal = 0.0;

        for (Produto produto : itens) {
            precoTotal += produto.getValor();
        }

        return precoTotal;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------\n");
        sb.append("Carrinho de compras:\n\n");
        for (Produto produto : itens) {
            sb.append(produto.toString()).append("\n");
        }
        sb.append("\nPreço total: R$").append(calcularPrecoTotal());
        return sb.toString();
    }
}