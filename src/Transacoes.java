import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transacoes {
    private Integer numConta;
    private Double valor;
    private LocalDateTime dataHora;

    public Transacoes(Integer numConta, Double valor, LocalDateTime dataHora) {
        this.numConta = numConta;
        this.valor = valor;
        this.dataHora = dataHora;
    }



    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Transacoes{" +
                "numConta=" + numConta +
                ", valor=" + valor +
                ", dataHora=" + dataHora.format(fmt) +
                '}';
    }
}
