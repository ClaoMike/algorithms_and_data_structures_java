import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileReader {
    private ArrayList<String> rows = new ArrayList<>();
    
    public TextFileReader(String filepath) {

         try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                rows.add(data);
            }
            
            myReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public ArrayList<String> getData() {
        return rows;
    }

    public void printDataAsAnArray() {
        System.out.println(rows);
    }

    public void printDataRowByRow() {
        int i = 1;
        for(String s: rows){
            System.out.println(String.valueOf(i++) + ". " + s);
        }
        
    }
}
