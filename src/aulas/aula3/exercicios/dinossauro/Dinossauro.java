package aulas.aula3.exercicios.dinossauro;

public class Dinossauro {
    int energia;
    double velocidade;
    double temperatura;
    boolean humor;

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public boolean isHumor() {
        return humor;
    }

    public void setHumor(boolean humor) {
        this.humor = humor;
    }

    public void pular(){
        this.diminuirEnergia();
        this.mudarHumor(true);
    }

    public void correr(){
        this.diminuirEnergia();
        this.mudarHumor(true);
    }

    public void comer(){
        this.aumentarEnergia();
        mudarHumor(true);
    }

    public void atirar(){
        this.diminuirEnergia();
        this.mudarHumor(true);
    }

    public void tomarSol(){
        this.aumentarVelocidade();
        this.mudarHumor(true);
    }

    public void ficarNaSombra(){
        this.aumentarEnergia();
        this.mudarHumor(false);
    }

    //

    private void aumentarVelocidade(){
        this.diminuirEnergia();
    }

    private void aumentarEnergia(){}

    private void mudarHumor(boolean humor){}

    private void diminuirEnergia(){}

}
