import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema {
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
        System.out.println("----Cadastro----");
        int opcao = Integer.parseInt(leitor.nextLine());
        switch (opcao) {

            case 1:

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

}
