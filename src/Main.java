import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        while (true){
            System.out.println("*********************");
            System.out.println("*****LOUUCADORA******");
            System.out.println("*********************");
            System.out.println("1 - Catalogo Filmes");
            System.out.println("2 - Catalogo Séries");
            System.out.println("3 - Alugar Filme/Série");
            System.out.println("4 - Devolver Filme/Série");
            System.out.println("5 - Comprar Filme");
            System.out.println("6 - Comprar Série");
            System.out.println("7 - Cadastrar Cliente");
            System.out.println("8 - Cadastrar Filme");
            System.out.println("9 - Cadastrar Série");
            System.out.println("0 - Listar Funcionários");
            System.out.println("*********************");
            int opcao = Integer.parseInt(leitor.nextLine());
            switch (opcao) {
                case 0:
                    break;
                case 1:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Filme.catalogoF(leitor);
                    break;
                case 2:
                    Series.lerArquivo(leitor,Series.serie);
                    Series.catalogoS(leitor);
                    break;
                case 3:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Series.lerArquivo(leitor,Series.serie);
                    Alugar.alugar(leitor);
                    break;
                case 4:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Series.lerArquivo(leitor,Series.serie);
                    Devolver.devolver(leitor);
                    break;
                case 5:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Comprar.menuCompraFilmes(leitor);
                    break;
                case 6:
                    Series.lerArquivo(leitor,Series.serie);
                    Comprar.menuCompraS(leitor);
                    break;
                case 7:
                    Cliente.cadastrarCliente(leitor);
                    break;
                case 8:
                    Filme.lerArquivo(leitor,Filme.filmes);
                    Filme.cadastrarFilme(leitor);
                    break;
                case 9:
                    Series.lerArquivo(leitor,Series.serie);
                    Series.cadastrarSerie(leitor);
                    break;
                case 0:
                    Funcionario.ListarFuncionarios(leitor);
                    break;
                default:
                    break;
            }
        }
    }
}