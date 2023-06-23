import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaDeProdutos {


    public static List<Produto> produtosCadastrados = new ArrayList<>();

    public static List<Produto> getProdutosCadastrados() {
        return produtosCadastrados;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtosCadastrados = produtos;
    }

    static public void adicionaProduto(Produto produto){
        produtosCadastrados.add(produto);
    }

    static public List<Produto> prePopulaCardapio(){
        Random id = new Random();
        produtosCadastrados.add(new Produto("Cheeseburger", "Cheeseburger canhâo aquele",18.00));
        produtosCadastrados.add(new Produto("Massa à bolonhesa", "Macarrão com molho",20.00));
        produtosCadastrados.add(new Produto("A la minuta", "A la minuta tradicional",22.00));

        return produtosCadastrados;
    }

    public void exibirListaProdutos(int i) { // exibe todos os restaurantes puxando de Cadastro

        for (Produto produto : ListaDeProdutos.produtosCadastrados) {
            System.out.println(i + ". " + produto.getNomeProduto());
            i++;
        }
    }


}

