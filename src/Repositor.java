public class Repositor extends Funcionario{
    public Repositor(int idade, String nome, String cpf, char genero, String cargo, float salario) {
        super(idade, nome, cpf, genero, cargo, salario);
    }

    @Override
    public void realizarAcao() {
        System.out.println("Repositor está reponto estoque...");
    }
}
