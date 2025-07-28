import java.util.List;

public class Service {


    public static Conta buscarConta(List<Conta> contas, int numeroConta) {
        return contas.stream()
                .filter(c -> c.getNumConta() == numeroConta)
                .findFirst()
                .orElse(null);
    }

    public static Transacoes buscarTransacao(List<Transacoes> transacoes, int numeroConta){
        return transacoes.stream()
                .filter(c ->c.getNumConta() == numeroConta)
                .findFirst()
                .orElse(null);
    }


}
