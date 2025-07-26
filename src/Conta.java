import java.time.LocalDateTime;

abstract class  Conta {

    private String nome;
    private static Integer numConta = 0;
    private Double saldo;
    private LocalDateTime dataHora;

    public Conta(String nome) {
        this.nome = nome;
        this.numConta += 1;
        this.saldo = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    protected void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
    dataHora = LocalDateTime.now();
    }

    public void sacar(double valor) {
    dataHora = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", numConta=" + numConta +
                ", saldo=" + saldo +
                '}';
    }
}
