package olga.fedianina.lesson20;


import olga.fedianina.lesson12.CalculatorException;

import java.io.*;

public class BinHandler<T> {
    private File file;
    public BinHandler() {
        file = new File("lesson20.bin");
    }
    //    file+ - сериализация (ObjectOutputStream) - объект
    public void writeToFile(T object){
        try (FileOutputStream fileOutput = new FileOutputStream(file);//запист в файл
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)//серриализация превращает объект (object)в последовательность байт
        )
        {
            objectOutput.writeObject(object);
            // ObjectOutputStream вызывает метод write у потока, переданного ему
            // в конструктор (в данном случае fileOutput), поэтому
            // FileOutputStream записывает данную последовательность в файл
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //файл - дессерриализация -- oбъект
    public T readFromFile(){
        Object result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
            ObjectInputStream objectInput = new ObjectInputStream(fileInput)
        ) {
            result = objectInput.readObject();//ObjectInputStream вызывает метод read  у потока, переданного ему в конструктор
            // - чтение последовательности байт
            // ObjectInputStream преобразует полученную последоавтельность в Object

        }catch (IOException | ClassNotFoundException e){//ClassNotFoundException может вылететь, если класса, зашитого в последовательности байт не будет в программе
            throw new RuntimeException(e);
        }
        return (T) result;
    }
}

