package game.Classes;

public class Entity {
    private boolean ally;
    private String name;
    private int HP;
    private int income;
    private int damage;
    private int defense;
    private int reward;
    private int cost;
    private int priority;
    public int getHP(){
        return HP;
    }
    public String getName(){
        return this.name;
    }
    public int getIncome(){
        return this.income;
    }
    public int getDamage(){
        return this.damage;
    }
    public int getDefense(){
        return this.defense;
    }
    public int getReward(){
        return this.reward;
    }
    public int getCost(){
        return this.cost;
    }
    public int getPrio(){
        return this.priority;
    }

    public int attack(Entity target){
        damage = (int)Math.ceil(
                        getDamage()*(((double) (100-target.getDefense()) /100))
                );
        target.hurt(damage);

        return damage;
    }
    public int hurt(int damage){
        HP -= damage;
        return Math.max(HP, 0);
    }
    public Entity(boolean ally, int HP, int income, int damage, int defense, int cost, int reward, String name, int prio) {
        this.ally = ally;
        this.HP = HP;
        this.income = income;
        this.damage = damage;
        this.defense = defense;
        this.reward = reward;
        this.cost = cost;
        this.name = name;
        this.priority = prio;
    }
}
