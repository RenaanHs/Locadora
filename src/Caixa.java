public class Caixa extends Funcionario{
    public Caixa(int idade, String nome, String cpf, char genero, String cargo, float salario) {
        super(idade, nome, cpf, genero, cargo, salario);
    }

    @Override
    public void realizarAcao() {
        System.out.println("Caixa está processando pagamento...");
    }
}
