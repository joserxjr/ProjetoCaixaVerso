
public class ContaCorrente extends Conta {
    private static Double limiteAprovado;
    private Double limiteDisponivel;
    private  Double limiteOriginal;

    public ContaCorrente(String nome, Double limiteAprovado) {
        super(nome);
        this.limiteAprovado = limiteAprovado;
        this.limiteDisponivel = limiteAprovado;
        this.limiteOriginal = limiteAprovado;
    }

    public static Double getLimiteAprovado() {
        return limiteAprovado;
    }



    public static void limiteAprovado(double renda){
        if (renda < 1000.00){
            limiteAprovado = 0.0;
        } else if (renda < 3000.00) {
            limiteAprovado = 1000.0;
        }else {
            limiteAprovado = 2000.0;
        }
    }


    @Override
    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito deve ser positivo.");
            return;
        }
        double saldoAnterior = getSaldo();
        if (saldoAnterior < 0) {
            if (valor >= limiteOriginal){
                limiteDisponivel = limiteOriginal;
                atualizarSaldo(valor);
            } else {
                limiteDisponivel += valor;
                atualizarSaldo(valor);
            }
        } else {
            atualizarSaldo(valor);
        }
        System.out.println("Deposito de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
    }

    @Override
    public void sacar(double valor){
            if (valor <= 0) {
                System.out.println("Valor de saque deve ser positivo.");
                return;
            }
            double saldoAtual = getSaldo();
            double totalDisponivel = saldoAtual + limiteDisponivel;
            if (valor > totalDisponivel) {
                System.out.println("Valor de saque inválido. Saldo + limite insuficientes.");
                return;
            }
            if (valor <= saldoAtual) {
                atualizarSaldo(-valor);
                System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
            } else {
                double valorDoLimite = valor - saldoAtual;
                atualizarSaldo(-valor);
                limiteDisponivel -= valorDoLimite;
            }
        }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nome=" + getNome() +
                ", numConta=" + getNumConta() +
                ", saldo=" + getSaldo() +
                ", limiteDisponivel=" + limiteDisponivel +
                ", limiteOriginal=" + limiteOriginal +
                '}';
    }
}





