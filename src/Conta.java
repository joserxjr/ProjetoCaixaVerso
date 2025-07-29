import java.time.LocalDateTime;

abstract class  Conta {

    private String nome;
    private Integer numConta;
    private Double saldo;

    public Conta(String nome, Integer numConta) {
        this.nome = nome;
        this.numConta = numConta;
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

    protected void atualizarSaldo(double valor) {
        this.saldo += valor;
    }

    protected void depositar(double valor) {
    }

    protected void sacar(double valor) {
    }



}
