public class Estoque {
    public static boolean verificarDisponibilidade(String titulo) {
        for (Filme filme : Filme.filmes) {
            if (filme.titulo.equalsIgnoreCase(titulo) && filme.status == Status.Disponivel) {
                return true;
            }
        }
        return false;
    }
}
