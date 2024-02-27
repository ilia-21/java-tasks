package game;
import game.Classes.Entity;
public class EnemyAI {
    private static String mode = "none";
    static int estimate(String who){
        int count;
        Entity[] arr;
        if(who == "Player"){
            arr = Play.allies;
            count = Play.entityCount[0];
        } else {
            arr = Play.enemies;
            count = Play.entityCount[1];
        }
        int hp = 0;
        for(int i = 0;i<count; i++){
            hp+= arr[i].getHP();
        }
        return hp;
    }
    static void think(){
        if(
            (Core.enemy.getHP()<100) ||
            (Play.entityCount[1]+1<Play.entityCount[0]) ||
            (Core.enemy.getGold()>200) ||
            (estimate("player")>estimate("enemy"))
        ){
            mode = "attack";
        } else if (((double) estimate("player") /estimate("enemy")>=1.5)){
            mode = "hardAttack";
        } else if (Core.enemy.getHP()<10){
            mode = "panic";
        } else if(Play.entityCount[1]>Play.entityCount[0]){
            mode = "passive";
        } else {
            mode = "calmAttack";
        }
    }
    static void makeDecision(){
        switch (mode){
            case "attack":
                if(Math.random()<0.5){
                    Core.summon(Allies.knight);
                } else {
                    Core.summon(Allies.rook);
                }
                break;
            case "hardAttack":
                Core.summon(Allies.knight);
            case "panic":
            case "calmAttack":
                Core.summon(Allies.rook);
                break;
            case "passive":
                Core.summon(Allies.miner);
        }
    }
}
