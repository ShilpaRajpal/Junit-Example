//package org.example;
//
//import org.example.Product;
//import org.example.ShoppingCart;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class ShoppingCartTest {
//
//    @Mock
//    Product apple;
//
//    @Mock
//    Product banana;
//
//    @Test
//    public void testAddProduct() {
//        ShoppingCart cart = new ShoppingCart();
//        when(apple.getPrice()).thenReturn(1.0);
//
//        cart.addProduct(apple, 2);
//
//        assertEquals(2, cart.getQuantity(apple));
//    }
//
//    @Test
//    public void testRemoveProduct() {
//        ShoppingCart cart = new ShoppingCart();
//        when(banana.getPrice()).thenReturn(1.50);
//        cart.addProduct(banana, 1);
//        cart.removeProduct(banana);
//
//        assertEquals(0, cart.getQuantity(banana));
//    }
//
//    @Test
//    public void testGetTotalPrice() {
//        ShoppingCart cart = new ShoppingCart();
//
//        when(apple.getPrice()).thenReturn(1.0);
//        when(banana.getPrice()).thenReturn(1.50);
//
//        cart.addProduct(apple, 2);
//        cart.addProduct(banana, 1);
//
//        assertEquals(3.5, cart.getTotalPrice(), 0.0);
//    }
//}
//
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @Mock
    private Product product1;

    @Mock
    private Product product2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        shoppingCart = new ShoppingCart();
    }

    @AfterEach
    void tearDown() {
        shoppingCart = null;
    }

    @Test
    void testAddNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.addProduct(null, 1));
    }

    @Test
    void testRemoveNullProduct() {
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.removeProduct(null));
    }

    @Test
    void testEmptyShoppingCart() {
        assertEquals(0.0, shoppingCart.getTotalPrice());
        assertEquals(0, shoppingCart.getQuantity(product1));
    }

    @Test
    void testAddProduct() {
        when(product1.getPrice()).thenReturn(10.0);
        shoppingCart.addProduct(product1, 2);
        assertEquals(2, shoppingCart.getQuantity(product1));
        assertEquals(20.0, shoppingCart.getTotalPrice());
    }

    @Test
    void testAddDuplicateProducts() {
        when(product1.getPrice()).thenReturn(10.0);
        shoppingCart.addProduct(product1, 2);
        shoppingCart.addProduct(product1, 3);
        assertEquals(5, shoppingCart.getQuantity(product1));
        assertEquals(50.0, shoppingCart.getTotalPrice());
    }

    @Test
    void testAddNegativeQuantity() {
        when(product1.getPrice()).thenReturn(10.0);
        assertThrows(IllegalArgumentException.class, () -> shoppingCart.addProduct(product1, -1));
    }

    @Test
    void testRemoveProduct() {
        when(product1.getPrice()).thenReturn(10.0);
        shoppingCart.addProduct(product1, 2);
        shoppingCart.removeProduct(product1);
        assertEquals(0, shoppingCart.getQuantity(product1));
        assertEquals(0.0, shoppingCart.getTotalPrice());
    }

    @Test
    void testRemoveNonExistentProduct() {
        shoppingCart.removeProduct(product1);
        assertEquals(0, shoppingCart.getQuantity(product1));
        assertEquals(0.0, shoppingCart.getTotalPrice());
    }

    @Test
    void testGetTotalPrice() {
        when(product1.getPrice()).thenReturn(10.0);
        when(product2.getPrice()).thenReturn(20.0);
        shoppingCart.addProduct(product1, 2);
        shoppingCart.addProduct(product2, 1);
        assertEquals(40.0, shoppingCart.getTotalPrice());
    }
}