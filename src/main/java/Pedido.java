import java.util.List;
//Classe para todos os pedidos
class Pedido {
    //Atributos
    private Cliente cliente;
    private Restaurante restaurante;
    private List<Produto> itens;
    private boolean entregue;
    //Construtor

    public Pedido(Cliente cliente, Restaurante restaurante, List<Produto> itens) {
        this.cliente = cliente;
        this.restaurante = restaurante;
        this.itens = itens;
        this.entregue = false;
    }

    public void realizarEntrega(String cidade) {
        if (cidade.equalsIgnoreCase("Porto Alegre")) {
            // Lógica para realizar a entrega
            this.entregue = true;
            System.out.println("Pedido realizado com sucesso em Porto Alegre.");
        } else {
            System.out.println("Desculpe, as entregas só podem ser feitas em Porto Alegre.");
        }
    }

    // Getters e setters


}
