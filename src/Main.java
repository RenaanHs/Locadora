import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
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
                case 1:
                    Cliente.cliente();
                    break;
                case 2:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Filme.catalogoF(leitor);
                    break;
                case 3:
                    Series.lerArquivo(leitor,Series.serie);
                    Series.catalogoS(leitor);
                    break;
                case 4:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Filme.cadastrarFilme(leitor);
                    break;
                case 5:
                    Series.lerArquivo(leitor,Series.serie);
                    Series.cadastrarSerie(leitor);
                    break;
                case 6:
                    Funcionario.ListarFuncionarios(leitor);
                    break;
                default:
                    break;
            }
        }
    }
}
