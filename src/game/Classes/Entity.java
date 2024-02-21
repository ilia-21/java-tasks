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
    private int age;
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
    public int getAge(){
        return this.age;
    }

    public int attack(Entity target){
        return target.damage(target.getHP()-(getDamage()-(getDamage()*(target.getDefense()/100))));
    }
    public int damage(int damage){
        HP -= damage;
        return Math.max(HP, 0);
    }
    public Entity(boolean ally, int HP, int income, int damage, int defense, int cost, int reward, String name) {
        System.out.println("Создано существо \"" + name + "\"");
        this.ally = ally;
        this.HP = HP;
        this.income = income;
        this.damage = damage;
        this.defense = defense;
        this.reward = reward;
        this.cost = cost;
        this.name = name;
        this.age = 0;
    }
}
