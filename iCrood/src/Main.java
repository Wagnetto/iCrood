import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;


public class Main {
    public static LocalDate formatarDataRecebida(String dataRecebida) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        return LocalDate.parse(dataRecebida, formatador);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Cria data de nascimento em string e formata para local date
        String daataNascimentoPedro = "02/03/2010";
        LocalDate nascimentoPedroFormatado = formatarDataRecebida(daataNascimentoPedro);

        System.out.println("█ █▀▀ █▀█ █▀█ █▀█ █▀▄\n" +
                           "█ █▄▄ █▀▄ █▄█ █▄█ █▄▀");
        System.out.println("=====================");
        System.out.println("Bem-vindo!"
                +"Ja possui um cadastro?\n"
                +"1. Sim          2. Não");
        int cadastro= scan.nextInt();

            System.out.println("Digite seu nome:");
//            String nomeUser = scan.nextLine();
            String nomeUser = "Pedro"
            System.out.println("CPF:");
//            String cpfUser = scan.nextLine();

            System.out.println("Data de Nascimento (dd/MM/yyyy):");
//            String dataNascimentoUser = scan.nextLine();
            LocalDate nascimentoUser = formatarDataRecebida(dataNascimentoUser);

            System.out.println("Endereço:");
            String enderecoUser = scan.nextLine();

            System.out.println("Número de telefone/celular");
            String numeroComunicacaoUser = scan.nextLine();

            System.out.println("Email:");
            String emailUser = scan.nextLine();

            // usa o que foi criado para instanciar carlos tipo vendor
            Vendor carlos = new Vendor(nomeUser, cpfUser, nascimentoUser, enderecoUser, numeroComunicacaoUser, emailUser, 100, true, UUID.randomUUID(), new ArrayList<>());
            Client pedro = new Client("Pedro", "431567-43", nascimentoPedroFormatado, "Rua PedroExemplo123", "6752-6578", "pedro@email.com", 100, false, UUID.randomUUID(), null);

        Restaurante restaurante1 = new Restaurante("FAgondi",UUID.randomUUID(), null, enderecoUser, "12345-34", null);


        // Printa carlos e suas informações
        System.out.println(carlos.toStringUser());
        // Printa pedro e suas informações
        System.out.println(pedro.toStringUser());
        // Printa restaurante e suas informações
        System.out.println(restaurante1.toString());

        // adiciona restaurante a carlos com o método
        carlos.AdicionarRestaurante(restaurante1);

        // printa, perceba que proprietario agora tem um restaurante vinculado, mas nao printa carlos pois não tem tostring
        System.out.println(restaurante1.toString());
    }

    public static int calcularIdade(LocalDate dataNascimento) {
        // Cria uma data com o horário atual e armazena em dataAtual
        LocalDate dataAtual = LocalDate.now();

        // Pega o periodo entre dataNascimento e dataAtual e armazena em periodoIdade
        Period periodoIdade = Period.between(dataNascimento, dataAtual);

        // Retorna o periodo só que apenas os anos (caso contrario retornaria o mes e o dia também)
        return periodoIdade.getYears();
    }
}