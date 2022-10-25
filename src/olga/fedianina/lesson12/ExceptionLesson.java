package olga.fedianina.lesson12;

import java.io.IOException;

public class ExceptionLesson {
    public static void redFromJsonFile(String fileName) throws IOException {
        if (!fileName.endsWith(".json")) {//если название файла не заканчивается на
            throw new IOException("Программа не работает с данным типом файлов"); //генер объект искл времени компиляции
        }

        System.out.println("Чтение из файла...");
    }

    public static void main(String[] args) {
        try {
            Actions.sum(2,5);
        }catch (CalculatorException e){
            throw new RuntimeException(e);
        }



        try {
            redFromJsonFile("file.json");
        }catch (IOException e){
            System.out.println("невозможно прочесть из файла");
            //throw new RuntimeException(e);
        }


    int a = 1, b = 0, res;
    int[] ints = new int[3];
    //ints [30]= 100

    String string = null;
    // string.equals("null");

    Object object = "123";
    //String stringObject = (String) object; тут  все будет нора, так как 123 - строка

    Integer integer = (Integer) object;
    try {
        res = a / b;
    } catch(ArithmeticException exception){
        System.out.println(exception.getMessage());
        res = a;
    }
        System.out.println(res);


    try {
        if (System.currentTimeMillis()%2==0) integer = (Integer) object;
        else ints [30] = 100;
    }catch (ClassCastException exception){
        System.out.println("Проблемы с превидением типов");
    }catch (ArrayIndexOutOfBoundsException exception){
        System.out.println("Проблемы с массивом");
    }

        try {
            if (System.currentTimeMillis()%2==0) integer = (Integer) object;
            else ints [30] = 100;
        }catch (ClassCastException | ArrayIndexOutOfBoundsException exception){
            System.out.println("..." + exception.getMessage());
        }

        try {
            if (System.currentTimeMillis()%2==0) integer = (Integer) object;
            else ints [30] = 100;
        }catch (RuntimeException exception){
            System.out.println("Проблема времени выполнения");
        }
        try {
            if (System.currentTimeMillis()%2==0) integer = (Integer) object;
            else ints [30] = 100;
        }catch (ClassCastException exception){
            System.out.println("проблемы с привед типом");

        }
        catch (RuntimeException exception){
            System.out.println("Проблема времени выполнениz");
        }



        try {
            if (System.currentTimeMillis()%2==0) integer = (Integer) object;
            else ints [30] = 100;
        }catch (ClassCastException exception) {
            System.out.println("проблемы с привед типом");
        }
        finally {
            System.out.println("///");
        }
    }

}
