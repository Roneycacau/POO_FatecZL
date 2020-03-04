package aulas.aula3.exercicios.aluno;

import aulas.aula2.exemplo.A;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GestaoAlunos {

    private int indice;
    private List<Aluno> alunos = new ArrayList<>();

    public void criar(int indice, Long id, String nome, String ra, int day, int month, int year) {
        Aluno aluno = new Aluno(id, nome, ra, LocalDate.of(day, month, year));
        alunos.add(indice, aluno);
    }

    public void atualizar() {
    }

    public void excluir(String ra) {
        Optional<Aluno> aluno = Optional.ofNullable(alunos.stream()
                .filter(a -> a.getRa().equals(ra))
                .forEach(aluno.get().);


    }

    public void exibir(String ra) {
        Optional<Aluno> aluno = Optional.ofNullable(alunos.stream()
                .filter(a -> a.getRa().equals(ra))
                .forEach(Aluno::exibir);
    }

    public void menu() {
    }
}
