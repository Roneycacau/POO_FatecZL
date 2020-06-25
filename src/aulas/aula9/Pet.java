package aulas.aula9;

import java.time.LocalDate;

public class Pet {
    private long id;
    private String nome;
    private String raca;
    private double peso;
    private LocalDate nascimento;

    public Pet(long id, String nome, String raca, double peso, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.peso = peso;
        this.nascimento = nascimento;
    }

    public Pet() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }
}
