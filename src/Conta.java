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

    protected void atualizarSaldo(double valor) {
        this.saldo += valor;
    }

    protected void depositar(double valor) {
    }

    protected void sacar(double valor) {
    }



}
