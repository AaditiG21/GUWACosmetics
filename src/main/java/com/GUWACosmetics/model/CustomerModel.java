package com.GUWACosmetics.model;

public class CustomerModel {

    private String firstName;
    private String lastName;
    private String userName;
    private String phonenumber;
    private String email;
    private String password;

    /**
     * Constructor for creating a CustomerModel with only username and password.
     * 
     * @param userName the username of the customer.
     * @param password the password of the customer.
     */
    public CustomerModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    /**
     * Constructor for creating a CustomerModel with full details.
     * 
     * @param firstName the first name of the customer.
     * @param lastName the last name of the customer.
     * @param userName the username of the customer.
     * @param phonenumber the phone number of the customer.
     * @param email the email address of the customer.
     * @param password the password of the customer.
     */
    public CustomerModel( String userName, String firstName, String lastName, String phonenumber, String email, String password) {
        super();
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phonenumber = phonenumber;
        this.email = email;
        this.password = password;
    }
    
   

    /**
     * Gets the first name of the customer.
     * 
     * @return the first name of the customer.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the customer.
     * 
     * @param firstName the first name to set for the customer.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the customer.
     * 
     * @return the last name of the customer.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the customer.
     * 
     * @param lastName the last name to set for the customer.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the username of the customer.
     * 
     * @return the username of the customer.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username of the customer.
     * 
     * @param userName the username to set for the customer.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the phone number of the customer.
     * 
     * @return the phone number of the customer.
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * Sets the phone number of the customer.
     * 
     * @param phonenumber the phone number to set for the customer.
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * Gets the email of the customer.
     * 
     * @return the email of the customer.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email of the customer.
     * 
     * @param email the email to set for the customer.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the password of the customer.
     * 
     * @return the password of the customer.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the customer.
     * 
     * @param password the password to set for the customer.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
