import java.util.Scanner;

public class MockExam2 {

    static Scanner input = new Scanner(System.in);

    static final int YEARS = 5;
    static final double RATE = 0.039; // 3.9%

    public static void main(String[] args) {

        int[] investments = new int[6];
        boolean filled = false;

        while (true) {
            System.out.println("Welcome to the Investments program!");
            System.out.println("Available options:");
            System.out.println("1. Enter the initial amount of money for 6 investments and store them inside an array");
            System.out.println("2. Calculate and print the total amounts for each investment of the array");
            System.out.print("Enter 1 or 2 (or anything else to exit): ");

            if (!input.hasNextInt()) {
                break; // anything else exits
            }

            int choice = input.nextInt();

            if (choice == 1) {
                fillArrayInvestments(investments);
                filled = true;
            } else if (choice == 2) {
                if (!filled) {
                    System.out.println("Please enter the 6 investments first (choose option 1).");
                } else {
                    calculateAndPrintInvestments(investments, YEARS, RATE);
                }
            } else {
                break;
            }
        }

        System.out.println("Goodbye!");
        input.close();
    }

    // Methods
    public static double invest(int amount, int years, double rate) {
        return amount * (1 + (years * rate));
    }

    public static void fillArrayInvestments(int[] investments) {
        for (int i = 0; i < investments.length; i++) {
            int value;
            do {
                System.out.print("Enter investment #" + (i + 1) + " (positive integer): ");
                while (!input.hasNextInt()) {
                    System.out.print("Invalid input. Enter a positive integer: ");
                    input.next(); // discard non-int token
                }
                value = input.nextInt();
            } while (value <= 0);

            investments[i] = value;
        }
    }

    public static void calculateAndPrintInvestments(int[] investments, int years, double rate) {
        for (int i = 0; i < investments.length; i++) {
            double result = invest(investments[i], years, rate);
            System.out.println("Investment #" + (i + 1) + ": initial " + investments[i] + " -> ROI after "
                    + years + " years = " + result);
        }
    }
}
