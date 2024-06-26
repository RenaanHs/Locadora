import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cliente extends Pessoa {
    private int id;
    private static int idCounter = 0;

    public Cliente(int idade, String nome, String cpf, char genero, int id) {
        super(idade, nome, cpf, genero);
        this.id = id;
    }

    public int getId() {
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
            return;
        }

        System.out.print("CPF: ");
        String cpf = leitor.nextLine();

        System.out.print("Gênero (M/F): ");
        char genero = ' ';
        if (leitor.hasNextLine()) {
            genero = leitor.nextLine().charAt(0);
        }

        int id = ++idCounter;
        Cliente novoCliente = new Cliente(idade, nome, cpf, genero, id);
        pessoa.add(novoCliente);

        System.out.println("Cliente cadastrado com sucesso!");
        System.out.println("Nome: " + nome + " Id: " + id);

        salvarArquivo();
    }

    public static boolean pesquisarId(int id, Scanner leitor) {
        boolean encontrado = false;

        while (!encontrado) {
            for (Cliente cliente : Cliente.pessoa) {
                if (id == cliente.getId()) {
                    System.out.println("Nome do cliente: " + cliente.nome);
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
        return encontrado;
    }

    public static void lerArquivo() throws FileNotFoundException {
        File arquivo = new File("C:\\Users\\silvi\\Downloads\\Locadora-main\\Locadora-main\\src\\Cliente.txt");
        Scanner scanner = new Scanner(arquivo);

        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine();
            String[] partes = linha.split(",");

            if (partes.length >= 5) {
                int idade = Integer.parseInt(partes[0].trim());
                String nome = partes[1].trim();
                String cpf = partes[2].trim();
                char genero = partes[3].trim().charAt(0);
                int id = Integer.parseInt(partes[4].trim());

                Cliente cliente = new Cliente(idade, nome, cpf, genero, id);
                pessoa.add(cliente);
                idCounter = Math.max(idCounter, id);
            }
        }
        scanner.close();
    }

    public static void salvarArquivo() {
        try {
            FileWriter writer = new FileWriter("C:\\Users\\silvi\\Downloads\\Locadora-main\\Locadora-main\\src\\Cliente.txt");
            for (Cliente cliente : pessoa) {
                writer.write(cliente.idade + "," + cliente.nome + "," + cliente.cpf + "," + cliente.genero + "," + cliente.getId() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo: " + e.getMessage());
        }
    }

    public static void listarClientes() {
        if (pessoa.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Cliente cliente : pessoa) {
                System.out.println("ID: " + cliente.getId() + ", Nome: " + cliente.nome + ", Idade: " + cliente.idade + ", CPF: " + cliente.cpf + ", Gênero: " + cliente.genero);
            }
        }
    }

    public static void cliente(Scanner leitor) {
        try {
            lerArquivo();
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado: " + e.getMessage());
        }

        while (true) {
            System.out.println("*********************");
            System.out.println("*****LOUUCADORA******");
            System.out.println("*********************");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Alugar Filme/Série");
            System.out.println("3 - Devolver Filme/Série");
            System.out.println("4 - Comprar Filme");
            System.out.println("5 - Comprar Série");
            System.out.println("6 - Listar Clientes");
            System.out.println("0 - Retornar ao Menu Anterior");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine());
            switch (opcao) {
                case 1:
                    Cliente.cadastrarCliente(leitor);
                    break;
                case 2:
                    Filme.lerArquivo(Filme.filmes);
                    Series.lerArquivo(Series.serie);
                    Alugar.alugar(leitor);
                    break;
                case 3:
                    Filme.lerArquivo(Filme.filmes);
                    Series.lerArquivo(Series.serie);
                    Devolver.devolver(leitor);
                    break;
                case 4:
                    System.out.println("Informe o ID do cliente:");
                    int idComprarF = Integer.parseInt(leitor.nextLine());
                    if (Cliente.pesquisarId(idComprarF, leitor)) {
                        Filme.lerArquivo(Filme.filmes);
                        Estoque.carregarFilmes(Filme.filmes);
                        Comprar.menuCompraFilmes(leitor);
                    } else {
                        System.out.println("ID do cliente não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Informe o ID do cliente:");
                    int idComprarS = Integer.parseInt(leitor.nextLine());
                    if (Cliente.pesquisarId(idComprarS, leitor)) {
                        Series.lerArquivo(Series.serie);
                        Estoque.carregarSeries(Series.serie);
                        Comprar.menuCompraS(leitor);
                    } else {
                        System.out.println("ID do cliente não encontrado.");
                    }
                    break;
                case 6:
                    Cliente.listarClientes();
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
}



