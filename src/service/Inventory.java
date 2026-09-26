package service;

import model.Product;

public class Inventory {

    private Product[] products;
    private int productCount;

    private static final int MAX_PRODUCTS = 10;

    // Default constructor
    public Inventory() {
        products = new Product[MAX_PRODUCTS];
        productCount = 0;
    }

    // Parameterized constructor
    public Inventory(int capacity) {
        products = new Product[capacity];
        productCount = 0;
    }

    // Add a product
    public void addProduct(Product product) {

        if (productCount < products.length) {
            products[productCount] = product;
            productCount++;

            System.out.println("Product added successfully.");
        } else {
            System.out.println("Inventory is full.");
        }
    }

    // View all products
    public void viewProducts() {

        if (productCount == 0) {
            System.out.println("No products in inventory.");
            return;
        }

        System.out.println("\n===== INVENTORY PRODUCTS =====");

        for (int i = 0; i < productCount; i++) {

            // Skip an empty position in the array
            if (products[i] == null) {
                continue;
            }

            System.out.println(products[i]);
        }
    }

    // Search product by name
   public Product searchProduct(String name) {

    for (int i = 0; i < productCount; i++) {

        if (products[i] != null) {

            System.out.println(
                "DEBUG: Stored product name = ["
                + products[i].getName() + "]"
            );

            System.out.println(
                "DEBUG: You searched for = ["
                + name + "]"
            );

            if (products[i].getName()
                    .trim()
                    .equalsIgnoreCase(name.trim())) {

                return products[i];
            }
        }
    }

    return null;
}

    // Method overloading: search product by ID
    public Product searchProduct(int productId) {

        for (int i = 0; i < productCount; i++) {

            if (products[i].getProductId() == productId) {
                return products[i];
            }
        }

        return null;
    }

    // Apply discount using an interface reference
    public boolean applyDiscount(int productId, double percentage) {

        Product product = searchProduct(productId);

        if (product != null) {

            // Interface reference
            Discountable discountable = product;

            discountable.applyDiscount(percentage);

            return true;
        }

        return false;
    }

    // Check low stock
    public void checkLowStock() {

        System.out.println("\n===== LOW STOCK PRODUCTS =====");

        boolean found = false;

        for (int i = 0; i < productCount; i++) {

            if (products[i] == null) {
                continue;
            }

            if (products[i].getQuantity()
                    <= products[i].getReorderLevel()) {

                System.out.println(
                        products[i].getName()
                        + " - Quantity: "
                        + products[i].getQuantity()
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }
    }

    // Calculate total inventory value
    public double calculateTotalValue() {

        double total = 0;

        for (int i = 0; i < productCount; i++) {

            total += products[i].calculateValue();
        }

        return total;
    }

    // Update product quantity
    public boolean updateQuantity(
            int productId,
            int newQuantity) {

        for (int i = 0; i < productCount; i++) {

            if (products[i].getProductId() == productId) {

                if (newQuantity >= 0) {

                    products[i].setQuantity(newQuantity);
                    return true;
                }

                return false;
            }
        }

        return false;
    }

    // Remove product
    public boolean removeProduct(int productId) {

        for (int i = 0; i < productCount; i++) {

            if (products[i].getProductId() == productId) {

                for (int j = i;
                     j < productCount - 1;
                     j++) {

                    products[j] = products[j + 1];
                }

                products[productCount - 1] = null;
                productCount--;

                return true;
            }
        }

        return false;
    }

    // Get number of products currently in inventory
    public int getProductCount() {
        return productCount;
    }
}