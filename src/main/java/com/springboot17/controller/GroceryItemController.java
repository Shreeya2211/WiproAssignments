package com.springboot17.controller;

import com.springboot17.entity.GroceryItem;
import com.springboot17.service.GroceryItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery")
public class GroceryItemController 
{

    @Autowired
    private GroceryItemService service;

    @PostMapping
    public ResponseEntity<GroceryItem> createItem(@Valid @RequestBody GroceryItem item) 
    {
        return ResponseEntity.ok(service.createItem(item));
    }

    @GetMapping
    public List<GroceryItem> getAllItems() 
    {
        return service.getAllItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getItemById(@PathVariable Long id)
    {
        return service.getItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @Valid @RequestBody GroceryItem item)
    {
        return ResponseEntity.ok(service.updateItem(id, item));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) 
    {
        service.deleteItem(id);
        return ResponseEntity.ok("Item deleted with ID: " + id);
    }
}
