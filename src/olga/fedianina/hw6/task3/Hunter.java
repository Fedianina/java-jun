package olga.fedianina.hw6.task3;

import olga.fedianina.hw6.task3.catAndMous.Cat;
import olga.fedianina.hw6.task3.catAndMous.Mous;

public class Hunter {
    public static void main(String[] args) {
        Mous mous1 = new  Mous (12.3);
        Mous mous2 = new Mous(27);
        Cat cat1 = new Cat("Tom", 20.0, 3);
        Cat cat2 = new Cat("Fred", 12, 5);
        Mous mous3 = new Mous(11);
        cat1.huntOfMouse(mous3);
        cat2.fight(cat1);
        Mous [] arrMouse = new Mous[7];
        for (int i =0;i< arrMouse.length; ++i){
            arrMouse[i]=new Mous();
            cat1.huntOfMouse(arrMouse[i]);
        }
    }
}
