package olga.fedianina.lessons7.base;

import olga.fedianina.lessons7.units.Infantry;
import olga.fedianina.lessons7.units.Knight;

public abstract class BattleUnit extends Unit{
    protected int attackScore;

    public BattleUnit(int healthScore, int attackScore){
        super(healthScore);
        if (attackScore<1) {
            throw new IllegalArgumentException("Атака должна быть больше 1");
        }
            this.attackScore = attackScore;
        }
        public int getAttackScore(){
        return attackScore;
        }


        abstract public void attack (BattleUnit enemy);// у всех юнитов, которые наследуются от
    // боевого юнита должны будут иметь именно такой метод атаки, но реализация у каждого дочернего класса - своя.


    //создание объекта. фабричный метод
    public static BattleUnit getBattleUnit(){
        String[] types = {"knight", "infantry"};
        if ((int) (Math.random() * types.length) == 0) return new Knight(30, 10, 5);
        else return new Infantry(30, 10, 5);

    }
    public static BattleUnit [] getBattleunits (int count){
        BattleUnit [] units = new BattleUnit[count];
        for (int i = 0; i < units.length; i++) {
// в статических методах мы можем обратится только к статическим св-вам или вызвать только статические методы

            units [i]= getBattleUnit();
        }
        return units;
    }
}


