package aulas.exerciciosEntregar.crudaluno;

import java.util.ArrayList;
import java.util.List;

public class AlunoControl {

    private List<Aluno> alunos = new ArrayList<>();

    public void adicionar(Aluno a){
        alunos.add(a);
        System.out.println("alunos adicionados" + alunos.size());
    }
    public Aluno pesquisar(String nome){
        for (Aluno aluno : alunos) {
            if(aluno.getNome().equalsIgnoreCase(nome)){
                return aluno;
            }
        }
        return null;
    }

}
