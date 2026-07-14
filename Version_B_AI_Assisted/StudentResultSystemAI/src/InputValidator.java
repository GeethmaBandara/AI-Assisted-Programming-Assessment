import java.util.Scanner;

public class InputValidator {

    private final Scanner scanner;

    public InputValidator(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInteger(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid input. Please enter a valid number."
                );
            }
        }
    }

    public int readMark(String message) {
        while (true) {
            int mark = readInteger(message);
            if (mark >= 0 && mark <= 100) {return mark;}
            System.out.println("Invalid mark. Mark must be between 0 and 100.");
        }
    }

    public String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (!input.isEmpty()) {return input;}
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}