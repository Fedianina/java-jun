package olga.fedianina.lesson13;

public class MethodsApp {
    public static void main (String[] args){
        String[] strings = {"fdsfs", "edsfdf", "sadas"};
        String string = "fdsfs";
        System.out.println( CustomUtils.inArray(strings, 12));
        System.out.println(CustomUtils.<String>inArray(strings, string));




        Integer [] integers = {34, 34234, 5464565};
        Integer integer = -34;
        System.out.println(CustomUtils.<Integer>inArray(integers, integer));


        System.out.println(CustomUtils.compareHashCode(integer, string));
        System.out.println(CustomUtils.<Integer, String>compareHashCode(12, "12"));


    }
}
