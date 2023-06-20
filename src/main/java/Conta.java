public class Conta {
    private int identificador;
    private String cpf;

    public Conta(int identificador, String cpf) {
        this.identificador = identificador;
        this.cpf = cpf;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getCpf() {
        return cpf;
    }
}

