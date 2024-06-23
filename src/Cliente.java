import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa implements Locadora{

     static int id;
     static int idCounter = 0;

    public Cliente(int idade, String nome, String cpf, char genero, int id) {
        super(idade, nome, cpf, genero);
        Cliente.id = id;
    }

    public static int getId() {
        return id;
    }

    static List<Cliente> pessoa = new ArrayList<>();

    public static void cadastrarCliente(Scanner leitor) {
        System.out.print("Nome: ");
        String nome = leitor.nextLine();

        System.out.print("Idade: ");
        int idade = 0;
        try {
            idade = Integer.parseInt(leitor.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Erro ao ler idade. Certifique-se de inserir um número válido.");
            return; // Retorna ou trata o erro conforme necessário
        }

        System.out.print("CPF: ");
        String cpf = leitor.nextLine();

        System.out.print("Gênero (M/F): ");
        char genero = ' ';
        if (leitor.hasNextLine()) {
            genero = leitor.nextLine().charAt(0);
        }

        int id = ++idCounter;
        pessoa.add(new Cliente(idade, nome, cpf, genero, id));

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Nome: "+ nome+" Id: " + id);
    }

    public static void pesquisarId(int id, Scanner leitor) {
        boolean encontrado = false;

        while (!encontrado) {
            for (Cliente pessoa : Cliente.pessoa) {
                if (id == getId()) {
                    System.out.println("Nome do cliente: " + pessoa.nome);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Cliente não encontrado!");
                System.out.println("Deseja tentar novamente? Digite 's' para sim ou qualquer outra coisa para sair:");
                String resposta = leitor.next();
                if (!resposta.equalsIgnoreCase("s")) {
                    System.out.println("Operação cancelada pelo usuário.");
                    break;
                }
                System.out.println("Por favor, insira um novo ID:");
                id = leitor.nextInt();
            }
        }
    }

public static void cliente() {
    Scanner leitor = new Scanner(System.in);
        while (true){
        System.out.println("*********************");
        System.out.println("*****LOUUCADORA******");
        System.out.println("*********************");
        System.out.println("1 - Cadastrar Cliente");
        System.out.println("2 - Alugar Filme/Série");
        System.out.println("3 - Devolver Filme/Série");
        System.out.println("4 - Comprar Filme");
        System.out.println("5 - Comprar Série");
        System.out.println("0 - Retornar ao Menu Anterior");
        System.out.println("*********************");
        int opcao = Integer.parseInt(leitor.nextLine());
        switch (opcao) {
            case 1:
                Cliente.cadastrarCliente(leitor);
                break;
            case 2:
                Filme.lerArquivo(leitor,Filme.filmes);
                Series.lerArquivo(leitor,Series.serie);
                Alugar.alugar(leitor);
                break;
            case 3:
                Filme.lerArquivo(leitor,Filme.filmes);
                Series.lerArquivo(leitor,Series.serie);
                Devolver.devolver(leitor);
                break;
            case 4:
                Filme.lerArquivo(leitor,Filme.filmes);
                Comprar.menuCompraFilmes(leitor);
                break;
            case 5:
                Series.lerArquivo(leitor,Series.serie);
                Comprar.menuCompraS(leitor);
                break;
            case 0:
                return;
            default:
                break;
        }
    }
}

}
