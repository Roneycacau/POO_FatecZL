package aulas.collections.exercícios.empresa.parteii;


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
        float nota = funcionario.getUltimaNotaAvaliacao();
        double salario = funcionario.getSalario() ;

        return calculaBonus(faltas, nota, salario);
    }

    private double calculaBonus(int faltas, float nota, double salario) {
        double bonusFalta = 0;
        double bonusNota = 0;
        if (faltas < 2) bonusFalta = 0.3;
        if (faltas <= 4) bonusFalta = 0.15;
        if (faltas > 4) bonusFalta = 0.05;

        if (nota < 5) bonusNota = 0.05;
        if (nota <= 7) bonusFalta = 0.15;
        if (nota > 7) bonusFalta = 0.3;
        return bonusFalta + bonusNota;
    }


    public void mostarBonusTodosFuncionarios() {
        funcionarios.forEach(f -> System.out.println(f.getNome() + "\nID: " + f.getId() + "\nbonus= " +  valorBonus(f)*100 + "%\n"));
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(Funcionario funcionario) {
        funcionarios.remove(funcionario);
    }
}

