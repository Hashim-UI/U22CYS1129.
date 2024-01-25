import java.util.Scanner;

public class TwoDigitCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Two-Digit Calculator");

        // Input validation loop
        int num1 = getTwoDigitNumber("Enter the first two-digit number: ", scanner);
        int num2 = getTwoDigitNumber("Enter the second two-digit number: ", scanner);

        System.out.println("Choose operation:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");

        // Input validation loop for operation choice
        char operator = getValidOperator(scanner);

        // Perform calculation based on the chosen operation
        double result = calculateResult(num1, num2, operator);

        System.out.println("Result: " + result);

        scanner.close();
    }

    // Method to get a valid two-digit number from the user
    private static int getTwoDigitNumber(String prompt, Scanner scanner) {
        int number;
        while (true) {
            System.out.print(prompt);
            String input = scanner.next();

            // Validate input for two digits
            if (input.length() == 2 && Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(1))) {
                number = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Invalid input. Please enter a two-digit number.");
            }
        }
        return number;
    }

    // Method to get a valid operator from the user
private static char getValidOperator(Scanner scanner) {
    char operator;
    while (true) {
        System.out.print("Enter the operation (use +, -, *, /): ");
        String input = scanner.next();

        // Validate input for a single character and a valid operator
        if (input.length() == 1 && (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/')) {
            operator = input.charAt(0);
            break;
        } else {
            System.out.println("Invalid input. Please enter a valid operator (+, -, *, /).");
        }
    }
    return operator;
}


    // Method to perform the calculation based on the operator
    private static double calculateResult(int num1, int num2, char operator) {
        double result = 0;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = (double) num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
        }
        return result;
    }
}