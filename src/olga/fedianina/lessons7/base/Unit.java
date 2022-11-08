package olga.fedianina.lessons7.base;

import java.io.Serializable;

abstract public class Unit implements Serializable {
    protected  int healthScore;
// создаем конструктор руками
    public Unit (int healthScore){
        if(healthScore < 1){
            throw  new IllegalArgumentException("Значение не может быть меньше 1");
        }
        this.healthScore = healthScore;
    }
    private final int maxHealScore = healthScore;
    public boolean isALive(){
        //if (0<healthScore) return true;
        //if (healthScore<=0)return false;
        return healthScore>0; //оператор просто вернет занчение выражения (true/false);
    }
    public void plusHealth (int healthScore){
        if(isALive()){
                this.healthScore = Math.min (this.healthScore +healthScore, maxHealScore);
                //смотрит минимальное значение и, либо возвращает здоровье + хилл, либо начальное здоровье
        }
    }

    public void minusHealth (int healthScore){
            if ( isALive()){
                this.healthScore -= healthScore;
            }
        }
    public int getHealthScore (){
        return healthScore;
    }



    public void rest (){
        plusHealth(1);// при вызове метода здоровье всех юнитов увеличится
        System.out.println("Unit востанавливает силы");
    }

    }


