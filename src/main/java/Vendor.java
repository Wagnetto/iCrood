class Vendor extends User {
    private Conta conta;

    public Vendor(String nome, String cpf, String email, String dataNascimento, String numeroContato, String endereco, String genero, String interesse) {
        super(nome, cpf, email, dataNascimento, numeroContato, endereco, genero, interesse);
        this.conta = new Conta(identificador, cpf);
    }

    public Conta getConta() {
        return conta;
    }
}