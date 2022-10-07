package olga.fedianina.hw6.task3.catAndMous;

import olga.fedianina.hw6.task3.Hunter;

public class Cat {
    //Класс Кот: имя, скорость, вес, пойманные мыши;
    public String catName;
    private double speed;
    private double weight;
    private Mous backpackForMouse[] = new Mous[99]; //Создали тип Mous тк будет содержэать именно мышей, а не числа

    public Cat(String catName, double speed, double weight) {
        this.catName = catName;
        setSpeed(speed);
        setWeight(weight);
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        if (speed < 5) throw new IllegalArgumentException("Скорость должна быть больше 5");
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 2) throw new IllegalArgumentException("Вес должен быть больше 2 кг");
        this.weight = weight;
    }

    public boolean huntOfMouse(Mous mous) {//Передали всю мышь, тк у нее всего 1 параметр. Кота не передаем, так как метод уже в коте и про кота все знает
        if (mous.getSpeed() < speed) {//cat.speed не пишем, так как смотрим скорость ЭТОГО класса
            if (backpackForMouse[backpackForMouse.length - 1] != null) {
                System.out.println("Рюкзак не резиновый!");
                return false;
            }
            for (int i = 0; i < backpackForMouse.length; ++i) {
                if (backpackForMouse[i] == null) {
                    backpackForMouse[i] = mous;
                    System.out.println("Мышь помещена в рюкзак!");
                    return true;
                }
            }
        }
        System.out.println("Мышь сбежала");
        return false;
    }


    public boolean fight(Cat cat)// Cat cat - второй кот. Про первого инфа в классе уже есть
    {
        Cat winner, loser;
        if (weight < cat.weight) {
            winner = cat;
            loser = this;
        } else if (weight > cat.weight) {
            winner = this;
            loser = cat;
        } else {
            System.out.println("Ничья, расходимся");
            return false;
        }

        System.out.println("Кот " + loser.catName + " проиграл");
        int amountMous1 = 0;
        while (loser.backpackForMouse[amountMous1] != null) ++amountMous1;

        int amountMous2 = 0;
        while (winner.backpackForMouse[amountMous2] != null) ++amountMous2;
        for (int i = 0; i < amountMous1 && i < winner.backpackForMouse.length; ++i) {
            winner.huntOfMouse(loser.backpackForMouse[i]);
            loser.backpackForMouse[i] = null;
        }
        return true;
    }

}






