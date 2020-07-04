package aulas.exerciciosEntregar.crudaluno;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AlunoControl {

//    private List<Aluno> alunos = new ArrayList<>();
    private ObservableList<Aluno> alunos = FXCollections.observableArrayList();

    public ObservableList<Aluno> getAlunos() {
        return alunos;
    }

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
