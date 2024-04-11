package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Shopping Cart APP =====");
        System.out.println();
        Product apple = new Product("Apple", 0.99);
        Product banana = new Product("Banana", 1.49);
        Product orange = new Product("Orange", 0.79);

        ShoppingCart shoppingCart = new ShoppingCart();

        // Add products to the shopping cart
        shoppingCart.addProduct(apple, 2);
        System.out.println("Added 2 Apples to the cart.");

        shoppingCart.addProduct(banana, 1);
        System.out.println("Added 1 Banana to the cart.");

        shoppingCart.addProduct(orange, 3);
        System.out.println("Added 3 Oranges to the cart.");

        System.out.println("Total price: $" + shoppingCart.getTotalPrice());

        shoppingCart.removeProduct(banana);
        System.out.println("Removed 1 Banana from the cart.");

        // Print the updated total price
        System.out.println("Total price: $" + shoppingCart.getTotalPrice());
    }
}