import java.util.Scanner;

public class GrocerySystem {

    // Temporary Sample Mathod for Testing
    // Will be replaced by TeamMate 1
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("Inventory feature will be added by teammate.");
    }

    // Temporary Sample Mathod for Testing
    // Will be replaced by TeamMate 2
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        System.out.println("Restock feature will be added by teammate.");
    }

    public static void main(String[] args) {

        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Inventory");
            System.out.println("2. Restock Item");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                printInventory(itemNames, itemPrices, itemStocks);
            } 
            else if (choice == 2) {
                System.out.print("Enter item name: ");
                sc.nextLine();
                System.out.print("Enter amount: ");
                sc.nextInt();
                restockItem(itemNames, itemStocks, "", 0);
            } 
            else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
