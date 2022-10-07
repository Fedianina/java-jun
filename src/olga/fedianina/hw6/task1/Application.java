package olga.fedianina.hw6.task1;

import olga.fedianina.hw6.task1.conditions.Alpenist;
import olga.fedianina.hw6.task1.conditions.Groups;
import olga.fedianina.hw6.task1.conditions.Mountain;

public class Application {
   public static void main(String[] args) {

        Groups group1 = new Groups(3);
        group1.plusAlpenist(new Alpenist("Вася", "Московская"));
        group1.plusAlpenist(new Alpenist("Петя","Бубеновский"));
        group1.plusAlpenist(new Alpenist("Яна", "Илларионовское"));
        Mountain mountain1 = new Mountain("Эверест", "Непал", 8848);
        group1.setMountain(mountain1);
        group1.setRecruitment(false);


        Groups group2 = new Groups(8);
        group2.plusAlpenist(new Alpenist("Фродо", "Хоббитон"));
        group2.plusAlpenist(new Alpenist("Сэм", "Хоббитон"));
        Mountain mountain2 = new Mountain("Роковая гора", "Мордор", 12000);
        group2.setMountain(mountain2);

        Groups groups3 = new Groups(10);
        groups3.plusAlpenist (new Alpenist("Света", "Васильевское"));
        groups3.plusAlpenist(new Alpenist("Кирилл", "Куйбышевская"));
        Mountain mountain3= new Mountain("Нет идей", "Где-то", 1345);
        groups3.setMountain(mountain3);

        System.out.println(group1);




    }
}
