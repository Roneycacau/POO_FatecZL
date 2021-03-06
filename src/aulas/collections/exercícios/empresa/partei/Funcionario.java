package aulas.collections.exercícios.empresa.partei;

public class Funcionario {
    private long id;
    private String nome;
    private String matricula;
    private double salario;
    private int faltasNoAno;
    private float ultimaNotaAvaliacao;
    private int qtdPremiosRecebidosAno;
    private boolean graduado;
    private String nomeFaculdade;
    private String nomeCurso;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getSalario() {
        return salario;
    }

    public int getFaltasNoAno() {
        return faltasNoAno;
    }

    public float getUltimaNotaAvaliacao() {
        return ultimaNotaAvaliacao;
    }

    public int getQtdPremiosRecebidosAno() {
        return qtdPremiosRecebidosAno;
    }

    public boolean isGraduado() {
        return graduado;
    }

    public String getNomeFaculdade() {
        return nomeFaculdade;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setUltimaNotaAvaliacao(float ultimaNotaAvaliacao) {
        this.ultimaNotaAvaliacao = ultimaNotaAvaliacao;
    }

    public void setGraduado(boolean graduado) {
        this.graduado = graduado;
    }

    public void setNomeFaculdade(String nomeFaculdade) {
        this.nomeFaculdade = nomeFaculdade;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public void adicionarFalta(){ this.faltasNoAno++; }

    public void adicionarPremio(){
        this.qtdPremiosRecebidosAno++;
    }
}
