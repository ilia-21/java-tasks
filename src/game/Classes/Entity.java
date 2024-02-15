package game.Classes;

public class Entity {
    private static boolean ally;
    private static String name;
    private static int HP;
    private static int income;
    private static int damage;
    private static int defense;
    private static int reward;
    private static int cost;
    public int getHP(){
        return HP;
    }
    public String getName(){
        return name;
    }
    public int getIncome(){
        return income;
    }
    public int getDamage(){
        return damage;
    }
    public int getDefense(){
        return defense;
    }
    public int getReward(){
        return reward;
    }
    public int getCost(){
        return cost;
    }

    public int attack(Entity target){
        return target.damage(target.getHP()-(getDamage()-(getDamage()*(target.getDefense()/100))));
    }
    public int damage(int damage){
        HP -= damage;
        return Math.max(HP, 0);
    }
    public Entity(boolean ally, int HP, int income,int damage, int defense, int cost, int reward, String name) {
        this.ally = ally;
        this.HP = HP;
        this.damage = damage;
        this.defense = defense;
        this.reward = reward;
        this.cost = cost;
        this.name = name;
    }
}
