public class ExemploThreads {

    // Uma tarefa que sera executada em uma thread
    static class MinhaTarefa implements Runnable {

        private String nome;

        public MinhaTarefa(String nome) {
            this.nome = nome;
        }

           public void run() {
            // Codigo que roda "em paralelo"
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread " + nome + " - passo " + i);

                try {
                    // Pausa de 300 ms so para ficar visivel a alternancia
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread " + nome + " terminou.");
        }
    }

    public static void main(String[] args) {

        // Cria duas threads, cada uma com uma tarefa
        Thread t1 = new Thread(new MinhaTarefa("A"));
        Thread t2 = new Thread(new MinhaTarefa("B"));

        System.out.println("Iniciando as threads...");

        // Dispara as duas threads
        t1.start();
        t2.start();

        System.out.println("main() continua enquanto as threads executam.");
    }
}