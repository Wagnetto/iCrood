import java.util.List;

public class MenuPedido {
    //TODO - trocar esta lista por dados reais do banco ou de uma implementação melhor
    String restaurantes[] = { "1 - Mc Donalds", "2 - Subway", "3 - A la minuta da Bia"};
    public void exibirRestaurantes(){
        for(int i = 0; i < restaurantes.length; i++){
            System.out.println(restaurantes[i]);
        }
    }

    public void selecionaRestaurante(){

    }
}
