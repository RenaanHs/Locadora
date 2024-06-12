import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Filme.lerArquivo();
        while (true){
            System.out.println("*********************");
            System.out.println("*****LOUUCADORA******");
            System.out.println("*********************");
            System.out.println("----Menu Principal----");
            System.out.println("1 - Cliente");
            System.out.println("2 - Catalogo");
            System.out.println("*********************");
int opcao = Integer.parseInt(leitor.nextLine());
switch (opcao) {

    case 1:
        Cliente.cadastrarCliente(leitor);
        break;
    case 2:
        Filme.catalogo(leitor);
        break;
   }
  }
 }
}
