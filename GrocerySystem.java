import java.util.Scanner;

/**
 * Grocery Management System using parallel arrays for item names, prices, and
 * stock quantities.
 */
public class GrocerySystem {

    /**
     * Prints the inventory by iterating through the parallel arrays.
     * Only prints slots that are not empty (names[i] != null).
     *
     * @param names  item names array
     * @param prices item prices array
     * @param stocks item stock array
     */
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                System.out.println("Item: " + names[i] + " | Price: $" + prices[i] + " | Stock: " + stocks[i]);
            }
        }
    }

    /**
     * Restocks an item by searching for the target name in the names array.
     * If found, adds the amount to the stock at the same index.
     * If not found, prints "Item not found."
     *
     * @param names  item names array
     * @param stocks item stock array
     * @param target item name to search for
     * @param amount amount to add
     */
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                System.out.println(target + " restocked successfully!");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    /**
     * Runs the user menu to display inventory and restocks
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        // Parallel arrays as asked in requirement
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // Sample data for testing
        itemNames[0] = "Carrot";
        itemPrices[0] = 2.00;
        itemStocks[0] = 5;

        itemNames[1] = "Apple";
        itemPrices[1] = 1.00;
        itemStocks[1] = 10;

        itemNames[2] = "Cookie";
        itemPrices[2] = 3.25;
        itemStocks[2] = 25;

        itemNames[3] = "Candy Bar";
        itemPrices[3] = 0.25;
        itemStocks[3] = 70;

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
            } else if (choice == 2) {
                System.out.print("Enter item name: ");
                String target = sc.nextLine();

                System.out.print("Enter amount: ");
                int amount = sc.nextInt();
                sc.nextLine();

                restockItem(itemNames, itemStocks, target, amount);
            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
