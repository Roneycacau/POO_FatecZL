package aulas.collections.exercícios.dicionario;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestaDicionario {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Map<String, Palavra> palavras = new HashMap();

        Dicionario dicionario = new Dicionario();

        String busca;

        do {
            System.out.println("Dicionario maroto\nPara sair digite 'fechar dicionário'\nDigite a palavra que deseja saber a definição: ");
            busca = s.nextLine();
            Palavra buscada = new Palavra(busca, "");
            if (dicionario.palavraExiste(buscada)) {
                System.out.println(palavras.get(busca));
                System.out.println("=====================");
                System.out.println();
                System.out.println();
            } else {
                System.out.println("Palavra buscada não foi encontrada, por favor entre com a definição");
                String definicao = s.nextLine();
                buscada.setDefinicao(definicao);
                dicionario.adiciona(buscada);
                palavras.put(busca, buscada);
                System.out.println("Dicionário atualizado com sucesso");
                System.out.println("=====================");
                System.out.println();
                System.out.println();
            }
        } while (!busca.equalsIgnoreCase("9"));

    }
}
