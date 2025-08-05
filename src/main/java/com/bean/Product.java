package com.bean;

public class Product {
    private String productCode;
    private String productName;
    private String productCategory;
    private double productPrice;
    private int productQuantity;

    // Constructors
    public Product() {}

    public Product(String productCode, String productName, String productCategory, double productPrice, int productQuantity) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
    }

    // Getters & Setters
    public String getProductCode()
    { 
    	return productCode;
    	}
    public void setProductCode(String productCode)
    { 
    	this.productCode = productCode;
    	}

    public String getProductName()
    { 
    	return productName;
    	}
    public void setProductName(String productName)
    { 
    	this.productName = productName;
    }

    public String getProductCategory()
    { 
    	return productCategory;
    	}
    public void setProductCategory(String productCategory)
    { 
    	this.productCategory = productCategory;
    	}

    public double getProductPrice()
    { 
    	return productPrice;
    	}
    public void setProductPrice(double productPrice)
    { 
    	this.productPrice = productPrice;
    	}

    public int getProductQuantity() 
    { 
    	return productQuantity;
    	}
    public void setProductQuantity(int productQuantity) 
    { 
    	this.productQuantity = productQuantity; 
    	}
}
