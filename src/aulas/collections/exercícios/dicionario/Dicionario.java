package aulas.collections.exercícios.dicionario;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Dicionario {
    Set<Palavra> palavras = new HashSet<>();

    public Set<Palavra> getPalavras() {
        return Collections.unmodifiableSet(palavras);
    }

    public void adiciona(Palavra palavra) {
        palavras.add(palavra);
    }

    public boolean palavraExiste(Palavra palavra) {
        return this.palavras.contains(palavra);
    }

    @Override
    public String toString() {
        return "Dicionario{\n" + palavras.toString() + "\n" +
                "\n}";
    }

}
