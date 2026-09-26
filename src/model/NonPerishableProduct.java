package model;

public class NonPerishableProduct extends Product {

    private int warrantyMonths;

    public NonPerishableProduct(int productId, String name, String category,
                                double price, int quantity, String supplier,
                                int reorderLevel, double discount,
                                int warrantyMonths) {

        super(productId, name, category, price, quantity,
              supplier, reorderLevel, discount,
              ProductType.NON_PERISHABLE);

        this.warrantyMonths = warrantyMonths;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        if (warrantyMonths >= 0) {
            this.warrantyMonths = warrantyMonths;
        }
    }

    @Override
    public double calculateValue() {
        return getDiscountedPrice() * getQuantity();
    }

    @Override
    public String toString() {
        return super.toString()
                + ", Type: Non-Perishable"
                + ", Warranty: " + warrantyMonths + " months";
    }
}
