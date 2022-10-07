package olga.fedianina.hw6.task2.condition;

import java.util.Arrays;

public class MyFoodstuff {
    //Класс МоиПродукты:
    //Свойства: максимальное количество белков / жиров / углеводов / калорий / список продуктов (массив)
    //Реализовать метод, который принимает на Продукт и добавляет его в список, если характеристики продукта полностью соответствуют заявленным разрешениям,
    // в противном случае сообщить, по какой причине продукт не может быть добавлен в список (например, слишком большое содержание калорий)
    //Реализовать метод, который выводит названия всех продуктов из списка
    private  Foodstuff[]  food = new Foodstuff[4];
    private Foodstuff max = new Foodstuff("max",300, 200, 400, 1500);
    private Foodstuff medium = new Foodstuff();
    private int count;



   public void plussFood (Foodstuff foodstuff) {

       if (count < food.length) {

           if ((medium.getProtein() + foodstuff.getProtein()) > max.getProtein()) {
               System.out.println("Суточная норома протеина превышена");
               return;
           }

           if ((medium.getFat() + foodstuff.getFat()) > max.getFat()) {
               System.out.println("Суточная норома жиров превышена");
               return;
           }
           if ((medium.getCarbone() + foodstuff.getCarbone()) > max.getCarbone()) {
               System.out.println("Суточная норома углеводов превышена");
               return;
           }
           if ((medium.getCalory() + foodstuff.getCalory()) > max.getCalory()) {
               System.out.println("Суточная калорийность превышена");
               return;
           }
           food[count] = foodstuff;
           ++count;
           medium.setCalory(medium.getCalory() + foodstuff.getCalory());
           medium.setProtein(medium.getProtein() + foodstuff.getProtein());
           medium.setCarbone(medium.getCarbone() + foodstuff.getCarbone());
           medium.setFat(medium.getFat() + foodstuff.getFat());
           System.out.println("Продукт успешно добавлен в список");
       } else {
           System.out.println("Список продуктов полон");
           return;
       }
   }

    @Override
    public String toString() {
        return "MyFoodstuff{" +
                "food=" + Arrays.toString(food) +
                '}';
    }
}

