import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
    static int valor = 15;
    static int idCounter = 0;
    static List<Cliente> pessoa = new ArrayList<>();
    static List<Series> serie = new ArrayList<>();
    static List<Filme> filmes = new ArrayList<>();

public static void catalogo(Scanner leitor){
    Filme.lerArquivo(leitor,filmes);
    Series.lerArquivo(leitor,serie);
    System.out.println("*********************");
    System.out.println("----Catalogo----");
    System.out.println("1 - Filme");
    System.out.println("2 - Series");
    int opcao = Integer.parseInt(leitor.nextLine());
    switch (opcao) {

        case 1:
            Filme.catalogo(leitor, filmes);
            break;
        case 2:
            Series.catalogo(leitor, serie);
            break;
        case 3:
            default:
            break;
    }
}
    public static void opcoes(Scanner leitor){
        System.out.println("*********************");
        System.out.println("----Opçoes----");
        System.out.println("1 - Alugar");
        System.out.println("2 - Devolver");
        int opcao = Integer.parseInt(leitor.nextLine());
        switch (opcao) {

            case 1:
            alugar(leitor);
                break;
            case 2:

                break;
            case 3:
            default:
                break;
        }
    }

    public static void cadastro(Scanner leitor) {
        System.out.println("*********************");
        System.out.println("----Cadastro----");
        System.out.println("1 - Filme");
        System.out.println("2 - Serie");
        System.out.println("3 - Cliente");
        int opcao = Integer.parseInt(leitor.nextLine());
        switch (opcao) {

            case 1:
                cadastrarFilme(leitor);
                break;
            case 2:
                cadastrarSerie(leitor);
                break;
            case 3:
                cadastrarCliente(leitor);
        }
    }

    private static void cadastrarSerie(Scanner leitor) {
        System.out.println("Digite o titulo da serie");
        String titulo = leitor.nextLine();
        System.out.println("Qual a classificação indicativa da serie?");
        int classificacao = Integer.parseInt(leitor.nextLine());
        System.out.println("Digite o genero da serie");
        String generos = leitor.nextLine();
        System.out.println("Quantas temporadas?");
        int temp = Integer.parseInt(leitor.nextLine());

        serie.add(new Series(titulo, classificacao,  Categoria.valueOf(generos), Status.Disponivel, temp));
    }


    private static void cadastrarFilme(Scanner leitor) {
        System.out.println("Digite o titulo do filme");
        String titulo = leitor.nextLine();
        System.out.println("Qual a classificação indicativa do filme?");
        int classificacao = Integer.parseInt(leitor.nextLine());
        System.out.println("Digite o genero do filme");
        String generof = leitor.nextLine();

        filmes.add(new Filme(titulo, classificacao, Categoria.valueOf(generof), Status.Disponivel));
    }

    public static void cadastrarCliente(Scanner leitor) {
        System.out.print("Nome: ");
        String nome = leitor.nextLine();
        System.out.print("idade: ");
        int idade = Integer.parseInt(leitor.nextLine());
        System.out.print("Cpf: ");
        String cpf = leitor.nextLine();
        System.out.print("Genero\nM- Masculino\nF- Feminino\n :");
        char genero = leitor.next().charAt(0);

        int id = ++idCounter;
        pessoa.add(new Cliente(idade, nome, cpf, genero, idCounter));

        System.out.println("Cliente Cadastrado com sucesso!!");

    }
    public static void alugar(Scanner leitor) {
        System.out.println("*********************");
        System.out.println("----Alugar----");
        System.out.print("Nome do cliente: ");
        String nomeCliente = leitor.nextLine();
        System.out.print("ID do cliente: ");
        int idCliente = Integer.parseInt(leitor.nextLine());
        System.out.print("Nome do filme ou série: ");
        String nomeItem = leitor.nextLine();
        
        boolean encontrado = false;
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(nomeItem) && filme.getStatus() == Status.Disponivel) {
                Alugar alugar = new Alugar();
                alugar.alugar(filme);
                System.out.println("Aluguel realizado com sucesso:");
                System.out.println("Cliente: " + nomeCliente);
                System.out.println("Filme: " + filme.getTitulo());
                System.out.println("Tempo de aluguel: 7 dias");
                System.out.println("Valor: R$ "+ valor);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            for (Series serie : serie) {
                if (serie.getTitulo().equalsIgnoreCase(nomeItem) && serie.getStatus() == Status.Disponivel) {
                    Alugar alugar = new Alugar();
                    alugar.alugarSerie(serie);
                    System.out.println("Aluguel realizado com sucesso:");
                    System.out.println("Cliente: " + nomeCliente);
                    System.out.println("Série: " + serie.getTitulo());
                    System.out.println("Tempo de aluguel: 7 dias");
                    System.out.println("Valor: R$ "+ valor); 
                    encontrado = true;
                    break;
                }
            }
        }

        if (!encontrado) {
            System.out.println("Item não encontrado ou não disponível para aluguel.");
        }
    }
}
