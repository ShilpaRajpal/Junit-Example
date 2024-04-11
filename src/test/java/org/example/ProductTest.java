package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProductTest {
    private Product product;

    @BeforeEach
    void setUp() {
        product = new Product("Apple", 0.99);
    }

    @AfterEach
    void tearDown() {
        product = null;
    }

    @Test
    void testGetName() {
        assertEquals("Apple", product.getName());
    }

    @Test
    void testGetPrice() {
        assertEquals(0.99, product.getPrice());
    }

    @Test
    void testCreateProductWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Product("", 0.99));
    }

    @Test
    void testCreateProductWithNullName() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null, 0.99));
    }

    @Test
    void testCreateProductWithNegativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new Product("Orange", -1.0));
    }
}