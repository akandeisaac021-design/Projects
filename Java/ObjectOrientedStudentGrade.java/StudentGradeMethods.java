public class Student{

    String studentName;
    int[] subjectScores;
    int totalScore;
    double averageScore;
    int position;

    Student(String studentName, int[] subjectScores){
        this.studentName =studentName;
        this.subjectScores =subjectScores;
        calculateTotalAndAverage(); // Initialize calculations immediately
    }

    private void calculateTotalAndAverage(){
        int sumOfScores =0;
        for (int score :subjectScores){
            sumOfScores +=score;
        }
        this.totalScore =sumOfScores;
        this.averageScore =(double) sumOfScores / subjectScores.length;
    }

    public static void calculatePositions(Student[] studentRecords){
        for (int studentRecordsIndex =0; studentRecordsIndex < studentRecords.length; studentRecordsIndex++){
            int rank =1;
            for (int comparedRecordindex =0; comparedRecordindex <studentRecords.length; comparedRecordindex++){
                if (studentRecords[comparedRecordindex].totalScore > studentRecords[studentRecordsIndex].totalScore){
                    rank++;
                }
            }
            studentRecords[studentRecordsIndex].position = rank;
        }
    }

    public static void printReport(Student[] studentRecords, String[] subjectNames){
        System.out.println("===================================================================");
        System.out.print("POS\tSTUDENT\t\t");
        for (String subjectName : subjectNames){
            System.out.print(subjectName + "\t");
        }
        System.out.println("TOT\tAVG");

        for (Student student : studentRecords){
            System.out.print(student.position + "\t" + student.studentName + "\t\t");
            for (int score :student.subjectScores){
                System.out.print(score + "\t");
            }
            System.out.printf("%d\t%.2f%n", student.totalScore, student.averageScore);
        }
    }
}

