package com.GUWACosmetics.util;

import java.util.regex.Pattern;
/**
 * LMU ID: 23048679
 * NAME: Aaditi Ghimire
 */

public class ValidationUtil {

    /**
     * Checks if the value is null or empty.
     *
     * @param value the string to check for null or empty.
     * @return true if the value is null or empty, false otherwise.
     */
    public static boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
    }

    /**
     * Validates the first and last name to allow only letters and spaces.
     * The name must be between 2 and 50 characters.
     *
     * @param name the name to validate.
     * @return true if the name is valid, false otherwise.
     */
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z\\s]{2,50}$");
    }

    /**
     * Validates the username to start with a letter, be alphanumeric, 
     * and have a length of 4 to 20 characters.
     *
     * @param username the username to validate.
     * @return true if the username is valid, false otherwise.
     */
    public static boolean isValidUsername(String username) {
        return username != null && username.matches("^[a-zA-Z][a-zA-Z0-9_]{3,19}$");
    }

    /**
     * Validates the phone number to ensure it is 10 digits long and starts with 98.
     *
     * @param phoneNumber the phone number to validate.
     * @return true if the phone number is valid, false otherwise.
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber != null && phoneNumber.matches("^98\\d{8}$");
    }

    /**
     * Validates the email to ensure it follows the standard email format.
     *
     * @param email the email address to validate.
     * @return true if the email is valid, false otherwise.
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    /**
     * Validates the password to ensure it is at least 8 characters long, contains 
     * at least one uppercase letter, one number, and one special character.
     *
     * @param password the password to validate.
     * @return true if the password is valid, false otherwise.
     */
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password != null && password.matches(passwordRegex);
    }

    /**
     * Checks if the password and confirm password fields match.
     *
     * @param password the original password.
     * @param confirmPassword the confirm password to compare with the original password.
     * @return true if the passwords match, false otherwise.
     */
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return password != null && password.equals(confirmPassword);
    }

    /**
     * Validates the stock value to ensure it is a valid integer between 0 and 999.
     *
     * @param s the stock value as a string.
     * @return true if the stock is valid, false otherwise.
     */
    public static boolean isValidStock(String s) {
        try {
            int stock = Integer.parseInt(s);
            return stock >= 0 && stock <= 999;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates the price value to ensure it is a valid integer between 0 and 999,999.
     *
     * @param s the price value as a string.
     * @return true if the price is valid, false otherwise.
     */
    public static boolean isValidPrice(String s) {
        try {
            int price = Integer.parseInt(s);
            return price >= 0 && price <= 999999;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
