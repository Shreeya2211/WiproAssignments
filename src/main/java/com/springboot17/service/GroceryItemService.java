package com.springboot17.service;

import com.springboot17.entity.GroceryItem;
import com.springboot17.repository.GroceryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    private final GroceryItemRepository repository;

    public GroceryItemService(GroceryItemRepository repository) {
        this.repository = repository;
    }

    public List<GroceryItem> getAllItems() {
        return repository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return repository.findById(id);
    }

    public GroceryItem createItem(GroceryItem item) {
        return repository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem updatedItem) {
        return repository.findById(id)
            .map(item -> {
                item.setName(updatedItem.getName());
                item.setQuantity(updatedItem.getQuantity());
                item.setPrice(updatedItem.getPrice());
                return repository.save(item);
            }).orElseThrow(() -> new RuntimeException("Item not found"));
    }

    public void deleteItem(Long id) {
        repository.deleteById(id);
    }
}