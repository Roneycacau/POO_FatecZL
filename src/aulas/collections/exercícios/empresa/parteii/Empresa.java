package aulas.collections.exercícios.empresa.parteii;

import java.util.Scanner;

public class Empresa {
    private Rh rh;

    public Empresa() {
        this.rh = new Rh();
    }

    public Funcionario contrataFuncionario(){
        Scanner s = new Scanner(System.in);

        System.out.println("Entre com os dados do novo funcionário");

        System.out.println("Digite o nome completo");
        String nome = s.nextLine();

        System.out.println("Digite a matrícula do funcionário");
        String matricula = s.nextLine();

        System.out.println("Digite a quantidade de faltas no ultimo ano");
        int faltas = s.nextInt();
        float nota;
        do{
            System.out.println("Digite a nota da ultima avaliação (de 0 a 10 podendo ter números quebrados");
            nota = s.nextFloat();
        }while (nota <0 || nota > 10);

        Funcionario f = new Funcionario();
        f.setNome(nome);
        f.setFaltasNoAno(faltas);
        f.setUltimaNotaAvaliacao(nota);
        System.out.println("CADASTRO FINALIZADO\n============================");
        return f;
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        for (int i = 0; i < 5; i++ ){
            empresa.rh.adicionarFuncionario(empresa.contrataFuncionario());
        }
        empresa.rh.mostarBonusTodosFuncionarios();
    }

}
