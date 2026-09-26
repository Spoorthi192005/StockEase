package model;

import service.Discountable;

public abstract class Product implements Discountable {

    // Product parameters
    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private String supplier;
    private int reorderLevel;
    private double discount;
    private ProductType productType;

    // Static variable
    private static int productCount = 0;

    // Final constant
    public static final double MAX_DISCOUNT = 50.0;

    // Default constructor
    public Product() {
        this.productId = 0;
        this.name = "Unknown";
        this.category = "General";
        this.price = 0.0;
        this.quantity = 0;
        this.supplier = "Unknown";
        this.reorderLevel = 0;
        this.discount = 0.0;
        this.productType = ProductType.NON_PERISHABLE;

        productCount++;
    }

    // Parameterized constructor
    public Product(int productId, String name, String category,
                   double price, int quantity, String supplier,
                   int reorderLevel, double discount,
                   ProductType productType) {

        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.supplier = supplier;
        this.reorderLevel = reorderLevel;
        this.discount = discount;
        this.productType = productType;

        productCount++;
    }

    // Getters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public double getDiscount() {
        return discount;
    }

    public ProductType getProductType() {
        return productType;
    }

    // Setters
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel >= 0) {
            this.reorderLevel = reorderLevel;
        }
    }

    public void setDiscount(double discount) {
        if (discount >= 0 && discount <= MAX_DISCOUNT) {
            this.discount = discount;
        }
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    // Abstract method
    public abstract double calculateValue();

    // Interface method
    @Override
    public void applyDiscount(double percentage) {
        if (percentage >= 0 && percentage <= MAX_DISCOUNT) {
            this.discount = percentage;
        }
    }

    // Operator precedence demonstration
    public double getDiscountedPrice() {
        // * and / are evaluated before -
        return price - price * discount / 100;
    }

    // Final method
    // Final because all products should use the same Product ID label format.
    public final String getProductIdLabel() {
        return "P-" + productId;
    }

    // Override toString() from Object
    @Override
    public String toString() {
        return "Product ID: " + productId
                + ", Name: " + name
                + ", Category: " + category
                + ", Price: ₹" + price
                + ", Quantity: " + quantity
                + ", Discount: " + discount + "%";
    }

    // Static method
    public static int getProductCount() {
        return productCount;
    }
}