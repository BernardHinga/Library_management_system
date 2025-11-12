package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class User {
    private String userName;
    private String email;
    private String password;
    private List<String> borrowedResources;
    public String file = "src/Data/user_list.csv";

//    Default constructor
    public User() {}

//    Constructor
    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

//    Getters
    public String getUserName() {return userName;}
    public String getEmail() {return email;}
    public String getPassword() {return password;}

//    Find user by the username
    public User getUser(String user, String filePath) {
        String line;
        String splitBy = ","; // CSV uses commas

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy);
                String username = data[0];
                String email = data[1];
                String password = data[2];

                //Example: add user to system or print
                if (username.equalsIgnoreCase(user)) {
                    return new User(username, email, password);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        if user isn't found
        return null;
    }

//    User Login
    public boolean login(String user_name, String pass) {
        User loginUser = getUser(user_name, file);
        if (loginUser == null) {
            System.out.println("User not found!");
            return false;
        }

        if (loginUser.password.equals(pass)) {
            System.out.println("User successfully logged in. Welcome " + loginUser.userName);
            return true;
        }else {
            System.out.println("Incorrect password. Please Try again!");
            return false;
        }
    }

    //borrowing resources
    public void borrowResource(String resource) {

    }

    //returning resources
    public void returnResource(String resource) {

    }

    //check borrowed items for a user
    public void viewBorrowedResources() {

    }
}
