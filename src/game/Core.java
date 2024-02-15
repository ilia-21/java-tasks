package game;

import game.Classes.Entity;
import game.Classes.King;

public class Core {
    public static int gold = 0;
    public static King king = null;
    public static King enemy = null;
    public static void gameStart(){
        gold = 100;
        king = new King();
        enemy = new King();
    }
    public static void gameOver(){

    }
    public static void tick(){

    }
    public static void buy(Entity entity){
        System.out.println("цена:"+entity.getCost());
        System.out.println("имя:"+entity.getName());
        if (entity.getCost()<=gold) {
            gold -= entity.getCost();
            Play.allies[Play.entityCount[0]] = entity;
            Play.entityCount[0]++;
            System.out.println("Вы успешно наняли следующего союзника: "+entity.getName());
        } else {
            System.out.println("У вас недостаточно золота!");
        }
    }
}
