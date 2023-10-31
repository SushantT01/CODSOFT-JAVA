
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Grade Calculator!");
        
        int totalSubjects;
        do {
            System.out.print("Enter the total number of subjects: ");
            totalSubjects = scanner.nextInt();
        } while (totalSubjects <= 0);
        
        int totalMarks = 0;
        
        for (int i = 1; i <= totalSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int subjectMarks = scanner.nextInt();
            
            // Check if the entered marks are within a valid range (0-100).
            if (subjectMarks < 0 || subjectMarks > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                i--; // Decrement i to re-enter marks for the same subject.
            } else {
                totalMarks += subjectMarks;
            }
        }
        
        double averagePercentage = (double) totalMarks / (totalSubjects * 100) * 100;
        
        String grade = calculateGrade(averagePercentage);
        
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
        
        scanner.close();
    }

    // Function to calculate the grade based on the average percentage.
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }
}
