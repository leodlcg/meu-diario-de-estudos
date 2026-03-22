import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalDate;

public class Pet {

    private static int totalNumberAnimals = 0;
    private int id;
    private String name;
    private String breed;
    private int age;
    private String ownerName;
    private String contactInfo;
    private LocalDate registrationDate;
    private ArrayList<Appointment> listOfAppointments = new ArrayList<>();

    Pet(String name, String breed, int age, String ownerName, String contactInfo) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.ownerName = ownerName;
        this.contactInfo = contactInfo;
        this.id = ++totalNumberAnimals;
        this.registrationDate = LocalDate.now();
        System.out.println("==================================");
        System.out.println("Pet registrado com sucesso! ID: " + this.id);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getBreed() {
        return this.breed;
    }

    public int getAge() {
        return this.age;
    }

    public String getOwnerName() {
        return this.ownerName;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

    public String getRegistrationDate() {
        return this.registrationDate.toString();
    }

    public ArrayList<Appointment> getListOfAppointments() {
        return this.listOfAppointments;
    }

    public void addAppointment(Appointment appointment) {
        this.listOfAppointments.add(appointment);
    }

    public static boolean isValidString(String value) {
        return value != null && !value.trim().isEmpty();
    }

    public static boolean isValidAge(int age) {
        return age > 0 && age <= 100;
    }

    public static boolean isValidContactInfo(String contact) {
        if (!isValidString(contact)) return false;
        String trimmed = contact.trim();
        // Aceita formato de e-mail básico ou número com ao menos 8 dígitos
        return trimmed.matches(".*@.*\\..*") || trimmed.replaceAll("[^0-9]", "").length() >= 8;
    }

    public String toString() {
        return "ID: " + this.id + "\n" +
               "Nome: " + this.name + "\n" +
               "Raça: " + this.breed + "\n" +
               "Idade: " + this.age + " ano(s)\n" +
               "Dono: " + this.ownerName + "\n" +
               "Contato: " + this.contactInfo + "\n" +
               "Data de Registro: " + this.registrationDate;
    }
}
