package aulas.collections.exercícios.caixadepagamento;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MetodoDePagamento {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        Map<String, String> pagamento = new HashMap<>();

        System.out.println("informe o valor do pagamento: ");
        double valor = s.nextDouble();

        System.out.println("Informe o método de pagamento(Dinheiro/Crédito/Débito/Cheque/Deposito): ");
        String metodo = s.next();

        pagamento.put("Dinheiro", "Pago R$ " + String.format("%.2f", valor) + " em dinheiro");
        pagamento.put("Crédito", "Foi utilizado R$ " + String.format("%.2f", valor) + " do limite do cartão de crédito");
        pagamento.put("Débito", "Pago R$ " + String.format("%.2f", valor) + " em cartão de débito");
        pagamento.put("Cheque", "Pago R$ " + String.format("%.2f", valor) + " em cheque");
        pagamento.put("Depósito", "Pago R$ " + String.format("%.2f", valor) + " em deposito bancario");

        System.out.println(pagamento.get(metodo));
    }
}
