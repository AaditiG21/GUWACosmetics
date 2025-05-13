package com.GUWACosmetics.service;

import com.GUWACosmetics.config.DbConfig;
import com.GUWACosmetics.model.ProductModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */
public class MakeupService {

    private Connection dbConn;

    public MakeupService() {
        try {
            this.dbConn = DbConfig.getDbConnection();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public Boolean addProduct(ProductModel productModel) {
        if (dbConn == null) {
            System.err.println("Database not connected");
            return null;
        }

        String insertQuery = "INSERT INTO product (product_name, product_shade, product_brand, product_stock, product_price) "
                           + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = dbConn.prepareStatement(insertQuery)) {
            stmt.setString(1, productModel.getName());
            stmt.setString(2, productModel.getShade());
            stmt.setString(3, productModel.getBrand());
            stmt.setInt(4, productModel.getStock());
            stmt.setInt(5, productModel.getPrice());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error adding product: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public List<ProductModel> getAllMakeupProducts() {
        List<ProductModel> products = new ArrayList<>();
        String query = "SELECT * FROM product";

        try (Statement stmt = dbConn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                ProductModel product = new ProductModel(
                    rs.getInt("product_id"),
                    rs.getString("product_name"),
                    rs.getString("product_shade"),
                    rs.getString("product_brand"),
                    rs.getInt("product_stock"),
                    rs.getInt("product_price")
                );
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println("Error retrieving products: " + e.getMessage());
            e.printStackTrace();
        }
        return products;
    }

    public boolean deleteProductById(int id) {
        String deleteQuery = "DELETE FROM product WHERE product_id = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(deleteQuery)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            System.err.println("Error deleting product: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
