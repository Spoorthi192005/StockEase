package model;

public class PerishableProduct extends Product {

    private String expiryDate;

    public PerishableProduct(int productId, String name, String category,
                             double price, int quantity, String supplier,
                             int reorderLevel, double discount,
                             String expiryDate) {

        super(productId, name, category, price, quantity,
              supplier, reorderLevel, discount,
              ProductType.PERISHABLE);

        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double calculateValue() {
        return getPrice() * getQuantity();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Type: Perishable"
                + ", Expiry Date: " + expiryDate;
    }
}