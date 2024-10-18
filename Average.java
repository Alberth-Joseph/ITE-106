import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
		System.out.println("How many students are in your class?");
        int studentNum = input.nextInt();
        input.nextLine();
        
		String[] names = new String[studentNum];
        int[][] scores = new int[studentNum][3];

        for (int count = 0; count < studentNum; count++) {
            System.out.print("Name of Student " + (count + 1) + ": ");
            names[count] = input.nextLine();
            scores[count] = askForScores(input, names[count]);
        }

        System.out.println("\nStudent Grades:");
        for (int count = 0; count < studentNum; count++) {
            double average = calculateAverage(scores[count]);
            char grade = assignLetterGrade(average);
            System.out.printf("%s: %.2f (%c)\n", names[count], average, grade);
        }

        input.close();
    }

    public static int[] askForScores(Scanner input, String studentName) {
        int[] scores = new int[3];
        System.out.println("Enter the scores for " + studentName + ":");
        for (int i = 0; i < 3; i++) {
            System.out.print("Score " + (i + 1) + ": ");
            scores[i] = input.nextInt();
        }
        input.nextLine();
        return scores;
    }

    public static double calculateAverage(int[] scores) {
        int total = 0;
        for (int score : scores) {
            total += score;
        }
        return total / (double) scores.length;
    }

    public static char assignLetterGrade(double average) {
        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else if (average >= 60) return 'D';
        else return 'F';
    }
}