public class Devolver {
    public void devolver(Filme f) {
        f.setStatus(Status.Disponivel);
        System.out.println("Filme " + f.getTitulo() + " devolvido com sucesso.");
    }

    public void devolverSerie(Series s) {
        s.setStatus(Status.Disponivel);
        System.out.println("Série " + s.getTitulo() + " devolvida com sucesso.");
    }
}
