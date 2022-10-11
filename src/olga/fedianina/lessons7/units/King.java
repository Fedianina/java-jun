package olga.fedianina.lessons7.units;

import olga.fedianina.lessons7.base.BattleUnit;
import olga.fedianina.lessons7.base.Unit;
import olga.fedianina.lessons7.base.AppSettings;

import java.util.Arrays;

public class King extends Unit {
    //привязываем родительский класс
    private int gold = AppSettings.GOLD;//обращаемся к классу со стат св-вом (значение св-ва = значению статической переменной)


    private BattleUnit[] army;


    public King(int healthScore) {
        super(healthScore);
    }

    public int getGold() {
        return gold;
    }


    public void generationArmy() {
        if (gold < AppSettings.ARMY_PRICE) {
            System.out.println("Стоимость армии " + AppSettings.ARMY_PRICE + " Не хватило денег");
            return;
        }
        gold -= AppSettings.ARMY_PRICE;
        army = BattleUnit.getBattleunits(AppSettings.UNITS_COUNT);
        //результат работы метода, котор находится в BattleUnit
        //создание объектов и генерация массива армии
    }

    public void updateArmy() {
        //обновление армии пока есть деньги
        for (int i = 0; i < army.length; i++) {
            if (gold < AppSettings.UNIT_PRICE) {
                System.out.println("Стоимость Юнита " + AppSettings.UNIT_PRICE);
                return;
            }
            if (!army[i].isALive()) {
                gold -= AppSettings.UNIT_PRICE;
                army[i] = BattleUnit.getBattleUnit();
            }
            //создание объекта

        }
    }

    public void startBattle(King enemy) {

        for (int j = 0; j < this.army.length; j++) {
            while (j<this.army.length-1 &&!this.army[j].isALive()) ++j;
            for (int i = 0; i < enemy.army.length; i++) {
                while (i < enemy.army.length-1 && !enemy.army[i].isALive()) ++i;
                this.army[j].attack(enemy.army[i]);
                if (enemy.army[i].isALive()) {
                    System.out.println("Противник выжил");
                    enemy.army[i].attack(this.army[j]);
                    if (this.army[j].isALive()) System.out.println("Все выжили");
                } else {
                    System.out.println("Противник убит");
                }
            }
        }
        this.winner(enemy);
    }
    public void winner(King enemy){
        int a = 0 , b = 0;
        for (int i = 0; i < army.length; i++) {
            if (this.army[i].isALive()) ++a;
            if (enemy.army[i].isALive()) ++b;
        }
        if (b<a) System.out.println("Выиграл нападавший");
        else if (a<b)System.out.println("Выиграл обороняющийся");
        else System.out.println("Ничья");
    }


    //армия одного нападает на другого
    //this.army[1] - тут можно вызвать реализацию методов конкретного юнита;
    //enemy.army[1] - тот на кого напали

    @Override
    public void rest() {
        if (gold < AppSettings.REST_PRICE) return;
        gold -= 10;
        System.out.println("King востанавливает силы");
    }

    public final void rest(Unit unit) {
        //ecли напишем public void rest (King unit){ король сможеть отдыхать толкьо с королем или любыми дочерними классами.
        // В данном случае мы можем передать тип данных Unit и любого его наследника
        // (короля, рыцаря, пехотинца тк. они все с типом юнит)
        if (gold < 20) return;
        gold -= 20;
        plusHealth(2);
        unit.plusHealth(1);
        System.out.println("King и Unit востанавливает силы");
    }

    @Override
    public String toString() {
        return "King{" +
                "army=" + Arrays.toString(army) +
                '}';
    }
}


