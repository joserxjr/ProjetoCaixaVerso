import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacoes {
    private Integer numConta;
    private Double valor;
    private LocalDateTime dataHora;
    private TipoOperacao tipo;
    private Double saldo;

    public Transacoes(Integer numConta, Double valor, LocalDateTime dataHora, TipoOperacao tipo, Double saldo) {
        this.numConta = numConta;
        this.valor = valor;
        this.dataHora = dataHora;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Integer getNumConta() {
        return numConta;
    }

    public Double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Transacoes{" +
                "numConta=" + numConta +
                ", valor=" + String.format("%.2f", valor) +
                ", tipo=" + tipo +
                ", saldo=" + String.format("%.2f", saldo) +
                ", dataHora=" + dataHora.format(fmt) +
                '}';
    }
}
