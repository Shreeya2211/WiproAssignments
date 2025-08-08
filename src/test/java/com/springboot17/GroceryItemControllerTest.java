package com.springboot17;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot17.controller.GroceryItemController;
import com.springboot17.entity.GroceryItem;
import com.springboot17.service.GroceryItemService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroceryItemController.class)
public class GroceryItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @SuppressWarnings("removal")
	@MockBean
    private GroceryItemService service;

    @Autowired
    private ObjectMapper objectMapper;

    // 1️⃣ Test GET /api/grocery
    @Test
    void testGetAllItems() throws Exception {
        GroceryItem item1 = new GroceryItem();
        item1.setId(1L);
        item1.setName("Apple");
        item1.setQuantity(10);
        item1.setPrice(2.5);

        GroceryItem item2 = new GroceryItem();
        item2.setId(2L);
        item2.setName("Banana");
        item2.setQuantity(5);
        item2.setPrice(1.0);

        Mockito.when(service.getAllItems()).thenReturn(Arrays.asList(item1, item2));

        mockMvc.perform(get("/api/grocery"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Apple"))
                .andExpect(jsonPath("$[1].name").value("Banana"));
    }

    // 2️⃣ Test GET /api/grocery/{id}
    @Test
    void testGetItemById() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setId(1L);
        item.setName("Mango");
        item.setQuantity(3);
        item.setPrice(1.5);

        Mockito.when(service.getItemById(1L)).thenReturn(Optional.of(item));

        mockMvc.perform(get("/api/grocery/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Mango"));
    }

    // 3️⃣ Test POST /api/grocery
    @Test
    void testCreateItem() throws Exception {
        GroceryItem item = new GroceryItem();
        item.setName("Orange");
        item.setQuantity(4);
        item.setPrice(2.0);

        Mockito.when(service.createItem(any(GroceryItem.class))).thenReturn(item);

        mockMvc.perform(post("/api/grocery")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(item)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Orange"));
    }

    // 4️⃣ Test PUT /api/grocery/{id}
    @Test
    void testUpdateItem() throws Exception {
        GroceryItem updatedItem = new GroceryItem();
        updatedItem.setId(1L);
        updatedItem.setName("Updated Apple");
        updatedItem.setQuantity(15);
        updatedItem.setPrice(3.0);

        Mockito.when(service.updateItem(eq(1L), any(GroceryItem.class))).thenReturn(updatedItem);

        mockMvc.perform(put("/api/grocery/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedItem)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Updated Apple"));
    }

    // 5️⃣ Test DELETE /api/grocery/{id}
    @Test
    void testDeleteItem() throws Exception {
        Mockito.doNothing().when(service).deleteItem(1L);

        mockMvc.perform(delete("/api/grocery/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Item deleted with ID: 1"));
    }
}
