package olga.fedianina.hw29.task1;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class ReflectionToString {
    private ReflectionToString() {
    }

    public static void reflectionToString(Object object) throws IllegalAccessException {
        reflectionToString(object, object.getClass().getSimpleName());
    }

    private static void reflectionToString(Object object, String string) throws IllegalAccessException {
        Class<?> objectClass = object.getClass();
        if (objectClass.isPrimitive()) {
            System.out.println(string + " " + String.valueOf(object));
            return;
        }
        Field[] fields = objectClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getType() == String.class) {
                System.out.println(string + "." + field.getName() + " " + field.get(object));
            } else if (field.getType().isPrimitive()) {
                System.out.println(string + "." + field.getName() + " " + String.valueOf(field.get(object)));
            } else if (field.getType().isArray()) {
                //System.out.println("Array!");
                int size = Array.getLength(field.get(object));
                for (int i = 0; i < size; i++) {
                    reflectionToString(Array.get(field.get(object), i), string + "." +
                            field.get(object).getClass().getSimpleName() + "\b" + i + "]");
                }
            } else {
                if (field.get(object) == null) {
                    System.out.println(string + "." + field.getName() + " null");
                } else {
                    reflectionToString(field.get(object), string + "." + field.get(object).getClass().getSimpleName());
                }
            }
        }
    }
}
