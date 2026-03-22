import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PetCareScheduler petCareScheduler = new PetCareScheduler();
        boolean running = true;

        System.out.println("==================================");
        System.out.println("  Bem-vindo ao PetCare Scheduler  ");
        System.out.println("==================================");

        while (running) {

            System.out.println("==================================");
            System.out.println("O que deseja fazer?");
            System.out.println("[1] Registrar Animal");
            System.out.println("[2] Agendar Consulta");
            System.out.println("[3] Visualizar Registros");
            System.out.println("[4] Salvar Dados em Arquivo");
            System.out.println("[5] Sair");
            System.out.println("==================================");

            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número de 1 a 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    petCareScheduler.registerPets();
                    break;
                case 2:
                    petCareScheduler.scheduleAppointments();
                    break;
                case 3:
                    petCareScheduler.displayRecords();
                    break;
                case 4:
                    petCareScheduler.saveToFile();
                    break;
                case 5:
                    System.out.println("==================================");
                    System.out.println("Saindo do sistema. Até logo!");
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida. Escolha entre 1 e 5.");
            }
        }

        scanner.close();
    }
}
