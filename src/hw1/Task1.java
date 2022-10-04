package hw1;

public class Task1 {
    public static void main(String[] args) {

        // Площадь прямоугольного параллелепипеда
        int length = 7, width = 8, height = 12;
        int area = 2 * (length * width + width * height + height * width);
        System.out.println(area);

        // куб числа
        int d = 7;
        int w = d * d * d;
        System.out.println(w);

        //скорость в м/с
        double time = 4.8;
        double dist = 6;
        double speed = dist * 1000/ (time * 60 * 60);
        System.out.println(speed);

        // ошибки
       /* float a = 45.6;  необходимо явное приведение, так как система считает число справа - числом типа double и боится,
        что оно не поместится во float.Решается явным приведением (буква "f" в конце выражения)*/
        float a = 45.6f;
        //long b = 60000; аналогично строчке выше, приводим к типу long
        long b = 60000L;
        //long c = r / b; система считает переменные a и b как переменные типа int. Необходимо привети результат их деления к long
        //long c = (long) (r / b);



        int x = 34;
        long y = 78;
        //int z = x / y; один из операндов типа long. Необходимо либо все выражение привети к long, либо, что лучше, операнд к int, однако, при делении получится число с плавающей точкой. Все выражение необходимо привести к типу double
        double z =((double) x) /  y;
        System.out.println(z);
        double n = 90.8;
        double m = -100.1;
        //int max = n > m ? n : m; в int хотим записать число типа double. Меняем тип переменной max на double
        double max = n > m ? n : m;

        byte code = 1;
        //boolean isActive = (boolean) code;// оператор boolean не взаимодействует с другими типом данных.

        //остаток от деления
        int q = 45;
        int e = q%10;
        int i = q/10;
        int u = e + i;
        System.out.println(u);

        int o = 11;
        int p = (o%10 + o/10);
        System.out.println(p);



    }

}
