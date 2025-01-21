import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileReadWrite {

    public static ArrayList<String[]> fileToList(String pathName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("./txt/" + pathName));
        ArrayList<String[]> wordList = new ArrayList<>();

        while (sc.hasNext()) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), ":");
            String[] input = {st.nextToken().trim(), st.nextToken().trim()};
            wordList.add(input);
        }

        return wordList;
    }

    public static void changeLeftRight(String fileName) throws IOException {
        Scanner sc = new Scanner(new File("./txt/" + fileName));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./txt/reverse" + fileName)));
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] token = line.split(":");
            String newLine = token[1] + " : " + token[0] + "\n";
            bw.write(newLine);
            bw.flush();
        }
        bw.close();
    }

    public static void makeEnglishTXT(int wordCount) throws IOException {
        Scanner sc = new Scanner(new File("./txt/영단어.txt"));
        ArrayList<String> englishList = new ArrayList<>();
        ArrayList<String> koreanList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (isKor(line.charAt(0))) {
                englishList.add(line);
            } else {
                koreanList.add(line);
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("./txt/영단어.txt")));
        for (int i = 0; i < englishList.size(); i++) {
            bw.write(englishList.get(i) + " : " + koreanList.get(i) + "\n");
            bw.flush();
        }
    }

    private static boolean isKor(char c) {
        if (c >= 'a' && c <= 'z') {
            return false;
        } else {
            return true;
        }
    }
}
