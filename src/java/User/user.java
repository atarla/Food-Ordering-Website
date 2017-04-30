/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;
import java.io.Serializable;

/**
 *
 * @author Pooja
 */
public class user implements Serializable {

    private String username;
    private String password;
    private String email;
    private String usertype;
    private String hash;
    private String salt;
    private String saltedHash;

    public user() {
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSaltedHash() {
        return saltedHash;
    }

    public void setSaltedHash(String saltedHash) {
        this.saltedHash = saltedHash;
    }
    
    public user(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public user(String username, String password, String email, String usertype) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.usertype = usertype;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

        public String getUserType() {
        return usertype;
    }

    public void setUserType(String usertype) {
        this.usertype = usertype;
    }

}
    
    

