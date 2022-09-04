import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    String filepath;
    File file;
    Scanner textScanner;

    public ReadFile(String filepath) throws FileNotFoundException {
        file = new File(filepath);
        textScanner = new Scanner(file);
    }
    public String readNextLine (){
        String line = textScanner.nextLine();
        return line;
    }
    public boolean fileHasText(){
        boolean hasText = textScanner.hasNext();
        return hasText;
    }
    public void ReadFiletoMenu() throws FileNotFoundException {
//        ReadFile rf = new ReadFile("C:\\Users\\kywahhhhhhh\\IdeaProjects\\arcteryxWarrantyApp\\src\\main\\resources" +
//                "\\Welcome");
        while (fileHasText()) {
            System.out.println(readNextLine());
    }
}
}
