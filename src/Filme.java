import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Filme {

    String titulo;
     int classIndicativa;
    Categoria categoria;
    Status status;


    static List<Filme> filmes = new ArrayList<>();
    public static void lerArquivo() {
        try {
            File arquivo = new File("film.txt");
            Scanner scanner = new Scanner(arquivo);

            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String[] partes = linha.split(" ");

                if (partes.length >= 4) {
                    String titulo = partes[0];
                    int classIndicativa = Integer.parseInt(partes[1]);
                    String categoria = partes[2];
                    String status = partes[3];
                    filmes.add(new Filme(titulo,classIndicativa, Categoria.valueOf(categoria), Status.valueOf(status)));
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: filmes.txt");
            e.printStackTrace();
        }
    }
    public Filme(String titulo, int classInficativa, Categoria categoria, Status status) {
        this.titulo = titulo;
        this.classIndicativa = classIndicativa;
        this.categoria = categoria;
        this.status = status;

    }


    public static void catalogo(Scanner leitor){
        System.out.println("**********************");
        System.out.println("***Catalogo Filmes***");
        System.out.println("1 - Todos");
        System.out.println("2 - Categoria");
        int opcao = Integer.parseInt(leitor.nextLine());

switch (opcao){
    case 1:
     for (Filme f : filmes){
         System.out.println("Titulo : "+ f.titulo+"Categoria: "+f.categoria+"Status: "+f.status);
     }
     break;
    case 2:
        System.out.println("Digite a categoria:");
        String categoriaDigitada = leitor.nextLine();
        for (Filme f : filmes) {
            if (f.categoria.toString().equalsIgnoreCase(categoriaDigitada)) {
                System.out.println("Titulo: " + f.titulo + ", Categoria: " + f.categoria + ", Status: " + f.status);
            }
        }
        break;

}

    }

}
