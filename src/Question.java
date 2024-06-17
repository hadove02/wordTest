import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {
    final static int ANSWER = 0, QUESTION = 1;

    public static void sequenceQuestion(ArrayList<String[]> data) {
        ArrayList<String[]> wrongList = new ArrayList<>();
        for (String[] sequence : data) {
            if (!sequenceQuestionOne(sequence)) {
                wrongList.add(sequence);
            }
        }

        if (!wrongList.isEmpty()) {
            sequenceQuestion(wrongList);
        }
    }

    private static boolean sequenceQuestionOne(String[] sequence) {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        boolean[] rndIndex = new boolean[sequence.length];
        boolean isCorrect = true;

        System.out.println(sequence[0]);

        System.out.print("랜덤 개수 선택 (최대 개수 : " + (sequence.length - 1) + ")> ");
        int rndAmount = Integer.parseInt(new Scanner(System.in).nextLine());


        if (rndAmount > sequence.length - 1) {
            System.out.print("랜덤 개수 다시 선택 (최대 개수 : " + (sequence.length - 1) + ")> ");
            rndAmount = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < rndAmount; ) {
            int index = rnd.nextInt(sequence.length - 1) + 1;
            if (!rndIndex[index]) {
                rndIndex[index] = true;
                i++;
            }
        }

        for (int i = 1; i < sequence.length; i++) {
            if (!rndIndex[i]) {
                System.out.print(" " + sequence[i] + " ");
            } else {
                System.out.print(" [     ] ");
            }
        }
        System.out.println();

        int index = 0;
        for (int i = 0; i < rndAmount; i++) {
            System.out.print((i + 1) + " > ");
            String answer = sc.nextLine();
            while (!rndIndex[index]) {
                index++;
            }
            if (sequence[index].equals(answer)) {
                System.out.println("정답");
            } else {
                System.out.println(sequence[index]);
                isCorrect = false;
            }
            index++;
        }
        return isCorrect;
    }

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
