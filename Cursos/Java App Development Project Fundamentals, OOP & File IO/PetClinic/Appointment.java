import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

    private LocalDateTime dateTime;
    private String note;
    private String vetName;

    Appointment(String note, String vetName) {
        this.dateTime = LocalDateTime.now();
        this.note = note;
        this.vetName = vetName;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public String getNote() {
        return this.note;
    }

    public String getVetName() {
        return this.vetName;
    }

    public static boolean hasConflict(java.util.ArrayList<Appointment> appointments, LocalDateTime newDateTime) {
        for (Appointment a : appointments) {
            long diffMinutes = Math.abs(java.time.Duration.between(a.getDateTime(), newDateTime).toMinutes());
            if (diffMinutes < 60) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "Data/Hora: " + this.dateTime.format(formatter) + "\n" +
               "Veterinário: " + this.vetName + "\n" +
               "Observação: " + this.note;
    }
}
