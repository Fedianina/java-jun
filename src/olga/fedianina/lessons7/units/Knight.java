package olga.fedianina.lessons7.units;

import olga.fedianina.lessons7.base.BattleUnit;

import java.io.Serializable;

public class Knight extends BattleUnit implements Serializable {

    private int additionalHealth;


    public  Knight (int healthScore, int attackScore, int additionalHealth){
        super( healthScore, attackScore);
        if (additionalHealth<1){
            throw new IllegalArgumentException("не мб быть <1");}
        this.additionalHealth = additionalHealth;
        }

        public void attack (BattleUnit enemy){
            System.out.println("Рыцарь атакует");
            enemy.minusHealth(this.attackScore);
            if (!enemy.isALive()) this.plusHealth(this.additionalHealth +1);

        }

    @Override
    public String toString() {
        return " Knight ";
    }
}





