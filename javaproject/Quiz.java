
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
    private int correctAnswer;

    public Question(String question, List<String> options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }
}

public class Quiz {
    private List<Question> questions;
    private int score;
    private int currentQuestion;

    public Quiz() {
        questions = new ArrayList<>();
        score = 0;
        currentQuestion = 0;
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        for (currentQuestion = 0; currentQuestion < questions.size(); currentQuestion++) {
            Question question = questions.get(currentQuestion);
            System.out.println(question.getQuestion());

            for (int i = 0; i < question.getOptions().size(); i++) {
                System.out.println((i + 1) + ". " + question.getOptions().get(i));
            }

            System.out.print("Enter your answer (1-" + question.getOptions().size() + "): ");
            long startTime = System.currentTimeMillis();
            int answer = scanner.nextInt();
            long endTime = System.currentTimeMillis();

            if (endTime - startTime > 10000) {
                System.out.println("Time's up!");
            } else if (answer == question.getCorrectAnswer()) {
                score++;
                System.out.println("Correct!");
            } else {
                System.out.println("Incorrect. The correct answer was " + question.getCorrectAnswer());
            }
        }

        System.out.println("Quiz finished! Your final score is " + score + "/" + questions.size());
    }

    public static void main(String[] args) {
        Quiz quiz = new Quiz();

        List<String> options1 = new ArrayList<>();
        options1.add("JVM");
        options1.add("JRE");
        options1.add("JDK");
        options1.add("JDB");
        Question question1 = new Question("Which of the following is used to find and fix bugs in the Java programs?", options1, 4);
        quiz.addQuestion(question1);

        List<String> options2 = new ArrayList<>();
        options2.add("identifier");
        options2.add("identifier_");
        options2.add("1identifier");
        options2.add("identifier1");
        Question question2 = new Question("Which of these cannot be used for a variable name in Java?", options2, 3);
        quiz.addQuestion(question2);

        List<String> options3 = new ArrayList<>();
        options3.add("Object-oriented");
        options3.add("Use of pointers");
        options3.add("Portable");
        options3.add("Dynamic and Extensible");
        Question question3 = new Question("Which of the following is not a Java feature?", options3, 2);
        quiz.addQuestion(question3);

        List<String> options4 = new ArrayList<>();
        options4.add("Object");
        options4.add("int");
        options4.add("long");
        options4.add("void");
        Question question4 = new Question("What is the return type of the hashCode() method in the Object class?", options4, 2);
        quiz.addQuestion(question4);

        List<String> options5 = new ArrayList<>();
        options5.add("java.util package");
        options5.add("java.lang package");
        options5.add("java.awt package");
        options5.add("java.io package");
        Question question5 = new Question("Which package contains the Random class?", options5, 1);
        quiz.addQuestion(question5);

        quiz.startQuiz();
    }
}

