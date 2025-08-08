package com.springboot17.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
public class GroceryItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{grocery.name.notblank}")
    private String name;

    @Min(value = 1, message = "{grocery.quantity.min}")
    private int quantity;

    @Min(value = 1, message = "{grocery.price.min}")
    private double price;

    // Getters and Setters
    public Long getId()
    { 
    	return id;
    	}
    public void setId(Long id)
    { 
    	this.id = id;
    	}

    public String getName() 
    { 
    	return name; 
    	}
    public void setName(String name)
    { 
    	this.name = name;
    	}

    public int getQuantity()
    { 
    	return quantity;
    	}
    public void setQuantity(int quantity) 
    { 
    	this.quantity = quantity;
    	}

    public double getPrice()
    { 
    	return price;
    	}
    public void setPrice(double price) 
    { 
    	this.price = price;
    	}
}
