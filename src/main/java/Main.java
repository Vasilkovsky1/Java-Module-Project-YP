import java.util.*;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("На сколько человек необходимо разделить счет?");
            if (scanner.hasNextInt()) {
                int userInput = scanner.nextInt();
                if (userInput <= 1) {
                    System.out.println("Число ввода должно быть больше 1");
                } else {
                    calculator.account(userInput);
                    break;
                }
            }
            else {
                System.out.println("Введите целое число");
            }
        }
    }
}