import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Main
 */
public class Main {
    /* 
     *     1.  Создайте класс исключения, который будет выбрасываться при делении на
     *         0. Исключение должно отображать понятное для пользователя сообщение
     *         об ошибке.
     *     2.  Создайте класс исключений, которое будет возникать при обращении к
     *         пустому элементу в массиве ссылочного типа. Исключение должно
     *         отображать понятное для пользователя сообщение об ошибке
     *     3.  Создайте класс исключения, которое будет возникать при попытке открыть
     *         несуществующий файл. Исключение должно отображать понятное для
     *         пользователя сообщение об ошибке.
     * */
    
    public static void main(String[] args) {
        // try{
        //    task1(); 
        // }
        // catch (DivisionByZeroException e){
        //     System.out.println(e.getMessage());
        // }

        // try {
        //     task2(new String[]{"1", "2", "3", "4", null, "6"}, 2);
        // }
        // catch (NullElementArrayException e){
        //     System.out.printf("%s \nЕго индекс: %d", e.getMessage(), e.getIndex());
        // }

        try {
            task3("C:\\test\\test.txt");
        }
        catch (MyFileNotFoundException e){
            System.out.printf("%s : %s", e.getMessage(), e.getFileName());
        }
    }

    public static void task1(){
        try{
            int a = 5/0;
        }
        catch (ArithmeticException e){
            throw new DivisionByZeroException("Ошибка деления на 0");
        }

    }

    public static void task2(String[] arr, int index){
        try {
            if (arr[index] == null){
                throw new NullElementArrayException("Элемента массива не проинициализирован", index);
            }          
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
    }

    public static void task3(String fileName) throws MyFileNotFoundException{
        // FileReader fileReader = null;
        try (FileReader fileReader = new FileReader(fileName)){
            // fileReader = new FileReader(fileName);
            char[] buf = new char[4];
            fileReader.read(buf);
            for (int i = 0; i < buf.length; i++) {
                System.out.println(buf[i]);
            }
            // 1 2 3 4 5 6 7 8 9
            // buf = 1 2 3 4 5 6
            // buf = 
            // fileReader.read(buf);
            // System.out.println();
            // // buf = 7 8 9 4 5 6
            // for (int i = 0; i < buf.length; i++) {
            //     System.out.println(buf[i]);
            // }
        }
        catch (FileNotFoundException e){
            throw new MyFileNotFoundException("Файл не найден", fileName);
        }
        catch (Exception e){
            System.out.println("Ошибка чтения");
        }
        // finally{
        //     try {
        //         fileReader.close(); 
        //     }
        //     catch (Exception ex){
        //         System.out.println(ex.getMessage());
        //     } 
        // }


    }
}

class DivisionByZeroException extends ArithmeticException{
    public DivisionByZeroException(String mess){
        super(mess);
    }
}

class NullElementArrayException extends RuntimeException{
    private int index;

    public NullElementArrayException(String mess, int index){
        super(mess);
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

}

class MyFileNotFoundException extends Exception{
    private String fileName;

    public MyFileNotFoundException(String mess, String fileName){
        super(mess);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}