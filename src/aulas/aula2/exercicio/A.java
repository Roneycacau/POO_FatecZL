package aulas.aula2.exercicio;

public class A {
    int a = 2;
    String x = "X";
    String y;

    public void fazAlgo(){
        int b = 4;
        String s = "S";
        outro();
    }
    public void outro() {
        int c = 5;
        String w = "W";
    }
    public static void main(String[] args) {
        A a = new A();
        a.fazAlgo();
    }
}
