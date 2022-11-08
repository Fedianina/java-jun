package olga.fedianina;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArgsAndProps {
    public static void main(String[] args) {
        for (String arg: args ){
            System.out.println(arg);
        }


        Properties properties = new Properties();

        //позволяет загрузать даннные из InputStream (часто из *.properties файлов)
        //хэш табл. Хранят ключи и значение (они всегда строки)
        properties.setProperty("ключ", "значение");// добавление
        String value = properties.getProperty("ключ");// получение значения
        properties.clear();// очистка

        try (InputStream input = ArgsAndProps.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(input);
        }catch (IOException e){
            System.out.println("Пробллемы с чтением");
        }
        properties.forEach((key, val) -> System.out.println(key+ ": "+ val));

        }

    }

