package com.springboot17;

import com.springboot17.entity.GroceryItem;
import com.springboot17.repository.GroceryItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class GroceryItemIntegrationTest {

    @Autowired
    private GroceryItemRepository repository;

    // 1️ Test Create and Retrieve
    @Test
    void testCreateAndFindItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Orange");
        item.setQuantity(10);
        item.setPrice(5.0);

        GroceryItem saved = repository.save(item);
        GroceryItem found = repository.findById(saved.getId()).orElse(null);

        assertNotNull(found);
        assertEquals("Orange", found.getName());
        assertEquals(10, found.getQuantity());
    }

    // 2️ Test Update
    @Test
    void testUpdateItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");
        item.setQuantity(5);
        item.setPrice(2.0);

        GroceryItem saved = repository.save(item);

        // Update
        saved.setName("Green Apple");
        saved.setQuantity(7);
        repository.save(saved);

        GroceryItem updated = repository.findById(saved.getId()).orElse(null);

        assertNotNull(updated);
        assertEquals("Green Apple", updated.getName());
        assertEquals(7, updated.getQuantity());
    }

    // 3️ Test Delete
    @Test
    void testDeleteItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Banana");
        item.setQuantity(3);
        item.setPrice(1.5);

        GroceryItem saved = repository.save(item);
        Long id = saved.getId();

        repository.deleteById(id);

        assertFalse(repository.findById(id).isPresent());
    }

    // 4️ Test Get All
    @Test
    void testGetAllItems() {
        GroceryItem item1 = new GroceryItem();
        item1.setName("Mango");
        item1.setQuantity(6);
        item1.setPrice(3.5);

        GroceryItem item2 = new GroceryItem();
        item2.setName("Grapes");
        item2.setQuantity(8);
        item2.setPrice(4.0);

        repository.save(item1);
        repository.save(item2);

        List<GroceryItem> items = repository.findAll();
        assertEquals(2, items.size());
    }
}
