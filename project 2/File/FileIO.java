package File;
import java.io.*;
import java.util.Scanner;

public class FileIO {

    public static void saveInFile(String data) {
        try {
            File folder = new File("File");
            if(!folder.exists()) { folder.mkdir(); }
            File file = new File("File/data.txt");
            FileWriter writer = new FileWriter(file, false); 
            writer.write(data + "\n");
            writer.close();
        } catch(IOException e) {
            System.out.println("Cannot Write File");
        }
    }
    public static String readFromFile() {
        String content = "";
        try {
            File file = new File("File/data.txt");
            if (!file.exists()) { return "No data found."; }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                content += sc.nextLine() + "\n";
            }
            sc.close();
        } catch (Exception e) {
            return "Error reading file.";
        }
        return content;
    }
}