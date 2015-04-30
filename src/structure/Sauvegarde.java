package structure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime BLAISE
 */
public class Sauvegarde {

    /**
     * Sauvegarde la liste de façon plus claire dans un autre fichier pour
     * risque.
     *
     * @param lp ListPass object
     * @param filename Name of the file
     */
    public static void sauvegardeTotale(ListPass lp, String filename) {
        try {
            try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
                // Loop
                Set set = lp.keySet();
                Iterator it = set.iterator();
                while (it.hasNext()) {
                    // Get key
                    String key = (String) it.next();
                    // Get value
                    Maxpass mp = lp.get(key);
                    // Print
                    pw.println(key + "=>" + mp.getLogin() + ";" + mp.getPassword());
                }
            }
        } catch (IOException ex) {
            System.out.println("Error: IOException for file " + filename);
        }
    }
}
