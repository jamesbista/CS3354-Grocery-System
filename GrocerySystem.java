import java.util.Scanner;

public class GrocerySystem {

    // Temporary Sample Method for Testing
    // Will be replaced by TeamMate 1
    public static void printInventory(String[] names, double[] prices, int[] stocks) {
        System.out.println("Inventory feature will be added by teammate.");
        for (int i = 0; i < names.length; i++)
        {

            if(names[i] != null)
            {
                System.out.println("Item: " + names[i] + " | Price: $" + prices[i] + " | Stock: " + stocks[i]);
            }

        }
    }

    // Temporary Sample Method for Testing
    // Will be replaced by TeamMate 2
    public static void restockItem(String[] names, int[] stocks, String target, int amount) {
        System.out.println("Restock feature will be added by teammate.");
    }

    public static void main(String[] args) {

        String[] itemNames = new String[10];
        double[] itemPrices = new double[10];
        int[] itemStocks = new int[10];

        //Items for the arrays can be modified if need be
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
