import java.util.Arrays;
import java.util.Scanner;

public class StudentGradeOOP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade System (OOP Version) ===");
        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        scanner.nextLine();

        String[] subjectNames = new String[numberOfSubjects];
        for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {
            System.out.print("Enter subject name: ");
            subjectNames[subjectIndex] = scanner.nextLine();
        }

        Student[] studentRecords = new Student[numberOfStudents];

        for (int studentIndex = 0; studentIndex < numberOfStudents; studentIndex++) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();

            int[] subjectScores = new int[numberOfSubjects];
            for (int subjectIndex = 0; subjectIndex < numberOfSubjects; subjectIndex++) {
                System.out.print("Enter score for " + subjectNames[subjectIndex] + ": ");
                int subjectScore = scanner.nextInt();

                while (subjectScore < 0 || subjectScore > 100) {
                    System.out.println("Invalid score. Please enter between 0 and 100: ");
                    subjectScore = scanner.nextInt();
                }

                subjectScores[subjectIndex] = subjectScore;
            }
            scanner.nextLine();

            studentRecords[studentIndex] = new Student(studentName, subjectScores);
        }

        // Logic calls
        Student.calculatePositions(studentRecords);
        Student.printReport(studentRecords, subjectNames);
    }
}

