package com.GUWACosmetics.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.GUWACosmetics.config.DbConfig;
import com.GUWACosmetics.model.CustomerModel;

/**
 * ProfileService handles the business logic required for managing
 * customer profiles in the GUWACosmetics application.
 *
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */
public class ProfileService {

	private Connection dbConn;
	private boolean isConnectionError = false;
    /**
     * Constructs a ProfileService object and initializes a database
     * connection using DbConfig.
     * @param True 
     */
	public ProfileService() {
		try {
			dbConn = DbConfig.getDbConnection();
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			isConnectionError = true;
		}
	}
   
    /**
     * Retrieves a customer's profile by their username.
     *
     * @param userName The username of the customer.
     * @return CustomerModel object containing customer details, or null if not found.
     */
    public CustomerModel getCustomerByUsername(String userName) {
        CustomerModel customer = null;
        String query = "SELECT UserName, First_Name, Last_Name, Phone_Number, Email, Password FROM user WHERE UserName = ?";

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                customer = new CustomerModel(
                    rs.getString("UserName"),
                    rs.getString("First_Name"),
                    rs.getString("Last_Name"),
                    rs.getString("Phone_Number"),
                    rs.getString("Email"),
                    rs.getString("Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customer;
    }

    /**
     * Updates a customer's profile in the database.
     *
     * @param userName          The username of the customer.
     * @param firstName         The updated first name.
     * @param lastName          The updated last name.
     * @param phoneNumber       The updated phone number.
     * @param email             The updated email address.
     * @param password          (Unused parameter - can be removed if not used)
     * @param encryptedPassword The encrypted password to update. If null or empty, password will not be updated.
     * @return true if the profile was updated successfully, false otherwise.
     */
    public boolean updateUserProfile(String userName, String firstName, String lastName,
                                     String phoneNumber, String email, String password, String encryptedPassword) {
        String query;
        boolean includePassword = encryptedPassword != null && !encryptedPassword.isEmpty();

        if (includePassword) {
            query = "UPDATE user SET First_Name = ?, Last_Name = ?, Phone_Number = ?, Email = ?, Password = ? WHERE UserName = ?";
        } else {
            query = "UPDATE user SET First_Name = ?, Last_Name = ?, Phone_Number = ?, Email = ? WHERE UserName = ?";
        }

        try (PreparedStatement stmt = dbConn.prepareStatement(query)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, phoneNumber);
            stmt.setString(4, email);

            if (includePassword) {
                stmt.setString(5, encryptedPassword);
                stmt.setString(6, userName);
            } else {
                stmt.setString(5, userName);
            }

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
