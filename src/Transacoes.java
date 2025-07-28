import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacoes {
    private Integer numConta;
    private Double valor;
    private LocalDateTime dataHora;
    private TipoOperacao tipo;

    public Transacoes(Integer numConta, Double valor, LocalDateTime dataHora, TipoOperacao tipo) {
        this.numConta = numConta;
        this.valor = valor;
        this.dataHora = dataHora;
        this.tipo = tipo;
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
                ", valor=" + valor +
                ", tipo=" + tipo +
                ", dataHora=" + dataHora.format(fmt) +
                '}';
    }
}
