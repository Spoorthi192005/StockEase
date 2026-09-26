package main;

import java.util.Scanner;

import model.Product;
import model.PerishableProduct;
import model.NonPerishableProduct;
import service.Inventory;

public class InventoryApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println("       STOCKEASE INVENTORY");
            System.out.println("=================================");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Quantity");
            System.out.println("5. Remove Product");
            System.out.println("6. Calculate Inventory Value");
            System.out.println("7. Check Low Stock");
            System.out.println("8. Apply Discount");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    addProduct(scanner, inventory);
                    break;

                case 2:
                    inventory.viewProducts();
                    break;

                case 3:
                    searchProduct(scanner, inventory);
                    break;

                case 4:
                    updateQuantity(scanner, inventory);
                    break;

                case 5:
                    removeProduct(scanner, inventory);
                    break;

                case 6:

                    double totalValue =
                            inventory.calculateTotalValue();

                    System.out.printf(
                            "Total Inventory Value: ₹%.2f%n",
                            totalValue
                    );

                    // Explicit type casting: double to int
                    int wholeValue = (int) totalValue;

                    System.out.println(
                            "Whole-number Inventory Value: ₹"
                            + wholeValue
                    );

                    break;

                case 7:
                    inventory.checkLowStock();
                    break;

                case 8:
                    applyDiscount(scanner, inventory);
                    break;

                case 9:
                    running = false;

                    System.out.println(
                            "Thank you for using StockEase!"
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }

    // Add a product
    public static void addProduct(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n===== ADD PRODUCT =====");

        System.out.print("Enter Product ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Supplier: ");
        scanner.nextLine();
        String supplier = scanner.nextLine();

        System.out.print("Enter Reorder Level: ");
        int reorderLevel = scanner.nextInt();

        System.out.print("Enter Discount (%): ");
        double discount = scanner.nextDouble();

        System.out.print(
                "Enter Product Type "
                + "(1 = Perishable, 2 = Non-Perishable): "
        );

        int typeChoice = scanner.nextInt();
        scanner.nextLine();

        if (typeChoice == 1) {

            System.out.print("Enter Expiry Date: ");
            String expiryDate = scanner.nextLine();

            Product product = new PerishableProduct(
                    id,
                    name,
                    category,
                    price,
                    quantity,
                    supplier,
                    reorderLevel,
                    discount,
                    expiryDate
            );

            inventory.addProduct(product);

        } else if (typeChoice == 2) {

            System.out.print("Enter Warranty (months): ");
            int warrantyMonths = scanner.nextInt();

            Product product = new NonPerishableProduct(
                    id,
                    name,
                    category,
                    price,
                    quantity,
                    supplier,
                    reorderLevel,
                    discount,
                    warrantyMonths
            );

            inventory.addProduct(product);

        } else {

            System.out.println("Invalid product type.");
        }
    }

    // Search product
    public static void searchProduct(
            Scanner scanner,
            Inventory inventory) {

        System.out.println("\n===== SEARCH PRODUCT =====");
        System.out.println("1. Search by Name");
        System.out.println("2. Search by Product ID");
        System.out.print("Enter choice: ");

        int searchChoice = scanner.nextInt();
        scanner.nextLine();

        Product product;

        switch (searchChoice) {

            case 1:

                System.out.print("Enter product name: ");
                String name = scanner.nextLine();

                product = inventory.searchProduct(name);

                break;

            case 2:

                System.out.print("Enter product ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                product = inventory.searchProduct(id);

                break;

            default:

                System.out.println("Invalid search choice.");

                return;
        }

        if (product != null) {

            System.out.println("Product Found:");
            System.out.println(product);

        } else {

            System.out.println("Product not found.");
        }
    }

    // Update quantity
    public static void updateQuantity(
            Scanner scanner,
            Inventory inventory) {

        System.out.print("\nEnter Product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter New Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        boolean updated =
                inventory.updateQuantity(id, quantity);

        if (updated) {

            System.out.println(
                    "Quantity updated successfully."
            );

        } else {

            System.out.println(
                    "Product not found or invalid quantity."
            );
        }
    }

    // Remove product
    public static void removeProduct(
            Scanner scanner,
            Inventory inventory) {

        System.out.print(
                "\nEnter Product ID to remove: "
        );

        int id = scanner.nextInt();
        scanner.nextLine();

        boolean removed =
                inventory.removeProduct(id);

        if (removed) {

            System.out.println(
                    "Product removed successfully."
            );

        } else {

            System.out.println(
                    "Product not found."
            );
        }
    }

    // Apply discount
    public static void applyDiscount(
            Scanner scanner,
            Inventory inventory) {

        System.out.print("\nEnter Product ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Discount Percentage: ");
        double percentage = scanner.nextDouble();
        scanner.nextLine();

        boolean applied =
                inventory.applyDiscount(id, percentage);

        if (applied) {

            System.out.println(
                    "Discount applied successfully."
            );

        } else {

            System.out.println(
                    "Product not found or invalid discount."
            );
        }
    }
}