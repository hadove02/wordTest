import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReadWrite {
    static final String COMPUTER_GRAPHICS = "컴퓨터 그래픽스.txt";
    static final String GLUT_FUNCTION = "glut 함수.txt";
    static final String PSYCHOLOGYMIDDLE = "인간과 심리.txt";
    static final String PSYCHOLOGYEND = "인간과 심리 기말.txt";
    public static ArrayList<String[]> fileToList(String pathName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./txt/"+pathName));
        ArrayList<String[]> wordList = new ArrayList<>();

        while (sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
            String[] input = {st.nextToken().trim(), st.nextToken().trim()};
            wordList.add(input);
        }

        return wordList;
    }
}
