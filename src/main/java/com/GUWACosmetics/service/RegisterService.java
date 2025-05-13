package com.GUWACosmetics.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.GUWACosmetics.config.DbConfig;
import com.GUWACosmetics.model.CustomerModel;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */
public class RegisterService {
	private Connection dbConn;
	
	public RegisterService() {
		try {
			this.dbConn = DbConfig.getDbConnection();
			} 
		catch (SQLException |ClassNotFoundException ex) {
			System.err.println("Database connection error: " + ex.getMessage());
			ex.printStackTrace();
			} 
		}
	
	public Boolean registerCustomer(CustomerModel customerModel) {
		if (dbConn == null)
		{
			System.err.println("Database did not connect");
			return null;
			}
		
		String insertQuery = "INSERT INTO user (First_Name,Last_Name,UserName,Phone_Number,Email,Password) "
		+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {
			
			insertStmt.setString(1, customerModel.getFirstName());
			insertStmt.setString(2, customerModel.getLastName());
			insertStmt.setString(3, customerModel.getUserName());
			insertStmt.setString(4, customerModel.getPhonenumber());
			insertStmt.setString(5, customerModel.getEmail());
			insertStmt.setString(6, customerModel.getPassword());
			
			return insertStmt.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.err.println("Error during customer registration: " + e.getMessage());
			e.printStackTrace();
			return null;
			}
		}
	}