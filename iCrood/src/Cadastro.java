import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cadastro {
    List<Client> clients = new ArrayList<>();

    public void inserirDados(){
        Scanner scan = new Scanner(System.in);
        String nome = "", cpf = "", dataNascimento = "", endereco = "", numeroTelefone = "", email = "";
        System.out.println("Entre seu nome: \nEntre seu CPF: \nEntre sua data de Nascimento: \nEntre seu endereço: \nEntre seu Número de Telefone: \n");
        nome = scan.nextLine();
        cpf = scan.nextLine();
        dataNascimento = scan.nextLine();
        endereco = scan.nextLine();
        numeroTelefone = scan.nextLine();
        email = scan.nextLine();
        
    }
    public void cadastrar(String nome, ){

    }


}
