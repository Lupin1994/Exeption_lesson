import java.util.Random;

public class HomeWork_1 {

    // 1) Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

    static void divide(int a, int b) {
        if (a == 0 || b == 0) {
            throw new ArithmeticException("Делить на 0 нельзя!");
        }
        int res = a / b;
        System.out.println(res);
    }

    // ----------------------------------------------------------------------------
    static void printLength(String text) {
        System.out.println(text.length());
    } // null ошибка если ничего не передать
    // --------------------------------------------------------------------------

    static void checkIndex(int[] arr) {
        if (arr.length < 3) {
            System.out.println("Error");
        }
    }
    // ---------------------------------------------------------------------------

    static int[] createArray() {
        Random rnd = new Random();
        int[] arr = new int[rnd.nextInt(2) + 3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(1, 10);
        }
        return arr;
    }

    static void writeArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(" " + arr[i]);
        }
    }

    public static void main(String[] args) {
        // printLength(null);
        // int[] array = new int[2];
        // checkIndex(array);
        // task1();
        task2();
    }

    // 2) Реализуйте метод, принимающий в качестве аргументов два целочисленных
    // массива,
    // и возвращающий новый массив, каждый элемент которого равен разности элементов
    // двух
    // входящих массивов в той же ячейке. Если длины массивов не равны, необходимо
    // как-то
    // оповестить пользователя.
    static void task1() {
        int[] arr1 = createArray();
        // writeArray(arr1);
        // System.out.println("-");
        int[] arr2 = createArray();
        // writeArray(arr2);
        // System.out.print("=");
        if (arr1.length == arr2.length) {
            int[] res = new int[arr1.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = arr1[i] - arr2[i];
            }
            writeArray(res);
        } else {
            System.out.println("Количество элементов в массиве не совпадают!");
        }
    }
    // 3) (Дополнительно) Реализуйте метод, принимающий в качестве аргументов два
    // целочисленных массива,
    // и возвращающий новый массив, каждый элемент которого равен частному элементов
    // двух входящих массивов в той же ячейке. Если длины массивов не равны,
    // необходимо
    // как-то оповестить пользователя.
    // Важно: При выполнении метода единственное исключение,
    // которое пользователь может увидеть - RuntimeException, т.е. ваше.

    static void task2() {
        int[] arr1 = createArray();

        int[] arr2 = createArray();

        if (arr1.length == arr2.length) {
            int[] res = new int[arr1.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = arr1[i] / arr2[i];
            }
            writeArray(res);
        } else {
            throw new RuntimeException("Количество эл-тов в массиве не совпадает");
        }
    }
}
