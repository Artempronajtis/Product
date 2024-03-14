package ru.netology.javaqa.Product.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {
    @Test
    public void testRemoveExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        repository.add(product1);
        repository.add(product2);

        repository.removeById(1);

        Product[] expectedProducts = {product2};
        assertArrayEquals(expectedProducts, repository.findAll());
    }

    @Test
    public void testRemoveNonExistingElement() {
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1, "Product 1", 100);
        Product product2 = new Product(2, "Product 2", 200);
        repository.add(product1);
        repository.add(product2);

        assertThrows(NotFoundException.class, () -> repository.removeById(3),
                "Expected NotFoundException was not thrown");
    }
}
