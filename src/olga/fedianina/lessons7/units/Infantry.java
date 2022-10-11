package olga.fedianina.lessons7.units;
import  olga.fedianina.lessons7.base.BattleUnit;

public class Infantry extends BattleUnit {
    private int additionalAttack;



    public Infantry(int healthScore, int attackScore, int additionalAttack){
        super(healthScore,attackScore);// это все из родительского класса
        if (additionalAttack<1) {
            throw new IllegalArgumentException("additionalAttack не мб < 1");
        }
        this.additionalAttack = additionalAttack;
        }
        public void upAdditionalAttack (){
            additionalAttack+=(int)(Math.random()*3);//ничего не передаем
        }





        @Override
        public void attack (BattleUnit enemy){ //реализация абстрактного метода (enemy - любой объект типа BattleUnit)
            System.out.println("Атака");
            enemy.minusHealth(this.attackScore);

        }

    @Override
    public String toString() {
        return " Infantry ";
    }
}

