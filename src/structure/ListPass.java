package structure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime BLAISE
 */
public class ListPass extends HashMap<String, Maxpass> implements Serializable {

    /**
     * Filename in which we save all passwords.
     */
    public static String filename = "storedPassword.pmp";

    /**
     * Empty constructor which initialize empty map.
     */
    public ListPass() {
        super();
    }

    /**
     * Read a ListPass object from the "filename" file.
     *
     * @return ListPass object
     */
    public static ListPass readFromFile() {
        return readFromFile(filename);
    }

    /**
     * Read a ListPass object from a file.
     *
     * @param filename Name of the file
     * @return ListPass object
     */
    public static ListPass readFromFile(String filename) {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                return (ListPass) ois.readObject();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + filename + " not found.");
        } catch (IOException ex) {
            System.out.println("Error: IOException in file " + filename);
        } catch (ClassNotFoundException ex) {
            System.out.println("Erreur de classe.");
        }
        return null;
    }

    /**
     * Save into "filename" file.
     */
    public void save() {
        saveInFile(filename);
    }

    /**
     * Save the list in a specific file
     *
     * @param filename Name of the file
     */
    public void saveInFile(String filename) {
        try {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
                oos.writeObject(this);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListPass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ListPass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Print the HashMap on the Console.
     */
    protected void lister() {
        Set cles = this.keySet();
        Iterator it = cles.iterator();
        while (it.hasNext()) {
            // Get the key/value
            String cle = (String) it.next();
            Maxpass valeur = this.get(cle);
            // Print
            System.out.println(cle + " => " + valeur.getLogin() + " ; ********");
        }
    }

    /**
     * Get the password with the key.
     *
     * @param cle String
     * @return Password
     */
    public String getPass(String cle) {
        return this.get(cle).getPassword();
    }

    /**
     * Add a new entry in the map and save it.
     *
     * @param key Key
     * @param login Login
     * @param password Password
     */
    public void addAndSave(String key, String login, String password) {
        // Put on the map
        this.put(key, new Maxpass(login, password));
        // Save
        save();
    }

    /**
     * Delete a key and save the map.
     *
     * @param key Key
     */
    public void delAndSave(String key) {
        this.remove(key);
    }
}
