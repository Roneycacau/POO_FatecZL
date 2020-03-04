package aulas.aula3.exercicios.aluno;

import java.time.LocalDate;

public class Aluno {

    private long id;
    private String nome;
    private String ra;
    private LocalDate nascimento;

    public Aluno(Long id, String nome, String ra, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.ra = ra;
        this.nascimento = nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getRa() {
        return ra;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void exibir(){
        System.out.println(
                "ID: " + this.getId() + "\n"
                "Nome: " + this.getNome() + "\n"
                "RA: " + this.getRa() + "\n"
                "Data de Nascimento: " + this.getNascimento() + "\n"
        );
    }
}
