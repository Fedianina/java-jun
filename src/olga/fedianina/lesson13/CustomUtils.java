package olga.fedianina.lesson13;

public class CustomUtils {
    public static <T> boolean inArray (T[] array, T element){
        for (T t: array){
            if (element.equals(t)) return  true;
        }
        return false;
    }


    public static <T extends Number, K extends String> int compareHashCode(T first, K second){
        return Integer.compare(first.hashCode(),second.hashCode());


    }
}
