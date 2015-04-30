package structure;

import java.util.Scanner;

/**
 *
 * @author Maxime BLAISE
 */
public class Console {

    /**
     * ListPass object used in the program.
     */
    public static ListPass lp;

    /**
     * Scanner in order to read user line.
     */
    public static Scanner sc = new Scanner(System.in);

    /**
     * Allow to read and write the clipboard
     */
    public static ModifPressPap mpp = new ModifPressPap();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        initListPass();
        runAutomate();
    }

    /**
     * Initialize HashMap used during the program.
     */
    private static void initListPass() {
        System.out.println("Try to init ListPass object from " + ListPass.filename + " ... ");
        lp = ListPass.readFromFile();
        if (lp == null) {
            System.out.print("Initialize new empty map instead ... ");
            lp = new ListPass();
            System.out.println("Done.");
        } else {
            System.out.println("OK");
        }
    }

    /**
     * Automate.
     */
    private static void runAutomate() {
        // Ask for a line
        System.out.print("Console:$ ");
        String line = sc.nextLine();
        // Loop
        while (!line.equals("exit")) {
            switch (line) {
                case "ls":
                    lp.lister();
                    break;
                case "add":
                    System.out.print("Key => ");
                    String key = sc.nextLine();
                    System.out.print("Login => ");
                    String login = sc.nextLine();
                    System.out.print("Password => ");
                    String password = sc.nextLine();
                    lp.addAndSave(key, login, password);
                    break;
                default:
                    String[] lines = line.split(" ");
                    switch (lines[0]) {
                        case "getl":
                            if (lines.length >= 2) {
                                Maxpass mp = lp.get(lines[1]);
                                System.out.println(mp);
                                mpp.setClipboardContents(mp.getLogin());
                            }
                            break;
                        case "getp":
                            if (lines.length >= 2) {
                                Maxpass mp = lp.get(lines[1]);
                                System.out.println(mp);
                                mpp.setClipboardContents(mp.getPassword());
                            }
                            break;
                        case "del":
                            if (lines.length >= 2) {
                                lp.delAndSave(lines[1]);
                            }
                            break;
                    }
                    break;
            }
            // Ask for new line
            System.out.print("Console:$ ");
            line = sc.nextLine();
        }
    }

}
