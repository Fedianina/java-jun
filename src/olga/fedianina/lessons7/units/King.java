package olga.fedianina.lessons7.units;

import olga.fedianina.lessons7.base.Unit;

public class King extends Unit {
    //привязываем родительский класс
    private int gold = 500;
    public King(int healthScore){
        super(healthScore);
    }
    public int getGold(){
        return gold;
    }
    @Override
    public void rest () {
       if (gold<10) return;
       gold-=10;
        System.out.println("King востанавливает силы");
    }
    public void rest (Unit unit){
        //ecли напишем public void rest (King unit){ король сможеть отдыхать толкьо с королем или любыми дочерними классами.
        // В данном случае мы можем передать тип данных Unit и любого его наследника
        // (короля, рыцаря, пехотинца тк. они все с типом юнит)
        if (gold<20) return;
        gold-=20;
        plusHealth(2);
        unit.plusHealth(1);
        System.out.println("King и Unit востанавливает силы");
    }

}
