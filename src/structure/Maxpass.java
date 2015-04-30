/*
 * It's a structure with Login+Password
 */
package structure;

import java.io.Serializable;

/**
 *
 * @author Maxime BLAISE
 */
public class Maxpass implements Serializable {
    
    /**
     * Login (name or email)
     */
    private String login;
    
    /**
     * Password.
     */
    private String password;

    /**
     * Create a Maxpass with a specific login and password.
     * 
     * @param login Login
     * @param password Password
     */
    public Maxpass(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Maxpass{" + "login=" + login + ", password=" + password + '}';
    }
    
    
}
