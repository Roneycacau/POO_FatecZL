package aulas.aula2.exercicio;

public class A_StackOverFlow {
    int a = 2;
    String x = "X";
    String y;

    public void fazAlgo() {
        int b = 0;
        String s = "S";
        outro();
        b++;
        System.out.println(b);
    }

    public void outro() {
        int c = 5;
        String w = "W";
        fazAlgo();
    }

    public static void main(String[] args) {
        A_StackOverFlow a = new A_StackOverFlow();
        a.fazAlgo();
    }
}
