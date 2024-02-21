package game;

import game.Classes.Entity;
import game.Classes.King;


public class Core {
    public static King king = null;
    public static King enemy = null;
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

        //Атаки игроком
        for(int i = 0;i<Play.entityCount[0]; i++){
            if(Play.entityCount[1]>0){
                Play.enemies[0].damage(Play.allies[i].attack(Play.enemies[0]));
                System.out.printf("Ваш %s атакует следующего врага: %s, нанося %d урона%n", Play.allies[i].getName(), Play.enemies[0], Play.allies[i].attack(Play.enemies[0]));
                if(Play.enemies[0].getHP()<=0){
                    System.out.printf("Противник %s убит, вы получаете %d золота%n", Play.enemies[0].getName(), Play.enemies[0].getReward());
                    king.addGold(Play.enemies[0].getReward());
                    kill(Play.enemies[0]);

                }
            } else {
                System.out.printf("У противника не осталось войск, %s атакует короля и наносит %d урона%n", Play.allies[i].getName(), Play.allies[i].getDamage());
                enemy.damage(Play.allies[i].getDamage());
                if(enemy.getHP()<=0){
                    gameOver("win");
                }
            }
        }
        //Добыча золота
        for(int i = 0;i<Play.entityCount[0]; i++){
            king.addGold(Play.allies[i].getIncome());
            System.out.printf("%s добывает вам %d золота%n", Play.allies[i].getName(), Play.allies[i].getIncome());
        }
        //Добыча золота соперника
        for(int i = 0;i<Play.entityCount[1]; i++){
            enemy.addGold(Play.enemies[i].getIncome());
        }

    }
    public static void buy(Entity entity){
        if (king.withdrawGold(entity.getCost())) {
            Play.allies[Play.entityCount[0]] = entity;
            Play.entityCount[0]++;
            System.out.println("Вы успешно наняли следующего союзника: "+entity.getName());
        } else {
            System.out.println("Недостаточно золота!");
        }
    }
    public static void kill(Entity entity){
        int index = -1;
        for(int i = 0; (i<Play.allies.length) && (index==-1);i++){
            if(Play.allies[i]==entity){
                index = i;
            }
        }
        Play.allies[Play.entityCount[index]] = null;
        for(int i = index; i<Play.allies.length-1;i++){
            Play.allies[i] = Play.allies[i+1];
        }
    }
    public static void addEntity(Entity entity){
        Play.enemies[Play.entityCount[1]] = entity;
    }
    static Entity[] setPriorities(Entity[] arr){

        for (int i = 0; i < Play.entityCap/2; i++) {
            for (int j = i + 1; j < Play.entityCap/2; j++) {
                Entity tmp;
                if (arr[i]==null) return arr;
                if (arr[i].getAge() > arr[j].getAge()) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }
}
