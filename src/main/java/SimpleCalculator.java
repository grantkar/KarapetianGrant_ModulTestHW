import java.util.Scanner;

public class SimpleCalculator {
    static Scanner scanner = new Scanner(System.in);
    static String number1;
    static String number2;

    public static void main(String[] args) {

        System.out.println("Введите число num1 :");
        number1 = scanner.next();
        int num1 = 0;
        int num2 = 0;
        if (isNumeric(number1)) {
            num1 = Integer.parseInt(number1);
        }

        System.out.println("Введите число num2 :");
        number2 = scanner.next();
        if (isNumeric(number2)) {
            num2 = Integer.parseInt(number2);
        }

        char operation = getOperation();

        if (isOperation(operation)) {
            int result = calc(num1, num2, operation);
            System.out.println("Результат операции: " + result);
        }
    }


    public static boolean isNumeric(String str) throws NumberFormatException {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Вы ввели не число, мы заменим его на '0'");
            return false;
        }
    }

    public static char getOperation() {
        System.out.println("Введите операцию:");
        char operation;
        operation = scanner.next().charAt(0);
        return operation;
    }

    public static boolean isOperation(char symbol) {
        if (symbol == '+' | symbol == '-' | symbol == '*' | symbol == '/') {
            return true;
        } else {
            System.out.println("Недопустимый символ операций");
            return false;
        }
    }

    public static int calc(int num1, int num2, char operation) throws ArithmeticException {
        int result;
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
               return num1 * num2;

            case '/':
               return num1 / num2;
        }
        return 0;
    }

}
