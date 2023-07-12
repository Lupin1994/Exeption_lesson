// Напишите приложение, которое будет запрашивать у пользователя следующие данные, 
//разделенные пробелом:
// Фамилия Имя Отчество номертелефона

// Форматы данных:
// фамилия, имя, отчество - строки
// номертелефона - целое беззнаковое число без форматирования

// Ввод всех элементов через пробел

// Приложение должно проверить введенные данные по количеству. 
//Если количество не совпадает с требуемым, вернуть код ошибки, 
//обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, 
//чем требуется.

// Приложение должно попытаться распарсить полученные значения 
//и выделить из них требуемые параметры. Если форматы данных не совпадают, 
//нужно бросить исключение, соответствующее типу проблемы. 
//Можно использовать встроенные типы java и создать свои. 
//Исключение должно быть корректно обработано, 
//пользователю выведено сообщение с информацией, что именно неверно.

// Если всё введено и обработано верно, должен создаться файл с названием, 
//равным фамилии, в него в одну строку должны записаться полученные данные, вида

// <Фамилия><Имя><Отчество><номер_телефона>

// Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

// Не забудьте закрыть соединение с файлом.

// При возникновении проблемы с чтением-записью в файл, 
//исключение должно быть корректно обработано, 
//пользователь должен увидеть стектрейс ошибки.

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.FileSystemException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * H_work_03
 */
public class H_work_03 {

    public static void main(String[] args) throws IOException {
        try {
            writeFile();
            System.out.println("success");
        }catch (FileSystemException e) {
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getStackTrace());
        }
    }

    static void writeFile() throws Exception{
        System.out.println("Введите фамилию, имя, отчество,дату рождения(day.month.year), номер телефона(одним числом) и пол(m(man) или w(woman)),все через пробел");

        String text;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            text = bf.readLine();
        } catch (IOException e) {
            throw new Exception("Ошибка при вводе");
        }

        String[] arr = text.split(" ");
        if (arr.length != 6){
            throw new Exception("Введены не все данные");
        }

        String lastName = arr[0];
        String firstName = arr[1];
        String patronym = arr[2];

        SimpleDateFormat format = new SimpleDateFormat("dd.mm.yyyy");
        Date birthdate;
        try {
            birthdate = format.parse(arr[3]);
        } catch (ParseException e) {
            throw new ParseException("Ошибка ввода даты,обратите внимание на формат", e.getErrorOffset());
        }

        int numberPhone;
        try {
            numberPhone = Integer.parseInt(arr[4]);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка ввода телефона");
        }

        String sex = arr[5];
        if(!sex.toLowerCase().equals("m") && !sex.toLowerCase().equals("w")){
            throw new RuntimeException("Ошибка в воде пола");
        }

        String fileName = "files\\" + lastName.toLowerCase() + ".txt";
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)){
            if (file.length() > 0){
                fileWriter.write('\n');
            }
            fileWriter.write(String.format("%s %s %s %s %s %s", lastName, firstName, patronym, format.format(birthdate), numberPhone, sex));
        }catch (IOException e){
            throw new FileSystemException("Ошибка при работе с файлом");
        }

    }
}