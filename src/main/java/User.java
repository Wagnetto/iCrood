import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

//Classe do usuário
public abstract class User {
    // Atributos
    protected String nome;
    protected String cpf;
    protected LocalDate dataNascimento;
    protected String endereco;
    protected String numeroTelefone;
    protected String email;
    protected double saldoCarteira;

    public User(String nome, String cpf, LocalDate dataNascimento, String endereco, String numeroTelefone, String email, double saldoCarteira) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.email = email;
        this.saldoCarteira = saldoCarteira;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSaldoCarteira() {
        return saldoCarteira;
    }

    public void setSaldoCarteira(double saldoCarteira) {
        this.saldoCarteira = saldoCarteira;
    }

    // Métodos
    public int CalcularIdade(LocalDate dataNascimento) {
        // Cria uma data com o horário atual e armazena em dataAtual
        LocalDate dataAtual = LocalDate.now();

        // Pega o periodo entre dataNascimento e dataAtual e armazena em periodoIdade
        Period periodoIdade = Period.between(dataNascimento, dataAtual);

        // Retorna o periodo só que apenas os anos (caso contrario retornaria o mes e o dia também)
        return periodoIdade.getYears();
    }

    public LocalDate FormatarDataRecebida(String dataRecebida) {
        // Cria um formatador que usa o formato dia mês e ano (os Ms precisam ser maiusculos, senão referenciam minutos)
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // esse método LocalDate.parse transforma uma String em LocalDate, usando um formato específico (formatador acima)
        // e a String necessária.
        return LocalDate.parse(dataRecebida, formatador);
    }

    public double AcrescentarSaldo(double valorAcrescentado) {
        return getSaldoCarteira() - valorAcrescentado;
    }

    public double DescontarSaldo(double valorDescontado) {
        return getSaldoCarteira() - valorDescontado;
    }

}