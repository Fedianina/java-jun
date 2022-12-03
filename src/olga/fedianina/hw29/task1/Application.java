package olga.fedianina.hw29.task1;

import olga.fedianina.lesson29.annotation.Cat;

public class Application {
    public static void main(String[] args) {
        Cat cat= new Cat();
        try {
            ReflectionToString.reflectionToString(new Lvl2());//int[]{1,2,3});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
