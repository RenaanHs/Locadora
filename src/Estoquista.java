public class Estoquista extends Funcionario{
    public Estoquista(int idade, String nome, String cpf, char genero, String cargo, float salario) {
        super(idade, nome, cpf, genero, cargo, salario);
    }

    @Override
    public void realizarAcao() {
        System.out.println("Estoquista está controlando estoque...");
    }
}
