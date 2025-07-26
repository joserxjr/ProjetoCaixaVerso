import java.util.Objects;

public class ContaCorrente extends Conta {
    private static Double limiteAprovado;
    private Double limite;

    public ContaCorrente(String nome, Double limite) {
        super(nome);
        this.limite = limite;
    }

    public static Double getLimiteAprovado() {
        return limiteAprovado;
    }

    public Double getLimite() {
        return limite;
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

        setSaldo(getSaldo() + valor);
        double saldoAtual = getSaldo();
        double novoLimite = limite + valor;
        if (saldoAtual + limite >= limiteAprovado) {
            limite = limiteAprovado;
        } else {
            limite = novoLimite;
        }
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");

    }

    @Override
    public void sacar(double valor){
        double saldoTotal = getSaldo() + limite;
        if (valor > 0 && valor <= getSaldo()) {
            setSaldo(getSaldo() - valor);
            System.out.println("Saque realizado com sucesso! ");
        } else if (valor > 0 && valor <= saldoTotal) {
            setSaldo(getSaldo()-valor);
            limite =  limite - (valor - getSaldo());
        }else {
            System.out.println("Valor de saque inválido ou conta não possui saldo para operação. ");
        }

    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "nome='" + getNome() + '\'' +
                ", numConta=" + getNumConta() +
                ", saldo=" + getSaldo() +
                ", limite=" + limite +
                '}';
    }



}





