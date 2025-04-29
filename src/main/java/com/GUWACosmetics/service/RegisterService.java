package com.GUWACosmetics.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.GUWACosmetics.config.DbConfig;
import com.GUWACosmetics.model.CustomerModel;

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
		
		String insertQuery = "INSERT INTO customer (first_Name, last_Name, username, phone_Number,email,password) "
				+ ""+ "VALUES (?, ?, ?, ?, ?, ?)";
		try (PreparedStatement insertStmt = dbConn.prepareStatement(insertQuery)) {
			/* Fetch program ID
programStmt.setString(1, studentModel.getProgram().getName());
ResultSet result = programStmt.executeQuery();
int programId = result.next() ? result.getInt("program_id") : 1;*/
			// Insert customer details
			insertStmt.setString(1, customerModel.getFirstName());
			insertStmt.setString(2, customerModel.getLastName());
			insertStmt.setString(3, customerModel.getUserName());
			insertStmt.setString(4, customerModel.getPhonenumber());
			insertStmt.setString(6, customerModel.getEmail());
			insertStmt.setString(7, customerModel.getPassword());
			
			return insertStmt.executeUpdate() > 0;
			
		} catch (SQLException e) {
			System.err.println("Error during customer registration: " + e.getMessage());
			e.printStackTrace();
			return null;
			}
		}
	}