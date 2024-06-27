import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Series.lerArquivo(Series.serie);
        Filme.lerArquivo(Filme.filmes);
        while (true){
            System.out.println("*********************");
            System.out.println("*****LOUUCADORA******");
            System.out.println("*********************");
            System.out.println("1 - Clientes");
            System.out.println("2 - Catalogo Filmes");
            System.out.println("3 - Catalogo Séries");
            System.out.println("4 - Cadastrar Filme");
            System.out.println("5 - Cadastrar Série");
            System.out.println("6 - Funcionários");
            System.out.println("0 - Sair");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine());
            switch (opcao) {
                case 0:
                    System.out.println("Saindo do programa...");
                    leitor.close();
                    return;
                case 1:
                    Cliente.cliente(leitor);
                    break;
                case 2:
                    Filme.catalogoF(leitor);
                    Estoque.carregarFilmes(Filme.filmes);
                    break;

                case 3:
                    Series.catalogoS(leitor);
                    Estoque.carregarSeries(Series.serie);
                    break;
                case 4:
                    Filme.cadastrarFilme(leitor);
                    Estoque.carregarFilmes(Filme.filmes);
                    break;
                case 5:
                    Series.cadastrarSerie(leitor);
                    Estoque.carregarSeries(Series.serie);
                    break;
                case 6:
                    Funcionario.ListarFuncionarios();
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}
