import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Scanner;
public class DatabaseSystem {
    private List<DataObject> database;
    private static final String DATABASE_FILE = "D\\sqlite\\db\\database.txt";

    public DatabaseSystem() {
        database = new ArrayList<>();
    }

    public void addObject(DataObject obj) {
        database.add(obj);
    }

    public void editObject(int index, DataObject newObj) {
        if (index >= 0 && index < database.size()) {
            database.set(index, newObj);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void removeObject(int index) {
        if (index >= 0 && index < database.size()) {
            database.remove(index);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void printDatabase() {
        if (database.isEmpty()) {
            System.out.println("The database is empty.");
        } else {
            for (int i = 0; i < database.size(); i++) {
                DataObject obj = database.get(i);
                System.out.println("Index: " + i);
                System.out.println("Object Name: " + obj.getObject_Name() + "\n");
                System.out.println("Object Stock Amount: " + obj.getObject_Stock_Amount() + "\n");
                System.out.println("Object Distributor: " + obj.getObject_Distributor() + "\n");
                System.out.println("Object Lent Status: " + obj.getObject_Lent_Status() + "\n");
                System.out.println("Object Borrower Identity: " + obj.getObject_Borrower_Identity() + "\n\n");
            }
        }
    }
    public void saveDatabaseToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATABASE_FILE))) {
            for (DataObject obj : database) {
                writer.println(obj.getObject_Name());
                writer.println(obj.getObject_Stock_Amount());
                writer.println(obj.getObject_Distributor());
                writer.println(obj.getObject_Lent_Status());
                writer.println(obj.getObject_Borrower_Identity());
            }
            System.out.println("Database saved to file: " + DATABASE_FILE);
        } catch (IOException e) {
            System.out.println("Failed to save the database to file.");
        }
    }

    public void loadDatabaseFromFile() {
        database.clear();
        try (Scanner scanner = new Scanner(new File(DATABASE_FILE))) {
            while (scanner.hasNextLine()) {
                String Object_Name = scanner.nextLine();
                int Object_Stock_Amount = Integer.parseInt(scanner.nextLine());
                String Object_Distributor = scanner.nextLine();
                boolean Object_Lent_Status = Boolean.parseBoolean(scanner.nextLine());
                String Object_Borrower_Identity = scanner.nextLine();
                DataObject obj = new DataObject(Object_Name, Object_Stock_Amount, Object_Distributor, Object_Lent_Status, Object_Borrower_Identity );
                database.add(obj);
            }
            System.out.println("Database loaded from file: " + DATABASE_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Database file not found.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid data format in the database file.");
        }
    }


}