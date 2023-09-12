package util.database;

import org.main.*;

public class DatabaseWriter {
    /*
    Initialize
    Handle data folder creation and processing to ensure that the files are properly stored
    Needs to create a data folder if it doesn't exist.
    Needs to create a Horses folder, Health Records folder, Vaccinations folder, Notes folder, Client folder, Logs Folder
     */

    public static void initialize() {

    }

    /*
    Take in an object, and send it to a private inner method to save for that given type
     */

    public static boolean writeToFile(Object object) {
        throw new UnsupportedOperationException();
    }

    private boolean saveClient(Client client) {
        throw new UnsupportedOperationException();
    }

    private boolean saveHorse(Horse horse) {
        throw new UnsupportedOperationException();
    }

    private boolean saveHealthRecord(HealthRecord healthRecord) {
        throw new UnsupportedOperationException();
    }

    private boolean saveVaccination(Vaccination vaccination) {
        throw new UnsupportedOperationException();
    }

    private boolean saveNote(Note note) {
        throw new UnsupportedOperationException();
    }

    public void writeLog() {

    }
}
