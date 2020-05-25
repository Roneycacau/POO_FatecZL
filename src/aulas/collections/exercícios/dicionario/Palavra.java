package aulas.collections.exercícios.dicionario;

import java.util.Objects;

public class Palavra{
    private String palavra;
    private String definicao;

    public Palavra(String palavra, String definicao) {
        this.palavra = palavra;
        this.definicao = definicao;
    }

    public void setDefinicao(String definicao) {
        this.definicao = definicao;
    }

    @Override
    public String toString() {
        return palavra.toUpperCase() +
                "{ definicao= " + definicao +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Palavra palavra1 = (Palavra) o;
        return palavra.equals(palavra1.palavra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palavra);
    }
}
