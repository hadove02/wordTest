import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Question.run(FileReadWrite.fileToList(FileReadWrite.PSYCHOLOGYEND));
    }
}