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
    }
    public static void tick(){
        //Атаки игроком
        for(int i = 0;i<Play.entityCount[0]; i++){
            if(Play.entityCount[1]>0){

            } else {
                enemy.damage(Play.allies[i].getDamage());
            }
        }
        //Добыча золота
        for(int i = 0;i<Play.entityCount[0]; i++){
            king.addGold(Play.allies[i].getIncome());
            System.out.println(Play.allies[i].getName() + " добывает вам " + Play.allies[i].getIncome() + " золота");
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
        for(int i = 0; i)
        Play.allies[Play.entityCount[0]] = entity;
        Play.entityCount[0]++;
    }
    public static void addEntity(Entity entity){
        Play.enemies[Play.entityCount[1]] = entity;
    }
}
