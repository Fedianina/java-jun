package olga.fedianina.hw29.task2;

import olga.fedianina.ArgsAndProps;
import olga.fedianina.lesson29.annotation.Cat;
import olga.fedianina.lesson29.annotation.Config;
import olga.fedianina.lesson29.annotation.Required;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class Instance {


    private static Object confCheck(Class<?> cls) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        if (cls.isAnnotationPresent(Config.class)) { // проверили на аннотированность конфигом
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(); // получили массив с конструкторами
            return declaredConstructor.newInstance();
        }
        return null;
    }


    private static void reqCheck(Object object, Class<?> cls) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        if (object == null) return;

        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Required.class)) {
                recordField(object, field);
            }
        }
    }

    private static void recordField(Object object, Field field) throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Properties properties = new Properties();
        try (InputStream input = ArgsAndProps.class.getClassLoader().getResourceAsStream("forAnnotation.properties")) {
            properties.load(input);
        } catch (IOException e) {
            System.out.println(e);
        }


        if (field.getType().isPrimitive() || field.getType()== String.class) {
            System.out.println(field.getType().getSimpleName());
            switch (field.getType().getSimpleName()){
                case "String"->{
                    field.set(object, properties.get(field.getName()));
                }
                case "int"->{
                    field.set(object, Integer.parseInt(String.valueOf(properties.get(field.getName()))));
                }
                default -> System.out.println("Не знаю такого");
            }

        }
    }

    public static Object getInstance(Class<?> cls) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Object object = confCheck(cls);
        reqCheck(object, cls);
        return object;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getInstance(Cat.class).toString());
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }

}
