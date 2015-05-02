/*
 * Password Generator
 */
package structure;

import java.util.ArrayList;

/**
 *
 * @author Maxime BLAISE
 */
public class PasswordGenerator {
    
    /**
     * Generate a list of passwords with specific parameters.
     * 
     * @param number Number of passwords
     * @param size Size of one password
     * @param lower Lowercase allow
     * @param upper Uppercase allow
     * @param num Number allow
     * @param special Special character
     * @return List of passwords
     */
    public static ArrayList<String> generatePasswords(int number, int size, boolean lower, boolean upper, boolean num, boolean special) {
        // Initialize res
        ArrayList<String> listPasswords = new ArrayList<>();
        // Loop
        for(int i=0;i<number;i++) {
            listPasswords.add(generatePassword(size, lower, upper, num, special));
        }
        // Return
        return listPasswords;
    }

    /**
     * Generate one password with specific parameters.
     * 
     * @param size Size of one password
     * @param lower Lowercase allow
     * @param upper Uppercase allow
     * @param num Number allow
     * @param special Special character
     * @return List of passwords
     */
    private static String generatePassword(int size, boolean lower, boolean upper, boolean num, boolean special) {
        // Initialize password
        String password = "";
        // Loop 
        for(int i=0;i<size;i++) {
            password += generateCharacter(lower, upper, num, special);
        }
        // Return
        return password;
    }

    /**
     * Generate one character with specific parameters.
     * 
     * @param lower Lowercase allow
     * @param upper Uppercase allow
     * @param num Number allow
     * @param special Special character
     * @return List of passwords
     */
    public static String generateCharacter(boolean lower, boolean upper, boolean num, boolean special) {
        // Initialize a list
        ArrayList<Integer> listInteger = new ArrayList<>();
        // Check lower
        if(lower) {
            for(int i=97;i<=122;i++) {
                listInteger.add(i);
            }
        }
        // Check upper
        if(upper) {
            for(int i=65;i<=90;i++) {
                listInteger.add(i);
            }
        }
        // Check number
        if(num) {
            for(int i=48;i<=57;i++) {
                listInteger.add(i);
            }
        }
        // Check special
        if(special) {
            for(int i=33;i<=47;i++) {
                listInteger.add(i);
            }
            for(int i=58;i<=64;i++) {
                listInteger.add(i);
            }
            for(int i=91;i<=95;i++) {
                listInteger.add(i);
            }
            for(int i=123;i<=126;i++) {
                listInteger.add(i);
            }
        }
        // Random
        int i = (int) (Math.random() * listInteger.size());
        // Return
        return Character.toString((char)(int)listInteger.get(i));
    }
    
    public static void main(String[] args) {
        // Just letters
        System.out.println("Generate 5 passwords with letters : ");
        System.out.println("------------------------------------");
        generatePasswords(5, 20, true, true, false, false).stream().forEach((str) -> {
            System.out.println("\t"+str);
        });
        // Just numbers
        System.out.println("Generate 5 passwords with numbers : ");
        System.out.println("------------------------------------");
        generatePasswords(5, 20, false, false, true, false).stream().forEach((str) -> {
            System.out.println("\t"+str);
        });
        // Letter + numbers
        System.out.println("Generate 5 passwords with letters and numbers : ");
        System.out.println("------------------------------------------------");
        generatePasswords(5, 20, true, true, true, false).stream().forEach((str) -> {
            System.out.println("\t"+str);
        });
        // All characters
        System.out.println("Generate 5 passwords with all characters : ");
        System.out.println("-------------------------------------------");
        generatePasswords(5, 20, true, true, true, true).stream().forEach((str) -> {
            System.out.println("\t"+str);
        });
    }
}
