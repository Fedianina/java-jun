package olga.fedianina.lessons16;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {

    private static void calculate (Operation operation, double x, double y){
        System.out.println("Результат "+ operation.execute(x,y));
    }
    public static void main(String[] args) {

        //руализация метода execute функционального интерфейса + создание эл-та типа Operation
        Operation plus = (first, second) -> first + second;
        System.out.println(plus.execute(3,4));


        Operation div = (a, b) ->{
            if (b==0)return 0;
            return a/b;
        };

        System.out.println(div.execute(0, 56));


        calculate(plus, 7, 229);
        calculate((n, m) ->n+m, 8, 9);


        //Predicate

        Predicate <Integer> isPos = x ->x>0;
        Predicate <Integer> isNeg = x ->x<0;
        Predicate <Integer> isEven = x ->x%2==0;

        System.out.println(isPos.test(-90));
        System.out.println(isPos.and(isEven).test(100));//дефолтный метод and проверит оба условия и вернет true если оба верны. Вместо&&
        System.out.println(isNeg.or(isPos).test(0));//то же самое, толкьо или


        //Function

        Function<Integer, Double> down = a -> a*0.8;
        Function<Integer, Integer> up = a -> a*2;
        Function<Integer, String> str = a ->{
            if (a<=0) throw new IllegalArgumentException("Число Б0");
            return a + "p";
        };
        System.out.println(down.apply(100));







        }
    }

