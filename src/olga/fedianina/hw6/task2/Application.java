package olga.fedianina.hw6.task2;

import olga.fedianina.hw6.task2.condition.Foodstuff;
import olga.fedianina.hw6.task2.condition.MyFoodstuff;

public class Application {
    public static void main(String[] args) {
        MyFoodstuff  lisp = new MyFoodstuff();
        lisp.plussFood(new Foodstuff("каша", 20, 20, 47, 23));
        lisp.plussFood(new Foodstuff("Вафли", 10, 20, 40, 50));
        lisp.plussFood(new Foodstuff("Мясо", 40,20,30,50));
        lisp.plussFood(new Foodstuff("еда",23, 232,54, 45));
        lisp.plussFood(new Foodstuff("каша", 20, 20, 47, 23));
        System.out.println(lisp);


    }
}
