package game;

import game.Classes.Entity;
import game.Classes.King;


public class Core {
    public static King king = null;
    public static King enemy = null;
    public static int tickCount = 1;
    public static void gameStart(){
        king = new King();
        enemy = new King();
    }
    public static void gameOver(String result){
        switch (result){
            case "win":
                System.out.println("Вы победили!");
            case "defeat":
                System.out.println("Вы проиграли!");
            case "error":
                System.out.println("Игра закончилась из-за ошибки");
        }
        System.exit(0);
    }
    public static void tick(){
        setPriorities(Play.enemies);
        EnemyAI.think();
        EnemyAI.makeDecision();
        //Атаки игроком
        for(int i = 0;i<Play.entityCount[0]; i++){
            if(Play.allies[0].getDamage()!=0) {
                if (Play.entityCount[1] > 0) {
                    int damage = Play.allies[i].attack(Play.enemies[0]);
                    System.out.printf("Ваш %s атакует следующего врага: %s, нанося %d \uEB05%n", Play.allies[i].getName(), Play.enemies[0].getName(), damage);
                    if (Play.enemies[0].getHP() <= 0) {
                        System.out.printf("Противник %s убит, вы получаете %d \uF155%n", Play.enemies[0].getName(), Play.enemies[0].getReward());
                        king.addGold(Play.enemies[0].getReward());
                        delete(Play.enemies[0]);

                    }
                } else {
                    System.out.printf("У противника не осталось войск, %s атакует короля и наносит %d \uEB05%n", Play.allies[i].getName(), Play.allies[i].getDamage());
                    enemy.damage(Play.allies[i].getDamage());
                    if (enemy.getHP() <= 0) {
                        gameOver("win");
                    }
                }
            }
        }
        //Атака противника
        for(int i = 0;i<Play.entityCount[1]; i++){
            if(Play.enemies[i].getDamage()!=0){
                if(Play.entityCount[0]>0){
                    int damage = Play.enemies[i].attack(Play.allies[0]);
                    System.out.printf("Ваш %s атакован вражеским врагом: %s, получает %d \uEB05%n", Play.allies[0].getName(), Play.enemies[i].getName(), damage);
                    if(Play.allies[0].getHP()<=0){
                        System.out.printf("Ваш %s убит%n", Play.allies[0].getName());
                        king.addGold(Play.allies[0].getReward());
                        kill(Play.allies[0]);

                    }
                } else {
                    System.out.printf("У вас не осталось войск, вражеский %s атакует вашего короля и наносит %d \uEB05%n", Play.enemies[i].getName(), Play.enemies[i].getDamage());
                    king.damage(Play.enemies[i].getDamage());
                    if(king.getHP()<=0){
                        gameOver("loss");
                    }
                }
            }
        }
        //Добыча золота
        for(int i = 0;i<Play.entityCount[0]; i++){
            if(Play.allies[i].getIncome()!=0) {
                king.addGold(Play.allies[i].getIncome());
                System.out.printf("%s добывает вам %d \uF155%n", Play.allies[i].getName(), Play.allies[i].getIncome());
            }
        }
        //Добыча золота соперника
        for(int i = 0;i<Play.entityCount[1]; i++){
            enemy.addGold(Play.enemies[i].getIncome());
        }
        tickCount++;
    }
    public static void buy(Entity entity){
        if (king.withdrawGold(entity.getCost())) {
            Play.allies[Play.entityCount[0]] = entity;
            Play.entityCount[0]++;
            System.out.println("Вы успешно наняли следующего союзника: "+entity.getName());
        } else {
            System.out.println("Недостаточно \uF155!");
        }
    }
    public static void summon(Entity entity){
        if(entity.getCost()<=Core.enemy.getGold()) {
            Core.enemy.withdrawGold(entity.getCost());
            Play.enemies[Play.entityCount[1]] = entity;
            Play.entityCount[1]++;
        }
    }
    public static void kill(Entity entity){
        int index = -1;
        for(int i = 0; (i<Play.allies.length) && (index==-1);i++){
            if(Play.allies[i]==entity){
                index = i;
            }
        }
        index = (index==-1)? 0 : index;
        Play.allies[Play.entityCount[0]] = null;
        for(int i = index; i<Play.allies.length-1;i++){
            Play.allies[i] = Play.allies[i+1];
        }
        Play.entityCount[0]--;
    }
    public static void delete(Entity entity){
        int index = -1;
        for(int i = 0; (i<Play.enemies.length) && (index==-1);i++){
            if(Play.enemies[i]==entity){
                index = i;
            }
        }
        Play.enemies[Play.entityCount[1]] = null;
        for(int i = index; i<Play.enemies.length-1;i++){
            Play.enemies[i] = Play.enemies[i+1];
        }
        Play.entityCount[1]--;
    }
    static Entity[] setPriorities(Entity[] arr){
        if(Play.entityCount[1]<=1) return arr;
        for (int i = 0; i < Play.entityCap/2; i++) {
            for (int j = i + 1; j < Play.entityCap/2; j++) {
                Entity tmp;
                if (arr[i]==null) return arr;
                if (arr[i].getPrio() > arr[j].getPrio()) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
