import java.util.Scanner;

public class StudentGrades {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        int[] grades = new int[5];
        boolean filled = false;

        while (true) {
            System.out.println("Welcome to the Student Grades! : ");
            System.out.println("1. Enter grades");
            System.out.println("2. Print grades ");
            System.out.println("Enter 1 or 2 (anything else to exit)");

            if (!input.hasNextInt()) {
                System.out.println("Invalid input");
                break;
            }   

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    fillGrades(grades);
                    filled = true;
                    break;
                case 2:
                    if (!filled) {
                        System.out.println("Please enter grades first");
                    } else printResults(grades);
                    break;
                default: return;

            }
        }
        System.out.println("Thank you for using our program.");
        input.close();
    }

    public static String calculateGradeCategory(int grade) {
        if (grade >= 90) {
            return "Excellent";
        } else if (grade >= 75) {
            return "Very Good";
        } else if (grade >= 60) {
            return "Good";
        } else if (grade >= 50) {
            return "Pass";
        } else return "Fail";
    }

    public static void fillGrades(int[] grades) {
        for (int i = 0; i < grades.length; i++) {

            int currentGrade;

            do {
                System.out.println("Please enter grade number " + (i + 1));
                currentGrade = input.nextInt();

                if (currentGrade < 0 || currentGrade > 100) {
                    System.out.println("Grade number must be between 0 and 100");
                }
            } while (currentGrade < 0 || currentGrade > 100);
            grades[i] = currentGrade;

        }
    }

    public static void printResults(int[] grades) {
        int sum=0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
            System.out.println(grades[i]);
            System.out.println(calculateGradeCategory(grades[i]));
        }
        System.out.println((double)sum / grades.length);
    }


}
