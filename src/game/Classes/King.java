package game.Classes;

public class King {
    private int HP;
    private int gold;
    public int getHP(){
        return this.HP;
    }
    public int getGold(){
        return this.gold;
    }
    public void heal(int amount){
        HP = (getHP()+amount)>100 ? 100 : HP + amount;
    }
    public void damage(int amount){
        HP = (getHP()-amount)<=0 ? 0 : HP - amount;
    }

    public boolean withdrawGold(int amt){
        if(this.getGold()>=amt){
            this.gold -= amt;
            return true;
        } else {
            return false;
        }
    }
    public void addGold(int amt){
        this.gold += amt;
    }
    public King() {
        this.HP = 100;
        this.gold = 100;
    }
}
