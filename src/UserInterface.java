import java.util.InputMismatchException;
import java.util.Scanner;
public class UserInterface {

    static void UILoop() {
        Scanner scanner = new Scanner(System.in);
        DatabaseSystem databaseSystem = new DatabaseSystem();

        while (true) {
            System.out.println("1. Add an object to the Inventory");
            System.out.println("2. Edit an object within the Inventory");
            System.out.println("3. Remove an object from the Inventory");
            System.out.println("4. Print the Inventory database");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Please enter the Object Name: \n");
                        String Object_Name = scanner.next();

                        System.out.print("now enter the Object stock amount: \n");
                        int Object_Stock_Amount = scanner.nextInt();

                        System.out.println("Enter the Object Distributor: ");
                        String Object_Distributor = scanner.next();

                        System.out.println("Is the Object being lent out? if it is being lent out type 'true' otherwise type 'false': ");
                        boolean Object_Lent_Status = scanner.nextBoolean();

                        System.out.println("And now enter the Identity of the borrower for the Object, if there is no borrower and you typed 'false' for it being lent out then type 'none': ");
                        String Object_Borrower_Identity = scanner.next();

                        DataObject newObj = new DataObject(Object_Name, Object_Stock_Amount, Object_Distributor, Object_Lent_Status, Object_Borrower_Identity);
                        databaseSystem.addObject(newObj);
                        System.out.println("Object added to the database.");

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. please re enter your input \n");
                        scanner.nextLine(); // Clear the invalid input from the scanner
                    }
                    break;

                case 2:
                    System.out.print("Enter the index of the object to edit: ");
                    int editIndex = scanner.nextInt();

                    System.out.print("Please enter the new Object Name: \n");
                    String New_Object_Name = scanner.next();

                    System.out.print("now enter the new Object stock amount: \n");
                    int New_Object_Stock_Amount = scanner.nextInt();

                    System.out.println("Enter the new or same Object Distributor: ");
                    String New_Object_Distributor = scanner.next();

                    System.out.println("update the Object Lent status, if it is being lent out type 'true' otherwise type 'false': ");
                    boolean New_Object_Lent_Status = scanner.nextBoolean();

                    System.out.println("update the borrower Identity, if there is no borrower and you typed 'false' for it being lent out then type 'none': ");
                    String New_Object_Borrower_Identity = scanner.next();

                    DataObject editedObj = new DataObject(New_Object_Name, New_Object_Stock_Amount, New_Object_Distributor, New_Object_Lent_Status, New_Object_Borrower_Identity);
                    databaseSystem.editObject(editIndex, editedObj);
                    System.out.println("Object edited.");
                    break;

                case 3:
                    System.out.print("Enter the index of the object to remove: ");
                    int removeIndex = scanner.nextInt();

                    databaseSystem.removeObject(removeIndex);
                    System.out.println("Object removed from the database.");
                    break;

                case 4:
                    databaseSystem.printDatabase();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
