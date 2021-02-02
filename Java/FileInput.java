import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInput {

    public static void readFile(String path){
        try{
            File myFile = new File(path);
            StringBuilder sb = new StringBuilder();
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()){
                sb.append(scanner.nextLine() + "\n");
            }
            scanner.close();
            String myString = sb.toString();
            System.out.print(myString);
            
        }catch(FileNotFoundException e){
            System.out.println("Error: " + e);
        }
    }
    public static void main(String[] args) {
        readFile("Java/TestFile.txt");
    }
}
