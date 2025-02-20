
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        scanner.nextLine(); // Add this line to consume newline
        System.out.println("You entered: " + numSubjects);

        String[] subjectNames = new String[numSubjects];
        double[] marks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter name of Subject " + (i + 1) + ": ");
            subjectNames[i] = scanner.nextLine();

            System.out.print("Enter marks for " + subjectNames[i] + " (out of 100): ");
            marks[i] = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
        }

        double totalMarks = 0;
        for (double mark : marks) {
            totalMarks += mark;
        }

        double averagePercentage = (totalMarks / numSubjects);

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("\nResults:");
        System.out.println("Subject-wise Marks:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println(subjectNames[i] + ": " + marks[i]);
        }
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
        scanner.close();

    }
}


