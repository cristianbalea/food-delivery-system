package DataAccess;

import java.io.PrintWriter;

public class FileWriter {
    /**
     * Metoda pentru scrierea in fisier a facturilor pentru comenzi si a rapoartelor.
     *
     * @param filename
     * @param text
     */
    public static void write(String filename, String text) {
        try {
            PrintWriter printWriter = new PrintWriter("C:\\Users\\balea\\Documents\\Facultate\\TP\\PT2022_30221_Balea_Cristian_Constantin_Assignment_4\\" + filename);
            printWriter.write(text);
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
