package aulas.aula2.exercicio;

import java.util.ArrayList;
import java.util.List;

public class A_OutOfMemoryError {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<Integer>();
        while (true) {
            lista.add(new Integer(0));
        }
    }
}
