
import java.util.UUID;
import mainpkg.UserType;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SRB Shakib
 */
public class User {
    private String name;
    private String id;
    private String password;
    private UserType userType;

    public User(String name, String id, String password, UserType userType) {
        this.name = name;
        this.id = id;
        this.password = password;
        this.userType = userType;
    }
    private String generateID() {
        // Generate a unique ID using UUID
        return UUID.randomUUID().toString();
    }

    private String generatePassword() {
        // Generate a random password
        // You can implement your logic to generate a password here
        // For simplicity, let's generate a random 8-character password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            int index = (int) (Math.random() * characters.length());
            password.append(characters.charAt(index));
        }
        return password.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", id=" + id + ", password=" + password + ", userType=" + userType + '}';
    }
    
    
}
