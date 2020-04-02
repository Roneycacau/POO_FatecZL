package aulas.aula2.exemplo;

public class TesteStringBuffer {
        public static void main(String[] args) {
            long startTime = System.currentTimeMillis();
            String texto = "";
            for (int i = 0; i < 2147483647; i++) {
                texto += i + ", ";
            }
            System.out.println(texto);
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            System.out.println("Tempo gasto " + duration + "ms");

            StringBuffer sb = new StringBuffer("");
            startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                sb.append(i + ", ");
            }
            System.out.println(sb);
            endTime = System.currentTimeMillis();
            duration = endTime - startTime;
            System.out.println("Tempo gasto " + duration + "ms");

        }
    }