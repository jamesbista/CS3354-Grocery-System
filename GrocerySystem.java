import java.util.Scanner;

/**
 * GrocerySystem is a simple grocery management system that uses parallel arrays
 * to store item names, prices, and stock quantities.
 *
 * Users can:
 * 1) View inventory
 * 2) Restock an item
 * 3) Exit
 */
public class GrocerySystem {

    /**
     * Prints all non-empty inventory slots (where names[i] != null).
     *
     * @param names  the array of item names
     * @param prices the array of item prices (same index matches the same item)
     * @param stocks the array of item stock counts (same index matches the same
     *               item)
     */
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("\n--- Inventory ---");
        boolean anyItem = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                anyItem = true;
                System.out.println("Item: " + names[i] + " | Price: $" + prices[i] + " | Stock: " + stocks[i]);
            }
        }

        if (!anyItem) {
            System.out.println("No items in inventory.");
        }
    }

    /**
     * Searches for the target item name and adds the amount to its stock.
     * If the item is not found, prints "Item not found."
     *
     * @param names  the array of item names
     * @param stocks the array of item stocks
     * @param target the name of the item to restock
     * @param amount how many units to add to stock
     */
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        boolean found = false;

        for (int i = 0; i < names.length; i++) {
            if (names[i] != null && names[i].equalsIgnoreCase(target)) {
                stocks[i] += amount;
                System.out.println(target + " restocked successfully! New stock: " + stocks[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    /**
     * Runs the user menu loop and calls the appropriate methods based on user
     * input.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        // Sample starter items (you can modify these if you want)
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

            // Prevent crash if user types letters like "clear"
            if (!sc.hasNextInt()) {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
                sc.nextLine(); // consume the bad input
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                printInventory(itemNames, itemPrices, itemStocks);

            } else if (choice == 2) {
                System.out.print("Enter item name: ");
                String target = sc.nextLine();

                System.out.print("Enter amount: ");
                if (!sc.hasNextInt()) {
                    System.out.println("Invalid amount. Please enter a number.");
                    sc.nextLine(); // consume bad input
                    continue;
                }
                int amount = sc.nextInt();
                sc.nextLine(); // consume newline

                if (amount <= 0) {
                    System.out.println("Amount must be greater than 0.");
                    continue;
                }

                restockItem(itemNames, itemStocks, target, amount);

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
            }
        }

        sc.close();
    }
}
