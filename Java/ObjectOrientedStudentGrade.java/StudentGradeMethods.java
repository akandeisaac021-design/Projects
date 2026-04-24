import java.util.Scanner;

public class StudentGradeMethods{

    String studentName;
    int[] subjectScores;
    int totalScore;
    double averageScore;
    int position;

    Student(String studentName, int[] subjectScores){
        this.studentName = studentName;
        this.subjectScores = subjectScores;
        calculateTotalAndAverage();
    }


    public static void calculateTotalAndAverage() {
        int sumOfScores = 0;

        for (int subjectScore : subjectScores) {
            sumOfScores += subjectScore;
        }
        this.totalScore = sumOfScores;
        this.averageScore = (double) sumOfScores / subjectScores.length;
    }


    public static void calculatePositions(Student[] studentRecords){
        for (int currentStudentIndex = 0; currentStudentIndex < studentRecords.length; currentStudentIndex++) {
            int rank =1;

            for (int comparisonStudentIndex = 0; comparisonStudentIndex < studentRecords.length; comparisonStudentIndex++) {

                if (studentRecords[comparisonStudentIndex].totalScore > studentRecords[currentStudentIndex].totalScore) {
                    rank++;
                }
            }

            studentRecords[currentStudentIndex].position = rank;
        }
    }


    public static void printReport(Student[] studentRecords, String[] subjectNames) {
        System.out.println("===================================================================");
        System.out.print("Position\tStudent Name\t");
        for (String subjectName : subjectNames) {
            System.out.print(subjectName + "\t");
        }
        System.out.println("Total\tAverage");

        for (Student studentRecord : studentRecords) {
            System.out.print(studentRecord.position + "\t\t" + studentRecord.studentName + "\t");

            for (int subjectScore : studentRecord.subjectScores) {
                System.out.print(subjectScore + "\t");
            }

            System.out.printf("%d\t%.2f%n", studentRecord.totalScore, studentRecord.averageScore);
        }
    }
}
