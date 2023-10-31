

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class QuizApp {
    private static int score = 0;
    private static int questionNumber = 0;
    private static String[][] questions = {
        {"What is the capital of France?", "A) Paris", "B) London", "C) Berlin", "D) Rome", "A"},
        {"Which planet is known as the Red Planet?", "A) Venus", "B) Mars", "C) Jupiter", "D) Saturn", "B"},
        {"What is 2 + 2?", "A) 3", "B) 4", "C) 5", "D) 6", "B"}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quiz App!");
        System.out.println("You have 10 seconds to answer each question.\n");

        Timer timer = new Timer();

        for (int i = 0; i < questions.length; i++) {
            System.out.println("Question " + (i + 1) + ": " + questions[i][0]);
            for (int j = 1; j < 5; j++) {
                System.out.println(questions[i][j]);
            }

            System.out.print("Enter your choice (A/B/C/D): ");
            String userChoice = scanner.next();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! The correct answer is " + questions[questionNumber][5]);
                    questionNumber++;
                    if (questionNumber >= questions.length) {
                        displayResult();
                        timer.cancel();
                    }
                }
            }, 10000);

            if (userChoice.equalsIgnoreCase(questions[questionNumber][5])) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer is " + questions[questionNumber][5] + "\n");
            }
            questionNumber++;
        }

        // Ensure the timer thread finishes its task before ending the program.
        while (questionNumber < questions.length) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        displayResult();
        timer.cancel();
    }

    private static void displayResult() {
        System.out.println("Quiz completed!");
        System.out.println("Your Score: " + score + " out of " + questions.length);
    }
}
