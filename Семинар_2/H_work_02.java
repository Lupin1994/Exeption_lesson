import java.io.IOException;
import java.util.Scanner;

/**
 * H_work_02
 */
public class H_work_02 {

    public static void main(String[] args) {
        // task1();
        // task2();
        // task3();
        // task4();

    }

    // 1.Реализуйте метод, который запрашивает у пользователя ввод дробного числа
    // (типа float), и возвращает введенное значение.
    // Ввод текста вместо числа не должно приводить к падению приложения,
    // вместо этого, необходимо повторно запросить у пользователя ввод данных.

    // Как реализовать через цикл while с флагом, повторный ввод числа?
    static void task1() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введи дробное число: ");
        try {
            double number = scan.nextFloat();
            System.out.println(number);
            scan.close();

        } catch (Exception ex) {
            System.out.println("Некорректно введено дробное число...");
            return;
        }

    }

    // -------------------------------------------------------------------------

    // 2.Если необходимо, исправьте данный код (Вроде поправил, но при делении на
    // ноль
    // теперь выдает бесконечность в типе данных double можете сказать почему?)
    static void task2() {
        try {
            int d = 0;
            double[] doubleArray = { 1, 2, 34, 5, 7, 89, 8, 5, 4, 3 };
            double catchedRes1 = doubleArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Catching exception: " + ex);
        }
    }
    // -------------------------------------------------------------------------

    // 3.Дан следующий код, исправьте его там, где требуется

    static void task3() {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (ArithmeticException ex) {
            System.out.println("Деление на ноль!");
        } catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Exception ex) {
            System.out.println("Что-то пошло не так...");
        }
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    // -------------------------------------------------------------------------

    // 4.Разработайте программу, которая выбросит Exception,
    // когда пользователь вводит пустую строку.
    // Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

    static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String userInput = scanner.nextLine();

        try {
            if (userInput.isEmpty()) {
                throw new Exception("Пустые строки вводить нельзя!");
            } else {
                System.out.println("Вы ввели: " + userInput);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
// -------------------------------------------------------------------------
