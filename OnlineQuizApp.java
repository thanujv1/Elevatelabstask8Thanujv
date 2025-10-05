import java.util.*;

class Question {
    String questionText;
    String[] options;
    int correctAnswer; // index starting from 1

    public Question(String questionText, String[] options, int correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean isCorrect(int answer) {
        return answer == correctAnswer;
    }
}

public class OnlineQuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();

        // Adding questions
        questions.add(new Question("1. What is the capital of France?",
                new String[] { "1. Berlin", "2. Madrid", "3. Paris", "4. Rome" }, 3));

        questions.add(new Question("2. Which language runs in a web browser?",
                new String[] { "1. Java", "2. C", "3. Python", "4. JavaScript" }, 4));

        questions.add(new Question("3. Who developed Java?",
                new String[] { "1. Microsoft", "2. Sun Microsystems", "3. Google", "4. Oracle" }, 2));

        questions.add(new Question("4. What does OOP stand for?",
                new String[] { "1. Object-Oriented Programming", "2. Overloaded Object Programming",
                        "3. Oriented Object Process", "4. Other Option Provided" },
                1));

        int score = 0;

        // Quiz loop
        for (Question q : questions) {
            System.out.println("\n" + q.questionText);
            for (String option : q.options) {
                System.out.println(option);
            }

            System.out.print("Enter your answer (1-4): ");
            int answer = sc.nextInt();

            if (q.isCorrect(answer)) {
                System.out.println("✅ Correct!");
                score++;
            } else {
                System.out.println("❌ Wrong! Correct answer is option " + q.correctAnswer);
            }
        }

        // Display result
        System.out.println("\n🎯 Quiz Over!");
        System.out.println("Your final score: " + score + " out of " + questions.size());

        if (score == questions.size())
            System.out.println("🏆 Excellent! Perfect score!");
        else if (score >= questions.size() / 2)
            System.out.println("👍 Good job!");
        else
            System.out.println("📘 Keep practicing!");

        sc.close();
    }
}
