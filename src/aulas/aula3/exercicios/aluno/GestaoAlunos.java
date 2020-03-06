package aulas.aula3.exercicios.aluno;

import aulas.aula2.exemplo.A;

import java.time.LocalDate;
import java.util.*;

public class GestaoAlunos {

    private int indice;
    private List<Aluno> alunos = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void criar(Long id, String nome, String ra, int year, int month, int day) {
        Aluno aluno = new Aluno(id, nome, ra, LocalDate.of(year, month, day));
        alunos.add(indice, aluno);
    }
/*
    private void subMenuAtualizar(String ra){
        int opt = 0;
        do {
            System.out.println("Digite a letra em destaque para acessar a opção desejada" +
                    "[1]Para atualizar o nome" +
                    "[2]Para atualizar a data de nascimento" +
                    "[9]Para voltar ao menu anterior");
            opt = sc.nextInt();
            switch (opt){
            case 1: atualizarNome();
                    break;
            case 2: atualizarNascimento();
                    break;
            case 9: break;
            default:
                System.out.println("Opção inválida");
            }
        }while(opt != 9);

    }*/
//TODO depois fazer essa paradinha

    public void atualizar() {
        System.out.print("Digite o RA para buscar o aluno: ");
        String ra = sc.nextLine();
        Aluno filtrado = alunos.stream()
                .filter(aluno -> aluno.getRa().equals(ra))
                .findFirst()
                .orElse(null);

        if (filtrado != null) {
            System.out.println("informe o nome do Aluno: ");
            String nome = sc.nextLine();
            System.out.println("Informe o dia do nascimento");
            int dia = sc.nextInt();
            System.out.println("Informe o mês do nascimento");
            int mes = sc.nextInt();
            System.out.println("Informe o ano do nascimento");
            int ano = sc.nextInt();
            LocalDate dataNasc = LocalDate.of(ano, mes, dia);
            filtrado.setNascimento(dataNasc);
            filtrado.setNome(nome);
        }
        System.out.println(filtrado != null ? "Usuário atualizado" : "Usuário não encontrado");
    }

    public void excluir(String ra) {
        if (!alunos.removeIf(aluno -> aluno.getRa().equals(ra))) {
            System.out.println("Não foi encontrado aluno com RA: " + ra);
        } else {
            alunos.removeIf(aluno -> aluno.getRa().equals(ra));
            System.out.println("Aluno removido");
        }
    }

    public void exibir(String ra) {
        Aluno alunoFiltrado = alunos.stream()
                .filter(aluno -> ra.equals(aluno.getRa()))
                .findAny()
                .orElse(null);
        if (alunoFiltrado != null) {
            alunoFiltrado.exibir();
        } else {
            System.out.println("Aluno nao encontrado");
        }
    }

    public void menu() {
    }
}
