import java.util.Scanner;

public class Calculator {

    public static double add(double a, double b) {
        return a + b;
    }

    public static double sub(double a, double b) {
        return a - b;
    }

    public static double mul(double a, double b) {
        return a * b;
    }

    // Division with exception handling
    public static double div(double a, double b) {
        try {
            if (b == 0) {
                throw new ArithmeticException("Cannot divide by zero");
            }
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return 0;
        }
    }}
class Demo{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Console Calculator ===");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            if (choice >= 1 && choice <= 4) {
                try {
                    System.out.print("Enter first number: ");
                    double num1 = sc.nextDouble();

                    System.out.print("Enter second number: ");
                    double num2 = sc.nextDouble();

                    double result = 0;

                    switch (choice) {
                        case 1:
                            result = Calculator.add(num1, num2);
                            break;
                        case 2:
                            result = Calculator.sub(num1, num2);
                            break;
                        case 3:
                            result = Calculator.mul(num1, num2);
                            break;
                        case 4:
                            result = Calculator.div(num1, num2);
                            break;
                    }

                    System.out.println("Result: " + result);

                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter numbers only.");
                    sc.nextLine(); // clear buffer
                }
            } else if (choice != 5) {
                System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        System.out.println("Calculator exited.");
        sc.close();
    }
}