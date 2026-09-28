# StockEase — Console-Based Inventory Management System

## 1. Project Overview

StockEase is a console-based Java Inventory Management System developed using Object-Oriented Programming concepts. The system allows users to add, view, search, update and remove products, calculate inventory value, check low-stock products and apply discounts.

The project is organized using three custom packages: `main`, `model` and `service`.

## 2. Main Features

- Add Perishable and Non-Perishable products
- View all products
- Search products by name or Product ID
- Update product quantity
- Remove products
- Calculate total inventory value
- Check low-stock products
- Apply discounts
- Console-based menu using Scanner

## 3. Mandatory Java Feature Mapping

| Mandatory Feature | Exact File/Class |
|---|---|
| Classes and Objects | `Product.java`, `PerishableProduct.java`, `NonPerishableProduct.java`, `Inventory.java`, `InventoryApp.java` |
| Encapsulation | `Product.java`, `PerishableProduct.java`, `NonPerishableProduct.java` — private fields with public getters/setters |
| Different Data Types | `Product.java` — `int`, `double`, `String`, `ProductType` |
| `final` Constant | `Product.java` — `MAX_DISCOUNT`; `Inventory.java` — `MAX_PRODUCTS` |
| Variable Scope | Local variables in `InventoryApp.java` and `Inventory.java`; instance fields in model classes |
| Operators and Precedence | `Product.java` — `getDiscountedPrice()` |
| Type Conversion/Casting | `InventoryApp.java` — `(int) totalValue` |
| Enum | `ProductType.java` |
| if-else | `InventoryApp.java`, `Product.java`, `Inventory.java` |
| switch | `InventoryApp.java` |
| Loops | `InventoryApp.java`, `Inventory.java` |
| break | `InventoryApp.java` |
| continue | `Inventory.java` |
| return | `Inventory.java`, `InventoryApp.java` |
| Array of Objects | `Inventory.java` — `Product[] products` |
| Scanner Input | `InventoryApp.java` |
| Formatted Output | `InventoryApp.java` — `System.out.printf()` |
| Constructor Overloading | `Product.java`, `Inventory.java` |
| Method Overloading | `Inventory.java` — `searchProduct(String)` and `searchProduct(int)` |
| Static Field/Method | `Product.java` — `productCount`, `getProductCount()` |
| `this` Keyword | `Product.java`, `PerishableProduct.java`, `NonPerishableProduct.java` |
| String Methods | `Inventory.java` — `trim()` and `equalsIgnoreCase()` |
| Base Class | `Product.java` |
| Two Subclasses | `PerishableProduct.java`, `NonPerishableProduct.java` |
| `super` | `PerishableProduct.java`, `NonPerishableProduct.java` |
| Method Overriding | `PerishableProduct.java`, `NonPerishableProduct.java` |
| Dynamic Binding | `Inventory.java` — `Product` reference calls overridden `calculateValue()` |
| Abstract Class | `Product.java` |
| Abstract Method | `Product.java` — `calculateValue()` |
| Interface | `Discountable.java` |
| Interface Implementation | `Product.java` implements `Discountable` |
| Interface Reference | `Inventory.java` — `Discountable discountable = product` |
| `toString()` Override | `Product.java`, `PerishableProduct.java`, `NonPerishableProduct.java` |
| Final Method | `Product.java` — `getProductIdLabel()` |
| Custom Packages | `main`, `model`, `service` |
| Package Imports | `InventoryApp.java`, `Product.java`, subclass files |

## 4. Package Structure

```text
StockEase/
└── src/
    ├── main/
    │   └── InventoryApp.java
    ├── model/
    │   ├── Product.java
    │   ├── ProductType.java
    │   ├── PerishableProduct.java
    │   └── NonPerishableProduct.java
    └── service/
        ├── Discountable.java
        └── Inventory.java

## 5. Class Relationship

```text
                         <<abstract>>
                           Product
                              |
              +---------------+---------------+
              |                               |
           extends                         extends
              |                               |
              v                               v
   PerishableProduct                 NonPerishableProduct
        |                                  |
   expiryDate                         warrantyMonths


                  <<interface>>
                   Discountable
                        ^
                        |
                    implements
                        |
                      Product


                    <<enum>>
                  ProductType
                  /         \
                 /           \
          PERISHABLE     NON_PERISHABLE


                     Inventory
                         |
                         |
                    Product[]
                         |
                         v
                 Manages Products


                  InventoryApp
                       |
                       v
                    Inventory
                       |
                    Scanner
```


add:

```markdown
## 5. Project Structure

The project follows a simple package-based structure:

- `main` — contains the main application and console menu.
- `model` — contains product-related classes and the product type enum.
- `service` — contains inventory operations and the discount interface.
## 6. How to Run

Compile the Java source files from the `src` directory and run `InventoryApp`.

The application provides a console-based menu for managing inventory products.

## 7. Sample Output

A sample console output is included in `SAMPLE_OUTPUT.txt`.
