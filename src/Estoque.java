import java.util.ArrayList;
import java.util.List;

public class Estoque {

    // Método para verificar a disponibilidade de um filme
    public static boolean verificarDisponibilidade(String titulo) {
        for (Filme filme : Filme.filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo) && filme.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }

    // Método para listar todos os filmes disponíveis no estoque
    public static void exibirCatalogoCompleto() {
        for (Filme filme : Filme.filmes) {
            System.out.println("Título: " + filme.titulo + ", Categoria: " + filme.categoria +
                               ", Classificação Indicativa: " + filme.classIndicativa + ", Status: " + filme.status);
        }
    }
}
