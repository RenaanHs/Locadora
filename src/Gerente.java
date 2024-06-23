public class Gerente extends Funcionario{
    public Gerente(int idade, String nome, String cpf, char genero, String cargo, float salario) {
        super(idade, nome, cpf, genero, cargo, salario);
    }

    @Override
    public void realizarAcao() {
        System.out.println("Gerente está gerenciando operações...");
    }
}
