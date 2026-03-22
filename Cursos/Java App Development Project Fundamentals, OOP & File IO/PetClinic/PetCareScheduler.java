import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PetCareScheduler {

    private ArrayList<Pet> pets = new ArrayList<>();
    private static final String FILE_NAME = "pets_data.txt";

    PetCareScheduler() {}

    public void registerPets() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("=== REGISTRO DE ANIMAL ===");

        String name = readValidString(scanner, "Nome do animal");
        if (name == null) return;

        String breed = readValidString(scanner, "Raça do animal");
        if (breed == null) return;

        Integer age = readValidAge(scanner);
        if (age == null) return;

        String ownerName = readValidString(scanner, "Nome do dono");
        if (ownerName == null) return;

        String contactInfo = readValidContact(scanner);
        if (contactInfo == null) return;

        if (isDuplicate(ownerName, name)) {
            System.out.println("==================================");
            System.out.println("ERRO: Já existe um pet com o nome '" + name +
                               "' registrado para o dono '" + ownerName + "'.");
            System.out.println("Registro cancelado.");
            return;
        }

        Pet newPet = new Pet(name, breed, age, ownerName, contactInfo);
        pets.add(newPet);
    }

    public void scheduleAppointments() {
        if (pets.isEmpty()) {
            System.out.println("==================================");
            System.out.println("Nenhum animal registrado. Registre um animal primeiro.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("==================================");
        System.out.println("=== AGENDAR CONSULTA ===");

        String ownerName = readValidString(scanner, "Nome do dono");
        if (ownerName == null) return;

        String petName = readValidString(scanner, "Nome do pet");
        if (petName == null) return;

        Pet pet = searchPet(ownerName, petName);
        if (pet == null) {
            System.out.println("==================================");
            System.out.println("Pet não encontrado. Verifique o nome do dono e do animal.");
            return;
        }

        displayPetInfo(pet);

        if (!confirmPet(scanner)) {
            System.out.println("Agendamento cancelado.");
            return;
        }

        String note = readValidString(scanner, "Observação / motivo da consulta");
        if (note == null) return;

        String vetName = readValidString(scanner, "Nome do veterinário");
        if (vetName == null) return;

        LocalDateTime now = LocalDateTime.now();
        if (Appointment.hasConflict(pet.getListOfAppointments(), now)) {
            System.out.println("==================================");
            System.out.println("AVISO: Já existe um agendamento dentro de 1 hora para este pet.");
            System.out.println("Deseja prosseguir mesmo assim? [1] Sim  [2] Não");
            int choice = readIntSafe(scanner);
            if (choice != 1) {
                System.out.println("Agendamento cancelado.");
                return;
            }
        }

        Appointment appointment = new Appointment(note, vetName);
        pet.addAppointment(appointment);

        System.out.println("==================================");
        System.out.println("Consulta agendada com sucesso!");
        System.out.println(appointment);
    }

    public void displayRecords() {
        if (pets.isEmpty()) {
            System.out.println("==================================");
            System.out.println("Nenhum animal registrado.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("==================================");
        System.out.println("Nome do dono:");
        String ownerName = scanner.nextLine().trim();
        System.out.println("Nome do pet:");
        String petName = scanner.nextLine().trim();

        Pet pet = searchPet(ownerName, petName);
        displayPetInfo(pet);

        if (pet != null && !pet.getListOfAppointments().isEmpty()) {
            System.out.println("=== CONSULTAS ===");
            for (Appointment a : pet.getListOfAppointments()) {
                System.out.println("----------------------------------");
                System.out.println(a);
            }
            System.out.println("==================================");
        } else if (pet != null) {
            System.out.println("Nenhuma consulta agendada para este pet.");
        }
    }

    public void saveToFile() {
   
        if (pets.isEmpty()) {
            System.out.println("==================================");
            System.out.println("Nenhum dado para salvar. Registre ao menos um animal.");
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            writer.println("======= RELATÓRIO PETCARE =======");
            writer.println("Gerado em: " + LocalDateTime.now().format(formatter));
            writer.println("Total de animais: " + pets.size());
            writer.println("==================================");

            for (Pet pet : pets) {
                writer.println(pet.toString());
                writer.println("--- Consultas ---");

                if (pet.getListOfAppointments().isEmpty()) {
                    writer.println("Nenhuma consulta agendada.");
                } else {
                    for (Appointment a : pet.getListOfAppointments()) {
                        writer.println(a.toString());
                        writer.println("----------------------------------");
                    }
                }
                writer.println("==================================");
            }

            System.out.println("==================================");
            System.out.println("Dados salvos com sucesso em: " + FILE_NAME);

        } catch (IOException e) {
            System.out.println("==================================");
            System.out.println("ERRO ao salvar os dados: " + e.getMessage());
            System.out.println("Verifique se o programa tem permissão de escrita na pasta.");
        } catch (Exception e) {
            System.out.println("==================================");
            System.out.println("Erro inesperado ao salvar: " + e.getMessage());
        }
    }

    private boolean isDuplicate(String ownerName, String petName) {
        for (Pet p : pets) {
            if (p.getOwnerName().equalsIgnoreCase(ownerName.trim()) &&
                p.getName().equalsIgnoreCase(petName.trim())) {
                return true;
            }
        }
        return false;
    }

    private Pet searchPet(String ownerName, String petName) {
        for (Pet p : pets) {
            if (p.getOwnerName().equalsIgnoreCase(ownerName.trim()) &&
                p.getName().equalsIgnoreCase(petName.trim())) {
                return p;
            }
        }
        return null;
    }

    private void displayPetInfo(Pet pet) {
        if (pet == null) {
            System.out.println("==================================");
            System.out.println("Pet não encontrado.");
            return;
        }
        System.out.println("==================================");
        System.out.println(pet);
        System.out.println("==================================");
    }

    private boolean confirmPet(Scanner scanner) {
        System.out.println("Este é o pet correto? [1] Sim  [2] Não");
        int choice = readIntSafe(scanner);
        return choice == 1;
    }

    private String readValidString(Scanner scanner, String fieldName) {
        System.out.println("==================================");
        System.out.println(fieldName + ":");
        String value = scanner.nextLine().trim();
        if (!Pet.isValidString(value)) {
            System.out.println("ERRO: '" + fieldName + "' não pode ser vazio.");
            System.out.println("Retornando ao menu...");
            return null;
        }
        return value;
    }

    private Integer readValidAge(Scanner scanner) {
        while (true) {
            System.out.println("==================================");
            System.out.println("Idade do animal:");
            try {
                int age = Integer.parseInt(scanner.nextLine().trim());
                if (!Pet.isValidAge(age)) {
                    System.out.println("ERRO: Idade inválida. Deve ser entre 1 e 100.");
                    System.out.println("Retornando ao menu...");
                    return null;
                }
                return age;
            } catch (NumberFormatException e) {
                System.out.println("ERRO: Digite apenas números para a idade.");
                System.out.println("Retornando ao menu...");
                return null;
            }
        }
    }

    private String readValidContact(Scanner scanner) {
        System.out.println("==================================");
        System.out.println("Contato (telefone ou e-mail):");
        String contact = scanner.nextLine().trim();
        if (!Pet.isValidContactInfo(contact)) {
            System.out.println("ERRO: Contato inválido. Informe um e-mail ou telefone com ao menos 8 dígitos.");
            System.out.println("Retornando ao menu...");
            return null;
        }
        return contact;
    }

    private int readIntSafe(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
