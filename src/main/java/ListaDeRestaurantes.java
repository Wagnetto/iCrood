import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaDeRestaurantes {

    static List<Produto> cardapio = new ArrayList<>(ListaDeProdutos.prePopulaCardapio());


    public static List<Restaurante> estabelecimentosCadastrados = new ArrayList<>();

    public List<Restaurante> getEstabelecimentos() {
        return estabelecimentosCadastrados;
    }

    public void setEstabelecimentos(List<Restaurante> estabelecimentos) {
        this.estabelecimentosCadastrados = estabelecimentos;
    }

    static public void adicionaRestaurante(Restaurante restaurante){
        estabelecimentosCadastrados.add(restaurante);
    }

    static public List<Restaurante> prePopulaListaRestaurantes(){
        Random id = new Random();
        estabelecimentosCadastrados.add(new Restaurante("Xis da Bia", id.nextInt(10) +1, "Av. Paraguassu, 300", "90190-000", cardapio));
        estabelecimentosCadastrados.add(new Restaurante("Casa do Sol", id.nextInt(10) +1, "Av. Érico Veríssimo, 300", "90190-111", cardapio));
        estabelecimentosCadastrados.add(new Restaurante("Tudo Pelo Social", id.nextInt(10) +1, "Av. João Alfredo, 300", "90190-111", cardapio));

        return estabelecimentosCadastrados;
    }

    public static void exibirProduto(int i, Produto produto) {
        System.out.println(i + ". " + produto.getNomeProduto());
        System.out.println(produto.getDescricaoProduto());
        System.out.println(produto.getValor());
    }

    public static String exibirListaProdutos() {
        int i = 1;
            for (Produto produto : cardapio) {
                exibirProduto(i, produto);
                i++;
            }

        return null;
    }


}
