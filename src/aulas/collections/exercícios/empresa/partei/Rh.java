package aulas.collections.exercícios.empresa.partei;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rh {
    private List<Funcionario> funcionarios = new ArrayList<>();

    public List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public double valorBonus(Funcionario funcionario) {
        int faltas = funcionario.getFaltasNoAno();
        double salario = funcionario.getSalario() ;

        return calculaBonus(faltas, salario);
    }

    private double calculaBonus(int faltas, double salario) {
        if (faltas < 2) {
            return salario * 0.3;
        }
        if (faltas <= 4) {
            return salario * 0.15;
        }
        return salario * 0.05;
    }


    public void mostarBonusTodosFuncionarios() {
        funcionarios.forEach(f -> System.out.println(f.getNome() + " bonus: " + valorBonus(f)));
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
}

