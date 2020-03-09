package aulas.aula3.exercicios.aluno;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        GestaoAlunos gestao = new GestaoAlunos();
        String opt;
        do {
            opt = JOptionPane.showInputDialog("Digite a letra em destaque para acessar a opção desejada\n" +
                    "(C)riar\n(E)xibir\n(R)emover\n(A)tualizar\n(S)air");
            switch (opt.toUpperCase()) {
                case "C":
                    int indice = Integer.parseInt(JOptionPane.showInputDialog("Informe em qual índice deseja criar o aluno"));
                    gestao.criar(indice);
                    break;
                case "E":
                    gestao.exibir(JOptionPane.showInputDialog("Digite o RA"));
                    break;
                case "R":
                    gestao.excluir(JOptionPane.showInputDialog("Digite o RA"));
                    break;
                case "A":
                    gestao.atualizar(JOptionPane.showInputDialog("Digite o RA do aluno"));
                    break;
                case "S":
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opção inválida","",JOptionPane.ERROR_MESSAGE);
                    break;
            }
        } while (!opt.equalsIgnoreCase("s"));
    }
}
