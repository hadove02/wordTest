import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {
    final static int ANSWER = 0, QUESTION = 1;

    public static void run(ArrayList<String[]> wordList) {
        while (!wordList.isEmpty()) {
            wordList = randomQuestion(wordList);
        }
    }

    private static boolean question(String[] question, Scanner sc) {
        System.out.print(question[QUESTION] + " > ");
        String answer = sc.nextLine();

        if (answer.equals(question[ANSWER])) {
            System.out.println("정답!");
            return true;
        } else {
            System.out.println(question[ANSWER]);
            return false;
        }
    }

    private static ArrayList<String[]> randomQuestion(ArrayList<String[]> wordList) {
        ArrayList<String[]> incorrectList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();
        boolean[] duplication = new boolean[wordList.size()];

        int questionNum = 0;
        int incorrectNum = 0;
        for (int i = 0; i < wordList.size(); i++) {
            int randomIndex;
            do {
                randomIndex = rnd.nextInt(wordList.size());
            } while (duplication[randomIndex]);
            if (!question(wordList.get(randomIndex), sc)) {
                incorrectList.add(wordList.get(randomIndex));
                incorrectNum++;
            }
            duplication[randomIndex] = true;
            questionNum++;
        }
        System.out.println("(" + (questionNum - incorrectNum) + "/" + questionNum + ")");

        return incorrectList;
    }
}
