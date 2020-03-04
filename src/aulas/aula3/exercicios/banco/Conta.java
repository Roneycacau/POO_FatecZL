package aulas.aula3.exercicios.banco;

import java.util.Date;

public class Conta {

    private double saldo;
    private String numero;
    private String senha;
    private Transacao[] historico;

    public Conta(String numero, String senha) {
        this.numero = numero;
        this.senha = senha;
    }

    public String getNumero() {
        return numero;
    }


    public String getSenha() {
        return senha;
    }


    public boolean efetuarSaque(double valor){
        return valor <= this.saldo? false:true;
    }
    public boolean efetuarDeposito(double valor){
        return false;
    }
    public boolean efetuarPagamento(String boleto, double valor){
        return valor <= this.saldo? false:true;
    }
    public Transacao[] extrato(Date inicio, Date fim){
        return new Transacao[0];
    }
}
