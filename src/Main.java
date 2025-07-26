import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        int opcao;
        List<Conta> conta = new ArrayList<>();
        List<Transacoes> transacoes = new ArrayList<>();

        do {
            System.out.println("-------------------------------");
            System.out.println("          Bem vindo!           ");
            System.out.println("-------------------------------");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1 - Cadastrar conta corrente: ");
            System.out.println("2 - Cadastrar conta poupança: ");
            System.out.println("3 - Exibir contas: ");
            System.out.println("4 - Depositar: ");
            System.out.println("5 - Sacar: ");
            System.out.println("0 - Sair. ");
            System.out.println("-------------------------------");
            opcao = sc.nextInt();
            System.out.println();
            sc.nextLine();

                switch (opcao) {
                    case 0:
                        System.out.println("Saindo do sistema.");
                        break;
                    case 1:
                        System.out.print("Digite o nome do titular: ");
                        String nome = sc.nextLine();
                        System.out.print("Digite o valor da renda: ");
                        double renda = sc.nextDouble();
                        ContaCorrente.limiteAprovado(renda);
                        Double limiteImplantar = ContaCorrente.getLimiteAprovado();
                        ContaCorrente novaCC = new ContaCorrente(nome,limiteImplantar);
                        conta.add(novaCC);
                        System.out.println("Dados incluídos com sucesso. ");
                        System.out.println(novaCC);
                        break;
                    case 2:
                        System.out.print("Digite o nome do titular: ");
                        nome = sc.nextLine();
                        ContaPoupanca novaCp = new ContaPoupanca(nome);
                        conta.add(novaCp);
                        System.out.println("Dados incluídos com sucesso. ");
                        System.out.println(novaCp);
                        break;
                    case 3:
                        System.out.println("Contas cadastrada: ");
                        for (Conta dado : conta){
                            System.out.println(dado);
                        }
                        break;
                    case 4:
                        System.out.println("Digite uma conta já cadastrada para deposito: ");
                        int contaDeposito = sc.nextInt();
                        Conta contaEncontrada = conta.stream()
                                .filter(c -> c.getNumConta() == contaDeposito)
                                .findFirst()
                                .orElse(null);
                        if (contaEncontrada != null){
                            System.out.print("Digite o valor do deposito: ");
                            double valorDeposito = sc.nextDouble();
                            contaEncontrada.depositar(valorDeposito);
                            Transacoes operacoes = new Transacoes(contaDeposito,valorDeposito, LocalDateTime.now());
                            transacoes.add(operacoes);
                            System.out.println(operacoes);
                        }else{
                            System.out.println("Conta não encontrada. ");
                        }
                        System.out.println(contaEncontrada);
                        break;
                    case 5:
                        System.out.println("Digite uma conta já cadastrada para saque: ");
                        int contaSaque = sc.nextInt();
                        Conta contaEncontrada2 = conta.stream()
                                .filter(c -> c.getNumConta() == contaSaque)
                                .findFirst()
                                .orElse(null);
                        if (contaEncontrada2 != null){
                            System.out.println("Digite um valor de saque:");
                            double valorSaque =sc.nextDouble();
                            if (contaEncontrada2 instanceof ContaCorrente){
                                contaEncontrada2.sacar(valorSaque);
                            } else if (contaEncontrada2 instanceof ContaPoupanca) {
                                contaEncontrada2.sacar(valorSaque);
                            }
                            Transacoes operacoes = new Transacoes(contaSaque,valorSaque,LocalDateTime.now());
                            transacoes.add(operacoes);
                            System.out.println(operacoes);
                        } else {
                            System.out.println("Conta não encontrada. ");
                        }
                        System.out.println(contaEncontrada2);
                        break;
                    default:
                        System.out.println("Opção inválida, repita. ");
                }

        } while (opcao != 0);

        sc.close();

    }
}