package com.GUWACosmetics.model;

public class ProductModel {
    private int Id;
    private String Name;
    private String Shade;
    private String Brand;
    private int Stock;
    private int Price;

    /**
     * Constructor for creating a ProductModel with full details including ID.
     * 
     * @param id the ID of the product.
     * @param name the name of the product.
     * @param shade the shade of the product.
     * @param brand the brand of the product.
     * @param stock the stock quantity of the product.
     * @param price the price of the product.
     */
    public ProductModel(int id, String name, String shade, String brand, int stock, int price) {
        super();
        Id = id;
        Name = name;
        Shade = shade;
        Brand = brand;
        Stock = stock;
        Price = price;
    }

    /**
     * Constructor for creating a ProductModel without the ID (used for new products).
     * 
     * @param name the name of the product.
     * @param shade the shade of the product.
     * @param brand the brand of the product.
     * @param stock the stock quantity of the product.
     * @param price the price of the product.
     */
    public ProductModel(String name, String shade, String brand, int stock, int price) {
        super();
        Name = name;
        Shade = shade;
        Brand = brand;
        Stock = stock;
        Price = price;
    }

    /**
     * Gets the name of the product.
     * 
     * @return the name of the product.
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the product.
     * 
     * @param name the name to set for the product.
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Gets the shade of the product.
     * 
     * @return the shade of the product.
     */
    public String getShade() {
        return Shade;
    }

    /**
     * Sets the shade of the product.
     * 
     * @param shade the shade to set for the product.
     */
    public void setShade(String shade) {
        Shade = shade;
    }

    /**
     * Gets the brand of the product.
     * 
     * @return the brand of the product.
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * Sets the brand of the product.
     * 
     * @param brand the brand to set for the product.
     */
    public void setBrand(String brand) {
        Brand = brand;
    }

    /**
     * Gets the stock quantity of the product.
     * 
     * @return the stock quantity of the product.
     */
    public int getStock() {
        return Stock;
    }

    /**
     * Sets the stock quantity of the product.
     * 
     * @param stock the stock quantity to set for the product.
     */
    public void setStock(int stock) {
        Stock = stock;
    }

    /**
     * Gets the price of the product.
     * 
     * @return the price of the product.
     */
    public int getPrice() {
        return Price;
    }

    /**
     * Sets the price of the product.
     * 
     * @param price the price to set for the product.
     */
    public void setPrice(int price) {
        Price = price;
    }

    /**
     * Gets the ID of the product.
     * 
     * @return the ID of the product.
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets the ID of the product.
     * 
     * @param id the ID to set for the product.
     */
    public void setId(int id) {
        Id = id;
    }
}
