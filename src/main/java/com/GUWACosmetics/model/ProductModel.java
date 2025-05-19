package com.GUWACosmetics.model;

/**
 * Model class representing a Product.
 * Contains details such as id, name, shade, brand, stock, price, and image.
 * 
 * @author Aaditi Ghimire
 */
public class ProductModel {
    private int Id;
    private String Name;
    private String Shade;
    private String Brand;
    private int Stock;
    private int Price;
    private String image;

    /**
     * Constructor with id for existing products.
     * 
     * @param id    the unique product ID
     * @param name  the product name
     * @param shade the product shade
     * @param brand the product brand
     * @param stock the available stock quantity
     * @param price the price of the product
     * @param image the image URL or filename
     */
    public ProductModel(int id, String name, String shade, String brand, int stock, int price, String image) {
        super();
        Id = id;
        Name = name;
        Shade = shade;
        Brand = brand;
        Stock = stock;
        Price = price;
        this.image = image;
    }

    /**
     * Constructor without id, used for new products before database assignment.
     * 
     * @param name  the product name
     * @param shade the product shade
     * @param brand the product brand
     * @param stock the available stock quantity
     * @param price the price of the product
     * @param image the image URL or filename
     */
    public ProductModel(String name, String shade, String brand, int stock, int price, String image) {
        super();
        Name = name;
        Shade = shade;
        Brand = brand;
        Stock = stock;
        Price = price;
        this.image = image;
    }

    /**
     * Gets the product ID.
     * 
     * @return the product ID
     */
    public int getId() {
        return Id;
    }

    /**
     * Sets the product ID.
     * 
     * @param id the product ID to set
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Gets the product name.
     * 
     * @return the product name
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the product name.
     * 
     * @param name the product name to set
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Gets the product shade.
     * 
     * @return the product shade
     */
    public String getShade() {
        return Shade;
    }

    /**
     * Sets the product shade.
     * 
     * @param shade the product shade to set
     */
    public void setShade(String shade) {
        Shade = shade;
    }

    /**
     * Gets the product brand.
     * 
     * @return the product brand
     */
    public String getBrand() {
        return Brand;
    }

    /**
     * Sets the product brand.
     * 
     * @param brand the product brand to set
     */
    public void setBrand(String brand) {
        Brand = brand;
    }

    /**
     * Gets the stock quantity.
     * 
     * @return the stock quantity
     */
    public int getStock() {
        return Stock;
    }

    /**
     * Sets the stock quantity.
     * 
     * @param stock the stock quantity to set
     */
    public void setStock(int stock) {
        Stock = stock;
    }

    /**
     * Gets the product price.
     * 
     * @return the product price
     */
    public int getPrice() {
        return Price;
    }

    /**
     * Sets the product price.
     * 
     * @param price the product price to set
     */
    public void setPrice(int price) {
        Price = price;
    }

    /**
     * Gets the product image URL or filename.
     * 
     * @return the product image
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the product image URL or filename.
     * 
     * @param image the product image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
}
