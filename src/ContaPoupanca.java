public class ContaPoupanca extends Conta{
    public ContaPoupanca(String nome, Integer numConta) {
        super(nome, numConta);
    }

    @Override
    public void depositar(double valor) {
        if (valor > 0) {
            atualizarSaldo(valor);
            System.out.println("Depósito de R$" + String.format("%.2f", valor)+ " realizado com sucesso.");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    @Override
    public void sacar(double valor) {
        if (valor > 0 && valor <= getSaldo()) {
            atualizarSaldo(-valor);
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
        } else {
            System.out.println("Saque não autorizado. Verifique o valor e o saldo disponível.");
        }
    }

    @Override
    public String toString() {
        return "ContaPoupança{" +
                "nome='" + getNome() + '\'' +
                ", numConta=" + getNumConta() +
                ", saldo=" + String.format("%.2f",getSaldo() ) +
                '}';
    }
}
