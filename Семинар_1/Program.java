import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Program
 */
public class Program {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
        // System.out.printf("Длинна массива: %d\n", task1(new int[]{2,3,4,4}));
        // task2();
        // task3();
        task4();
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив.
     * Если длинна массива меньше заданного минимума,метод возвращает -1,
     * в качестве кода ошибки, иначе -- длину массива
     */

    public static int task1(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        return arr.length;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный массив и
     * некоторое значение.
     * Метод ищет в массиве заданное значение и возвращает его индекс. Например:
     * 1) если длина массива меньше заданного минимума,метод возвращает -1
     * 2) если искомый элемент не найден, метод возвращает -2
     * 3) если вместо массива пришел null, метод вернет -3
     * Напишите метод, в котором реализуйте взаимодействие с пользователем.
     * То есть, этот метод запросит искомой число у пользователя, вызовет первый,
     * обработает возвращенное значение и покажет читаемый результат пользователю.
     * Например: если вернулся -2,пользователю выведется сообщение: "Искомый элемент
     * не найден"
     */

    public static void task2() {
        while (true) {
            System.out.println("Укажите число для поиска: ");
            if (scanner.hasNextInt()) {
                int searchNumber = scanner.nextInt();
                int[] array = new int[random.nextInt(5) + 1];
                if (random.nextInt(2) == 0) {
                    array = null;
                } else {
                    for (int i = 0; i < array.length; i++) {
                        array[i] = random.nextInt(10);
                        System.out.printf("%d\t", array[i]);
                    }
                    System.out.println();
                }
                int codeResult = processArray(array, searchNumber);
                if (codeResult == -1) {
                    System.out.println("Длина массива менее 3 элементов");
                } else if (codeResult == -2) {
                    System.out.println("Элемент не найден");
                } else if (codeResult == -3) {
                    System.out.println("Массив некорректно проинициализирован");
                } else {
                    System.out.println("Массив успешно обработан. Завершение работы приложения");
                    System.out.printf("Элемент найден по индексу %d \n", codeResult);
                    return;
                }
            } else {
                System.out.println("Число для поиска указанно не корректно.\nУкажите ввод числа");
                scanner.nextLine();
            }
        }
    }

    static int processArray(int[] arr, int searchNumber) {
        if (arr == null) {
            return -3; // если вместо массива пришел null, метод вернет -3
        }
        if (arr.length < 3) {
            return -1; // если длина массива меньше заданного минимума,метод возвращает -1
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == searchNumber) {
                return i;
            }
        }
        return -2; // если искомый элемент не найден, метод возвращает -2
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный
     * массив.
     * Необходимо посчитать и вернуть сумму элементов этого массива.
     * При этом накладываем на метод2 ограничения: метод может работать только с
     * квадратными числами
     * (кло-во строк = кол-ву столбцов), и в каждой ячейке может лежать только
     * значение 0 или 1.
     * Если нарушается одно из условий, метод должен выбросить RuntimeException с
     * сообщением об ошибке.
     */

    static void task3() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n *** Итерация %d ***\n\n", i + 1);
            processArray(generateArray());
        }
    }

    static void processArray(int[][] arr) {
        if (arr[0].length != arr.length) {
            throw new RuntimeException("Некорректная размерность массива");
            // throw new IOException("123");
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    throw new RuntimeException(
                            String.format("Некорректное значение массива по индексу [%d][%d]", i, j));
                } else {
                    sum += arr[i][j];
                }
            }
        }
        System.out.printf("Сумма элементов массива: %d\n", sum);
    }

    static int[][] generateArray() {
        int[][] arr = new int[random.nextInt(2) + 4][4];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(2);
                if (random.nextInt(500) == 0) {
                    arr[i][j] = 2; // намеренная ошибка
                }
                System.out.printf("%d ", arr[i][j]);
            }
            System.out.println();
        }
        return arr;
    }

    /**
     * Реализуйте метод, принимающий в качестве аргумента целочисленный двумерный
     * массив.
     * Необходимо посчитать и вернуть сумму элементов этого массива.
     * При этом накладываем на метод2 ограничения: метод может работать только с
     * квадратными числами
     * (кло-во строк = кол-ву столбцов), и в каждой ячейке может лежать только
     * значение 0 или 1.
     * Если нарушается одно из условий, метод должен вернуть код ошибки.
     * Программа должна корректно обработать код ошибки и вывести сообщение
     * пользователю.
     * Сравнить такой вариант обработки исключений с предыдущим.
     */

    static void task4() {
        for (int i = 0; i < 5; i++) {
            System.out.printf("\n *** Итерация %d ***\n\n", i + 1);
            int errCode = processArrayV2(generateArray());
            if (errCode == -1) {
                System.out.println("Некорректная размерность массива.");
            } else if (errCode == -2) {
                System.out.println("Некорректное значение массива.");
            } else {
                System.out.printf("Сумма элементов массива: %d\n", errCode);
            }
        }
    }

    static int processArrayV2(int[][] arr) {
        if (arr.length != arr[0].length) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0 && arr[i][j] != 1) {
                    return -2;
                } else {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

}