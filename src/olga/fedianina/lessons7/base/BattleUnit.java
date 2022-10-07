package olga.fedianina.lessons7.base;

abstract class BattleUnit extends Unit{
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
        abstract public void attack (BattleUnit enemy);
    }

