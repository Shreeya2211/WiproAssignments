package com.springboot17;

import com.springboot17.entity.GroceryItem;
import com.springboot17.repository.GroceryItemRepository;
import com.springboot17.service.GroceryItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GroceryItemServiceTest {

    @Mock
    private GroceryItemRepository repository;

    @InjectMocks
    private GroceryItemService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // 1️⃣ Test createItem
    @Test
    void testCreateItem() {
        GroceryItem item = new GroceryItem();
        item.setName("Apple");
        item.setQuantity(10);
        item.setPrice(2.5);

        when(repository.save(item)).thenReturn(item);

        GroceryItem result = service.createItem(item);

        assertEquals("Apple", result.getName());
        verify(repository, times(1)).save(item);
    }

    // 2️⃣ Test getAllItems
    @Test
    void testGetAllItems() {
        GroceryItem item1 = new GroceryItem();
        item1.setName("Apple");

        GroceryItem item2 = new GroceryItem();
        item2.setName("Banana");

        when(repository.findAll()).thenReturn(Arrays.asList(item1, item2));

        List<GroceryItem> items = service.getAllItems();

        assertEquals(2, items.size());
        assertEquals("Apple", items.get(0).getName());
        verify(repository, times(1)).findAll();
    }

    // 3️⃣ Test getItemById
    @Test
    void testGetItemById() {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        item.setName("Mango");

        when(repository.findById(1L)).thenReturn(Optional.of(item));

        Optional<GroceryItem> result = service.getItemById(1L);

        assertEquals("Mango", result.get().getName());
        verify(repository, times(1)).findById(1L);
    }

    // 4️⃣ Test updateItem
    @Test
    void testUpdateItem() {
        GroceryItem existingItem = new GroceryItem();
        existingItem.setId(1L);
        existingItem.setName("Old Apple");
        existingItem.setQuantity(5);
        existingItem.setPrice(1.5);

        GroceryItem updatedItem = new GroceryItem();
        updatedItem.setName("New Apple");
        updatedItem.setQuantity(10);
        updatedItem.setPrice(2.5);

        when(repository.findById(1L)).thenReturn(Optional.of(existingItem));
        when(repository.save(any(GroceryItem.class))).thenReturn(updatedItem);

        GroceryItem result = service.updateItem(1L, updatedItem);

        assertEquals("New Apple", result.getName());
        assertEquals(10, result.getQuantity());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(existingItem);
    }

    // 5️⃣ Test deleteItem
    @Test
    void testDeleteItem() {
        doNothing().when(repository).deleteById(1L);

        service.deleteItem(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
