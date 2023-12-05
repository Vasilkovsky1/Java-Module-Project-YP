import java.util.*;

public class Calculator {
    Format format = new Format();
    ArrayList<Product> products = new ArrayList<>();

    public void displayProduct() {
        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println(product.getName() + " " + format.format(product.getPrice()));
        }
    }

    private String readNonEmptyInput(Scanner scanner) {
        String input;
        do {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Поле ввода не может быть пустым. Пожалуйста, введите корректное значение.");
            }
        } while (input.isEmpty());
        return input;
    }

    public void account(int userInput) {
        Scanner scanner = new Scanner(System.in);
        double sum = 0;
        while (true) {
            System.out.println("Введите наименование товара или для завершения введите('Завершить')");
            String name = readNonEmptyInput(scanner);
            if (name.equalsIgnoreCase("Завершить")) {
                displayProduct();
                System.out.println("Каждый человек должен заплатить " + format.format(sum / userInput));
                return;
            }
            while (true) {
                double price;
                System.out.println("Введите его стоимость.\nСтоимость должна быть в формате 10.45");
                scanner.useLocale(Locale.US);
                while (!scanner.hasNextDouble()) {
                    System.out.println("Введите корректное число.");
                    scanner.next();
                }
                price = scanner.nextDouble();
                sum += price;
                products.add(new Product(name, price));
                scanner.nextLine();
                System.out.println("Товар успешно добавлен, добавить еще один? (да/нет)");
                String answer = readNonEmptyInput(scanner);
                if (answer.equalsIgnoreCase("да")) {
                    break;
                } else {
                    displayProduct();
                    System.out.println("Каждый человек должен заплатить " + format.format(sum / userInput));
                    return;
                }
            }
        }
    }
}