import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //FileReadWrite.makeEnglishTXT(44);
        //FileReadWrite.changeLeftRight(TextName.ENGLISHWORD);
        Question.run(FileReadWrite.fileToList(TextName.ENGLISHWORD));
    }
}
