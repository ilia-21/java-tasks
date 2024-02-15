package game.Classes;

public class King {
    private static int HP;
    public static int getHP(){
        return HP;
    }
    public static void heal(int amount){
        HP = (getHP()+amount)>100 ? 100 : HP + amount;
    }

    public King() {
        this.HP = 100;
    }
}
